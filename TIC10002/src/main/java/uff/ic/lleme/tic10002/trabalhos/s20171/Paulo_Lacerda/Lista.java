package uff.ic.lleme.tic10002.trabalhos.s20171.Paulo_Lacerda;

public class Lista {

    private NodeLista head;
    private NodeLista cursor;

    private class NodeLista {

        Venda venda;
        NodeLista next;

        NodeLista(Venda venda) {
            this.venda = venda;
            this.next = null;
        }
    }

    public Lista() {
        head = null;
        resetCursor();
    }

    public void add(Venda venda) {
        NodeLista novo = new NodeLista(venda);
        if (head == null)
            head = novo;
        else {
            NodeLista aux = head;
            head = novo;
            novo.next = aux;
        }
        resetCursor();
    }

    public Venda getNext() {
        Venda retorno = null;
        if (cursor != null) {
            retorno = cursor.venda;
            cursor = cursor.next;
        }
        return retorno;
    }

    public void resetCursor() {
        cursor = head;
    }

}
