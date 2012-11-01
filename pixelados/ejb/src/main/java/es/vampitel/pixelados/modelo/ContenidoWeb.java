package es.vampitel.pixelados.modelo;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="contenido_web")
public class ContenidoWeb implements Serializable {
	
	private static final long serialVersionUID = 7040736498710074995L;
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String nombre;
	@Column(name="fecha_publicacion", nullable=false)
	private Date fechaPublicacion;
	@Column(nullable=false)
	private String contenido;
	
	@ManyToOne
	@JoinColumn(name="tipocontenidoID")
	private TipoContenido tipoContenido;
	@ManyToOne
	@JoinColumn(name="usuarioID")
	private Usuario usuarioID;
	
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
	
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public TipoContenido getTipoContenido() {
		return tipoContenido;
	}
	
	public void setTipoContenido(TipoContenido tipoContenido) {
		this.tipoContenido = tipoContenido;
	}
	
	public Usuario getUsuarioID() {
		return usuarioID;
	}
	
	public void setUsuarioID(Usuario usuarioID) {
		this.usuarioID = usuarioID;
	}

}
