package exercicios.objetos.polinomios;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Polimomio
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class Polinomio {

  private int[] coeficientes; //> Coeficientes do polinomio
  private int grau;         //> Grau do polinomio 

  /**
   * Construtor.
   *
   * @param grau Grau do polinomio.
   */
  Polinomio(int grau) {
    this.grau = grau;
    this.coeficientes = new int[grau + 1];
    for (int i = 0; i <= grau; i++)
      coeficientes[i] = 0;
  }

  /**
   * Construtor.
   *
   * @param coeficientes Coeficientes do polinomio.
   */
  Polinomio(int[] coeficientes) {
    grau = coeficientes.length - 1;
    this.coeficientes = new int[grau + 1];
    for (int i = 0; i <= grau; i++)
      this.coeficientes[i] = coeficientes[i];
  }

  /**
   * Acesso ao coeficiente do monomio de grau i.
   *
   * @param i Grau do monomio
   * @return o valor do coeficiente.
   */
  public int getCoef(int i) {
    int coef = 0;
    try {
      coef = coeficientes[i];
    } catch (ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    }
    return coef;
  }

  /**
   * Atribui o valor do coeficiente do monomio de grau i.
   *
   * @param i Grau do monomio
   * @param c o valor do coeficiente.
   */
  public void setCoef(int i, int c) {
    try {
      coeficientes[i] = c;
    } catch (ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    }
  }

  /**
   * Soma de polinomios.
   *
   * @param p Polinomio que sera somado
   * @return a soma dos pominomios
   */
  public Polinomio somar(Polinomio p) {
    int menorGrau, maiorGrau;
    Polinomio maiorPol;

    if (p.grau > this.grau) {
      maiorGrau = p.grau;
      menorGrau = this.grau;
      maiorPol = p;
    } else {
      maiorGrau = this.grau;
      menorGrau = p.grau;
      maiorPol = this;
    }

    Polinomio q = new Polinomio(maiorGrau);
    for (int i = 0; i <= menorGrau; i++)
      q.coeficientes[i] = this.coeficientes[i] + p.coeficientes[i];
    for (int i = menorGrau + 1; i <= maiorGrau; i++)
      q.coeficientes[i] = maiorPol.coeficientes[i];
    return q;
  }

  /**
   * Multiplicacao de polinomios.
   *
   * @param p Polinomio que sera multiplicado
   * @return a multiplicacao dos pominomios
   */
  public Polinomio multiplicar(Polinomio p) {
    Polinomio q = new Polinomio(p.grau + this.grau);
    for (int i = 0; i <= p.grau; i++)
      for (int j = 0; j <= this.grau; j++) {
        int valor = q.getCoef(i + j) + p.getCoef(i) * this.getCoef(j);
        q.setCoef(i + j, valor);
      }

    return q;
  }

  /**
   * Imprime os polinomios.
   */
  public void print() {
    for (int i = grau; i > 0; i--)
      System.out.print(coeficientes[i] + "x^" + i + "+");
    System.out.println(coeficientes[0]);
  }
}
