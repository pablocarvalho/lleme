package uff.ic.biblioteca.oldmodel.patterns.adapter;

import uff.ic.biblioteca.oldmodel.Material;

import java.util.TreeMap;

public class MaterialColecao extends BusinessObjectCollection {

    private static final long serialVersionUID = -2496929745701544330L;
    private TreeMap treeMap = null;

    public MaterialColecao() {
        treeMap = new TreeMap();
    }

    public Material get(int index) {
        if (index <= this.treeMap.size() - 1) {
            return (Material) this.treeMap.values().toArray()[index];
        }
        return null;
    }

    public Material get(Object key) {
        return (Material) this.treeMap.get(key);
    }

    @SuppressWarnings("unchecked")
    public Material put(Material material) {
        return (Material) this.treeMap.put(material.getKey(), material);
    }

    public Material remove(Object key) {
        return (Material) this.treeMap.remove(key);
    }

    public int size() {
        return this.treeMap.size();
    }
}
