/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe Main
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.arquivos.LeArquivoTexto;

import java.util.Scanner;
import javax.swing.JFileChooser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

  /**
   * Programa simples que lê uma arquivo texto de registro. Ilustra como ler os
   * campos de um registro separadamente usando o objeto da classe Scanner
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {
    try {
      InputStream in = new FileInputStream("fgsdfg");
      Scanner sc = new Scanner(in);
     
      
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }


    // Array de alunos
    Aluno[] alunos = new Aluno[10];

    // Diálogo para seleção de arquivos 
    JFileChooser fc = new JFileChooser();
    // Objeto que receberá o arquivo
    File file = null;

    // Testa se o arquivo foi aberto com sucesso
    int returnVal = fc.showOpenDialog(null);
    if (returnVal == JFileChooser.APPROVE_OPTION)
      file = fc.getSelectedFile();

    try {
      // Cria um FileReader
      FileReader f = new FileReader(file);
      // Cria um Buffer de leitura
      BufferedReader buff = new BufferedReader(f);
      // End of file
      boolean eof = false;

      do {
        // Lê uma linha e armazena em s
        String s = buff.readLine();

        // Fim de papo.
        if (s == null)
          eof = true;
        else {
          // Leitura usando a classe scanner
          Scanner scanner = new Scanner(s);

          // Lê a matrícula
          int matricula = scanner.nextInt();
          //sscanner.useDelimiter(" ");
          String nome = scanner.next();
          //scanner.reset();

          // Lê a nota
          int nota = scanner.nextInt();

          // Armazena o aluno
          alunos[Aluno.numAlunos] = new Aluno(matricula, nome, nota);
          alunos[Aluno.numAlunos - 1].print();

          System.out.println(s);
        }

      } while (!eof);
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
