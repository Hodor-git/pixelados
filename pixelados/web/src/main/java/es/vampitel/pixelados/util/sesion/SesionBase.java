package es.vampitel.pixelados.util.sesion;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import es.vampitel.pixelados.modelo.Usuario;

public class SesionBase implements Serializable{
	
	private static final long serialVersionUID = -4887807453770242875L;
	
	//Variable estática de BaseBB para la clave de usuario
	protected final static String CLAVE_USUARIO_SESION = "usuario";
		
	public void almacenarVariableEnSesion(String nombreVariable, Object variable)
	{
		HttpSession sesion = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		sesion.setAttribute(nombreVariable,variable);
	}

	public Object obtenerVariableDeSesion(String nombreVariable)
	{
		HttpSession sesion = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return (sesion.getAttribute(nombreVariable));
	}

	public void almacenarUsuarioEnSesion(Usuario usuario)
	{
		this.almacenarVariableEnSesion(CLAVE_USUARIO_SESION, usuario);
	}

	public Usuario obtenerUsuarioDeSesion()
	{
		return (Usuario) (this.obtenerVariableDeSesion(CLAVE_USUARIO_SESION));
	}

}
