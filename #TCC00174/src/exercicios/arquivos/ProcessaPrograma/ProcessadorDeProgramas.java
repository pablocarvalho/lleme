/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe Processa programa
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.arquivos.ProcessaPrograma;

import java.io.*;

public class ProcessadorDeProgramas {

  private boolean comentario; //> flag de comentário.

  /**
   * Processa uma linha de código.
   *
   * @return resultado do processamento.
   */
  public Imagem processarLinha(String linha) {
    Imagem imagem = new Imagem(linha.length());

    // Inicia o processamento de uma linha na posicao pos=0
    int pos = 0;

    // Enquanto o fim da linha não for atingido ...
    while (pos < linha.length())
      // Se esta dentro de um comentário:
      if (comentario) {
        // Enquanto nao atinge o fim do comentario
        while (pos < linha.length() - 1 && !ehFimComentario(pos, linha))
          pos++;

        // Se saiu do while pois encontrou o fim do comentário
        if (pos < linha.length() - 1 && ehFimComentario(pos, linha)) {
          comentario = false;
          pos = pos + 2;
        } // Se atingiu o fim da linha
        else
          pos++;
      } // Se se é o inicio de um comentário
      else if (ehInicioComentario(pos, linha)) {

        comentario = true;
        pos = pos + 2;

      } // Se é uma String
      else if (linha.charAt(pos) == '"') {
        do
          pos++;
        while (linha.charAt(pos) != '"');

        pos++;
      } // Se é uma letra
      else if (ehLetra(linha.charAt(pos))) {

        imagem.getSimb().setCharAt(pos, 'I');
        imagem.setNumId(imagem.getNumId() + 1);

        while (ehLetra(linha.charAt(pos)) || ehDigito(linha.charAt(pos)))
          pos++;
      } // Se é um dígito
      else if (ehDigito(linha.charAt(pos))) {

        imagem.getSimb().setCharAt(pos, 'N');
        imagem.setNumNumbers(imagem.getNumNumbers() + 1);

        while (ehDigito(linha.charAt(pos)))
          pos++;
      } // todos os outros símbolos
      else
        pos++;
    return imagem;
  }

  /**
   * Testa se é um dígito.
   *
   * @param c caracter a ser testado.
   * @return o resultado do teste
   */
  public static boolean ehDigito(char c) {
    return (c >= '0' && c <= '9');
  }

  /**
   * Testa se é uma letra.
   *
   * @param c caracter a ser testado.
   * @return o resultado do teste
   */
  public static boolean ehLetra(char c) {
    return (Character.toUpperCase(c) >= 'A'
            && Character.toUpperCase(c) <= 'Z');
  }

  /**
   * Testa se é um início de comentário.
   *
   * @param pos posicao do caracter testado.
   * @param linha a linha que esta sendo testada.
   * @return o resultado do teste
   */
  public static boolean ehInicioComentario(int pos, String linha) {
    return (linha.charAt(pos) == '/'
            && linha.charAt(pos + 1) == '*');
  }

  /**
   * Testa se é um fim de comentário.
   *
   * @param pos posicao do caracter testado.
   * @param linha a linha que esta sendo testada.
   * @return o resultado do teste
   */
  public static boolean ehFimComentario(int pos, String linha) {
    return (linha.charAt(pos) == '*'
            && linha.charAt(pos + 1) == '/');
  }

  /**
   * Processa um programa.
   *
   * @param nomePrograma nome do arquivo testado
   */
  public void processarProgramas(String nomePrograma) {
    try {
      // Cria um FileReader
      FileReader file = new FileReader(nomePrograma);
      // Cria um BufferedReader
      BufferedReader buff = new BufferedReader(file);
      // Inicializa a variaável comentário
      comentario = false;

      // Enquanto o buffer estiver cheio
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
