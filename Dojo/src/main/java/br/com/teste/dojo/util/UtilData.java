package br.com.teste.dojo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilData {

	public static Date formatarStringParaData(String data){
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
