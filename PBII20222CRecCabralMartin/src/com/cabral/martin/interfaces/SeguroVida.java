package com.cabral.martin.interfaces;

import com.cabral.martin.entities.Persona;
import com.cabral.martin.enums.TipoDeBeneficiario;
import com.cabral.martin.exceptions.PersonaExistenteException;

public interface  SeguroVida {
	
	public void agregarBeneficiario(Persona persona, TipoDeBeneficiario tipo) throws PersonaExistenteException;

	public Integer obtenerCantidadDeBeneficiarios();


}
