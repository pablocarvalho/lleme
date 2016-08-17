package exercicios.arquivos.compras;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

  private static Produto[] produtos = new Produto[100];

  public static void main(String[] args) {
    Compra[] compras = new Compra[100];
    int pos = 0;

    try (InputStream in = new FileInputStream("compras.txt");) {
      Scanner sc = new Scanner(in);

      int codigo = 0;
      int qtd = 0;
      double preco = 0;
      String nome = null;

      Compra compra = null;
      int codigoAnt = -1;

      while (sc.hasNext()) {
        codigo = sc.nextInt();
        qtd = sc.nextInt();
        preco = sc.nextDouble();
        nome = sc.nextLine();

        Produto produto = buscarProduto(nome,preco);
        Item item = new Item(qtd, produto);
        if (codigo != codigoAnt)
          compra = new Compra(codigo);
        compra.incluiItem(item);
        compras[pos++] = compra;

        codigoAnt = codigo;
      }

    } catch (FileNotFoundException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
    } finally {
    }

    try (OutputStream out = new FileOutputStream("compras2.txt", false)) {
      OutputStreamWriter buff = new OutputStreamWriter(out);

      for (int i = 0; i < compras.length; i++) {
        Compra compra = compras[i];
        if (compra != null)
          for (int j = 0; j < compra.getItens().length; j++)
            if (compra.getItens()[j] != null) {
              buff.write(compra.getCodigo() + " ");
              buff.write(compra.getItens()[j].getQtd() + " ");
              buff.write(compra.getItens()[j].getProduto().getPreco() * 2 + " ");
              buff.write(compra.getItens()[j].getProduto().getNome());
              buff.write("\n");
            }
      }

    } catch (FileNotFoundException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
    }
  }

  private static Produto buscarProduto(String nome, double preco) {
    Produto produto =null;
    for (Produto p : produtos)
      if (p != null && p.getNome().equals(nome))
        return p;
    produto = new Produto(nome,preco);
    return produto;
  }
}
