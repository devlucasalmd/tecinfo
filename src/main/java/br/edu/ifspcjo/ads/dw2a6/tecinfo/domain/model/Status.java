package br.edu.ifspcjo.ads.dw2a6.tecinfo.domain.model;

import jakarta.persistence.Embeddable;

@Embeddable
public enum Status {

	EM_APROVACAO("Em Aprovação"),
	APROVADA("Aprovada"),
	EM_ANDAMENTO("Em Andamento"),
	FINALIZADA("Finalizada");
	
	private String description;
	
	private Status(String description) {
		this.description = description;
	}
	
	public String getStatus() {
		return description;
	}
}
