/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios.arquivos.direto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luiz Leme
 */
public class Main2 {

  public static void main(String[] args) {
    try (RandomAccessFile file = new RandomAccessFile("nome", "r");) {
      
      file.seek(22);
      
      throw new MinhaException("dfgsdgf");
      
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
    }catch (IOException ex) {
      Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
    }
  }
}
