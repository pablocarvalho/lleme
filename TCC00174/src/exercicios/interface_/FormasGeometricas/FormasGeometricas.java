package exercicios.interface_.FormasGeometricas;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Colecao de formas geometricas
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class FormasGeometricas {

  FormasGeometricas() {
    Circulo c1 = new Circulo(10.0, 100.0, 40.0, new Cor(255, 0, 0));
    Forma c2 = new Circulo(30.0, 300.0, 100.0, new Cor(40, 50, 140));
    Retangulo r1 = new Retangulo(100.0, 100.0, 80.0, 80.0, new Cor(30, 40, 20));
    Forma r2 = new Retangulo(200.0, 200.0, 85.0, 95.0, new Cor(0, 255, 0));
    Forma t1 = new Triangulo(150.0, 60.0, new Point2D(150.0, 160.0),
            new Point2D(250.0, 60.0), new Point2D(70.0, 40.0), new Cor(100, 20, 255));


    ColecaoFormas cf = new ColecaoFormas(10);

    cf.adicionarForma(r1);
    cf.adicionarForma(c1);
    cf.adicionarForma(c2);
    cf.adicionarForma(t1);
    cf.adicionarForma(r2);


    //Bubblesort.ordenar(cf.getFormas(),cf.getNumFormas());
    //  InsertionSort.ordenar(cf.getFormas(), cf.getNumFormas());

    cf.imprimirInfo();

    MainFrame mainFrame = new MainFrame(cf);
  }

  /**
   * Método principal.
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {

    FormasGeometricas formasGeometricasApp = new FormasGeometricas();
  }
}
