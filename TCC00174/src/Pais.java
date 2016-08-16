/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luiz Leme
 */
public class Pais {

  private String nome;
  private String capital;
  private float dimensao;
  private Pais[] fronteiras = new Pais[10];
  private int pos = 0;

  public Pais(String nome, String capital, float dimensao) {
    this.nome = nome;
    this.capital = capital;
    this.dimensao = dimensao;
  }

  public boolean equals(final Pais outro) {
    return this.nome.equals(outro.nome) && this.capital.equals(outro.capital);
  }

  public void addFronteira(Pais pais) {
    if (!this.equals(pais) && !isFronteira(pais))
      fronteiras[pos++] = pais;
  }

  public boolean isFronteira(Pais pais) {
    for (Pais p : fronteiras)
      if (p != null && p.equals(pais))
        return true;
    return false;
  }

  public Pais[] listFronteiras() {
    return fronteiras;
  }

  public Pais[] listVisinhosComuns(Pais pais) {
    Pais[] visinhos = new Pais[10];
    int pos = 0;
    for (Pais p : fronteiras)
      if (pais.isFronteira(p))
        visinhos[pos++] = p;
    return visinhos;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public float getDimensao() {
    return dimensao;
  }

  public void setDimensao(float dimensao) {
    this.dimensao = dimensao;
  }
}
