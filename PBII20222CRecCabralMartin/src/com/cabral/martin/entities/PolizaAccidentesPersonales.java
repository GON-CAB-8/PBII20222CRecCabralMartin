package com.cabral.martin.entities;

import java.util.HashMap;
import java.util.Map;
import com.cabral.martin.enums.TipoDeBeneficiario;
import com.cabral.martin.exceptions.PersonaExistenteException;
import com.cabral.martin.interfaces.SeguroVida;

public class PolizaAccidentesPersonales extends Poliza implements SeguroVida {

	private Integer numeroPoliza;
	private Persona asegurado;
	private Map<Persona, TipoDeBeneficiario> beneficiarios;
	private Double sumaAsegurada;
	private Double prima;
	private Double premio;
	private Boolean tuvoAccidente;

	public PolizaAccidentesPersonales(Integer numeroPoliza, Persona asegurado, Double sumaAsegurada, Double prima) {
		this.beneficiarios = new HashMap<>();
		this.numeroPoliza = numeroPoliza;
		this.asegurado = asegurado;
		this.sumaAsegurada = sumaAsegurada;
		this.prima = prima;
		this.premio = prima * 1.21;
		this.tuvoAccidente = Boolean.FALSE;
	}

	public Integer getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(Integer numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public Persona getAsegurado() {
		return asegurado;
	}

	public void setAsegurado(Persona asegurado) {
		this.asegurado = asegurado;
	}

	public Map<Persona, TipoDeBeneficiario> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(Map<Persona, TipoDeBeneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public Double getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(Double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public Double getPrima() {
		return prima;
	}

	public void setPrima(Double prima) {
		this.prima = prima;
	}

	public Double getPremio() {
		return premio;
	}

	public void setPremio(Double premio) {
		this.premio = premio;
	}
	
	

	public Boolean getTuvoAccidente() {
		return tuvoAccidente;
	}

	public void setTuvoAccidente(Boolean tuvoAccidente) {
		this.tuvoAccidente = tuvoAccidente;
	}

	@Override
	public void agregarBeneficiario(Persona persona, TipoDeBeneficiario tipo) throws PersonaExistenteException {
		try {
			beneficiarios.put(persona, tipo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer obtenerCantidadDeBeneficiarios() {
		return this.beneficiarios.size();
	}

}
