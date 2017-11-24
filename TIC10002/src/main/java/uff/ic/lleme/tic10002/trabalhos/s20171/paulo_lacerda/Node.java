package uff.ic.lleme.tic10002.trabalhos.s20171.paulo_lacerda;

public class Node {

    private int key;
    private int height;
    private Lista lista;
    private Node left;
    private Node right;

    public Node(int key, Venda venda) {
        this.key = key;
        this.lista = new Lista();
        this.addVenda(venda);
        this.left = null;
        this.right = null;
        this.height = 0;
    }

    public void addVenda(Venda venda) {
        lista.add(venda);
    }

    public int getKey() {
        return this.key;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Lista getLista() {
        return this.lista;
    }

    public Node getRight() {
        return this.right;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public String toString() {
        Lista listaaux = this.lista;
        Venda venda = listaaux.getNext();
        String itens = "[";
        while (venda != null) {
            itens += venda.toString() + " -> ";
            venda = listaaux.getNext();
        }
        itens += "null]";
        listaaux.resetCursor();
        return itens;
    }
}
