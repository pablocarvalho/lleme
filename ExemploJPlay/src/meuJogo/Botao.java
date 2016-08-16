package meuJogo;

import jplay.GameImage;
import jplay.Mouse;
import jplay.Window;

public class Botao extends GameImage {

  private Window janela;

  public Botao(Window jan) {
    super("botao.png");
    x = 300;
    y = 400;
    janela = jan;
  }

  public boolean clicado() {
    Mouse m = janela.getMouse();
    return m.isLeftButtonPressed() && m.isOverArea((int) x,
            (int) y, (int) x + width, (int) y + height);
  }
}
