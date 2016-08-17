package provas.s20102.p320102ex2;

public class Avaliacao {

  public String matricula;
  public float p3 = 0f;
  public float trabalho = 0f;

  public Avaliacao(String matricula) {
    this.matricula = matricula;
  }

  public float getMedia() {
    return 0.3f * trabalho + 0.7f * p3;
  }
}
