package ic.tcc00175.biblioteca.oldmodel.patterns.adapter;

import ic.tcc00175.biblioteca.oldmodel.Usuario;

import java.util.TreeMap;

public class UsuarioColecao extends BusinessObjectCollection {

    private static final long serialVersionUID = -5681858037978642226L;
    private TreeMap treeMap = null;

    public UsuarioColecao() {
        treeMap = new TreeMap();
    }

    public Usuario get(int index) {
        if (index <= this.treeMap.size() - 1) {
            return (Usuario) this.treeMap.values().toArray()[index];
        }
        return null;
    }

    public Usuario get(Object key) {
        return (Usuario) this.treeMap.get(key);
    }

    @SuppressWarnings("unchecked")
    public Usuario put(Usuario usuario) {
        return (Usuario) this.treeMap.put(usuario.getKey(), usuario);
    }

    public Usuario remove(Object key) {
        return (Usuario) this.treeMap.remove(key);
    }

    public int size() {
        return this.treeMap.size();
    }
}