package exercicios;

public class VS20102Ex1 {

  public static void main(String[] args) {
    float salarioMinimo = 500.0f;
    int pos, qtd = 0;
    float[] salarios = leSalarios("");
    float[] histograma = new float[10];

    for (int i = 0; i < salarios.length; i++) {
      pos = (int) (salarios[i] / salarioMinimo);
      if (pos < 10 || salarios[i] == 10 * salarioMinimo)
        qtd++;
      pos = (pos == 10) ? 9 : pos;
      for (int j = pos; j < histograma.length; j++)
        histograma[j]++;
    }

    for (int i = 0; i < histograma.length; i++) {
      histograma[i] /= (qtd / 100.0);
      System.out.println(histograma[i]);
    }
  }

  public static float[] leSalarios(String nomeArquivo) {
    float[] salarios = {100.4f, 200.5f, 278.5f, 300.4f, 5000.0f};
    // programar carga de salarios
    return salarios;
  }
}
