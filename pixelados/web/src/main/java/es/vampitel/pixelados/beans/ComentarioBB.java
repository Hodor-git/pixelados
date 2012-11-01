package es.vampitel.pixelados.beans;

import java.io.Serializable;

import java.util.*;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.vampitel.pixelados.modelo.Comentario;
import es.vampitel.pixelados.modelo.Usuario;
import es.vampitel.pixelados.modelo.ejb.ServicioComentario;
import es.vampitel.pixelados.util.sesion.SesionBase;

/**
 * BB encargado de la gestión de comentarios.
 * @author Javi
 *
 */

@Named
@SessionScoped
public class ComentarioBB implements Serializable {
	
	private static final long serialVersionUID = -666701715548052674L;

	private static final Logger log = LoggerFactory.getLogger(ComentarioBB.class);
	
	private String textoComentario;
	private Comentario comentario;
	private List<Comentario> listaComentarios;
	
	@Inject
	SesionBase sesionBase;
	
	@Inject
	NavegacionBB navegacionBB;
	
	@EJB
	ServicioComentario servicioComentario;
	
	/**
	 * Getters y setters
	 */
	public String getTextoComentario() {
		return textoComentario;
	}

	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}

	public Comentario getComentario() {
		return comentario;
	}
	
	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}
	
	public List<Comentario> getListaComentarios() {		
		return listaComentarios;
	}
	
	public void setListaComentarios(List<Comentario> listaComentarios) {
		this.listaComentarios = listaComentarios;
	}
	
	/**
	 * Recoge dentro de una lista aquellos comentarios asociados a una sección concreta de la web (por ejemplo, Artículos).
	 * Posteriormente la setea dentro del atributo para permitir el acceso desde la vista.
	 * @param id (ID del elemento concreto correspondiente)
	 * @param seccionWeb (nombre de la sección: artículo, entrevista....etc)
	 */
	public void mostrarComentarios(Long id, String seccionWeb) {
		
		List<Comentario> lista = servicioComentario.listaComentarios(id, seccionWeb);
		
		this.setListaComentarios(lista);
		
	}
	
	/**
	 * Inserta un comentario dentro de la BDD y actualiza la lista que lo incluye.
	 */
	public void insertaComentario() {
		
		Usuario usuario = sesionBase.obtenerUsuarioDeSesion();
		String seccionWeb = navegacionBB.getNombreSeccion();
		String textoComentario = this.getTextoComentario();
		Long seccionID = navegacionBB.getSeccionID();
		
		servicioComentario.insertaComentario(textoComentario, usuario, seccionID, seccionWeb);
		
		this.setTextoComentario("");
		this.mostrarComentarios(seccionID, seccionWeb);
		
	}
	
	/**
	 * Borra un comentario y actualiza la lista que lo incluye.
	 * @param id (ID del objeto comentario a borrar proporcionada desde la vista)
	 */
	public void borraComentario(Long id) {
		
		Long analisisID = navegacionBB.getSeccionID();
		
		servicioComentario.borraComentario(id);
		this.mostrarComentarios(analisisID, navegacionBB.getNombreSeccion());
	}
	
}
