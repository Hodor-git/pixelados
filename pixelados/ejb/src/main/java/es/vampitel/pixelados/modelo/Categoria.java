package es.vampitel.pixelados.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Categoria implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="nombre_categoria", nullable=false)
	private String nombre;

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
	
}
