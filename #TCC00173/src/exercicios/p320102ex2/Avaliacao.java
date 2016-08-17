package exercicios.p320102ex2;

public class Avaliacao {

  public String matricula;
  public float p3;
  public float trabalho;

  public float media() {
    return 0.3f * trabalho + 0.7f * p3;
  }
}
