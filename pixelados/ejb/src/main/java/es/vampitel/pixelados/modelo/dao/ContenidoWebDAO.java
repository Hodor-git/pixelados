package es.vampitel.pixelados.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import es.vampitel.pixelados.modelo.ContenidoWeb;

public class ContenidoWebDAO extends DAOBase<ContenidoWeb> {
	
	@PersistenceContext(unitName="PersistenciaJPA")
    private EntityManager em;
	
	/**
	 * Devuelve desde la BDD una lista de artículos, entrevistas o guías y tutoriales según el parámetro tipoContenidoNombre 
	 * @param String tipoContenidoNombre (articulo, entrevista, guiastutoriales)
	 * @return List (ContenidoWeb)
	 */
	public List<ContenidoWeb> listarPorTipoContenido(String tipoContenidoNombre) {
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder(); 
		CriteriaQuery<ContenidoWeb> criteria = criteriaBuilder.createQuery(ContenidoWeb.class); 
		Root<ContenidoWeb> contenidoWeb = criteria.from(ContenidoWeb.class); 
		criteria.select(contenidoWeb).where(criteriaBuilder.equal(contenidoWeb.get("tipoContenido").get("nombre"), tipoContenidoNombre));
		Query query = em.createQuery(criteria);
		List<ContenidoWeb> listaTipoContenido = (List<ContenidoWeb>) query.getResultList();
			
		return listaTipoContenido;
		
	}

}
