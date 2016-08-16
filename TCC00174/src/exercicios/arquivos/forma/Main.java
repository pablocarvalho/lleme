package exercicios.arquivos.forma;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

  public static void main(String[] args) {
    ColecaoFormas colecao = new ColecaoFormas();
    colecao.addForma(new Circulo(10), 2);

    try (OutputStream out = new FileOutputStream("formas.dat", false);
         ObjectOutputStream s = new ObjectOutputStream(out);) {
      s.writeObject(colecao);
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
    }

    ColecaoFormas colecao2;
    try (FileInputStream in = new FileInputStream("formas.dat");
         ObjectInputStream s = new ObjectInputStream(in);) {
      colecao2 = (ColecaoFormas) s.readObject();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
    }





  }
}
