package uff.ic.lleme.tcc00175.exercicios.calculadora.mediator;

public abstract class Mediador {

    public Mediador() {
        criarClassesRelacionadas();
    }

    public abstract void objetoAlterado(ClasseMediada mediado);

    public abstract void criarClassesRelacionadas();
}
