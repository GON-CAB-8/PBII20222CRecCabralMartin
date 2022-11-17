package com.cabral.martin.entities;

import com.cabral.martin.enums.TipoBien;

public abstract class Bien {
	private TipoBien tipoBien;

	public Bien(TipoBien tipoBien) {
		super();
		this.tipoBien = tipoBien;
	}

	public TipoBien getTipoBien() {
		return tipoBien;
	}

	public void setTipoBien(TipoBien tipoBien) {
		this.tipoBien = tipoBien;
	}
	
	

}
