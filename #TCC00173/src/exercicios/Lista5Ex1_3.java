package exercicios;

public class Lista5Ex1_3 {

  public static void main(String[] args) {
    int numero;
    int produtorio = 1;
    for (numero = 1; numero <= 15; numero += 2)
      produtorio *= numero;
    numero = 1;
    produtorio = 1;
    while (numero <= 15) {
      produtorio *= numero;
      numero += 2;
    }
    System.out.println("produtorio=" + produtorio);

  }
}
