package es.vampitel.pixelados.modelo.ejb;

import java.util.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import es.vampitel.pixelados.modelo.dao.SistemaInformaticoDAO;
import es.vampitel.pixelados.modelo.AnalisisSistemaInformatico;
import es.vampitel.pixelados.modelo.SistemaInformatico;

@Stateless
public class ServicioSeccion {
	
	@Inject
	SistemaInformaticoDAO sistemaInformatico;
	
	public AnalisisSistemaInformatico obtenerAnalisis(String nombreSistema) {
		
		try{
			AnalisisSistemaInformatico analisis = sistemaInformatico.obtenerAnalisis(nombreSistema);
			return analisis;
		} catch(NoResultException e) {
			return null;
		}
				
	}
	
	public SistemaInformatico obtenerSistema(String nombreSistema) {
		
		try{
			SistemaInformatico sistema = sistemaInformatico.buscarPorNombre(nombreSistema);
			return sistema;
		} catch(NoResultException e) {
			return null;
		}
		
	}

}
