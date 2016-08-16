package meuJogo;

import java.awt.Color;
import jplay.Window;

public class Fase1 {

  private Window janela;
  private Bola bola;

  public Fase1(Window jan) {
    janela = jan;
    bola = new Bola(jan);
  }

  public void atualiza() {
    bola.movimenta();
  }

  public void desenha() {
    janela.clear(Color.BLACK);
    bola.draw();
  }

  public boolean avancar() {
    return bola.x >= 600;
  }
}
