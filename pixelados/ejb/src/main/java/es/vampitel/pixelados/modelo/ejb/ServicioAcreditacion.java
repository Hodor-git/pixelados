package es.vampitel.pixelados.modelo.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import java.util.*;


import es.vampitel.pixelados.modelo.Usuario;
import es.vampitel.pixelados.modelo.dao.UsuarioDAO;

@Stateless
public class ServicioAcreditacion {
	
	@Inject 
	UsuarioDAO usuarioDAO;
	
	/* Método no necesario, las credenciales son comprobadas y gestionadas por el servidor
	public boolean autentificarUsuario(String nombre, String password) {
		
		try{
			Usuario usuario = usuarioDAO.comprobarCredenciales(nombre, password);
		} catch(NoResultException e) {
			return false;
		}
		
		return true;
		
	}*/
	
	public String mostrarNombre(Long id) {
		
		Usuario usuario = usuarioDAO.buscarPorID(id);
		
		String nombre = usuario.getNombre();
		
		return nombre;
		
	}
	
	/* Método no necesario, los roles y permisos son gestionados por el servidor
	public boolean tieneAccesoAdministrador(String nombre) {
		
		String usuario = usuarioDAO.obtenerPermiso(nombre);
		
		if(usuario.contains("administrador")) {
			return true;
		} else {
			return false;
		}
		
	}
	*/
	
	/**
	 * Comprueba si el nombre de usuario existe en la BDD
	 * @param nombre
	 * @return (True: existe. False: no existe)
	 */
	public boolean comprobarSiExiste(String nombre) {
		
		try{			
			Usuario usuario = usuarioDAO.buscarPorNombre(nombre);			
		} catch(NoResultException e) {			
			return false;
		}
		
		return true;
		
	}
	
	/*
	 * Registro todavía sin implementar
	 */
	public void registrarUsuario(Usuario usuario) {
		
		usuarioDAO.grabar(usuario);
		
	}
	
	/**
	 * Trae un usuario desde la BDD
	 * @param nombre (String)
	 * @return (Objeto usuario)
	 */
	public Usuario encontrarUsuario(String nombre) {
		return usuarioDAO.buscarPorNombre(nombre);
	}
	

}
