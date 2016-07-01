package edu.uniandes.alcaldiavirtual.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DOC_X_TIPO_TRAMITE database table.
 * 
 */
@Entity
@Table(name="DOC_X_TIPO_TRAMITE")
@NamedQuery(name="DocXTipoTramite.findAll", query="SELECT d FROM DocXTipoTramite d")
public class DocXTipoTramite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOC_X_TIPO_TRAMITE_CONSECUTIVO_GENERATOR", sequenceName="SEQ_DOC_TIPO_TRAMITE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOC_X_TIPO_TRAMITE_CONSECUTIVO_GENERATOR")
	private long consecutivo;

	private String estado;

	//bi-directional many-to-one association to DocumentoPlantilla
	@ManyToOne
	@JoinColumn(name="DOC_PLANTILLA_ID")
	private DocumentoPlantilla documentoPlantilla;

	//bi-directional many-to-one association to TipoTramite
	@ManyToOne
	@JoinColumn(name="TIPO_TRAMITE_ID")
	private TipoTramite tipoTramite;

	public DocXTipoTramite() {
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

	public DocumentoPlantilla getDocumentoPlantilla() {
		return this.documentoPlantilla;
	}

	public void setDocumentoPlantilla(DocumentoPlantilla documentoPlantilla) {
		this.documentoPlantilla = documentoPlantilla;
	}

	public TipoTramite getTipoTramite() {
		return this.tipoTramite;
	}

	public void setTipoTramite(TipoTramite tipoTramite) {
		this.tipoTramite = tipoTramite;
	}

}