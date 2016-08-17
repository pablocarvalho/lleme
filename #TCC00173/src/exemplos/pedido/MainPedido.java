package exemplos.pedido;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MainPedido {

  public static void main(String[] args) throws FileNotFoundException, IOException {


    InputStream input = new FileInputStream("produtos.txt");
    Scanner scan = new Scanner(input);
    Produto[] produtos = new Produto[50];
    int pos = 0;
    while (scan.hasNext() && pos < 50) {
      produtos[pos] = new Produto();
      produtos[pos].codigo = scan.nextInt();
      produtos[pos].preco = scan.nextInt();
      pos++;
    }
    input.close();

    input = new FileInputStream("pedidos.txt");
    scan = new Scanner(input);
    Pedido[] pedidos = new Pedido[50];
    pos = 0;
    while (scan.hasNext() && pos < 50) {
      pedidos[pos] = new Pedido();
      pedidos[pos].id = scan.nextInt();
      pedidos[pos].produto = Produto.buscaProduto(scan.nextInt(), produtos);
      pedidos[pos].qtd = scan.nextInt();
      pos++;
    }
    input.close();


    for (int i = 0; i < pedidos.length; i++) {
      float valor = pedidos[i].valor();
      System.out.println(pedidos[i].id + " " + valor);
    }

  }
}
