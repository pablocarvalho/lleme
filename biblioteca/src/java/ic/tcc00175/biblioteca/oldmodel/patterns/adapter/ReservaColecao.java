package ic.tcc00175.biblioteca.oldmodel.patterns.adapter;

import ic.tcc00175.biblioteca.oldmodel.Material;
import ic.tcc00175.biblioteca.oldmodel.Reserva;
import ic.tcc00175.biblioteca.oldmodel.Usuario;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public class ReservaColecao extends BusinessObjectCollection {

    private static final long serialVersionUID = 1761375474600296292L;
    private TreeMap treeMap = null;

    public ReservaColecao() {
        treeMap = new TreeMap();
    }

    public Reserva get(int index) {
        if (index <= this.treeMap.size() - 1) {
            return (Reserva) this.treeMap.values().toArray()[index];
        }
        return null;
    }

    public Reserva get(Object key) {
        return (Reserva) this.treeMap.get(key);
    }

    @SuppressWarnings("unchecked")
    public Reserva put(Reserva reserva) {
        return (Reserva) this.treeMap.put(reserva.getKey(), reserva);
    }

    public Reserva remove(Object key) {
        return (Reserva) this.treeMap.remove(key);
    }

    public void remove(Usuario usuario) {
        Object[] reservas = treeMap.values().toArray();
        for (int i = 0; i < reservas.length; i++) {
            if (((Reserva) reservas[i]).getLnkrevUsuario().equals(usuario)) {
                treeMap.remove(((Reserva) reservas[i]).getKey());
            }
        }
    }

    public void remove(Material material) {
        Object[] reservas = treeMap.values().toArray();
        for (int i = 0; i < reservas.length; i++) {
            if (((Reserva) reservas[i]).getLnkrevLivro().equals(material)) {
                treeMap.remove(((Reserva) reservas[i]).getKey());
            }
        }
    }

    public int size() {
        return this.treeMap.size();
    }

    @SuppressWarnings("unchecked")
    public boolean containsMaterial(Material material) {
        Iterator iter = this.treeMap.values().iterator();
        boolean achou = false;
        while (iter.hasNext() && !achou) {
            if (((Reserva) iter.next()).getLnkrevLivro().getKey().compareTo(
                    material.getKey()) == 0) {
                achou = true;
            }
        }
        return achou;
    }

    public Collection values() {
        return treeMap.values();
    }
}
