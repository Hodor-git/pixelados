package es.vampitel.pixelados.modelo;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="nombreUsuario", nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private Date fechaRegistro;
	@Column(nullable=false)
	private String salt;
	@Column(name="avatar", nullable=false)
	private String rutaAvatar;
	
	@ManyToOne
	@JoinColumn(name="tipopermisoID")
	private TipoPermiso tipoPermiso;
	
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public String getRutaAvatar() {
		return rutaAvatar;
	}
	
	public void setRutaAvatar(String rutaAvatar) {
		this.rutaAvatar = rutaAvatar;
	}
	
	public TipoPermiso getTipoPermiso() {
		return tipoPermiso;
	}
	
	public void setTipoPermiso(TipoPermiso tipoPermiso) {
		this.tipoPermiso = tipoPermiso;
	}
	
}
