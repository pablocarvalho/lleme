package exercicios.arquivos.forma;

import java.io.Serializable;

public class ColecaoFormas implements Serializable {

  private Forma[] formas = new Forma[10];

  public Forma getForma(int i) {
    return formas[i];
  }

  public Forma addForma(Forma forma, int i) {
    Forma antigo = formas[i];
    formas[i] = forma;
    return antigo;
  }
}
