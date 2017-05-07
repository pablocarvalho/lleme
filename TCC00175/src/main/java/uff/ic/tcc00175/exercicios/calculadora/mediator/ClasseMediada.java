package uff.ic.tcc00175.exercicios.calculadora.mediator;

public abstract class ClasseMediada {

    public Mediador mediador;

    public ClasseMediada(Mediador mediador) {
        this.mediador = mediador;
    }

    public abstract void alterado();
}
