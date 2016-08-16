package exercicios;

public class VS20102Ex2 {

  public static void main(String[] args) {
    float[][] ponto = lePonto("");
    float[][] estag = leEstagiario("");
    float minHoras = 0;
    float soma;
    float contador;
    for (int i = 0; i < ponto.length; i++) {
      minHoras = minHoras(ponto[i][0], estag);
      soma = 0;
      contador = 0;
      for (int j = 1; j < ponto[0].length; j++) {
        soma += ponto[i][j];
        if (ponto[i][j] >= minHoras)
          contador++;
      }

      if (contador == ponto[0].length - 1)
        System.out.println("matricula " + ponto[i][0]
                + " 15 dias");
      else if (soma >= (ponto[0].length - 1) * minHoras)
        System.out.println("matricula " + ponto[i][0]
                + " 10 dias");
      else
        System.out.println("matricula " + ponto[i][0]
                + " " + contador + " dias");
    }

  }

  public static float minHoras(float matricula, float[][] estagiarios) {
    float min = 0;
    for (int i = 0; i < estagiarios.length; i++)
      if (matricula == estagiarios[i][0])
        return estagiarios[i][1];
    return min;
  }

  public static float[][] lePonto(String nomeArquivo) {
    float[][] ponto = new float[10][7];
    // completar com leitura de arquivo
    return ponto;
  }

  public static float[][] leEstagiario(String nomeArquivo) {
    float[][] estagiario = new float[10][2];
    // completar com leitura de arquivo
    return estagiario;
  }
}
