package edu.uniandes.alcaldiavirtual.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DEPARTAMENTO database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEPARTAMENTO_DEPARTAMENTOID_GENERATOR", sequenceName="SEQ_DEPARTAMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPARTAMENTO_DEPARTAMENTOID_GENERATOR")
	@Column(name="DEPARTAMENTO_ID")
	private long departamentoId;

	private String nombre;

	//bi-directional many-to-one association to Municipio
	@OneToMany(mappedBy="departamento")
	private List<Municipio> municipios;

	public Departamento() {
	}

	public long getDepartamentoId() {
		return this.departamentoId;
	}

	public void setDepartamentoId(long departamentoId) {
		this.departamentoId = departamentoId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Municipio> getMunicipios() {
		return this.municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public Municipio addMunicipio(Municipio municipio) {
		getMunicipios().add(municipio);
		municipio.setDepartamento(this);

		return municipio;
	}

	public Municipio removeMunicipio(Municipio municipio) {
		getMunicipios().remove(municipio);
		municipio.setDepartamento(null);

		return municipio;
	}

}