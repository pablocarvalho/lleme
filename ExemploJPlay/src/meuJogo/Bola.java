package meuJogo;

import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;

public class Bola extends Sprite {

  private double vY, vX;
  private Window janela;

  public Bola(Window jan) {
    super("ball2.png");
    vY = 0;
    vX = 0.5;
    janela = jan;
  }

  public void movimenta() {
    x += vX;
    if (x < 0 || x + width > 800)
      vX = -vX;
    jump();
  }

  @Override
  public void jump() {
    Keyboard k = janela.getKeyboard();
    if (k.keyDown(Keyboard.SPACE_KEY)) {
      vY = -0.5;
      System.out.println("pulou");
    }
    y += vY;
    fall();
  }

  @Override
  public void fall() {
    if (y + height < 400)
      vY += Constantes.G;
    else
      vY = -vY / 1.1;
  }
}
