package com.cabral.martin.interfaces;

import com.cabral.martin.entities.Bien;
import com.cabral.martin.exceptions.BienExistenteException;

public interface SegurosGenerales {
	
	public void agregarBienAsegurado(Bien bien) throws BienExistenteException ;

}
