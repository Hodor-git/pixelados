package es.vampitel.pixelados.modelo;

import es.vampitel.pixelados.modelo.Categoria;
import es.vampitel.pixelados.modelo.SeccionPortada;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;


@Entity
public class Portada implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String contenido;
	@Column(name="enlace_web", nullable=false)
	private String enlaceWeb;
	@Column(name="enlace_foto", nullable=false)
	private String enlaceFoto;
	@Column(nullable=false)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="seccionID")
	private SeccionPortada seccion;
	
	@ManyToOne
	@JoinColumn(name="categoriaID")
	private Categoria categoria;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public String getEnlaceWeb() {
		return enlaceWeb;
	}
	
	public void setEnlaceWeb(String enlaceWeb) {
		this.enlaceWeb = enlaceWeb;
	}
	
	public String getEnlaceFoto() {
		return enlaceFoto;
	}
	
	public void setEnlaceFoto(String enlaceFoto) {
		this.enlaceFoto = enlaceFoto;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public SeccionPortada getSeccion() {
		return seccion;
	}

	public void setSeccion(SeccionPortada seccion) {
		this.seccion = seccion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
