package com.cabral.martin.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cabral.martin.entities.Auto;
import com.cabral.martin.entities.CompaniaDeSeguro;
import com.cabral.martin.entities.Documento;
import com.cabral.martin.entities.Persona;
import com.cabral.martin.entities.PolizaAccidentesPersonales;
import com.cabral.martin.entities.PolizaCombinadoFamiliar;
import com.cabral.martin.entities.PolizaDeAuto;
import com.cabral.martin.entities.Vivienda;
import com.cabral.martin.enums.TipoBien;
import com.cabral.martin.enums.TipoDeBeneficiario;
import com.cabral.martin.enums.TipoDocumento;
import com.cabral.martin.exceptions.BienExistenteException;
import com.cabral.martin.exceptions.PersonaExistenteException;
import com.cabral.martin.exceptions.PolizaExistenteException;
import com.cabral.martin.interfaces.SeguroVida;

public class SegurosTest {

	@Test
	public void queSePuedaEmitirUnaPolizaDeAutos() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6050.0;
		
		Persona asegurado = new Persona(new Documento(TipoDocumento.DNI, 35987654), "Camila", 24);
		Auto auto = new Auto(TipoBien.AUTO, "Ford", "Fiesta", 2010);
		PolizaDeAuto poliza = new PolizaDeAuto(NUMERO_DE_POLIZA,auto, asegurado, SUMA_ASEGURADA, PRIMA);
		
		try {
			poliza.agregarBienAsegurado(auto);
		} catch (BienExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		assertEquals(NUMERO_DE_POLIZA, poliza.getNumeroPoliza());
		assertEquals(asegurado, poliza.getAsegurado());
		assertEquals(PREMIO, poliza.getPremio());
		assertTrue(poliza.getAutos().contains(auto));
		
	}
	
	
	@Test
	public void queSePuedaEmitirUnaPolizaDeVida() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6050.0;
		
		Persona asegurado = new Persona(new Documento(TipoDocumento.DNI, 35987654), "Camila", 24);
		Persona hijo = new Persona(new Documento(TipoDocumento.DNI, 65456231), "Raul", 60);
		Persona conyuge = new Persona(new Documento(TipoDocumento.DNI, 65456231), "Raul", 60);

		
		SeguroVida poliza = new PolizaAccidentesPersonales(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA);
		try {
			poliza.agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
			poliza.agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);
		} catch (PersonaExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Integer beneficiariosEsperados = 1;

	
		assertEquals(beneficiariosEsperados, poliza.obtenerCantidadDeBeneficiarios());
		assertEquals(asegurado, ((PolizaAccidentesPersonales)poliza).getAsegurado());
		assertEquals(PREMIO, ((PolizaAccidentesPersonales)poliza).getPremio());
	}
	
	@Test
	public void queSePuedaEmitirUnaPolizaDeCombinadoFamiliar() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 20000000.0, PRIMA = 50000.0, PREMIO = 60500.0;
		
		Vivienda casa = new Vivienda(TipoBien.CASA, "Florencio Varela 1800", "San Justo", "La Matanza", "Buenos Aires");
		Persona asegurado = new Persona(new Documento(TipoDocumento.DNI, 35987654), "Camila", 24);
		Persona hijo = new Persona(new Documento(TipoDocumento.DNI, 35987654), "Arturo", 15);
		Persona hija = new Persona(new Documento(TipoDocumento.DNI, 55666747), "Maia", 8);
		Persona conyuge = new Persona(new Documento(TipoDocumento.DNI, 35987654), "Arturo", 30);
		
		PolizaCombinadoFamiliar poliza = new PolizaCombinadoFamiliar(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA);
		try {
			poliza.agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
			poliza.agregarBeneficiario(hija, TipoDeBeneficiario.HIJA);
			poliza.agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);
			poliza.agregarBienAsegurado(casa);
		} catch (Exception e) {

			e.printStackTrace();
		}

		
		Integer beneficiariosEsperados = 2;
	
		assertEquals(beneficiariosEsperados, poliza.obtenerCantidadDeBeneficiarios());
		assertEquals(asegurado, poliza.getAsegurado());
		assertEquals(PREMIO, poliza.getPremio());
	}
	
	@Test
	public void queSePuedanAdministrarDistintosTiposDePolizas() {
	
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
		
		Auto auto = new Auto(TipoBien.AUTO, "Ford", "Fiesta", 2010);
		
		
	
		try {
			libra.agregarPoliza(new PolizaDeAuto(1, new Auto(TipoBien.AUTO, "Ford", "Fiesta", 2010), new Persona(new Documento(TipoDocumento.DNI, 35987654), "Camila", 24), 2000000.0, 5000.0));
			libra.agregarPoliza(new PolizaDeAuto(2, new Auto(TipoBien.AUTO, "Fiat", "Idea", 2018), new Persona(new Documento(TipoDocumento.DNI, 51878666), "rogelio", 14), 1500000.0, 4000.0));
			libra.agregarPoliza(new PolizaAccidentesPersonales(3, new Persona(new Documento(TipoDocumento.DNI, 88855544), "Marta", 54), 2000000.0, 5000.0));
			libra.agregarPoliza(new PolizaCombinadoFamiliar(4, new Persona(new Documento(TipoDocumento.DNI, 32487654), "Natalia", 24), 2000000.0, 5000.0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		assertEquals((Integer)4, libra.obtenerLaCantidadDePolizasEmitidas());
	}
	

	@Test
	public void queSePuedaDenunciarUnSiniestroParaUnaPolizaDeVida(){
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
		
	
		try {
			libra.agregarPoliza(new PolizaAccidentesPersonales(numeroDePoliza, new Persona(new Documento(TipoDocumento.DNI, 35987654), "Camila", 24), 2000000.0, 5000.0));
		} catch (PolizaExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		libra.denunciarSiniestro(1);
		
		PolizaAccidentesPersonales polizaEsperada = (PolizaAccidentesPersonales) libra.getListaPolizas().get(0);
		
		
		
		assertTrue(polizaEsperada.getTuvoAccidente());
		
	}
	

}
