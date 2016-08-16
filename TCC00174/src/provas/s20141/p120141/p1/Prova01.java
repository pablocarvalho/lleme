package provas.s20141.p120141.p1;

import java.util.Scanner;
import provas.s20141.p120141.mtx.Matriz;
import provas.s20141.p120141.mtx.MatrizDensa;
import provas.s20141.p120141.mtx.MatrizIdentidade;

public class Prova01 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    boolean falhou = false;
    int linhas = 0;
    int colunas = 0;

    // primeira parte
    MatrizDensa m1 = null;
    do
      try {
        falhou = false;
        linhas = in.nextInt();
        colunas = in.nextInt();
        m1 = new MatrizDensa(linhas, colunas);
      } catch (Exception e) {
        falhou = true;
      }
    while (falhou);

    for (int i = 0; i < linhas; i++)
      for (int j = 0; j < colunas; j++)
        do {
          falhou = false;
          try {
            m1.atribuir(i, j, in.nextDouble());
          } catch (Exception e) {
            falhou = true;
          }
        } while (falhou);

    // segunda parte
    falhou = false;
    MatrizIdentidade m2 = null;
    do
      try {
        linhas = in.nextInt();
        m2 = new MatrizIdentidade(linhas);
      } catch (Exception e) {
        falhou = true;
      }
    while (falhou);

    imprimir(m1);
    imprimir(m2);
  }

  private static void imprimir(Matriz m1) {
    for (int i = 0; i < m1.numeroDeLinhas(); i++) {
      for (int j = 0; j < m1.numeroDeColunas(); j++)
        System.out.print(m1.obter(i, j) + "\t");
      System.out.println("   ");
    }
  }
}
