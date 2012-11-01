package es.vampitel.pixelados.modelo;

import javax.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="juegos")
public class Juego implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String nombre;
	@Column(name="fecha_lanzamiento", nullable=false)
	private Date fechaLanzamiento;
	
	@ManyToOne
	@JoinColumn(name="creadorID")
	private Creador creador;
	
	@ManyToMany
    @JoinTable(name="soporte_por_juego",
         joinColumns={@JoinColumn(name="juegoID")},
         inverseJoinColumns={@JoinColumn(name="soporteID")})
    private List<Soporte> listaSoportes;
	
	@ManyToMany
    @JoinTable(name="genero_por_juego",
         joinColumns={@JoinColumn(name="juegoID")},
         inverseJoinColumns={@JoinColumn(name="generoID")})
    private List<Genero> listaGeneros;
	
	@ManyToMany
    @JoinTable(name="juegos_por_sistema",
         joinColumns={@JoinColumn(name="juegoID")},
         inverseJoinColumns={@JoinColumn(name="sistemaID")})
    private List<SistemaInformatico> listaSistemas;
	
	@ManyToMany
    @JoinTable(name="fotos_por_juego",
         joinColumns={@JoinColumn(name="juegoID")},
         inverseJoinColumns={@JoinColumn(name="fotoID")})
    private List<Foto> listaFotos;
	
	@ManyToMany
    @JoinTable(name="el_joystick_por_juego",
         joinColumns={@JoinColumn(name="juegoID")},
         inverseJoinColumns={@JoinColumn(name="analisisID")})
    private List<ElJoystick> listaAnalisis;
	
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
	
	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	
	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	
	public Creador getCreador() {
		return creador;
	}
	
	public void setCreador(Creador creador) {
		this.creador = creador;
	}

	public List<Soporte> getListaSoportes() {
		return listaSoportes;
	}

	public void setListaSoportes(List<Soporte> listaSoportes) {
		this.listaSoportes = listaSoportes;
	}

	public List<Genero> getListaGeneros() {
		return listaGeneros;
	}

	public void setListaGeneros(List<Genero> listaGeneros) {
		this.listaGeneros = listaGeneros;
	}

	public List<SistemaInformatico> getListaSistemas() {
		return listaSistemas;
	}

	public void setListaSistemas(List<SistemaInformatico> listaSistemas) {
		this.listaSistemas = listaSistemas;
	}

	public List<Foto> getListaFotos() {
		return listaFotos;
	}

	public void setListaFotos(List<Foto> listaFotos) {
		this.listaFotos = listaFotos;
	}

	public List<ElJoystick> getListaAnalisis() {
		return listaAnalisis;
	}

	public void setListaAnalisis(List<ElJoystick> listaAnalisis) {
		this.listaAnalisis = listaAnalisis;
	}
	
	
}
