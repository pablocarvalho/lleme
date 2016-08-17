package exemplos;

public class InverterVetor {

  public static void main(String[] args) {
    int[] v = {1, 5, 6, 3, 99};
    inverter(v, 4);
    System.out.println(EscreverVetor.toString(v, 0));
  }

  public static void inverter(int[] v, int i) {
    int aux;
    i = i < 0 ? 0 : i;
    if (i < (v.length / 2)) {
      aux = v[i];
      v[i] = v[v.length - 1 - i];
      v[v.length - 1 - i] = aux;
      inverter(v, ++i);
    }
  }
}
