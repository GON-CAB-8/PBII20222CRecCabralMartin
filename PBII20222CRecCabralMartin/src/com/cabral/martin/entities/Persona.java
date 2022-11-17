package com.cabral.martin.entities;

import java.util.Objects;

public class Persona {
	private Documento documento;
	private String Nombre;
	private Integer edad;
	
	public Persona(Documento documento, String nombre, Integer edad) {
		super();
		this.documento = documento;
		Nombre = nombre;
		this.edad = edad;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(documento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(documento, other.documento);
	}
	
	
	

}
