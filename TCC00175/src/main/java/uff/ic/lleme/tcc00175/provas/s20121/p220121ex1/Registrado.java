package uff.ic.lleme.tcc00175.provas.s20121.p220121ex1;

public class Registrado extends Estado {

    public Registrado(Caso caso) {
        super(caso, "Registrado");
    }

    @Override
    public void distribuir(int usuario) {
        caso.estado = new EmAnalise(caso);
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
        throw new UnsupportedOperationException("Opera��o n�o permitida");
    }
}
