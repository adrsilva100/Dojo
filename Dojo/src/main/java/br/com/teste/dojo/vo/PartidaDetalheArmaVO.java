package br.com.teste.dojo.vo;

public class PartidaDetalheArmaVO implements Comparable<PartidaDetalheArmaVO>{

	private ArmaVO arma;
    private int qtdeMortes;
	
    public void adicionarMortesPelaArma(){
    	qtdeMortes++;
    }
    
	public int compareTo(PartidaDetalheArmaVO arg0) {
		if (qtdeMortes < arg0.getQtdeMortes()) {
            return -1;
        } else if (qtdeMortes > arg0.getQtdeMortes()) {
            return 1;
        }
        return 0;    
	}

	public ArmaVO getArma() {
		return arma;
	}

	public void setArma(ArmaVO arma) {
		this.arma = arma;
	}

	public int getQtdeMortes() {
		return qtdeMortes;
	}

	public void setQtdeMortes(int qtdeMortes) {
		this.qtdeMortes = qtdeMortes;
	}
}
