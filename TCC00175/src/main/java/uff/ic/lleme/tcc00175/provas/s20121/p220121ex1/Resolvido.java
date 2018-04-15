package uff.ic.lleme.tcc00175.provas.s20121.p220121ex1;

public class Resolvido extends Estado {

    public Resolvido(Caso caso) {
        super(caso, "Resolvido");
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
