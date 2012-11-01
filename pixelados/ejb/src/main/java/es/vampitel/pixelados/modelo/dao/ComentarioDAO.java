package es.vampitel.pixelados.modelo.dao;

import es.vampitel.pixelados.modelo.Comentario;
import es.vampitel.pixelados.modelo.SeccionWeb;

import java.util.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ComentarioDAO extends DAOBase<Comentario> {
	
	@PersistenceContext(unitName="PersistenciaJPA")
    private EntityManager em;
	
	@Inject
	SeccionWebDAO seccionWeb;
	
	/**
	 * Devuelve desde la BDD los comentarios asociados a una sección web (por ejemplo, análisis, artículo,
	 * tutorial...etc) y la ID concreta (por ejemplo, la ID que corresponde al análisis sobre el Commodore 64)
	 * @param id (Long)
	 * @param seccionWeb (String)
	 * @return Lista de comentarios
	 */
	public List<Comentario> listarComentariosPorElementoWeb(Long id, String seccionWeb) {
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder(); 
		CriteriaQuery<Comentario> criteria = criteriaBuilder.createQuery(Comentario.class);
		
		Root<Comentario> comentario = criteria.from(Comentario.class);
		
		criteria.select(comentario).where(criteriaBuilder.equal(comentario.get("seccionID"), id),
				criteriaBuilder.equal(comentario.get("seccionWeb").get("nombre"), seccionWeb));
		Query query = em.createQuery(criteria);
		
		List<Comentario> listaComentarios = (List<Comentario>) query.getResultList();
			
		return listaComentarios;		
	}
	
	/**
	 * Inserta el comentario en la BDD
	 * @param comentario (Objeto commentario)
	 * @param seccionWeb (Objeto seccionWeb ---> análisis, artículo...etc)
	 */
	public void insertaComentarioDAO(Comentario comentario, String seccionWeb) {
		
		SeccionWeb seccion = this.seccionWeb.encontrarSeccionPorNombre(seccionWeb);	
		
		this.em.merge(seccion);
		comentario.setSeccionWeb(seccion);
		
		this.em.persist(comentario);
		
	}
	
}
