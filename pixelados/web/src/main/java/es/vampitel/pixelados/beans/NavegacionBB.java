package es.vampitel.pixelados.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Este BB almacena en la sesión varios parámetros utilizados durante
 * la navegación web y el sistema de comentarios. 
 * @author Javi
 *
 */

@Named
@SessionScoped
public class NavegacionBB implements Serializable {

	private static final long serialVersionUID = -9068209503747634673L;
	
	private String nombreOrdenador;
	private String nombreSeccion;
	private Long seccionID;
	
	/**
	 * Getters y setters
	 */
	
	public String getNombreOrdenador() {
		return nombreOrdenador;
	}

	public void setNombreOrdenador(String nombreOrdenador) {
		this.nombreOrdenador = nombreOrdenador;
	}

	public String getNombreSeccion() {
		return nombreSeccion;
	}

	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}

	public Long getSeccionID() {
		return seccionID;
	}

	public void setSeccionID(Long seccionID) {
		this.seccionID = seccionID;
	}

}
