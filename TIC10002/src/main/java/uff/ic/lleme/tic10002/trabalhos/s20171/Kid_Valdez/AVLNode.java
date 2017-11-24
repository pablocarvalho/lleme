package uff.ic.lleme.tic10002.trabalhos.s20171.Kid_Valdez;

import java.util.LinkedList;
import java.util.List;

public class AVLNode {

    public Vendas dato;
    public AVLNode izquierdo;
    public AVLNode derecho;
    public int height;
    // CORRECAO: nao pode usar classes Java
    public List<Vendas> duplicados;

    // Constructors
    public AVLNode(Vendas dato) {
        this(dato, null, null);
    }

    public AVLNode(Vendas dato, AVLNode izq, AVLNode der) {
        this.dato = dato;
        this.izquierdo = izq;
        this.derecho = der;
        height = 0;
    }

    public void actiDupli() {
        if (duplicados == null) {
            duplicados = new LinkedList<>();
            duplicados.add(dato);
        }

    }
}
