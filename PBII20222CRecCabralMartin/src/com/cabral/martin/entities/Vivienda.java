package com.cabral.martin.entities;

import com.cabral.martin.enums.TipoBien;

public class Vivienda extends Bien{
	private String direccion;
	private String localidad;
	private String partido;
	private String provincia;
	
	
	public Vivienda(TipoBien tipoBien, String direccion, String localidad, String partido, String provincia) {
		super(tipoBien);
		this.direccion = direccion;
		this.localidad = localidad;
		this.partido = partido;
		this.provincia = provincia;
	}
	
	
	
	
	

}
