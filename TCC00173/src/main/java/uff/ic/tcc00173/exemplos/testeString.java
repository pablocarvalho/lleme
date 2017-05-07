package uff.ic.tcc00173.exemplos;

public class testeString {

  public static void main(String[] args) {
    String nome = "abcdefghij";
    char[] caracteres = nome.toCharArray();
    nome = String.copyValueOf(caracteres);
    System.out.println(nome);
  }
}
