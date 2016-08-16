package exercicios.objetos.universidade;

public class Aluno extends Pessoa {

  private double CR;
  private String curso;
  private int numaterias;

  public void setCR(double cr) {
    if (cr < 0 || cr > 10) {
      System.out.println("Invalido");
      this.CR = 0;
    } else
      this.CR = cr;
  }

  public double getCR() {
    return CR;
  }

  public void setCurso(String c) {
    curso = c;
  }

  public String getCurso() {
    return curso;
  }

  public void setMaterias(int n) {
    if (n < 0) {
      System.out.println("Invalido");
      numaterias = 0;
    } else
      numaterias = n;
  }

  public int getMaterias() {
    return numaterias;
  }

  public void alteraAluno(double c, String curso, int n, String nome, String endereco, String cpf, int idade, long telefone, long identidade) {
    setCR(c);
    setCurso(curso);
    setMaterias(n);
    alterarPessoa(nome, endereco, cpf, idade, telefone, identidade);
  }
}
