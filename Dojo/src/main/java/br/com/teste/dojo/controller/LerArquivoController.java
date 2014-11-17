package br.com.teste.dojo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.teste.dojo.service.ProcessarArquivoService;
import br.com.teste.dojo.vo.PartidaVO;

@Controller
public class LerArquivoController {
	
	@Autowired ProcessarArquivoService processar;
	
	@RequestMapping(value="/processarArquivo", method=RequestMethod.POST)
	public String processarArquivoLog(Model model,HttpServletRequest request
			, final RedirectAttributes redirectAttrs) throws IOException {
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("file");

		File file = multipartFileToFile(multipartFile);
		
		if(file.exists() && file.getName().endsWith(".txt")){
			List<PartidaVO> listaPartidas = processar.processarArquivo(file);
			model.addAttribute("listaPartida", listaPartidas);
			return "processar";
		}else{
			return "redirect:index.jsp";
		}
	}

	private File multipartFileToFile(MultipartFile multipart) throws IllegalStateException, IOException {
		File convFile = new File( multipart.getOriginalFilename());
		multipart.transferTo(convFile);
		return convFile;
	}
}
