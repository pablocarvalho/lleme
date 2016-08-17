/**
 *
 * @author marcoslage
 */
package exercicios.backtracking.back;

public class Posicao implements ICandidato {

  private int i = 0;
  private int j = 0;
  private Object data = null;

  public Posicao(int i, int j) {
    this.i = i;
    this.j = j;
    this.data = null;
  }

  public Posicao(int i, int j, Object dat) {
    this.i = i;
    this.j = j;
    this.data = dat;
  }

  public int getI() {
    return i;
  }

  public int getJ() {
    return j;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object obj) {
    this.data = obj;
  }

  @Override
  public String toString() {
    return new String("(" + i + "," + j + ")");
  }
}
