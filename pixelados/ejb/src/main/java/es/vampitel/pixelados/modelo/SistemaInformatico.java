package es.vampitel.pixelados.modelo;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="sistema_informatico")
public class SistemaInformatico implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String nombre;
	@Column(name="fecha_lanzamiento", nullable=false)
	private Date fechaLanzamiento;
	@Column(nullable=true)
	private String emulacion;
	@Column(name="datos_tecnicos", nullable=false)
	private String datosTecnicos;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="creadorID")
	private Creador creador;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tiposistemaID")
	private TipoSistema tipoSistema;
	
	@OneToOne
	@JoinColumn(name="analisisID")
	private AnalisisSistemaInformatico analisis;
	
	@ManyToMany
    @JoinTable(name="fotos_por_sistema",
         joinColumns={@JoinColumn(name="sistemaID")},
         inverseJoinColumns={@JoinColumn(name="fotoID")})
    private List<Foto> listaFotos;
	
	@ManyToMany(mappedBy="listaSistemas")
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
	
	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	
	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	
	public String getEmulacion() {
		return emulacion;
	}
	
	public void setEmulacion(String emulacion) {
		this.emulacion = emulacion;
	}
	
	public String getDatosTecnicos() {
		return datosTecnicos;
	}

	public void setDatosTecnicos(String datosTecnicos) {
		this.datosTecnicos = datosTecnicos;
	}

	public Creador getCreador() {
		return creador;
	}
	
	public void setCreador(Creador creador) {
		this.creador = creador;
	}
	
	public TipoSistema getTipoSistema() {
		return tipoSistema;
	}
	
	public void setTipoSistema(TipoSistema tipoSistema) {
		this.tipoSistema = tipoSistema;
	}

	public AnalisisSistemaInformatico getAnalisis() {
		return analisis;
	}

	public void setAnalisis(AnalisisSistemaInformatico analisis) {
		this.analisis = analisis;
	}

	public List<Foto> getListaFotos() {
		return listaFotos;
	}

	public void setListaFotos(List<Foto> listaFotos) {
		this.listaFotos = listaFotos;
	}

	public List<Juego> getListaJuegos() {
		return listaJuegos;
	}

	public void setListaJuegos(List<Juego> listaJuegos) {
		this.listaJuegos = listaJuegos;
	}
	

}
