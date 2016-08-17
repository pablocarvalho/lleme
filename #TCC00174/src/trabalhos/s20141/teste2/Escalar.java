package trabalhos.s20141.teste2;

public class Escalar extends Expressao {

    private double valor = 0;

    public Escalar(double valor) {
        this.valor = valor;
    }

    @Override
    public Expressao calcular() {
        return this;
    }

    public double getDouble() {
        return valor;
    }

    @Override
    public void imprimir() {
        System.out.println(valor + "\t");
    }

}
