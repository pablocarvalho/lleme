package oo;

public class Programa1 {

  public static void main(String[] args) {

    Turma turma = new Turma();
    turma.disciplina = "Prog I";
    turma.Horario = "manha";

    Turma turma2 = new Turma();
    turma2.disciplina = "Calc I";
    turma2.Horario = "manha";

    AlunoGraduacao aluno = new AlunoGraduacao();
    
    aluno.matricula = 123;
    aluno.nome = "luiz";
    aluno.notaEnem = 9f;
    aluno.turmas[0] = turma;
    aluno.turmas[1] = turma2;


    System.out.println(aluno.turmas[1].disciplina);
    aluno.listaDisciplinas();
  }
}
