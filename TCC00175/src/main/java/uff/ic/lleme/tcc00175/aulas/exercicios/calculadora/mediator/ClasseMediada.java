package uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.mediator;

public abstract class ClasseMediada {

    public Mediador mediador;

    public ClasseMediada(Mediador mediador) {
        this.mediador = mediador;
    }

    public abstract void alterado();
}
