package meuJogo;

import java.awt.Color;
import jplay.Window;
import jplay.Mouse;

public class MenuPrincipal {

  private Window janela;
  public Botao b;

  public MenuPrincipal(Window jan) {
    janela = jan;
    b = new Botao(jan);
  }

  public void desenha() {
    janela.clear(Color.red);
    b.draw();
  }

  public boolean avancar() {
    return b.clicado();
  }
}
