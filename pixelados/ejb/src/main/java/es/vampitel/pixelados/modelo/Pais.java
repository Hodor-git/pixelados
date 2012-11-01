package es.vampitel.pixelados.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Pais implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String nombre;
	@Column(name="foto_bandera", nullable=true)
	private String fotoBandera;
	
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
	
	public String getFotoBandera() {
		return fotoBandera;
	}
	
	public void setFotoBandera(String fotoBandera) {
		this.fotoBandera = fotoBandera;
	}

}
