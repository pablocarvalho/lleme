
import java.awt.Color;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.Window;

public class Main {

  public static void main(String[] args) {
    Window janela = new Window(800, 600);
    janela.setBackground(Color.BLACK);
    Sprite ping = new Sprite("ping.png");
    ping.x = 250;
    ping.y = 400;
    Sprite chao = new Sprite("chao.png");
    chao.x = 500;
    chao.y = 300;
    ping.setFloor(400);
    Keyboard kbd = janela.getKeyboard();
    double g = ping.getGravity();

    while (!kbd.keyDown(Keyboard.ESCAPE_KEY)) {

      ping.jump();
      ping.moveX(0.5);
      ping.moveY(0.5);
      if (ping.collided(chao)) {
        ping.setFloor(301);
        ping.setGravity(0);
      } else {
        ping.setFloor(400);
        ping.setGravity(g);
      }
      janela.clear(java.awt.Color.BLACK);

      ping.draw();
      chao.draw();
      janela.update();
    }
    janela.exit();
  }
}
