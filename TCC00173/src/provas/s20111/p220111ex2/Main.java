package provas.s20111.p220111ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

  public static int faixas = 25;

  public static void main(String[] args) throws FileNotFoundException {
    Item item;
    Compra compra = null, compras[] = new Compra[20];
    int codigo, codigoAnt = -1, pos = 0;
    InputStream input = new FileInputStream("compras.txt");
    Scanner in = new Scanner(input);
    while (in.hasNext()) {
      codigo = in.nextInt();
      if (codigo != codigoAnt) {
        compra = new Compra(codigo);
        compras[pos++] = compra;
        codigoAnt = codigo;
      }
      item = new Item(in.nextInt(), in.nextFloat());
      compra.addItem(item);
    }
    in.close();

    float menorValor = 1E10f, maiorValor = 0;
    for (int i = 0; i < compras.length && compras[i] != null; i++) {
      if (compras[i].getValor() < menorValor)
        menorValor = compras[i].getValor();
      if (compras[i].getValor() > maiorValor)
        maiorValor = compras[i].getValor();
    }
    float[] hist = histograma(compras, menorValor, maiorValor);

    float faixa, limite = 1E10f;
    for (int i = 0; i < hist.length; i++) {
      faixa = menorValor + i * (maiorValor - menorValor) / faixas;
      if (hist[i] < 0.2 && faixa < limite)
        limite = faixa;
      System.out.println(faixa + "\t" + hist[i] * 100);
    }
    System.out.println(limite);
  }

  public static float[] histograma(Compra[] compras, float menorValor, float maiorValor) {
    int faixa, qtd = 0;
    float delta = (maiorValor - menorValor) / faixas, histograma[] = new float[faixas];
    for (int i = 0; i < compras.length && compras[i] != null; i++) {
      qtd++;
      faixa = (int) ((compras[i].getValor() - menorValor) / delta);
      for (int j = 0; j < histograma.length && j <= faixa; j++)
        histograma[j]++;
    }
    for (int i = 0; i < histograma.length; i++)
      histograma[i] /= qtd;
    return histograma;
  }
}
