package com.cabral.martin.entities;

import java.util.HashSet;
import java.util.Set;

import com.cabral.martin.exceptions.BienExistenteException;
import com.cabral.martin.interfaces.SegurosGenerales;

public class PolizaDeAuto extends Poliza implements SegurosGenerales {

	private Integer numeroPoliza;
	private Set<Auto> autos;
	private Persona asegurado;
	private Double sumaAsegurada;
	private Double prima;
	private Double premio;

	public PolizaDeAuto(Integer numeroPoliza, Auto auto, Persona asegurado, Double sumaAsegurada, Double prima) {
		super();
		this.numeroPoliza = numeroPoliza;
		this.autos = new HashSet<>();
		this.asegurado = asegurado;
		this.sumaAsegurada = sumaAsegurada;
		this.prima = prima;
		this.premio = prima * 1.21;
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

	public Set<Auto> getAutos() {
		return autos;
	}

	public void setAutos(Set<Auto> autos) {
		this.autos = autos;
	}

	public Double getPremio() {
		return premio;
	}

	public void setPremio(Double premio) {
		this.premio = premio;
	}



	@Override
	public void agregarBienAsegurado(Bien bien) throws BienExistenteException {
		try {
			autos.add((Auto) bien);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	
	
	

}
