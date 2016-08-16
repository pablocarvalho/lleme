package exemplos.oo.aluno;

public class Aluno {

  public static String universidade;
  public String nome;
  public int matricula;
  public float p1 = 0f;
  public float p2;
  public final int periodo = 20102;

  public Aluno(String nome, int matricula) {
    this.nome = nome;
    this.matricula = matricula;
  }

  public Aluno(String nome) {
    this.nome = nome;
  }

  public void setNome(String nome) {
  }

  public float media() {
    return (p1 + p2) / 2;
  }
}
