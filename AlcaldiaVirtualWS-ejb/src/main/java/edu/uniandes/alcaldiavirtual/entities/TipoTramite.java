package edu.uniandes.alcaldiavirtual.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TIPO_TRAMITE database table.
 * 
 */
@Entity
@Table(name="TIPO_TRAMITE")
@NamedQuery(name="TipoTramite.findAll", query="SELECT t FROM TipoTramite t")
public class TipoTramite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_TRAMITE_TIPOTRAMITEID_GENERATOR", sequenceName="SEQ_TIPO_TRAMITE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_TRAMITE_TIPOTRAMITEID_GENERATOR")
	@Column(name="TIPO_TRAMITE_ID")
	private long tipoTramiteId;

	private String descripcion;

	private String nombre;

	private BigDecimal valor;

	//bi-directional many-to-one association to DocXTipoTramite
	@OneToMany(mappedBy="tipoTramite")
	private List<DocXTipoTramite> docXTipoTramites;

	//bi-directional many-to-one association to TramiteXMunicipio
	@OneToMany(mappedBy="tipoTramite")
	private List<TramiteXMunicipio> tramiteXMunicipios;

	public TipoTramite() {
	}

	public long getTipoTramiteId() {
		return this.tipoTramiteId;
	}

	public void setTipoTramiteId(long tipoTramiteId) {
		this.tipoTramiteId = tipoTramiteId;
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

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<DocXTipoTramite> getDocXTipoTramites() {
		return this.docXTipoTramites;
	}

	public void setDocXTipoTramites(List<DocXTipoTramite> docXTipoTramites) {
		this.docXTipoTramites = docXTipoTramites;
	}

	public DocXTipoTramite addDocXTipoTramite(DocXTipoTramite docXTipoTramite) {
		getDocXTipoTramites().add(docXTipoTramite);
		docXTipoTramite.setTipoTramite(this);

		return docXTipoTramite;
	}

	public DocXTipoTramite removeDocXTipoTramite(DocXTipoTramite docXTipoTramite) {
		getDocXTipoTramites().remove(docXTipoTramite);
		docXTipoTramite.setTipoTramite(null);

		return docXTipoTramite;
	}

	public List<TramiteXMunicipio> getTramiteXMunicipios() {
		return this.tramiteXMunicipios;
	}

	public void setTramiteXMunicipios(List<TramiteXMunicipio> tramiteXMunicipios) {
		this.tramiteXMunicipios = tramiteXMunicipios;
	}

	public TramiteXMunicipio addTramiteXMunicipio(TramiteXMunicipio tramiteXMunicipio) {
		getTramiteXMunicipios().add(tramiteXMunicipio);
		tramiteXMunicipio.setTipoTramite(this);

		return tramiteXMunicipio;
	}

	public TramiteXMunicipio removeTramiteXMunicipio(TramiteXMunicipio tramiteXMunicipio) {
		getTramiteXMunicipios().remove(tramiteXMunicipio);
		tramiteXMunicipio.setTipoTramite(null);

		return tramiteXMunicipio;
	}

}