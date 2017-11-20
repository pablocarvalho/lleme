package uff.ic.lleme.tic10002.trabalhos.s20171.kidvaldez;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AVLTree {

    List<Vendas> datosFial;
    List<Vendas> datosDate;
    public AVLNode root;
    double sumaVendas;

    public AVLTree() {
        datosFial = new ArrayList<>();
        datosDate = new ArrayList<>();
        sumaVendas = 0;
    }

    double getSumaVendas() {
        return sumaVendas;
    }

    //
    List<Vendas> consultaFilial(int x, int y) {
        if (x > y)
            throw new IllegalArgumentException("lower > upper");
        procurarFilial(root, x, y);
        return datosFial;
    }

    private void procurarFilial(AVLNode nodo, int x1, int x2) { // funcion resursiva
        AVLNode filhoIzq = nodo.izquierdo;
        AVLNode filhoDer = nodo.derecho;
        if (filhoIzq != null && nodo.dato.codFial > x1)
            procurarFilial(nodo.izquierdo, x1, x2);
        if (nodo.dato.codFial >= x1 && nodo.dato.codFial <= x2)
            if (nodo.duplicados != null)
                for (int j = 0; j < nodo.duplicados.size(); j++) {
                    sumaVendas = sumaVendas + nodo.duplicados.get(j).total;
                    datosFial.add(nodo.duplicados.get(j));
                }
            else {
                datosFial.add(nodo.dato);
                sumaVendas = sumaVendas + nodo.dato.total;
            }
        if (filhoDer != null && nodo.dato.codFial < x2)
            procurarFilial(nodo.derecho, x1, x2);
    }

    List<Vendas> consultaDate(Date x, Date y) {
        if (x.after(y))
            throw new IllegalArgumentException("lower > upper");
        procurarDate(root, x, y);
        return datosDate;
    }

    private void procurarDate(AVLNode nodo, Date x1, Date x2) {
        AVLNode filhoIzq = nodo.izquierdo;
        AVLNode filhoDer = nodo.derecho;

        if (filhoIzq != null && nodo.dato.fecha.compareTo(x1) > 0)
            procurarDate(nodo.izquierdo, x1, x2);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        if (nodo.dato.fecha.compareTo(x1) >= 0 && nodo.dato.fecha.compareTo(x2) <= 0)
            //sumaVendas = sumaVendas + nodo.dato.total;
            //datosDate.add(nodo.dato);
            if (nodo.duplicados != null)
                for (int j = 0; j < nodo.duplicados.size(); j++) {
                    sumaVendas = sumaVendas + nodo.duplicados.get(j).total;
                    datosDate.add(nodo.duplicados.get(j));
                }
            else {
                datosDate.add(nodo.dato);
                sumaVendas = sumaVendas + nodo.dato.total;
            }
        if (filhoDer != null && nodo.dato.fecha.compareTo(x2) < 0)
            procurarDate(nodo.derecho, x1, x2);
    }

    public void insertDate(Vendas x) {
        root = insertDate(x, root);
    }

    private AVLNode insertDate(Vendas x, AVLNode t) {
        if (t == null)
            t = new AVLNode(x, null, null);
        else if (x.fecha.before(t.dato.fecha)) {
            t.izquierdo = insertDate(x, t.izquierdo);
            if (height(t.izquierdo) - height(t.derecho) == 2)
                if (x.fecha.before(t.izquierdo.dato.fecha))
                    t = rotateWithLeftChild(t);
                /* Caso 1 */
                else
                    t = doubleWithLeftChild(t);
            /* Caso 2 */
        } else if (x.fecha.after(t.dato.fecha)) {
            t.derecho = insertDate(x, t.derecho);
            if (height(t.derecho) - height(t.izquierdo) == 2)
                if (x.fecha.after(t.derecho.dato.fecha))
                    t = rotateWithRightChild(t);
                /* Caso 4 */
                else
                    t = doubleWithRightChild(t);
            /* Caso 3 */
        } else { //; // Duplicado; no hago nada
            t.actiDupli();
            t.duplicados.add(x);
        }
        t.height = max(height(t.izquierdo), height(t.derecho)) + 1;
        return t;
    }

    public void insertFilial(Vendas x) {
        root = insertFilial(x, root);
    }

    private AVLNode insertFilial(Vendas x, AVLNode t) {
        if (t == null)
            t = new AVLNode(x, null, null);
        else if (x.codFial < t.dato.codFial) {
            t.izquierdo = insertFilial(x, t.izquierdo);
            if (height(t.izquierdo) - height(t.derecho) == 2)
                if (x.codFial < t.izquierdo.dato.codFial)
                    t = rotateWithLeftChild(t);
                else
                    t = doubleWithLeftChild(t);
        } else if (x.codFial > t.dato.codFial) { // derecha
            t.derecho = insertFilial(x, t.derecho);
            if (height(t.derecho) - height(t.izquierdo) == 2)
                if (x.codFial > t.derecho.dato.codFial) // recto 11 12 15
                    t = rotateWithRightChild(t);
                else
                    t = doubleWithRightChild(t);
        } else {  // Duplicado; lo insertamos a la derecha
            t.actiDupli();
            t.duplicados.add(x);
        }

        t.height = max(height(t.izquierdo), height(t.derecho)) + 1;
        return t;
    }

    private static int max(int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }

    private static AVLNode rotateWithLeftChild(AVLNode k2) {
        AVLNode k1 = k2.izquierdo;
        k2.izquierdo = k1.derecho;
        k1.derecho = k2;
        k2.height = max(height(k2.izquierdo), height(k2.derecho)) + 1;
        k1.height = max(height(k1.izquierdo), k2.height) + 1;
        return k1;
    }

    private static AVLNode rotateWithRightChild(AVLNode k1) {
        AVLNode k2 = k1.derecho;
        k1.derecho = k2.izquierdo;
        k2.izquierdo = k1;
        k1.height = max(height(k1.izquierdo), height(k1.derecho)) + 1;
        k2.height = max(height(k2.derecho), k1.height) + 1;
        return k2;
    }

    private static AVLNode doubleWithLeftChild(AVLNode k3) {
        k3.izquierdo = rotateWithRightChild(k3.izquierdo);
        return rotateWithLeftChild(k3);
    }

    private static AVLNode doubleWithRightChild(AVLNode k1) {
        k1.derecho = rotateWithLeftChild(k1.derecho);
        return rotateWithRightChild(k1);
    }

    private static int height(AVLNode t) {
        return t == null ? -1 : t.height;
    }

    public void imprimir() {
        imprimir(root);
    }

    private void imprimir(AVLNode nodo) {
        if (nodo != null) {
            imprimir(nodo.derecho);
            System.out.println("[" + nodo.dato + "]");
            imprimir(nodo.izquierdo);
        }
    }
}
