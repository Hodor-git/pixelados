package es.vampitel.pixelados.modelo.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

/**
 * DAO base desde el cual heredan el resto de DAO´s. Utiliza genéricos para las operaciones más
 * comunes como búsqueda por ID, nombre, actualizaciones, borrados e insercciones.
 * @author Javi
 *
 * @param <T>
 */

public class DAOBase<T> implements IDAOBase<T> {
	
	protected Class<T> claseEntidad;
	
	@PersistenceContext(unitName="PersistenciaJPA")
    private EntityManager em;
	
	public DAOBase() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.claseEntidad = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public T buscarPorID(Long id) {
		
		return em.find(claseEntidad, id);
	}

	@Override
	public T buscarPorNombre(String nombre) {
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder(); 
		CriteriaQuery<T> criteria = criteriaBuilder.createQuery(claseEntidad); 
		Root<T> tipo = criteria.from(claseEntidad); 
		criteria.select((Selection<? extends T>) tipo).where(criteriaBuilder.equal(tipo.get("nombre"), nombre));
		Query query = em.createQuery(criteria);
		T datoEncontradoPorNombre = (T) query.getSingleResult();
			
		return datoEncontradoPorNombre;
		
	}

	@Override
	public void grabar(T tipo) {
		
		em.persist(tipo);
	}

	@Override
	public void borrar(T tipo) {
		
		em.remove(tipo);
	}

	@Override
	public void actualizar(T tipo) {
		
		em.merge(tipo);
	}

}
