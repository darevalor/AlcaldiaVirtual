package edu.uniandes.alcaldiavirtual.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MUNICIPIO database table.
 * 
 */
@Entity
@NamedQuery(name="Municipio.findAll", query="SELECT m FROM Municipio m")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MUNICIPIO_MUNICIPIOID_GENERATOR", sequenceName="SEQ_MUNICIPIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MUNICIPIO_MUNICIPIOID_GENERATOR")
	@Column(name="MUNICIPIO_ID")
	private long municipioId;

	private String nombre;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="DEPARTAMENTO_ID")
	private Departamento departamento;

	//bi-directional many-to-one association to TramiteXMunicipio
	@OneToMany(mappedBy="municipio")
	private List<TramiteXMunicipio> tramiteXMunicipios;

	public Municipio() {
	}

	public long getMunicipioId() {
		return this.municipioId;
	}

	public void setMunicipioId(long municipioId) {
		this.municipioId = municipioId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<TramiteXMunicipio> getTramiteXMunicipios() {
		return this.tramiteXMunicipios;
	}

	public void setTramiteXMunicipios(List<TramiteXMunicipio> tramiteXMunicipios) {
		this.tramiteXMunicipios = tramiteXMunicipios;
	}

	public TramiteXMunicipio addTramiteXMunicipio(TramiteXMunicipio tramiteXMunicipio) {
		getTramiteXMunicipios().add(tramiteXMunicipio);
		tramiteXMunicipio.setMunicipio(this);

		return tramiteXMunicipio;
	}

	public TramiteXMunicipio removeTramiteXMunicipio(TramiteXMunicipio tramiteXMunicipio) {
		getTramiteXMunicipios().remove(tramiteXMunicipio);
		tramiteXMunicipio.setMunicipio(null);

		return tramiteXMunicipio;
	}

}