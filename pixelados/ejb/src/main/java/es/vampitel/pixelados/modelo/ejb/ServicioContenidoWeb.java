package es.vampitel.pixelados.modelo.ejb;

import java.util.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import es.vampitel.pixelados.modelo.ContenidoWeb;
import es.vampitel.pixelados.modelo.dao.ContenidoWebDAO;

@Stateless
public class ServicioContenidoWeb  {
	
	@Inject
	ContenidoWebDAO contenidoWebDAO;
	
	/**
	 * Servicio para recoger una lista de objetos ContenidoWeb. Retorna un null al BB en caso de que no haya
	 * resultado que devolver.
	 * @param nombreContenido
	 * @return List o null
	 */
	public List<ContenidoWeb> listarContenidoWeb(String nombreContenido) {
		
		try {
			List<ContenidoWeb> listaContenidoWeb = contenidoWebDAO.listarPorTipoContenido(nombreContenido);
			return listaContenidoWeb;
		} catch(NoResultException e) {
			return null;
		}
		
	}
	
}
