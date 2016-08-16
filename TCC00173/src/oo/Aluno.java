package oo;

public abstract class Aluno extends Pessoa implements NewInterface {

  public static String universidade = null;
  public int matricula = 0;
  public String nome = "";
  public Turma[] turmas = new Turma[5];

  public void listaDisciplinas() {
    lista();
  }

  protected void lista() {
    for (Turma t : turmas)
      if (t != null)
        System.out.println(t.disciplina);
  }

  public float calculaIMC(float peso, float altura) {
    return peso / (altura * altura);
  }
  
  public abstract float calcularNota(float peso);
}
