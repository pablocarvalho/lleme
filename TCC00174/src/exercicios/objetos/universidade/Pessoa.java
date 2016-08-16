package exercicios.objetos.universidade;

public class Pessoa {

  private String nome, endereco, cpf;
  private int idade;
  private long telefone, identidade;

  public void alterarPessoa(String nome, String endereco, String cpf, int idade, long telefone, long identidade) {
    setNome(nome);
    setEndereco(endereco);
    setCpf(cpf);
    setIdade(idade);
    setIdentidade(identidade);
    setTelefone(telefone);
  }

  public void setCpf(String cpf) {
    if (cpf.length() > 11) {
      System.out.println("Cpf Invalido");
      cpf = "";
    }
    try {

      Integer.parseInt(cpf);
    } catch (NumberFormatException e) {

      System.out.println("Cpf Invalido");
      cpf = "";

    }


    this.cpf = cpf;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void setIdade(int idade) {
    if (idade > 120) {
      System.out.println("Idade Invalida");
      idade = 0;

    }
    this.idade = idade;
  }

  public void setIdentidade(long identidade) {
    if (identidade > 9999999999l) {
      System.out.println("Identidade invalida");
      identidade = 0;
    }

    this.identidade = identidade;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setTelefone(long telefone) {
    if (telefone > 99999999) {
      System.out.println("Telefone Invalido");
      telefone = 0;
    }
    this.telefone = telefone;
  }

  public String getCpf() {
    return cpf;
  }

  public String getEndereco() {
    return endereco;
  }

  public int getIdade() {
    return idade;
  }

  public long getIdentidade() {
    return identidade;
  }

  public String getNome() {
    return nome;
  }

  public long getTelefone() {
    return telefone;
  }
}
