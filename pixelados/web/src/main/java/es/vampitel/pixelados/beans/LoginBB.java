package es.vampitel.pixelados.beans;

import es.vampitel.pixelados.modelo.Usuario;
import es.vampitel.pixelados.modelo.ejb.ServicioAcreditacion;
import es.vampitel.pixelados.util.sesion.SesionBase;

import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.inject.Inject;

import org.hibernate.exception.JDBCConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * BB encargado de gestión de credenciales y autentificación
 * @author Javi
 *
 */

@Named
@SessionScoped
public class LoginBB implements Serializable {
	
	private static final Logger log = LoggerFactory.getLogger(LoginBB.class);
	
	private String nombre;
	private String contrasenya;
	private Usuario usuario;
	
	@EJB
	ServicioAcreditacion servicioAcreditacion;
	
	@Inject
	SesionBase sesionBase;
		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public Usuario getUsuario() {
		
		if(usuario==null) {
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			String nombreUsuario = context.getUserPrincipal().getName();
			
			usuario = servicioAcreditacion.encontrarUsuario(nombreUsuario);
		}
		return usuario;
	}
	
	private HttpServletRequest getRequest() {
		
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
	/**
	 * Obtiene el nombre del usuario actual en sesión
	 * @return
	 */
	public String getNombreUsuario() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		
		String nombreUsuario = context.getUserPrincipal().getName();
		
		return nombreUsuario;
	}
	
	/**
	 * Comprueba si el usuario logueado tiene permiso de administrador
	 * @return (True: lo tiene, False: no lo tiene)
	 */
	public boolean isUsuarioAdministrador() {
		return getRequest().isUserInRole("administrador");
	}
	
	/**
	 * Comprueba si hay un usuario en sesión. Devuelve true en caso positivo y false en caso negativo.
	 * @return (True: existe. False: no existe)
	 */
	public boolean isUsuarioEnSesion() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		
		try{
			context.getUserPrincipal().getName();
			return true;
		} catch (NullPointerException e) {
			return false;
		}
		
	}
	
	/**
	 * Método necesario para evitar errores de navegación en el commandButton del form tratado mediante Ajax
	 * @return
	 */
	public String login () {
		return "prueba";
	}
	
	public void validar(ComponentSystemEvent e) {
		
		FacesContext context = FacesContext.getCurrentInstance();
	    HttpServletRequest request = (HttpServletRequest) 
	    context.getExternalContext().getRequest();
		
		 //Recoge los datos del formulario de login
	     UIForm form = (UIForm) e.getComponent(); 
	     UIInput usernameInput = (UIInput) form.findComponent("usernameInput");
	     UIInput passwordInput = (UIInput) form.findComponent("passwordInput");
	     
	     String identificador = (String)usernameInput.getValue();
	     String contrasenya = (String)passwordInput.getValue();
	     
	     boolean identificado = false;
			
	     try {
	    	  //Autentificación en el reino de seguridad configurado dentro del servidor (JBoss)
		      request.login(identificador, contrasenya);
		      identificado = true;
		      
		 } catch (ServletException ex) {
			 	//Credenciales incorrectas. Muestra el error correspondiente.
				context.addMessage(form.getClientId(), new FacesMessage("Datos incorrectos"));
				context.renderResponse();
		 }
	     
	     if(identificado) {
	    	//Credenciales correctas. Intenta insertar al usuario dentro de la sesión.
	    	 try {
		    	 this.insertaUsuarioEnSesion(identificador);
		     } catch (JDBCConnectionException ex) {
		    	 this.logOut();
		    	 ConfigurableNavigationHandler navegacion = (ConfigurableNavigationHandler)context.getApplication().getNavigationHandler();
				 navegacion.performNavigation("/error");
		     } catch (PersistenceException ex) {
		    	 this.logOut();
		    	 ConfigurableNavigationHandler navegacion = (ConfigurableNavigationHandler)context.getApplication().getNavigationHandler();
				 navegacion.performNavigation("/error");
		     }
	    	 
	    	 //El método de navegación podría establecerse en una clase Util y así evitaríamos repetir toda esta verborrea.
	    	 ConfigurableNavigationHandler navegacion = (ConfigurableNavigationHandler)context.getApplication().getNavigationHandler();
	    	 navegacion.performNavigation("/index");
	     }
	     
	}
	
	/**
	 * Cierra la sesión.
	 * @return
	 */
	public String logOut(){
		
		getRequest().getSession().invalidate();
		
		return "/logout";
	}
	
	/**
	 * Método que recoge los datos de usuario desde la BDD para, posteriormente, insertar el objeto Usuario
	 * ya poblado en la sesión.
	 * @param nombreUsuario (String Nombre de usuario)
	 */
	public void insertaUsuarioEnSesion(String nombreUsuario) {
		
		Usuario usuarioEnSesion = servicioAcreditacion.encontrarUsuario(nombreUsuario);
		
		sesionBase.almacenarUsuarioEnSesion(usuarioEnSesion);
		
	}
	

}
