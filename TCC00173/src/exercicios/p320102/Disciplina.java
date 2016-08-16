package exercicios.p320102;

public class Disciplina {

  public String nomeDisciplina;
  public Avaliacao[] avaliacoes = new Avaliacao[10];

  public Avaliacao recuperarAvaliacao(String matricula) {
    for (int i = 0; i < avaliacoes.length; i++)
      if (avaliacoes[i] != null && avaliacoes[i].matricula.equals(matricula))
        return avaliacoes[i];
    return null;
  }
}