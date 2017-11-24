package controleTrafego;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class GerarArquivos {
	
	public static void main (String args []) throws IOException {
		
		String diretorio = "C:\\Users\\Luana Uchôa\\Desktop\\ED";
		int quantidade = (int)(Math.random () * 15) + 1;
		
		File dir = new File(diretorio);
		if (!dir.exists()) {
			dir.mkdir();
		}

		for (int q = 0; q < quantidade; q++) {
			FileWriter arq = new FileWriter(diretorio + "\\fluxo" + new Date ().getTime() + ".txt");
			PrintWriter gravarArq = new PrintWriter(arq);
			for (int i = 1; i <= 5; i++) {
				int j = (int)((Math.random()*28)+1);
				int s = (int)((Math.random()*11)+1);
				int fluxo = (int) (Math.random() * 501);
				String data = String.format("%02d", j) + String.format("%02d", s) + "2017";
				gravarArq.println("S" + s + ";" + "R" + s + 1 + ";" + data + ";" + fluxo);
			}
			arq.close();
		}
	}

}
