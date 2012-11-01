package es.vampitel.pixelados.modelo;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="el_joystick")
public class ElJoystick implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="fecha_publicacion", nullable=false)
	private Date fechaPublicacion;
	@Column(nullable=false)
	private String introduccion;
	@Column(name="como_lucia", nullable=false)
	private String comoLucia;
	@Column(name="como_sonaba", nullable=false)
	private String comoSonaba;
	@Column(nullable=false)
	private String jugabilidad;
	@Column(name="conclusiones_nostalgicas", nullable=false)
	private String conclusionesNostalgicas;
	@Column(nullable=false)
	private Double puntuacion;
	@Column(name="pendiente_moderacion", nullable=false)
	private boolean pendienteModeracion;
	
	@ManyToOne
	@JoinColumn(name="usuarioID")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name="sistemaID")
	private SistemaInformatico sistema;
	
	@ManyToMany(mappedBy="listaAnalisis")
    private List<Juego> listaJuegos;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getIntroduccion() {
		return introduccion;
	}
	
	public void setIntroduccion(String introduccion) {
		this.introduccion = introduccion;
	}
	
	public String getComoLucia() {
		return comoLucia;
	}
	
	public void setComoLucia(String comoLucia) {
		this.comoLucia = comoLucia;
	}
	
	public String getComoSonaba() {
		return comoSonaba;
	}
	
	public void setComoSonaba(String comoSonaba) {
		this.comoSonaba = comoSonaba;
	}
	
	public String getJugabilidad() {
		return jugabilidad;
	}
	
	public void setJugabilidad(String jugabilidad) {
		this.jugabilidad = jugabilidad;
	}
	
	public String getConclusionesNostalgicas() {
		return conclusionesNostalgicas;
	}
	
	public void setConclusionesNostalgicas(String conclusionesNostalgicas) {
		this.conclusionesNostalgicas = conclusionesNostalgicas;
	}
	
	public Double getPuntuacion() {
		return puntuacion;
	}
	
	public void setPuntuacion(Double puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public boolean isPendienteModeracion() {
		return pendienteModeracion;
	}
	
	public void setPendienteModeracion(boolean pendienteModeracion) {
		this.pendienteModeracion = pendienteModeracion;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public SistemaInformatico getSistema() {
		return sistema;
	}
	
	public void setSistema(SistemaInformatico sistema) {
		this.sistema = sistema;
	}

	public List<Juego> getListaJuegos() {
		return listaJuegos;
	}

	public void setListaJuegos(List<Juego> listaJuegos) {
		this.listaJuegos = listaJuegos;
	}
	
}
