package es.vampitel.pixelados.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="fotos")
public class Foto implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String descripcion;
	@Column(name="ruta_enlace", nullable=false)
	private String rutaEnlace;
	
	@ManyToMany(mappedBy="listaFotos")
    private List<SistemaInformatico> listaSistemas;
	
	@ManyToMany(mappedBy="listaFotos")
    private List<Juego> listaJuegos;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getRutaEnlace() {
		return rutaEnlace;
	}
	
	public void setRutaEnlace(String rutaEnlace) {
		this.rutaEnlace = rutaEnlace;
	}

	public List<SistemaInformatico> getListaSistemas() {
		return listaSistemas;
	}

	public void setListaSistemas(List<SistemaInformatico> listaSistemas) {
		this.listaSistemas = listaSistemas;
	}

	public List<Juego> getListaJuegos() {
		return listaJuegos;
	}

	public void setListaJuegos(List<Juego> listaJuegos) {
		this.listaJuegos = listaJuegos;
	}
	
	
}
