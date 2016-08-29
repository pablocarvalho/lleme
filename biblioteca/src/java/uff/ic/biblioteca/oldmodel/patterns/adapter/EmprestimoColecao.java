package uff.ic.biblioteca.oldmodel.patterns.adapter;

import uff.ic.biblioteca.oldmodel.Devolucao;
import uff.ic.biblioteca.oldmodel.Emprestimo;
import uff.ic.biblioteca.oldmodel.Material;

import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public class EmprestimoColecao extends BusinessObjectCollection {

    private static final long serialVersionUID = 1761375474600296292L;
    private TreeMap treeMap = null;

    public EmprestimoColecao() {
        treeMap = new TreeMap();
    }

    public Emprestimo get(int index) {
        if (index <= this.treeMap.size() - 1) {
            return (Emprestimo) this.treeMap.values().toArray()[index];
        }
        return null;
    }

    public Emprestimo get(Object key) {
        return (Emprestimo) this.treeMap.get(key);
    }

    @SuppressWarnings("unchecked")
    public Emprestimo put(Emprestimo emprestimo) {
        return (Emprestimo) this.treeMap.put(emprestimo.getKey(), emprestimo);
    }

    public Emprestimo remove(Object key) {
        return (Emprestimo) this.treeMap.remove(key);
    }

    public int size() {
        return this.treeMap.size();
    }

    public int sizePendentes() {
        Iterator iter = this.treeMap.values().iterator();
        Emprestimo emprestimo = null;
        int qtd = 0;
        while (iter.hasNext()) {
            emprestimo = (Emprestimo) iter.next();
            if (emprestimo.isPendente()) {
                qtd++;
            }
        }
        return qtd;
    }

    public void setDevolucao(Material material) {
        Iterator iter = this.treeMap.values().iterator();
        boolean achou = false;
        Emprestimo emprestimo = null;
        while (iter.hasNext() && !achou) {
            emprestimo = (Emprestimo) iter.next();
            if (emprestimo.getLnkrevExemplar().getLnkrevMaterial().equals(
                    material)) {
                emprestimo.setLnkDevolucao(new Devolucao());
                emprestimo.getLnkrevExemplar().setLnkEmprestimo(null);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public boolean isEmprestado(Material material) {
        Iterator iter = this.treeMap.values().iterator();
        boolean achou = false;
        Material matEmpr = null;
        Emprestimo empr = null;
        while (iter.hasNext() && !achou) {
            empr = (Emprestimo) iter.next();
            matEmpr = empr.getLnkrevExemplar().getLnkrevMaterial();
            if (matEmpr.getKey().compareTo(material.getKey()) == 0
                    && empr.isPendente()) {
                achou = true;
            }
        }
        return achou;
    }

    public Collection values() {
        return treeMap.values();
    }

    public boolean containsEmprestado(Material material) {
        Iterator iter = treeMap.values().iterator();
        boolean achou = false;
        Emprestimo emprestimo = null;
        while (iter.hasNext() && !achou) {
            emprestimo = (Emprestimo) iter.next();
            if (emprestimo.getLnkMaterial().equals(material)
                    && emprestimo.isPendente()) {
                achou = true;
            }
        }
        return achou;
    }

    public boolean containsAtraso() {
        Iterator iter = treeMap.values().iterator();
        boolean achou = false;
        Emprestimo emprestimo = null;
        while (iter.hasNext() && !achou) {
            emprestimo = (Emprestimo) iter.next();
            if (Calendar.getInstance().getTime().after(
                    emprestimo.getLnkDevolucao().getData())
                    && emprestimo.isPendente()) {
                achou = true;
            }
        }
        return achou;
    }
}
