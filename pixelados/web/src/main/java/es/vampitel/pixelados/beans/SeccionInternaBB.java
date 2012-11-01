package es.vampitel.pixelados.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.vampitel.pixelados.modelo.SistemaInformatico;
import es.vampitel.pixelados.modelo.ejb.ServicioSeccion;

/**
 * Bean que se encarga de gestionar las secciones de Ordenador, Consola y Arcade.
 * @author Javi
 *
 */
@Named
@SessionScoped
public class SeccionInternaBB implements Serializable {

	private static final long serialVersionUID = 784503641796991939L;

	private static final Logger log = LoggerFactory.getLogger(SeccionInternaBB.class);
	
	@Inject
	NavegacionBB navegacion;
	
	@Inject
	ComentarioBB comentario;
	
	@EJB
	ServicioSeccion servicioSeccion;
	
	private String ordenador;
	private SistemaInformatico sistema;
	
	public String getOrdenador() {
		return ordenador;
	}

	public void setOrdenador(String ordenador) {
		this.ordenador = ordenador;
	}
	
	public SistemaInformatico getSistema() {
		return sistema;
	}

	public void setSistema(SistemaInformatico sistema) {
		this.sistema = sistema;
	}

	public String mostrarOrdenador(String nombre, String seccionWeb) {
		
		//Almacena en NavegacionBB el nombre del ordenador
		this.navegacion.setNombreOrdenador(nombre);
		//Almacena en NavegacionBB el nombre de la sección
		this.navegacion.setNombreSeccion(seccionWeb);
		
		//Obtiene desde la BDD los datos del sistema requerido y los almacena
		//en el atributo Sistema
		this.setSistema(this.servicioSeccion.obtenerSistema(nombre));
		
		//Obtiene la ID de la sección correspondiente y lo almacena en NavegacionBB
		this.navegacion.setSeccionID(this.getSistema().getAnalisis().getId());
		
		Long seccionID = navegacion.getSeccionID();
		
		//Recoge los comentarios asociados al contenido
		try{
			comentario.mostrarComentarios(seccionID, navegacion.getNombreSeccion());
		} catch(NullPointerException e) {
			log.info("Comentario retornado a null");
		}
		
		//Dirige por defecto a la subsección análisis
		return "/secciones/ordenador/subsecciones/analisis";
		
	}

}
