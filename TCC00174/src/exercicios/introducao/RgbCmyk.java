package exercicios.introducao;

/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Conversao de Cores
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class RgbCmyk {

  /**
   * Calcula o máximo de tres valores em ponto flutuante.
   *
   * @param x Primeiro ponto flutuante.
   * @param y Segundo ponto flutuante.
   * @param z Terceiro valor.
   * @return O máximo entre x, y e z.
   */
  public static float max(float x, float y, float z) {
    float w = (x >= y) ? x : y;
    return (w >= z) ? w : z;
  }

  /**
   * Converte de rgb para cmyk.
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {
    try {
      // Recebe os argumentos da linha de comando
      int r = Integer.parseInt(args[0]);
      int g = Integer.parseInt(args[1]);
      int b = Integer.parseInt(args[2]);
      float c, m, y, k;
      // Cor preta
      if (r == 0 && g == 0 && b == 0) {
        c = m = y = 0.0f;
        k = 1.0f;
      } // Conversao
      else {
        float w = max(r / 255.0f, g / 255.0f, b / 255.0f);

        c = (w - (r / 255.0f)) / w;
        m = (w - (g / 255.0f)) / w;
        y = (w - (b / 255.0f)) / w;
        k = 1.0f - w;
      }
      // Imprime os valores
      System.out.println("R=" + r + " G=" + g + " B=" + b);
      System.out.println("C=" + c + " M=" + m + " Y=" + y + " K=" + k);

    } // Erro no numero de argumentos        
    catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(e.toString());
    } // Erro no formato dos argumentos        
    catch (NumberFormatException e) {
      System.out.println(e.toString());
    }
  }
}
