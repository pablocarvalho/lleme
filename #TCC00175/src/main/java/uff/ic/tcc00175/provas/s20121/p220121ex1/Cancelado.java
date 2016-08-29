package uff.ic.tcc00175.provas.s20121.p220121ex1;

public class Cancelado extends Estado {

    public Cancelado(Caso caso) {
        super(caso, "Cancelado");
    }

    @Override
    public void distribuir(int usuario) {
        throw new UnsupportedOperationException("Opera��o n�o permitida");
    }

    @Override
    public void resolver() {
        throw new UnsupportedOperationException("Opera��o n�o permitida");
    }

    @Override
    public void cancelar() {
        throw new UnsupportedOperationException("Opera��o n�o permitida");
    }

    @Override
    public void reabrir() {
        caso.estado = new EmAnalise(caso);
    }
}
