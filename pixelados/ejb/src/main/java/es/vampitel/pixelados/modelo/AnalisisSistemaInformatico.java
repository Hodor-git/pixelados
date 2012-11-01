package es.vampitel.pixelados.modelo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.*;

@Entity
@Table(name="analisis_sistema_informatico")
public class AnalisisSistemaInformatico implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="fecha_publicacion", nullable=false)
	private Date fechaPublicacion;
	@Column(nullable=false)
	private String introduccion;
	@Column(name="tecnicamente_hablando", nullable=false)
	private String tecnicamenteHablando;
	@Column(name="que_nos_aporto", nullable=false)
	private String queNosAporto;
	@Column(name="recordando_experiencias", nullable=false)
	private String recordandoExperiencias;
	@Column(name="conclusiones_nostalgicas", nullable=false)
	private String conclusionesNostalgicas;
	
	/*
	@OneToOne(mappedBy = "analisis")
	private SistemaInformatico sistemaInformatico;
	*/
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuarioID")
	private Usuario usuarioID;
	
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
	
	public String getTecnicamenteHablando() {
		return tecnicamenteHablando;
	}
	
	public void setTecnicamenteHablando(String tecnicamenteHablando) {
		this.tecnicamenteHablando = tecnicamenteHablando;
	}
	
	public String getQueNosAporto() {
		return queNosAporto;
	}
	
	public void setQueNosAporto(String queNosAporto) {
		this.queNosAporto = queNosAporto;
	}
	
	public String getRecordandoExperiencias() {
		return recordandoExperiencias;
	}
	
	public void setRecordandoExperiencias(String recordandoExperiencias) {
		this.recordandoExperiencias = recordandoExperiencias;
	}
	
	public String getConclusionesNostalgicas() {
		return conclusionesNostalgicas;
	}
	
	public void setConclusionesNostalgicas(String conclusionesNostalgicas) {
		this.conclusionesNostalgicas = conclusionesNostalgicas;
	}
	
	public Usuario getUsuarioID() {
		return usuarioID;
	}
	
	public void setUsuarioID(Usuario usuarioID) {
		this.usuarioID = usuarioID;
	}
	
	
	

}
