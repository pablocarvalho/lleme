package exercicios.arquivos.compras;

public class Produto {

  private String nome=null;
  private double preco=0;

  public Produto(String nome, double preco) {
    this.nome=nome;
    this.preco=preco;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }
  
  
}
