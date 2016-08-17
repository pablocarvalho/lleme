package provas.s20112.p220112ex4v2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class P220112Ex4 {

  public static void main(String[] args) {
    int nAlunos = 10;
    int cont = 0;
    Aluno[] alunos = new Aluno[nAlunos];
    try (InputStream input = new FileInputStream("");) {
      Scanner in = new Scanner(input);
      while (in.hasNext() && cont < nAlunos) {
        int matricula = in.nextInt();
        String nome = in.nextLine();
        
        alunos[cont] = new Aluno(matricula, nome);        
      }

    } catch (FileNotFoundException ex) {
      Logger.getLogger(P220112Ex4.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(P220112Ex4.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
    }
  }
}
