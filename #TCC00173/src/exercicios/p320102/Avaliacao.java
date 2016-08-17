package exercicios.p320102;

class Avaliacao {

  public String matricula;
  public float p3;
  public float trab;

  public Avaliacao(String matricula) {
    this.matricula = matricula;

  }

  public float calcularMedia() {
    return (p3 + trab) / 2;
  }
}
