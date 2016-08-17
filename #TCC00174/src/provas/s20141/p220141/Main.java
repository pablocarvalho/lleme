package provas.s20141.p220141;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

  public static void main(String[] args) {

    MapaProduto produtos = new MapaProduto();
    Fila filaVendas = new Fila();
    Pilha pilhaVendas = new Pilha();

    try (InputStream in = new FileInputStream("")) {
      Scanner sc = new Scanner(in);

      int qtdVendas = 0;
      if (sc.hasNext())
        qtdVendas = sc.nextInt();

      for (int i = 0; i < qtdVendas; i++) {
        Venda venda = new Venda();
        venda.setNumero(sc.nextInt());
        venda.setData(sc.nextLine());

        int codProd = sc.nextInt();
        Produto produto = produtos.obter(codProd);
        if (produto == null) {
          produto = new Produto();
          produto.setCodigo(codProd);
          produto.setNome(sc.nextLine());
          venda.setQtd(sc.nextInt());
          produto.setPreco(sc.nextFloat());
          produtos.incluir(produto);
        } else {
          sc.nextLine();
          venda.setQtd(sc.nextInt());
          sc.nextFloat();
        }
        venda.setProduto(produto);

        filaVendas.enfilera(venda);
        pilhaVendas.empilha(venda);

      }

    } catch (FileNotFoundException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
    }

    try (OutputStream out1 = new FileOutputStream("saida_inversa.dat", false);
         ObjectOutputStream osI = new ObjectOutputStream(out1);
         OutputStream out2 = new FileOutputStream("saida_direta.dat", false);
         ObjectOutputStream osD = new ObjectOutputStream(out2);) {
      Venda venda = null;

      do {
        venda = pilhaVendas.desempilha();
        if (venda != null)
          osI.writeObject(venda);

        venda = filaVendas.desenfilera();
        if (venda != null)
          osD.writeObject(venda);
      } while (venda != null);

    } catch (IOException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
    }

  }
}
