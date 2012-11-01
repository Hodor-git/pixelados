package es.vampitel.pixelados.modelo.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

import es.vampitel.pixelados.modelo.Usuario;
import es.vampitel.pixelados.modelo.dao.UsuarioDAO;

/**
 * Todavía sin implementar dentro de la web/aplicación
 * @author Javi
 *
 */

@Stateless
public class ServicioRegistroUsuario {
	
	@Inject 
	UsuarioDAO usuarioDAO;
	
	public void registrarUsuario(Usuario usuario) {
		
		usuarioDAO.grabar(usuario);
		
	}

}
