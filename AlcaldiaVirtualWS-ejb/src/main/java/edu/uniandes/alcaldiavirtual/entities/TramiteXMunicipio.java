package edu.uniandes.alcaldiavirtual.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TRAMITE_X_MUNICIPIO database table.
 * 
 */
@Entity
@Table(name="TRAMITE_X_MUNICIPIO")
@NamedQuery(name="TramiteXMunicipio.findAll", query="SELECT t FROM TramiteXMunicipio t")
public class TramiteXMunicipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRAMITE_X_MUNICIPIO_CONSECUTIVO_GENERATOR", sequenceName="SEQ_TRAM_X_MUNI")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRAMITE_X_MUNICIPIO_CONSECUTIVO_GENERATOR")
	private long consecutivo;

	private String estado;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name="MUNICIPIO_ID")
	private Municipio municipio;

	//bi-directional many-to-one association to TipoTramite
	@ManyToOne
	@JoinColumn(name="TIPO_TRAMITE_ID")
	private TipoTramite tipoTramite;

	public TramiteXMunicipio() {
	}

	public long getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public TipoTramite getTipoTramite() {
		return this.tipoTramite;
	}

	public void setTipoTramite(TipoTramite tipoTramite) {
		this.tipoTramite = tipoTramite;
	}

}