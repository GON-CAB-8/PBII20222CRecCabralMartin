package com.cabral.martin.entities;

import java.util.ArrayList;
import java.util.List;

import com.cabral.martin.exceptions.PolizaExistenteException;

public class CompaniaDeSeguro {
	
	private String nombre;
	private List<Poliza> listaPolizas;
	
	public CompaniaDeSeguro(String nombre) {
		super();
		this.nombre = nombre;
		this.listaPolizas = new ArrayList<>();
	}
	
	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public List<Poliza> getListaPolizas() {
		return listaPolizas;
	}



	public void setListaPolizas(List<Poliza> listaPolizas) {
		this.listaPolizas = listaPolizas;
	}



	public void agregarPoliza(Poliza poliza) throws PolizaExistenteException {
		this.listaPolizas.add(poliza);
		
	}



	public Integer obtenerLaCantidadDePolizasEmitidas() {
		return this.listaPolizas.size();
	}



	public void denunciarSiniestro(int nroPoliza) {
		for (Poliza poliza : listaPolizas) {
			if(((PolizaAccidentesPersonales)poliza).getNumeroPoliza().equals(nroPoliza)) {
				((PolizaAccidentesPersonales)poliza).setTuvoAccidente(Boolean.TRUE);
			}
		}
		
	}








	
	


}
