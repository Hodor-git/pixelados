package es.vampitel.pixelados.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="creadores")
public class Creador implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=true)
	private String descripcion;
	@ManyToOne
	@JoinColumn(name="tipo_creadorID")
	private TipoCreador tipoCreador;
	@ManyToOne
	@JoinColumn(name="paisID")
	private Pais paisOrigen;
	
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
	
	public TipoCreador getTipoCreador() {
		return tipoCreador;
	}
	
	public void setTipoCreador(TipoCreador tipoCreador) {
		this.tipoCreador = tipoCreador;
	}
	
	public Pais getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(Pais paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
}
