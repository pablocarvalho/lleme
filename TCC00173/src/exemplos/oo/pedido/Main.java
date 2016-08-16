package exemplos.oo.pedido;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    Produto[] produtos = new Produto[10];
    Pedido[] pedidos = new Pedido[10];


    InputStream input = new FileInputStream("produtos.txt");
    Scanner in = new Scanner(input);
    int i = 0;
    while (in.hasNext())
      produtos[i++] = new Produto(in.nextInt(), in.nextFloat(), in.nextLine());
    input.close();

    input = new FileInputStream("pedidos.txt");
    in = new Scanner(input);
    i = 0;
    while (in.hasNext())
      pedidos[i++] = new Pedido(in.nextInt(), in.nextInt());
    input.close();

    input = new FileInputStream("itens.txt");
    in = new Scanner(input);
    i = 0;
    while (in.hasNext()) {
      int numeroPedido = in.nextInt();
      int qtd = in.nextInt();
      int codigoProduto = in.nextInt();
      int p = buscaProdutos(codigoProduto, produtos);
      if (p >= 0) {
        Produto produto = produtos[i];
        Item item = new Item(qtd, produto);
        int q = buscaPedido(numeroPedido, pedidos);
        if (q >= 0)
          pedidos[q].addItem(item);
      }
    }

    float[] hist = new float[3];
    for (int j = 0; j < pedidos.length || pedidos[i] == null; i++) {
      float valor = pedidos[i].valor();
      hist[faixa(valor, pedidos)]++;
    }



    input.close();

  }

  public static int buscaPedido(int numeroPedido, Pedido[] pedidos) {
    for (int i = 0; i < pedidos.length || pedidos[i] == null; i++)
      if (pedidos[i].numero == numeroPedido)
        return i;
    return -1;
  }

  public static int buscaProdutos(int codigoProduto, Produto[] produtos) {
    for (int i = 0; i < produtos.length || produtos[i] == null; i++)
      if (produtos[i].codigo == codigoProduto)
        return i;
    return -1;
  }

  private static int faixa(float valor, Pedido[] pedidos) {
    throw new UnsupportedOperationException("Not yet implemented");
  }
}
