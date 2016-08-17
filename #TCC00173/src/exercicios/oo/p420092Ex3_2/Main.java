package exercicios.oo.p420092Ex3_2;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

  static Produto produtos[] = new Produto[5];
  static Pedido pedidos[] = new Pedido[5];

  public static void main(String[] args) throws FileNotFoundException {
    InputStream input = new FileInputStream("Produtos.txt");
    Scanner in = new Scanner(input);
    int n = 0;
    Produto produto;
    while (in.hasNext()) {
      produto = new Produto();
      produto.codigo = in.nextInt();
      produto.preco = in.nextFloat();
      produtos[n] = produto;
      n++;
    }
    in.close();

    input = new FileInputStream("Pedidos.txt");
    in = new Scanner(input);
    n = 0;
    Pedido pedido;
    float media = 0;
    while (in.hasNext()) {
      pedido = new Pedido();
      pedido.numero = in.nextInt();
      pedido.produto = buscaProduto(in.nextInt());
      pedido.qtd = in.nextInt();
      pedidos[n] = pedido;
      media += pedido.calcValor();
      n++;
    }
    media = media / n;
    in.close();

    for (int i = 0; i < pedidos.length; i++)
      if (pedidos[i].calcValor() >= media)
        System.out.println(pedidos[i].numero + ", " + pedidos[i].calcValor());
  }

  private static Produto buscaProduto(int codigo) {
    for (int i = 0; i < produtos.length; i++)
      if (produtos[i].codigo == codigo)
        return produtos[i];
    return null;
  }
}
