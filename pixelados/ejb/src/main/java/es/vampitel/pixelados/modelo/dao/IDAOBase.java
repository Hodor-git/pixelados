package es.vampitel.pixelados.modelo.dao;
/**
 * Interface con las funciones básicas de todos los DAO´s
 * @author Javi
 *
 * @param <T>
 */

public interface IDAOBase<T> {
	
	T buscarPorID(Long id);
	T buscarPorNombre(String nombre);
	void grabar(T tipo);
	void borrar(T tipo);
	void actualizar(T tipo);

}
