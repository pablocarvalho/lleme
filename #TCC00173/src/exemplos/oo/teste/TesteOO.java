package exemplos.oo.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class TesteOO {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    InputStream input = new FileInputStream(".\\dat\\compras.txt");
    Scanner in = new Scanner(input);

    Compra[] compras = new Compra[11];
    int i = 0;
    int idCompraAnt = 0;
    Compra compra = null;

    InputStream input2 = new FileInputStream(".\\dat\\produtos.txt");
    Scanner in2 = new Scanner(input);
    Produto[] produtos = new Produto[10];
    int j = 0;
    while (in2.hasNext()) {
      int idProduto = in.nextInt();
      produtos[j] = new Produto();
      produtos[j].id = idProduto;
      j++;
    }
    in2.close();



    while (in.hasNext()) {
      int idCompra = in.nextInt();
      int qtdProduto = in.nextInt();
      int idProduto = in.nextInt();

      if (idCompra != idCompraAnt) {
        compra = new Compra();
        compra.id = idCompra;
        compras[i++] = compra;
        idCompraAnt = idCompra;
      }

      Item item = new Item();
      item.qtd = qtdProduto;

      item.produto = obterProduto(idProduto, produtos);

      compra.incluirItem(item);

    }
    input.close();



  }

  public static float[] histograma(Compra[] compras, float menor, float maior,
          int faixas) {
    float delta = (maior - menor) / faixas;
    float histograma[] = new float[faixas];
    for (int i = 0; i < compras.length; i++) {
      float numero = compras[i].valorTotal();
      if (numero >= menor && numero <= maior) {
        int faixa = (int) ((numero - menor) / delta);
        if (faixa == faixas)
          faixa--;
        histograma[faixa]++;
      }
    }
    return histograma;
  }

  public static Produto obterProduto(int id, Produto[] produtos) {
    for (int i = 0; i < produtos.length; i++)
      if (produtos[i].id == id)
        return produtos[i];
    return null;
  }
}
