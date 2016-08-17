package exemplos;

import java.util.Scanner;

public class DiferencaHoras {

  public static void main(String[] args) {
    // TODO code application logic here

    int hora1, hora2, minuto1, minuto2, conversao1, conversao2, diferenca1;

    Scanner in = new Scanner(System.in);

    System.out.println("Entre com a hora: ");
    hora1 = in.nextInt();

    System.out.println("Entre com o minuto: ");
    minuto1 = in.nextInt();

    System.out.println("Entre com a segunda hora: ");
    hora2 = in.nextInt();

    System.out.println("Entre com o segundo minuto: ");
    minuto2 = in.nextInt();

    conversao1 = converterMinutos(hora1, minuto1);
    conversao2 = converterMinutos(hora2, minuto2);

    diferenca1 = diferencaHora(hora1, minuto1, hora2, minuto2);

    System.out.println(conversao1 + " " + conversao2);
    System.out.println(diferenca1);


  }

  public static int converterMinutos(int hora, int minuto) {
    int horaMinutos = hora * 60 + minuto;

    return horaMinutos;

  }

  public static int diferencaHora(int hora1, int minuto1, int hora2, int minuto2) {
    int direncaMinutos = converterMinutos(hora2, minuto2) - converterMinutos(hora1, minuto1);

    return direncaMinutos;
  }
}
