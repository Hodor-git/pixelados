package es.vampitel.pixelados.modelo.ejb;

import java.util.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import es.vampitel.pixelados.modelo.Comentario;
import es.vampitel.pixelados.modelo.Usuario;
import es.vampitel.pixelados.modelo.dao.ComentarioDAO;

@Stateless
public class ServicioComentario {
	
	@Inject
	Comentario comentario;
	
	@Inject
	ComentarioDAO comentarioDAO;
	
	public List<Comentario> listaComentarios(Long id, String seccionWeb) { 
		
		try{
			List<Comentario> listaComentarios = comentarioDAO.listarComentariosPorElementoWeb(id, seccionWeb);
			return listaComentarios;
		} catch(NoResultException e) {
			return null;
		}
		
	}
	
	public void insertaComentario(String comentario, Usuario usuario, Long seccionID, String seccionWeb) {
		
		Date hoy = new Date();
		
		Comentario prueba = new Comentario();
		
		prueba.setComentario(comentario);
		prueba.setFechaPublicacion(hoy);
		prueba.setSeccionID(seccionID);
		prueba.setUsuario(usuario);
		
		/* No puedo inyectar directamente comentario aquí, al insertar por segunda vez un comentario me lanza una
		 * excepción de detached object
		this.comentario.setComentario(comentario);
		this.comentario.setFechaPublicacion(hoy);
		this.comentario.setUsuario(usuario);
		this.comentario.setSeccionID(seccionID);*/
		
		comentarioDAO.insertaComentarioDAO(prueba, seccionWeb);
		
	}
	
	public void borraComentario(Long id) {
		
		Comentario comentarioBorrado = comentarioDAO.buscarPorID(id);
		comentarioDAO.borrar(comentarioBorrado);
		//comentarioDAO.borrarComentarioDAO(id);
	}

}
