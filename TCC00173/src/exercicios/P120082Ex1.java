package exercicios;

public class P120082Ex1 {

  public static void main(String[] args) {


    int t1H = 10, t1M = 34, t1S = 26;
    int t2H = 14, t2M = 15, t2S = 0;

    int t1 = converteHms(t1H, t1M, t1S);
    int t2 = converteHms(t2H, t2M, t2S);
    int duracao = t2 - t1;
    converteHms(10, 20, 30);
    imprimeHms(duracao);

  }

  public static int converteHms(int hora, int minuto, int segundo) {
    return hora * 3600 + minuto * 60 + segundo;
  }

  public static void imprimeHms(int duracao) {
    int hora = duracao / 3600;
    int minuto = (duracao % 3600) / 60;
    int segundo = (duracao % 3600) % 60;
    System.out.println(hora + ":" + minuto + ":" + segundo);
  }
}
