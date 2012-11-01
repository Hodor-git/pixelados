package es.vampitel.pixelados.modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.vampitel.pixelados.modelo.ElJoystick;
import es.vampitel.pixelados.modelo.Genero;
import es.vampitel.pixelados.modelo.Juego;
import es.vampitel.pixelados.modelo.Foto;
import es.vampitel.pixelados.modelo.SistemaInformatico;
import es.vampitel.pixelados.modelo.Soporte;

import java.util.*;

/**
 * Funciones básicas para objetos de tipo Juego
 * (Todavía sin implementar dentro de la web)
 * @author Espe y Javi
 *
 */

public class JuegoDAO extends DAOBase<Juego> {
	
	public List<Foto> listarFotos(String nombreJuego) {
		
		return this.buscarPorNombre(nombreJuego).getListaFotos();		
	}
	
	public List<Genero> listarGeneros(String nombreJuego) {
		
		return this.buscarPorNombre(nombreJuego).getListaGeneros();
	}
	
	public List<Soporte> listarSoportes(String nombreJuego) {
		
		return this.buscarPorNombre(nombreJuego).getListaSoportes();
	}
	
	public List<SistemaInformatico> listarSistemasInformaticos(String nombreJuego) {
		
		return this.buscarPorNombre(nombreJuego).getListaSistemas();
	}
	
	public List<ElJoystick> listarElJoystick(String nombreJuego) {
				
		return this.buscarPorNombre(nombreJuego).getListaAnalisis();
	}

}
