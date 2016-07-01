package edu.uniandes.alcaldiavirtual.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ROL database table.
 * 
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROL_ROLID_GENERATOR", sequenceName="SEQ_ROL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_ROLID_GENERATOR")
	@Column(name="ROL_ID")
	private long rolId;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to PermisoXRol
	@OneToMany(mappedBy="rol")
	private List<PermisoXRol> permisoXRols;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="rol")
	private List<Usuario> usuarios;

	public Rol() {
	}

	public long getRolId() {
		return this.rolId;
	}

	public void setRolId(long rolId) {
		this.rolId = rolId;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<PermisoXRol> getPermisoXRols() {
		return this.permisoXRols;
	}

	public void setPermisoXRols(List<PermisoXRol> permisoXRols) {
		this.permisoXRols = permisoXRols;
	}

	public PermisoXRol addPermisoXRol(PermisoXRol permisoXRol) {
		getPermisoXRols().add(permisoXRol);
		permisoXRol.setRol(this);

		return permisoXRol;
	}

	public PermisoXRol removePermisoXRol(PermisoXRol permisoXRol) {
		getPermisoXRols().remove(permisoXRol);
		permisoXRol.setRol(null);

		return permisoXRol;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRol(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRol(null);

		return usuario;
	}

}