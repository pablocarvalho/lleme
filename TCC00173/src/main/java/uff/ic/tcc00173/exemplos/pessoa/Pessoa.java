package uff.ic.tcc00173.exemplos.pessoa;

public class Pessoa {

  public String nome;
  public float peso;
  public float altura;

  public float imc() {
    return peso / (float) Math.pow(altura, 2);
  }
}
