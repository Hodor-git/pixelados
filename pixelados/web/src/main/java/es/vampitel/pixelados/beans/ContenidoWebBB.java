package es.vampitel.pixelados.beans;

import java.util.*;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.vampitel.pixelados.modelo.ContenidoWeb;
import es.vampitel.pixelados.modelo.ejb.ServicioContenidoWeb;

/**
 * BB encargado de gestionar las secciones Artículos, Entrevistas además de Guías y Tutoriales
 * @author Javi
 *
 */
@Named
@SessionScoped
public class ContenidoWebBB implements Serializable {

	private static final long serialVersionUID = -5859828700986145504L;

	private static final Logger log = LoggerFactory.getLogger(ContenidoWeb.class);
	
	@Inject
	NavegacionBB navegacion;
	
	@Inject
	ComentarioBB comentario;
	
	@EJB
	ServicioContenidoWeb servicioContenidoWeb;
	
	private ContenidoWeb contenidoWeb;
	private List<ContenidoWeb> listaContenidoWeb;
	
	/**
	 * Getters y setters
	 */
	public ContenidoWeb getContenidoWeb() {
		return contenidoWeb;
	}

	public void setContenidoWeb(ContenidoWeb contenidoWeb) {
		this.contenidoWeb = contenidoWeb;
	}

	public List<ContenidoWeb> getListaContenidoWeb() {
		return listaContenidoWeb;
	}

	public void setListaContenidoWeb(List<ContenidoWeb> listaContenidoWeb) {
		this.listaContenidoWeb = listaContenidoWeb;
	}
	
	/**
	 * Genera una lista de enlaces disponibles según el tipo de contenido solicitado.
	 * @param nombreContenido (define el tipo de contenido que devuelve el método: artítulo, entrevista o guías y tutoriales)
	 * @return Ruta de navegación hacia la sección apropiada
	 */
	public String listarContenidoWeb(String nombreContenido) {
		
		List<ContenidoWeb> lista = servicioContenidoWeb.listarContenidoWeb(nombreContenido);
		
		this.setListaContenidoWeb(lista);
		navegacion.setNombreSeccion(nombreContenido);
		
		return "/secciones/" + nombreContenido + "/" + nombreContenido;
		
	}
	
	/**
	 * Dirige la navegación hacia el xhtml donde se muestra el contenido concreto solicitado.
	 * Además muestra los comentarios asociados.
	 * @param contenido (objeto de tipo Contenido para mostrar en la vista)
	 * @return Ruta de navegación hacia la sección apropiada
	 */
	public String navegarContenido(ContenidoWeb contenido) {
		
		//Se almacena el objeto contenido en el atributo
		this.setContenidoWeb(contenido);
		
		//Obtiene la ID del objeto contenido (
		navegacion.setSeccionID(this.getContenidoWeb().getId());
		
		//Recoge los comentarios asociados al contenido
		try{
			comentario.mostrarComentarios(contenido.getId(), navegacion.getNombreSeccion());
		} catch(NullPointerException e) {
			log.info("Comentario retornado a null");
		}
		
		//Se recoge el nombre de la sección desde NavegacionBB y se pega en la
		//ruta de navegación. Ejemplo: /secciones/articulo/contenidoarticulo o /secciones/entrevista/contenidoentrevista
		String nombreSeccion = navegacion.getNombreSeccion();
			
		return "/secciones/" + nombreSeccion + "/contenido" + nombreSeccion; 
	}
	

}
