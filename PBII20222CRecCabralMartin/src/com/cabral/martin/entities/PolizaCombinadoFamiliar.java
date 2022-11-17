package com.cabral.martin.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.cabral.martin.enums.TipoDeBeneficiario;
import com.cabral.martin.exceptions.BienExistenteException;
import com.cabral.martin.exceptions.PersonaExistenteException;
import com.cabral.martin.interfaces.SeguroVida;
import com.cabral.martin.interfaces.SegurosGenerales;

public class PolizaCombinadoFamiliar extends Poliza implements SegurosGenerales, SeguroVida{
	
	private Integer numeroPoliza;
	private Persona asegurado;
	private Map<Persona, TipoDeBeneficiario> beneficiarios;
	private Set<Bien> bienes;
	private Double sumaAsegurada;
	private Double prima;
	private Double premio;
	
	
	public PolizaCombinadoFamiliar(Integer numeroPoliza, Persona asegurado, Double sumaAsegurada, Double prima) {
		this.beneficiarios = new HashMap<>();
		this.bienes = new HashSet<>();
		this.numeroPoliza = numeroPoliza;
		this.asegurado = asegurado;
		this.sumaAsegurada = sumaAsegurada;
		this.prima = prima;
		this.premio = prima*1.21;
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


	public Set<Bien> getBienes() {
		return bienes;
	}


	public void setBienes(Set<Bien> bienes) {
		this.bienes = bienes;
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




	@Override
	public void agregarBienAsegurado(Bien bien) throws BienExistenteException {
		try {
			this.bienes.add(bien);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	


	
	

}
