package edu.uniandes.alcaldiavirtual.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DOCUMENTO_PLANTILLA database table.
 * 
 */
@Entity
@Table(name="DOCUMENTO_PLANTILLA")
@NamedQuery(name="DocumentoPlantilla.findAll", query="SELECT d FROM DocumentoPlantilla d")
public class DocumentoPlantilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOCUMENTO_PLANTILLA_DOCPLANTILLAID_GENERATOR", sequenceName="SEQ_DOCUMENTO_PLANTILLA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCUMENTO_PLANTILLA_DOCPLANTILLAID_GENERATOR")
	@Column(name="DOC_PLANTILLA_ID")
	private long docPlantillaId;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to DocXTipoTramite
	@OneToMany(mappedBy="documentoPlantilla")
	private List<DocXTipoTramite> docXTipoTramites;

	public DocumentoPlantilla() {
	}

	public long getDocPlantillaId() {
		return this.docPlantillaId;
	}

	public void setDocPlantillaId(long docPlantillaId) {
		this.docPlantillaId = docPlantillaId;
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

	public List<DocXTipoTramite> getDocXTipoTramites() {
		return this.docXTipoTramites;
	}

	public void setDocXTipoTramites(List<DocXTipoTramite> docXTipoTramites) {
		this.docXTipoTramites = docXTipoTramites;
	}

	public DocXTipoTramite addDocXTipoTramite(DocXTipoTramite docXTipoTramite) {
		getDocXTipoTramites().add(docXTipoTramite);
		docXTipoTramite.setDocumentoPlantilla(this);

		return docXTipoTramite;
	}

	public DocXTipoTramite removeDocXTipoTramite(DocXTipoTramite docXTipoTramite) {
		getDocXTipoTramites().remove(docXTipoTramite);
		docXTipoTramite.setDocumentoPlantilla(null);

		return docXTipoTramite;
	}

}