package edu.uniandes.alcaldiavirtual.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PERMISO_X_ROL database table.
 * 
 */
@Embeddable
public class PermisoXRolPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ROL_ID", insertable=false, updatable=false)
	private long rolId;

	@Column(name="PERMISO_ID", insertable=false, updatable=false)
	private long permisoId;

	public PermisoXRolPK() {
	}
	public long getRolId() {
		return this.rolId;
	}
	public void setRolId(long rolId) {
		this.rolId = rolId;
	}
	public long getPermisoId() {
		return this.permisoId;
	}
	public void setPermisoId(long permisoId) {
		this.permisoId = permisoId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PermisoXRolPK)) {
			return false;
		}
		PermisoXRolPK castOther = (PermisoXRolPK)other;
		return 
			(this.rolId == castOther.rolId)
			&& (this.permisoId == castOther.permisoId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.rolId ^ (this.rolId >>> 32)));
		hash = hash * prime + ((int) (this.permisoId ^ (this.permisoId >>> 32)));
		
		return hash;
	}
}