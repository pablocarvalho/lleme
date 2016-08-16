package exemplos;

public class ConversaoBinaria {

  public static void main(String[] args) {

    int numero = 10;
    byte[] digitos = new byte[10];
    int pos = digitos.length - 1;
    while (numero / 2 != 0) {
      digitos[pos--] = (byte) (numero % 2);
      numero = numero / 2;
    }
    digitos[pos--] = (byte) (numero % 2);

    for (int i = 0; i < digitos.length; i++)
      System.out.print(digitos[i] + " ");
  }
}
