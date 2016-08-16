package patterns.templateMethod.framework;

public abstract class Algoritmo {

    public void executarAlgoritmo() {
        passo1();
        passo2();
        passo3();
    }

    protected abstract void passo1();

    protected abstract void passo2();

    protected abstract void passo3();
}
