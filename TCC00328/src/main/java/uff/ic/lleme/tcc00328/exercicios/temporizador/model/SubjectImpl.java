package uff.ic.lleme.tcc00328.exercicios.temporizador.model;

import uff.ic.lleme.tcc00328.exercicios.temporizador.view.Observer;
import java.util.ArrayList;

public abstract class SubjectImpl implements Subject {

    private ArrayList<Observer> registry = new ArrayList();
    private Object state;

    public void attach(Observer o) {
        registry.add(o);
        // notifyObservers();
    }

    public void deattach(Observer o) {
        registry.remove(o);
        // notifyObservers();
    }

    public void notifyObservers() {
        for (Observer o : registry)
            o.update();
    }

    public void finalize() throws Throwable {
        registry = null;
        System.gc();
        System.out.println("Coletando lixo .....");
        super.finalize();
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }
}
