/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe Processa programa
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.arquivos.ProcessaPrograma;

public class Main {

  /**
   * Programa que percorre uma classe java e para cada linha imprime o caracter
   * I no inicio de cada identificador, o caracter e o caractere N para cada
   * numero inteiro. Comentários devem ser ignorados.
   *
   * Este exercício pode ser extendido para o tratamento de números reais e
   * identificação de palavras reservadas do Java.
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {
    // Cria um processador de programas        
    ProcessadorDeProgramas pp = new ProcessadorDeProgramas();

    // Processa o código imagem.java
    pp.processarProgramas("./src/processaprograma/imagem.java");
  }
}
