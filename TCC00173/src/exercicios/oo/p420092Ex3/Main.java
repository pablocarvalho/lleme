package exercicios.oo.p420092Ex3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

  private static final int N_PRODUTOS = 5;
  private static final int N_PEDIDOS = 3;
  private static Produto[] produtos = new Produto[N_PRODUTOS];
  private static Pedido[] pedidos = new Pedido[N_PEDIDOS];

  public static void main(String[] args) throws FileNotFoundException {
    InputStream input = new FileInputStream("Produtos.txt");
    Scanner in = new Scanner(input);
    int i = 0;
    while (in.hasNext() && i < N_PRODUTOS) {
      produtos[i] = new Produto();
      produtos[i].codigo = in.nextInt();
      produtos[i].preco = in.nextFloat();
      i++;
    }
    in.close();

    input = new FileInputStream("Pedidos.txt");
    in = new Scanner(input);
    i = 0;
    while (in.hasNext() && i < N_PRODUTOS) {
      pedidos[i] = new Pedido();
      pedidos[i].numero = in.nextInt();
      pedidos[i].produto = buscaProduto(in.nextInt());
      pedidos[i].qtd = in.nextInt();
      i++;
    }
    in.close();

    for (int j = 0; j < pedidos.length; j++)
      System.out.println(pedidos[j].numero + " valor = " + pedidos[j].calcPreco());

  }

  public static Produto buscaProduto(int codigo) {
    for (int i = 0; i < produtos.length; i++)
      if (produtos[i].codigo == codigo)
        return produtos[i];
    return null;
  }
}
