package uff.ic.lleme.tic10002.trabalhos.s20171.danielbastos;

class MyLinkedList {

    private Node head;
    private int size;

    public MyLinkedList() {
    }

    public void add(Object data) {
        if (head == null)
            head = new Node(data);

        Node t = new Node(data);
        Node cur = head;

        if (cur != null) {
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(t);
        }
        size = size + 1;
    }

    public Object get(int index) {
        Node cur = null;
        if (head != null) {
            cur = head.getNext();
            for (int i = 0; i < index; i++) {
                if (cur.getNext() == null)
                    return null;
                cur = cur.getNext();
            }
            return cur.getData();
        }
        return cur;
    }

    public boolean remove(int index) {
        Node cur = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (cur.getNext() == null)
                    return false;
                cur = cur.getNext();
            }
            cur.setNext(cur.getNext().getNext());
            size = size - 1;
            return true;
        }
        return false;
    }

    public String toString() {
        String ret = "("; // Uma homenagem a John McCarthy.
        if (head != null) {
            Node cur = head.getNext();
            while (cur != null) {
                ret += cur.getData().toString() + " ";
                cur = cur.getNext();
            }
        }
        ret += ")";
        return ret;
    }

    public int getSize() {
        return size;
    }

    private class Node {

        Node next;
        Object data;

        public Node(Object v) {
            next = null;
            data = v;
        }

        public Node(Object v, Node n) {
            next = n;
            data = v;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object v) {
            data = v;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            next = n;
        }
    }
}
