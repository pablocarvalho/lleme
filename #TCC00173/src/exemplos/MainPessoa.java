package exemplos;

import exemplos.pessoa.Pessoa;

public class MainPessoa {

  public static void main(String[] args) {
    Pessoa pessoa1 = new Pessoa();
    pessoa1.nome = "José";
    pessoa1.altura = 1.81f;
    pessoa1.peso = 90.0f;

    Pessoa pessoa2 = new Pessoa();
    pessoa2.nome = "marcelo";
    pessoa2.altura = 1.75f;
    pessoa2.peso = 76.0f;

    int[] numeros = new int[3];
    System.out.println(numeros[0]);
    Pessoa[] pessoas = new Pessoa[3];
    pessoas[0] = null;
    pessoas[0] = pessoa1;
    pessoas[0].nome = "xyz";
    pessoas[1] = pessoa2;
    System.out.println(pessoas[0].nome);

    System.out.println(pessoa1.imc());
    System.out.println(pessoa2.imc());


  }
}
