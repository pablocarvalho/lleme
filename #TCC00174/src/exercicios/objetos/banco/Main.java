package exercicios.objetos.banco;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {
    Banco[] bancos = new Banco[10];
    try {
      bancos[0] = new Banco(1, "Banco 1");
      String banco = "./banco1";
      FileInputStream file = new FileInputStream(banco + "/contas.dat");
      Scanner in = new Scanner(file);
      
      Conta conta = null;
      int numero = 0;
      int tipo = 0;
      float limite = 0;
      while (in.hasNext()) {
        numero = in.nextInt();
        tipo = in.nextInt();
        limite = in.nextFloat();
        
        if (tipo == 1)
          conta = new ContaComum(numero);
        else
          conta = new ContaEspecial(numero, limite);
        
        bancos[0].criarConta(conta);
        
      }
      
      file.close();
    } catch (IOException e) {
    }
  }
}
