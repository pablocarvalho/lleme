package patterns.strategy;

import java.util.Comparator;

public class ComparaId implements Comparator<Pessoa> {

    public int compare(Pessoa o1, Pessoa o2) {
        if (o1.id > o2.id)
            return 1;
        if (o1.id < o2.id)
            return -1;
        return 0;
    }
}
