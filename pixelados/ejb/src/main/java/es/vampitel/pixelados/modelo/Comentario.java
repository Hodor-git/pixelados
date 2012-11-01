package es.vampitel.pixelados.modelo;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="comentarios")
public class Comentario implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="fecha_publicacion", nullable=false)
	private Date fechaPublicacion;
	@Column(nullable=false)
	private String comentario;
	@Column(nullable=false)
	private Long seccionID;
	@ManyToOne
	@JoinColumn(name="seccionwebID")
	private SeccionWeb seccionWeb;
	@ManyToOne
	@JoinColumn(name="usuarioID")
	private Usuario usuario;
	
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
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public Long getSeccionID() {
		return seccionID;
	}

	public void setSeccionID(Long seccionID) {
		this.seccionID = seccionID;
	}

	public SeccionWeb getSeccionWeb() {
		return seccionWeb;
	}
	
	public void setSeccionWeb(SeccionWeb seccionWeb) {
		this.seccionWeb = seccionWeb;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
