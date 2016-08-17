package exercicios.objetos.universidade;

public class Professor extends Pessoa {

  private int siape;
  private String pesquisa;
  private String instituto;

  public void setPesquisa(String c) {
    pesquisa = c;
  }

  public String getPesquisa() {
    return pesquisa;
  }

  public String getInstituto() {
    return instituto;
  }

  public void setInstituto(String i) {
    instituto = i;
  }

  public int getSiape() {
    return siape;
  }

  public void setSiape(int s) {
    if (s > 9999999)
      System.out.println("Inválido");
    else
      siape = s;
  }

  public void setProfessor(int siap, String ins, String pesq, String nome, String endereco, String cpf, int idade, long telefone, long identidade) {
    setSiape(siap);
    setPesquisa(pesq);
    setInstituto(ins);
    alterarPessoa(nome, endereco, cpf, idade, telefone, identidade);
  }
}
