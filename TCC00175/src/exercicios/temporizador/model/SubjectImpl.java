package exercicios.temporizador.model;

import exercicios.temporizador.view.Observer;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class SubjectImpl implements Subject {

    private ArrayList registry = new ArrayList();
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
        Iterator iterator = registry.iterator();
        while (iterator.hasNext())
            ((Observer) iterator.next()).update();
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
