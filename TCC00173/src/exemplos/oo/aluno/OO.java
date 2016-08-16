package exemplos.oo.aluno;

public class OO {

  public static void main(String[] args) {
    AlunoPos aluno1 = new AlunoPos("Aluno A", 1234);
    AlunoPos aluno2 = new AlunoPos("Aluno B", 567);

    aluno1.p1 = 7.5f;
    aluno1.p2 = aluno2.p2 + 9.0f;
    Aluno.universidade = "UFF";
    aluno1.orientador = "orientador";
    System.out.println(aluno1.nome);
    System.out.println(aluno1.media());
    System.out.println(aluno1.periodo);

    aluno2.p1 = 8.5f;
    aluno2.p2 = 6.4f;
    System.out.println(Aluno.universidade);
    System.out.println(aluno2.nome);
    System.out.println(aluno2.media());
  }
}
