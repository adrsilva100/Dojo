package br.com.teste.dojo.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartidaVO {

	private Date dataInicio;
	private Date dataFim;
	private String nome;
	private Map<String, PartidaDetalheVO> detalhes = new HashMap<String, PartidaDetalheVO>();
	
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Map<String, PartidaDetalheVO> getDetalhes() {
		return detalhes;
	}
	
	public List<PartidaDetalheVO> getListaOrdernada(){
        List<PartidaDetalheVO> lista = new ArrayList<PartidaDetalheVO>(detalhes.values());
        Collections.sort(lista, Collections.reverseOrder());
        return lista;
    }
}
