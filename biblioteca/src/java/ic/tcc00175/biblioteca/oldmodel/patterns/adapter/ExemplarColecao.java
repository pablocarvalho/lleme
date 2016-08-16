package ic.tcc00175.biblioteca.oldmodel.patterns.adapter;

import ic.tcc00175.biblioteca.oldmodel.Exemplar;

import java.util.Iterator;
import java.util.TreeMap;

public class ExemplarColecao extends BusinessObjectCollection {

    private static final long serialVersionUID = 1761375474600296292L;
    private TreeMap treeMap = null;

    public ExemplarColecao() {
        treeMap = new TreeMap();
    }

    public Exemplar get(int index) {
        if (index <= this.treeMap.size() - 1) {
            return (Exemplar) this.treeMap.values().toArray()[index];
        }
        return null;
    }

    public Exemplar get(Object key) {
        return (Exemplar) this.treeMap.get(key);
    }

    @SuppressWarnings("unchecked")
    public Exemplar put(Exemplar emprestimo) {
        return (Exemplar) this.treeMap.put(emprestimo.getKey(), emprestimo);
    }

    public Exemplar remove(Object key) {
        return (Exemplar) this.treeMap.remove(key);
    }

    public int size() {
        return this.treeMap.size();
    }

    public int sizeDisponiveis() {
        Iterator iter = this.treeMap.values().iterator();
        Exemplar exemplar = null;
        int qtd = 0;
        while (iter.hasNext()) {
            exemplar = (Exemplar) iter.next();
            if (exemplar.getLnkEmprestimo() == null) {
                qtd++;
            }
        }
        return qtd;
    }
}