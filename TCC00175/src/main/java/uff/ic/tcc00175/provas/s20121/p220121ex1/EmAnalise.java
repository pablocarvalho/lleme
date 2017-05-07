package uff.ic.tcc00175.provas.s20121.p220121ex1;

public class EmAnalise extends Estado {

    public EmAnalise(Caso caso) {
        super(caso, "Em an�lise");
    }

    @Override
    public void distribuir(int usuario) {
        throw new UnsupportedOperationException("Opera��o n�o permitida");
    }

    @Override
    public void resolver() {
        caso.estado = new Resolvido(caso);
    }

    @Override
    public void cancelar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void reabrir() {
        throw new UnsupportedOperationException("Opera��o n�o permitida");
    }
}
