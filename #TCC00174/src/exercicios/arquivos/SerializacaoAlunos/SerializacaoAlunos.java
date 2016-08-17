package exercicios.arquivos.SerializacaoAlunos;

/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe Serialização de Alunos
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializacaoAlunos {

  /**
   * Programa que ilustra como serializar objetos de uma classe. No exemplo o
   * objeto é uma classe que encapsula uma lista de alunos implementada como um
   * array. A serialização salva e permite recuperar toda a lista como um
   * objeto único.
   *
   * Um teste interessante é tornar o array de alunos transiente na classe
   * Alunos e fazer Aluno não ser serializavel. O resultado é que o objeto da
   * classe Alunos é recuperado, contudo o array de alunos não é.
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {
    // Criacao dos alunos
    Aluno aluno1 = new Aluno("Anselmo", 111, 7.0);
    Aluno aluno2 = new Aluno("Carlos", 222, 8.0);
    Aluno aluno3 = new Aluno("Philipe", 333, 6.0);

    // Criacao da lista de alunos
    Alunos alunos = new Alunos(10);
    alunos.add(aluno1);
    alunos.add(aluno2);
    alunos.add(aluno3);

    try {
      // Cria um fluxo de arquivo
      FileOutputStream fo = new FileOutputStream("alunos.obj");
      // Cria fluxos de objetos
      ObjectOutputStream oo = new ObjectOutputStream(fo);
      oo.writeObject(alunos);
      // Imprime antes de destruir
      System.out.println("Antes da destruicao");
      alunos.print();

      // Destroi os objetos
      alunos = null;
      aluno1 = null;
      aluno2 = null;
      aluno3 = null;

      // Cria um fluxo de arquivo
      FileInputStream fi = new FileInputStream("alunos.obj");
      // Cria um fluxo de objeto
      ObjectInputStream oi = new ObjectInputStream(fi);
      System.out.println("Apos destruicao dos objetos");
      alunos = (Alunos) oi.readObject();
      // Imprime depois da leitura
      alunos.print();
    } catch (IOException ex) {
      ex.printStackTrace();
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }

  }
}
