package provas.s20141.p120141;

public class MyDouble implements Escalar<Double> {

    public Double valor = null;

    public MyDouble(Double valor) {
        this.valor = valor;
    }

    @Override
    public Double valor() {
        return valor;
    }

    @Override
    public Escalar<Double> produto(Escalar<Double> escalar) {
        return new MyDouble(this.valor() * escalar.valor());
    }

    @Override
    public Escalar<Double> quociente(Escalar<Double> escalar) {
        return new MyDouble(this.valor() / escalar.valor());
    }

    @Override
    public Escalar<Double> soma(Escalar<Double> escalar) {
        return new MyDouble(this.valor() + escalar.valor());
    }

    @Override
    public Escalar<Double> diferenca(Escalar<Double> escalar) {
        return new MyDouble(this.valor() - escalar.valor());
    }
}
