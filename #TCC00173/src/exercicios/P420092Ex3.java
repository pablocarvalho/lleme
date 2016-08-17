package exercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class P420092Ex3 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    float[][] produtos = carregaProdutos(".\\dat\\produtos.txt");
    for (int linha = 0; linha < produtos.length; linha++)
      for (int coluna = 0; coluna < produtos[0].length; coluna++)
        System.out.println(produtos[linha][coluna]);

    float[][] pedidos = carregaPedidos(".\\dat\\pedidos.txt");
    for (int linha = 0; linha < pedidos.length; linha++)
      for (int coluna = 0; coluna < pedidos[0].length; coluna++)
        System.out.println(pedidos[linha][coluna]);
    float preco = 0;
    for (int linha = 0; linha < pedidos.length; linha++) {
      preco = buscaPreco(pedidos[linha][1], produtos);
      pedidos[linha][3] = preco * pedidos[linha][2];
    }
    int cont = 0;
    float soma = 0;
    for (int linha = 0; linha < pedidos.length; linha++)
      soma += pedidos[linha][3];
    float media = soma / pedidos.length;

  }

  public static float buscaPreco(float produto, float[][] produtos) {
    float preco = 0;
    for (int linha = 0; linha < produtos.length; linha++)
      if (produtos[linha][0] == produto)
        return produtos[linha][1];
    return preco;
  }

  public static float[][] carregaPedidos(String arquivo) throws FileNotFoundException, IOException {
    float[][] pedidos = new float[20][4];
    int linha = 0;
    InputStream input = new FileInputStream(arquivo);
    Scanner in = new Scanner(input);
    while (in.hasNext()) {
      pedidos[linha][0] = in.nextInt();
      pedidos[linha][1] = in.nextInt();
      pedidos[linha][2] = in.nextInt();
      linha++;
    }
    input.close();
    return pedidos;
  }

  public static float[][] carregaProdutos(String arquivo) throws FileNotFoundException, IOException {
    float[][] produtos = new float[5][2];
    int linha = 0;
    InputStream input = new FileInputStream(arquivo);
    Scanner in = new Scanner(input);
    while (in.hasNext()) {
      produtos[linha][0] = in.nextInt();
      produtos[linha][1] = in.nextFloat();
      linha++;
    }
    input.close();
    return produtos;
  }

  public static float buscaPreco(int produto, float[][] produtos) {
    float preco = 0;


    return preco;
  }
}
