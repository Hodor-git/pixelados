package es.vampitel.pixelados.modelo.dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import es.vampitel.pixelados.modelo.Usuario;;

public class UsuarioDAO extends DAOBase<Usuario>{
	
	/**
	 * Ambos métodos no se utilizan ya que es el propio servidor
	 * quien se encarga de gestionar las credenciales y autentificación.
	 * Los he escrito un poco por practicar.
	 */
	
	@PersistenceContext(unitName="PersistenciaJPA")
    private EntityManager em;
	
	public String obtenerPermiso(String nombre) {
		
		Usuario usuario = this.buscarPorNombre(nombre);
		
		String permiso = usuario.getTipoPermiso().getNombre();
		
		return permiso;
		
	}
	
	public Usuario comprobarCredenciales(String nombre, String password) {
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder(); 
		CriteriaQuery<Usuario> criteria = criteriaBuilder.createQuery(Usuario.class); 
		Root<Usuario> usuario = criteria.from(Usuario.class); 
		criteria.select(usuario).where(criteriaBuilder.equal(usuario.get("nombre"), nombre)).where(criteriaBuilder.equal(usuario.get("password"), password));
		Query query = em.createQuery(criteria);
		Usuario usuarioRetornado = (Usuario) query.getSingleResult();
			
		return usuarioRetornado;
	}
	
}
