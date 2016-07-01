package edu.uniandes.alcaldiavirtual.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PERMISO database table.
 * 
 */
@Entity
@NamedQuery(name="Permiso.findAll", query="SELECT p FROM Permiso p")
public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERMISO_PERMISOID_GENERATOR", sequenceName="SEQ_PERMISO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERMISO_PERMISOID_GENERATOR")
	@Column(name="PERMISO_ID")
	private long permisoId;

	//bi-directional many-to-one association to PermisoXRol
	@OneToMany(mappedBy="permiso")
	private List<PermisoXRol> permisoXRols;

	public Permiso() {
	}

	public long getPermisoId() {
		return this.permisoId;
	}

	public void setPermisoId(long permisoId) {
		this.permisoId = permisoId;
	}

	public List<PermisoXRol> getPermisoXRols() {
		return this.permisoXRols;
	}

	public void setPermisoXRols(List<PermisoXRol> permisoXRols) {
		this.permisoXRols = permisoXRols;
	}

	public PermisoXRol addPermisoXRol(PermisoXRol permisoXRol) {
		getPermisoXRols().add(permisoXRol);
		permisoXRol.setPermiso(this);

		return permisoXRol;
	}

	public PermisoXRol removePermisoXRol(PermisoXRol permisoXRol) {
		getPermisoXRols().remove(permisoXRol);
		permisoXRol.setPermiso(null);

		return permisoXRol;
	}

}