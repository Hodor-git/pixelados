package es.vampitel.pixelados.modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.vampitel.pixelados.modelo.SeccionWeb;

public class SeccionWebDAO extends DAOBase<SeccionWeb> {
	
	@PersistenceContext(unitName="PersistenciaJPA")
    private EntityManager em;
	
	/**
	 * Método que devuelve un objeto SeccionWeb desde la BDD. Éste resulta necesario
	 * a la hora de insertar un comentario 
	 * @param nombreSeccionWeb (nombre de la sección a buscar)
	 * @return SeccionWeb
	 */
	public SeccionWeb encontrarSeccionPorNombre(String nombreSeccionWeb) {
		
		SeccionWeb seccionWeb = this.buscarPorNombre(nombreSeccionWeb);
		
		return seccionWeb;
	}

}
