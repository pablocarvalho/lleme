package exercicios.jogoDeDados;

public class Dado {

    private int valor = 1;

    public int obterValor() {
        return valor;
    }

    public int sortear() {
        valor = (int) (1 + Math.random() * 6);
        return valor;
    }
}
