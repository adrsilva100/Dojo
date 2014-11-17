package br.com.teste.dojo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.teste.dojo.enums.Acao;
import br.com.teste.dojo.vo.ArmaVO;
import br.com.teste.dojo.vo.JogadorVO;
import br.com.teste.dojo.vo.PartidaDetalheVO;
import br.com.teste.dojo.vo.PartidaVO;

@Service
public class ProcessarArquivoService {
	
	private PartidaVO partidaVO;
	private List<PartidaVO> listaPartidas = new ArrayList<PartidaVO>();

	public List<PartidaVO> processarArquivo(File arquivoLog) throws IOException{
		BufferedReader bfReader =  null;
		
		listaPartidas.clear();
		try{
			bfReader = new BufferedReader(new FileReader(arquivoLog));
			String linhaArquivo = bfReader.readLine();
			
			while (linhaArquivo != null) {
				processarLinha(linhaArquivo);
				linhaArquivo = bfReader.readLine();
			}
		}catch(Exception e){
			e.printStackTrace();
			bfReader.close();
		}finally{
			bfReader.close();	
		}

		return listaPartidas;
	}
	
	public boolean processarLinha(String linhaArquivo){
		if(linhaArquivo.contains("<WORLD>")){
			return false;
		}
		int indexAcao = linhaArquivo.indexOf("-");
        String dataNaoFormatada = linhaArquivo.substring(0, indexAcao);
        Date data = formatarStringParaData(dataNaoFormatada);
        String acao = linhaArquivo.substring(indexAcao, linhaArquivo.length());
		
        if(acao.contains(Acao.HAS_STARTED.getLabel())){
        	novaPartida(data, acao);
        }else if(acao.contains(Acao.HAS_ENDED.getLabel())){
        	fimPartida(data);
        }else{
        	setarDetalhePartida(data, acao);
        }
        
		return true;
	}
	
	private void novaPartida(Date dataIncio, String acao) {
        partidaVO = new PartidaVO();
        String aux[] = acao.split(" ");
        partidaVO.setNome(aux[3]);
        partidaVO.setDataInicio(dataIncio);
    }
	
	private void fimPartida(Date dataFim) {
        partidaVO.setDataFim(dataFim);
        listaPartidas.add(partidaVO);
    }
	
	private void setarDetalhePartida(Date dataDetalhe, String acao) {
        String aux[] = acao.split(" ");
        
        JogadorVO assassino = new JogadorVO();
        assassino.setNome(aux[1]);
        
        JogadorVO vitima = new JogadorVO();
        vitima.setNome(aux[3]);
        
        ArmaVO armaVO = new ArmaVO();
        armaVO.setModelo(aux[5]);

        if (!partidaVO.getDetalhes().containsKey(assassino.getNome())) {
        	PartidaDetalheVO partidaDetalheVO = new PartidaDetalheVO();
        	
        	partidaDetalheVO.setJogadorVO(assassino);
        	partidaVO.getDetalhes().put(assassino.getNome(), partidaDetalheVO);
        }
        partidaVO.getDetalhes().get(assassino.getNome()).adicionarAssassinato(armaVO);

        if (!partidaVO.getDetalhes().containsKey(vitima.getNome())) {
        	PartidaDetalheVO partidaDetalheVO = new PartidaDetalheVO();
        	
        	partidaDetalheVO.setJogadorVO(vitima);
        	partidaVO.getDetalhes().put(vitima.getNome(), partidaDetalheVO);
        }
        partidaVO.getDetalhes().get(vitima.getNome()).adicionarMorte();
    }

	public PartidaVO getPartidaVO() {
		return partidaVO;
	}

	public void setPartidaVO(PartidaVO partidaVO) {
		this.partidaVO = partidaVO;
	}

	public List<PartidaVO> getListaPartidas() {
		return listaPartidas;
	}
	
	private static Date formatarStringParaData(String data){
		Date dataFormatada = new Date();
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		try {
			dataFormatada = formatoData.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dataFormatada;
	}
}
