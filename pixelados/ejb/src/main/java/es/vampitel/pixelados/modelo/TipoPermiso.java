package es.vampitel.pixelados.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="tipo_permiso")
public class TipoPermiso implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="nombre_permiso", nullable=false)
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
