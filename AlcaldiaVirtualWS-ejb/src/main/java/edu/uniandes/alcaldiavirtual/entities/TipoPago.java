package edu.uniandes.alcaldiavirtual.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TIPO_PAGO database table.
 * 
 */
@Entity
@Table(name="TIPO_PAGO")
@NamedQuery(name="TipoPago.findAll", query="SELECT t FROM TipoPago t")
public class TipoPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_PAGO_TIPOPAGOID_GENERATOR", sequenceName="SEQ_TIPO_PAGO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_PAGO_TIPOPAGOID_GENERATOR")
	@Column(name="TIPO_PAGO_ID")
	private long tipoPagoId;

	private String nombre;

	public TipoPago() {
	}

	public long getTipoPagoId() {
		return this.tipoPagoId;
	}

	public void setTipoPagoId(long tipoPagoId) {
		this.tipoPagoId = tipoPagoId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}