package exercicios;

public class ListaRevisaoP1 {

  public static void main(String[] args) {
    String t1 = "10:34:26";
    String t2 = "14:15:00";

    String[] partes1 = t1.split(":");
    String[] partes2 = t2.split(":");

    int segundos1, segundos2, tempo;

    segundos1 = Integer.parseInt(partes1[0]) * 3600
            + Integer.parseInt(partes1[1]) * 60
            + Integer.parseInt(partes1[2]);
    segundos2 = Integer.parseInt(partes2[0]) * 3600
            + Integer.parseInt(partes2[1]) * 60
            + Integer.parseInt(partes2[2]);

    tempo = segundos2 - segundos1;

    int horas = tempo / 3600;
    int minutos = (tempo % 3600) / 60;
    int segundos = (tempo % 3600) % 60;
    System.out.println(horas + ":" + minutos + ":" + segundos);
  }
}
