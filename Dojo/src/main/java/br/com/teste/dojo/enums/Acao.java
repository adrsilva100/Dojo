package br.com.teste.dojo.enums;

public enum Acao {
	HAS_STARTED("has started"), HAS_ENDED("has ended");
	
	Acao(String label){
		this.label = label;
	}
	
	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
