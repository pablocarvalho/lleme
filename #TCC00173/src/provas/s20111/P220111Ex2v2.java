package provas.s20111;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import provas.s20111.p220111ex2v2.Compra;
import provas.s20111.p220111ex2v2.Item;

public class P220111Ex2v2 {

  public static void main(String[] args) {
    Compra[] compras = new Compra[50];
    carregarCompras(compras);

    for (Compra compra : compras)
      if (compra != null)
        System.out.println(compra.codigo + ": " + compra.valor());

  }

  public static void carregarCompras(Compra[] compras) {
    int codigo;
    int qtd;
    float valor;
    int tamanho = compras.length;
    Item item;
    int codigoAnt;
    int i = -1;
    int j = 0;
    int cont;
    try (InputStream input = new FileInputStream("./dat/compras.txt");
         Scanner in = new Scanner(input);) {
      codigoAnt = -1;
      cont = 0;
      while (in.hasNext() && cont < tamanho) {
        codigo = in.nextInt();
        qtd = in.nextInt();
        valor = in.nextFloat();
        if (codigo != codigoAnt) {
          compras[++i] = new Compra(codigo);
          codigoAnt = codigo;
          j = 0;
          cont++;
        }
        item = new Item();
        item.qtd = qtd;
        item.valor = valor;
        compras[i].itens[j++] = item;
      }
    } catch (Throwable e) {
    }
  }
}
