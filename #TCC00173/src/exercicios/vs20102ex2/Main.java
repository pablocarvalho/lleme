package exercicios.vs20102ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    Estagiario[] estagiarios = carregarEstagiarios("estagiarios.txt",
            "ponto.txt");
    for (Estagiario estagiario : estagiarios) {
      int ferias = calcularFerias(estagiario);
      System.out.println(estagiario.matricula + " " + ferias);
    }
  }

  private static Estagiario[] carregarEstagiarios(String arqEstagiarios,
          String arqPonto) throws FileNotFoundException, IOException {
    int qtdEstagiarios = 10;
    Estagiario[] estagiarios = new Estagiario[qtdEstagiarios];
    try (InputStream input = new FileInputStream(arqEstagiarios);) {
      Scanner in = new Scanner(input);
      int pos = 0;
      while (in.hasNext() && pos < qtdEstagiarios) {
        estagiarios[pos] = new Estagiario();
        estagiarios[pos].matricula = in.nextInt();
        estagiarios[pos].minimoHoras = in.nextInt();
        pos++;
      }
    }
    try (InputStream input = new FileInputStream(arqPonto);) {
      Scanner in = new Scanner(input);
      while (in.hasNext()) {
        int matricula = in.nextInt();
        Estagiario estagiario = buscaEstagiario(estagiarios, matricula);
        if (estagiario != null)
          for (int i = 0; i < 6; i++)
            estagiario.ponto[i] = in.nextInt();
      }
    }
    return estagiarios;
  }

  private static int calcularFerias(Estagiario estagiario) {
    boolean categ1 = true;
    int totalHoras = 0, diasUltrapassou = 0;

    for (int i = 0; i < 6; i++) {
      totalHoras += estagiario.ponto[i];
      if (estagiario.minimoHoras > estagiario.ponto[i])
        categ1 = false;
      else
        diasUltrapassou++;
    }
    if (categ1)
      return 15;
    else if (totalHoras >= 6 * estagiario.minimoHoras)
      return 10;
    else
      return 1 * diasUltrapassou;
  }

  private static Estagiario buscaEstagiario(Estagiario[] estagiarios,
          int matricula) {
    for (Estagiario estagiario : estagiarios)
      if (estagiario.matricula == matricula)
        return estagiario;
    return null;
  }
}
