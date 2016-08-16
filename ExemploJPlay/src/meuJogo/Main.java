package meuJogo;

import jplay.*;

public class Main {

    private static Window janela;

    public static Window getJanela() {
        return janela;
    }

    public static void main(String[] args) {
        Sprite s = new Sprite("img.png", 5);
        janela = new Window(800, 600);
        MenuPrincipal menu = new MenuPrincipal(janela);
        Fase1 fase = null;
        int cenaAtual = 0;
        s.play();
        while (true) {
            switch (cenaAtual) {
                case Constantes.MENU:
                    if (menu.avancar()) {
                        fase = new Fase1(janela);
                        cenaAtual++;
                    }
                    menu.desenha();
                    break;
                case Constantes.FASE1:
                    fase.atualiza();
                    fase.desenha();
                    break;
            }
            s.update();
            s.draw();
            janela.update();
        }
    }
}
