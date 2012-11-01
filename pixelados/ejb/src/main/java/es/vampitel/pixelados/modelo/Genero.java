package es.vampitel.pixelados.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Genero implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=true)
	private String descripcion;
	@ManyToMany(mappedBy="listaGeneros")
    private List<Juego> listaJuegos;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Juego> getListaJuegos() {
		return listaJuegos;
	}

	public void setListaJuegos(List<Juego> listaJuegos) {
		this.listaJuegos = listaJuegos;
	}

}
