package provas.s20121.p220121ex1;

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
        throw new UnsupportedOperationException("Operação não permitida");
    }

    @Override
    public void cancelar() {
        throw new UnsupportedOperationException("Operação não permitida");
    }

    @Override
    public void reabrir() {
        throw new UnsupportedOperationException("Operação não permitida");
    }
}
