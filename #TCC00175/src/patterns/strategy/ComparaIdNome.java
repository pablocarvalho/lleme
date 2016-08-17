package patterns.strategy;

import java.util.Comparator;

public class ComparaIdNome implements Comparator<Pessoa> {

    public int compare(Pessoa o1, Pessoa o2) {
        if (o1.id > o2.id)
            return 1;
        if (o1.id < o2.id)
            return -1;
        return o1.nome.compareTo(o2.nome);
    }
}
