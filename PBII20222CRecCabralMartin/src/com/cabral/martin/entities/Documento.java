package com.cabral.martin.entities;

import java.util.Objects;

import com.cabral.martin.enums.TipoDocumento;

public class Documento {
	private TipoDocumento tipoDocumento;
	private Integer numero;
	
	public Documento(TipoDocumento tipoDocumento, Integer numero) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.numero = numero;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero, tipoDocumento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		return Objects.equals(numero, other.numero) && tipoDocumento == other.tipoDocumento;
	}
	
	

}
