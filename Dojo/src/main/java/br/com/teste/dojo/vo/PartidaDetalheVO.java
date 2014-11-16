package br.com.teste.dojo.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartidaDetalheVO implements Comparable<PartidaDetalheVO>{

	private JogadorVO jogadorVO;
	private ArmaVO armaVO;
	private int qtdeAssassinato;
	private int qtdeMorte;
	private Map<String, PartidaDetalheArmaVO> listaArmas = new HashMap<String, PartidaDetalheArmaVO>();

	public int getQtdeAssassinato() {
		return qtdeAssassinato;
	}
	public void setQtdeAssassinato(int qtdeAssassinato) {
		this.qtdeAssassinato = qtdeAssassinato;
	}
	public int getQtdeMorte() {
		return qtdeMorte;
	}
	public void setQtdeMorte(int qtdeMorte) {
		this.qtdeMorte = qtdeMorte;
	}

	public void adicionarMorte() {
		qtdeMorte++;
	}

	public void adicionarAssassinato(ArmaVO armaVO) {
		PartidaDetalheArmaVO partidaDetalheArmaVO = new PartidaDetalheArmaVO();

		partidaDetalheArmaVO.setArma(armaVO);
		if (!listaArmas.containsKey(armaVO.getModelo())) {
			listaArmas.put(armaVO.getModelo(), partidaDetalheArmaVO);
		}
		listaArmas.get(armaVO.getModelo()).adicionarMortesPelaArma();

		qtdeAssassinato++;
	}
	
	public String getArmaQueMaisMatouPeloJogador() {
        if (listaArmas.isEmpty()) {
            return "";
        }
        List<PartidaDetalheArmaVO> lista = new ArrayList<PartidaDetalheArmaVO>(listaArmas.values());
        Collections.sort(lista, Collections.reverseOrder());
        return lista.get(0).getArma().getModelo();
    }

	public int compareTo(PartidaDetalheVO arg0) {
		if (qtdeAssassinato < arg0.getQtdeAssassinato()) {
			return -1;
		} else if (qtdeAssassinato > arg0.getQtdeAssassinato()) {
			return 1;
		}
		return 0;
	}
	
	public JogadorVO getJogadorVO() {
		return jogadorVO;
	}
	public void setJogadorVO(JogadorVO jogadorVO) {
		this.jogadorVO = jogadorVO;
	}
	public Map<String, PartidaDetalheArmaVO> getListArmas() {
		return listaArmas;
	}
	public void setListArmas(Map<String, PartidaDetalheArmaVO> listArmas) {
		this.listaArmas = listArmas;
	}
	public ArmaVO getArmaVO() {
		return armaVO;
	}
	public void setArmaVO(ArmaVO armaVO) {
		this.armaVO = armaVO;
	}
	public Map<String, PartidaDetalheArmaVO> getListaArmas() {
		return listaArmas;
	}
	public void setListaArmas(Map<String, PartidaDetalheArmaVO> listaArmas) {
		this.listaArmas = listaArmas;
	}
}
