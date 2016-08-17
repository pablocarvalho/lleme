package exercicios.backtracking.processaprograma;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anselmomontenegro
 */
public class ProcessadorDeProgramas {

  private boolean comentario;

  public Imagem processarLinha(String linha) {
    Imagem imagem = new Imagem(linha.length());

    int pos = 0;

    while (pos < linha.length())
      if (comentario) {
        while (pos < linha.length() - 1 && !ehFimComentario(pos, linha))
          pos++;

        if (pos < linha.length() - 1 && ehFimComentario(pos, linha)) {
          comentario = false;
          pos = pos + 2;
        } else
          pos++;
      } else if (ehInicioComentario(pos, linha)) {

        comentario = true;
        pos = pos + 2;

      } else if (linha.charAt(pos) == '"') {

        do
          pos++;
        while (linha.charAt(pos) != '"');
        pos++;
      } else if (ehLetra(linha.charAt(pos))) {

        imagem.getSimb().setCharAt(pos, 'I');
        imagem.setNumId(imagem.getNumId() + 1);

        while (ehLetra(linha.charAt(pos))
                || ehDigito(linha.charAt(pos)))
          pos++;
      } else if (ehDigito(linha.charAt(pos))) {
        imagem.getSimb().setCharAt(pos, 'N');
        imagem.setNumNumbers(imagem.getNumNumbers() + 1);
        while (ehDigito(linha.charAt(pos)))
          pos++;
      } else
        pos++;

    return imagem;
  }

  public static boolean ehDigito(char c) {
    return (c >= '0' && c <= '9');
  }

  public static boolean ehLetra(char c) {
    return (Character.toUpperCase(c) >= 'A' && Character.toUpperCase(c) <= 'Z');
  }

  public static boolean ehInicioComentario(int pos, String linha) {
    return (linha.charAt(pos) == '/' && linha.charAt(pos + 1) == '*');
  }

  public static boolean ehFimComentario(int pos, String linha) {
    return (linha.charAt(pos) == '*' && linha.charAt(pos + 1) == '/');
  }

  public void processarProgramas(String nomePrograma) {
    FileReader file = null;
    try {
      file = new FileReader(nomePrograma);
      BufferedReader buff = new BufferedReader(file);
      comentario = false;
      while (buff.ready()) {
        String linha = buff.readLine();
        System.out.println(linha);
        Imagem imagem = processarLinha(linha);
        imagem.print();
      }
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    } catch (EOFException ex) {
      ex.printStackTrace();
    } catch (IOException ex) {
      ex.printStackTrace();
    }

  }
}
