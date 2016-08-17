package exemplos.oo.ponto;

public class Aluno {

  public int matricula = 0;
  public String nome = null;
  private Notas notas = null;

  public Aluno(int matricula, String nome) {
    this.matricula = matricula;
    this.nome = nome;
  }

  public void addNotas(float p1, float p2, float p3) {
    notas = new Notas(p1, p2, p3);
  }

  public float maiorNota() {
    if (notas != null)
      if (notas.p1 > notas.p2)
        return notas.p1;
      else
        return notas.p2;
    return 0.0f;
  }

  public float notaFinal() {
    if (notas != null)
      return (notas.p1 + notas.p2) / 2;
    return 0.0f;
  }

  public float getP1() {
    if (notas != null)
      return notas.p1;
    return 0.0f;
  }

  public float getP2() {
    if (notas != null)
      return notas.p2;
    return 0.0f;
  }

  public float getP3() {
    if (notas != null)
      return notas.p3;
    return 0.0f;
  }
}
