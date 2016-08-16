package exercicios.objetos.ordenacao;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe Automovel
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class Automovel implements IComparavel {

  private String marca;           //> Marca do automovel
  private float velocidadeMaxima; //> Velocidade maxima do automovel 

  /**
   * Construtor.
   *
   * @param marca Marca do automovel.
   * @param velMax Velocidade máxima do automovel.
   */
  Automovel(String marca, float velMax) {
    this.marca = marca;
    this.velocidadeMaxima = velMax;
  }

  /**
   * Acesso a marca do automovel.
   *
   * @return marca do automovel.
   */
  public String getMarca() {
    return marca;
  }

  /**
   * Atribui uma marca ao automovel.
   *
   * @param marca Marca do automovel.
   */
  public void setMarca(String marca) {
    this.marca = marca;
  }

  /**
   * Acesso a velocidade maxima do automovel.
   *
   * @return velocidade maxima do automovel.
   */
  public float getVelocidadeMaxima() {
    return velocidadeMaxima;
  }

  /**
   * Atribui a velocidade maxima do automovel.
   *
   * @param velMax Velocidade maxima do automovel.
   */
  public void setVelocidadeMaxima(float velMax) {
    this.velocidadeMaxima = velMax;
  }

  /**
   * Metodo que compara automoveis.
   *
   * @param comparavel Objeto a ser comparado.
   */
  public int compararCom(IComparavel comp) {

    /* Polimorfismo:     
     * Cria uma referência da classe Aluno para o objeto do tipo comparavel
     */
    Automovel auto = (Automovel) comp;

    // Compara as velocidades maximas dos automoveis
    if (this.velocidadeMaxima < auto.velocidadeMaxima)
      return -1;
    if (this.velocidadeMaxima > auto.velocidadeMaxima)
      return 1;
    return 0;
  }

  /**
   * Imprime os atributos do automovel.
   */
  public void imprimir() {
    System.out.println("Marca:" + getMarca() + ", VelMax:" + getVelocidadeMaxima());
  }
}
