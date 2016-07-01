package edu.uniandes.alcaldiavirtual.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PERMISO_X_ROL database table.
 * 
 */
@Entity
@Table(name="PERMISO_X_ROL")
@NamedQuery(name="PermisoXRol.findAll", query="SELECT p FROM PermisoXRol p")
public class PermisoXRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PermisoXRolPK id;

	private String estado;

	//bi-directional many-to-one association to Permiso
	@ManyToOne
	@JoinColumn(name="PERMISO_ID")
	private Permiso permiso;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ROL_ID")
	private Rol rol;

	public PermisoXRol() {
	}

	public PermisoXRolPK getId() {
		return this.id;
	}

	public void setId(PermisoXRolPK id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Permiso getPermiso() {
		return this.permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}