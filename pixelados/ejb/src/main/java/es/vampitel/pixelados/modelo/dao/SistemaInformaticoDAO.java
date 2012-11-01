package es.vampitel.pixelados.modelo.dao;

import es.vampitel.pixelados.modelo.AnalisisSistemaInformatico;
import es.vampitel.pixelados.modelo.Foto;
import es.vampitel.pixelados.modelo.SistemaInformatico;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SistemaInformaticoDAO extends DAOBase<SistemaInformatico> {
	
	@PersistenceContext(unitName="PersistenciaJPA")
    private EntityManager em;
	
	public AnalisisSistemaInformatico obtenerAnalisis(String nombre) {
		
		return this.buscarPorNombre(nombre).getAnalisis();
	}
	
	public List<Foto> listarFotosSistema(String nombre) {
		
		return this.buscarPorNombre(nombre).getListaFotos();
	}

}
