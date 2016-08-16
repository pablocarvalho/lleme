package exercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class P220072Ex1_v2 {

  public static void main(String[] args) {

    try (InputStream input = new FileInputStream("./dat/vendas.txt");) {
      Scanner in = new Scanner(input);
      float lucro = 0;
      while (in.hasNext()) {
        int codigo = in.nextInt();
        int qtd = in.nextInt();
        float custo = in.nextFloat();
        float venda = in.nextFloat();
        lucro += qtd * (venda - custo);
      }
      System.out.println(lucro);

    } catch (FileNotFoundException ex) {
      Logger.getLogger(P220072Ex1_v2.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(P220072Ex1_v2.class.getName()).log(Level.SEVERE, null, ex);
    }


  }
}
