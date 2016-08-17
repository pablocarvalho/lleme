package aulas.heranca.exemplos.figura;

public class Triangulo extends Figura {

    public float c;
    public float b;
    public float a;

    public Triangulo(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public float area() {
        float p = (a + b + c) / 2;
        return (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
