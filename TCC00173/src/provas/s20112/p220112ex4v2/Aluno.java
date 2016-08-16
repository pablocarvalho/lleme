package provas.s20112.p220112ex4v2;

public class Aluno {

  public int matricula = 0;
  public String nome = null;
  public String endereco = null;

  public Aluno(){
    
  }
  public Aluno(int matricula, String nome) {
    this.matricula = matricula;
    this.nome = nome;
  }

  public String primeiroNome() {
    int fim = nome.indexOf(" ");
    fim = (fim == -1 ? nome.length() : fim);
    return nome.substring(0, fim);
  }
}
