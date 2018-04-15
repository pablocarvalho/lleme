package uff.ic.lleme.tcc00328.exercicios.temporizador.model;

import uff.ic.lleme.tcc00328.exercicios.temporizador.view.Observer;

public abstract interface Subject {

    public abstract void attach(Observer o);

    public abstract void deattach(Observer o);

    public abstract void notifyObservers();

    public abstract void finalize() throws Throwable;
}
