package br.com.teste.dojo.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import br.com.teste.dojo.service.ProcessarArquivoService;
import br.com.teste.dojo.vo.PartidaDetalheVO;
import br.com.teste.dojo.vo.PartidaVO;

public class TesteMain {

	public static void main(String[] args) throws IOException {
		ProcessarArquivoService processar = new ProcessarArquivoService();
		
		File file = new File("F:/Desktop/log.txt");
		
		if(file.exists()){
			List<PartidaVO> listaPartidas = processar.processarArquivo(file);
			
			
			for (PartidaVO partidaVO : listaPartidas) {
				System.out.println("Partida: " + partidaVO.getNome());
				
				for (PartidaDetalheVO partidaDetalheVO : partidaVO.getListaOrdernada()) {
					System.out.println("Nome: " + partidaDetalheVO.getJogadorVO().getNome());
					System.out.println("Assassinatos: " + partidaDetalheVO.getQtdeAssassinato());
					System.out.println("Mortes: " + partidaDetalheVO.getQtdeMorte());
					System.out.println("Arma que mais matou pelo jogador: " + partidaDetalheVO.getArmaQueMaisMatouPeloJogador());
				}
			}
		}else{
			System.out.println("Arquivo não existe");
		}
	}
}
