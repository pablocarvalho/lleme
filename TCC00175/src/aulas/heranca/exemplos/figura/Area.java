package aulas.heranca.exemplos.figura;

public class Area {

    public static void main(String[] args) {
        Figura fig = new Triangulo(2, 3, 5);
        System.out.println(fig.area());
    }
}
