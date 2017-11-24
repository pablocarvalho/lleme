package uff.ic.lleme.tic10002.trabalhos.s20171.Daniel_Bastos;

class AVLTree {

    private AVLNode root;

    public AVLTree() {
        root = null;
    }

    private int height(AVLNode t) {
        if (t == null)
            return -1;
        else
            return t.height;
    }

    private int max(int left, int right) {
        if (right < left)
            return left;
        else
            return right;
    }

    public void insert(Montante m) {
        root = insert(m, root);
    }

    public void insert(Venda v) {
        root = insert(v, root);
    }

    public void insert(int n) {
        root = insert(n, root);
    }

    private AVLNode insert(Montante m, AVLNode t) {
        if (t == null)
            t = new AVLNode(m);
        else if (m.key < t.key) {
            t.left = insert(m, t.left);
            if (height(t.left) - height(t.right) == 2)
                if (m.key < t.left.key)
                    t = rotateLeft(t);
                else
                    t = doubleLeft(t);
        } else if (t.key < m.key) {
            t.right = insert(m, t.right);
            if (height(t.right) - height(t.left) == 2)
                if (m.key > t.right.key)
                    t = rotateRight(t);
                else
                    t = doubleRight(t);
        } else {
            /* Esse mês já apareceu antes.  Adicionemo-o. */
            Montante u = (Montante) t.data;
            u.total += m.total;
        }
        t.height = max(height(t.left), height(t.right)) + 1;
        return t;
    }

    private AVLNode insert(Venda v, AVLNode t) {
        if (t == null)
            t = new AVLNode(v);
        else if (v.key < t.key) {
            t.left = insert(v, t.left);
            if (height(t.left) - height(t.right) == 2)
                if (v.key < t.left.key)
                    t = rotateLeft(t);
                else
                    t = doubleLeft(t);
        } else if (t.key < v.key) {
            t.right = insert(v, t.right);
            if (height(t.right) - height(t.left) == 2)
                if (v.key > t.right.key)
                    t = rotateRight(t);
                else
                    t = doubleRight(t);
        } else {
            Venda u = (Venda) t.data;
            u.total_vendido = u.total_vendido + v.total_vendido;
        }
        t.height = max(height(t.left), height(t.right)) + 1;
        return t;
    }

    private AVLNode insert(int x, AVLNode t) {
        if (t == null)
            t = new AVLNode(x);
        else if (x < t.key) {

            t.left = insert(x, t.left);
            if (height(t.left) - height(t.right) == 2)
                if (x < t.left.key)
                    t = rotateLeft(t);
                else
                    t = doubleLeft(t);
        } else if (x > t.key) {
            t.right = insert(x, t.right);
            if (height(t.right) - height(t.left) == 2)
                if (x > t.right.key)
                    t = rotateRight(t);
                else
                    t = doubleRight(t);
        } else
           ;  // já inserido
        t.height = max(height(t.left), height(t.right)) + 1;
        return t;
    }

    private AVLNode rotateLeft(AVLNode k2) {
        AVLNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AVLNode rotateRight(AVLNode k1) {
        AVLNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;
        return k2;
    }

    private AVLNode doubleLeft(AVLNode k3) {
        k3.left = rotateRight(k3.left);
        return rotateLeft(k3);
    }

    private AVLNode doubleRight(AVLNode k1) {
        k1.right = rotateLeft(k1.right);
        return rotateRight(k1);
    }

    public Object get(int val) {
        return get(root, val);
    }

    private Object get(AVLNode r, int val) {
        if (r != null) {
            if (r.key == val)
                return r.data;

            if (val < r.key)
                return get(r.left, val);

            return get(r.right, val);
        }

        return null;
    }

    public void inorder(String sep) {
        inorder(root, sep);
    }

    private void inorder(AVLNode r, String sep) {
        if (r != null) {
            inorder(r.left, sep);
            System.out.print(r.key + sep);
            if (r.data != null)
                System.out.print(r.data + sep);
            inorder(r.right, sep);
        }
    }

    public void preorder(String sep) {
        preorder(root, sep);
    }

    private void preorder(AVLNode r, String sep) {
        if (r != null) {
            System.out.print(r.key + sep);
            if (r.data != null)
                System.out.print(r.data + sep);
            preorder(r.left, sep);
            preorder(r.right, sep);
        }
    }

    public void postorder(String sep) {
        postorder(root, sep);
    }

    private void postorder(AVLNode r, String sep) {
        if (r != null) {
            postorder(r.left, sep);
            postorder(r.right, sep);
            System.out.print(r.key + sep);
        }
    }

    class AVLNode {

        AVLNode left, right;
        int key;
        int height;
        // CORRECAO: a arvore deve armazenar lista de vendas.
        Object data;

        public AVLNode(Montante m) {
            left = null;
            right = null;
            key = m.key;
            data = m;
        }

        public AVLNode(Venda v) {
            left = null;
            right = null;
            key = v.ano_mes;
            data = v;
        }

        public AVLNode() {
            left = null;
            right = null;
            key = 0;
            height = 0;
            data = null;
        }

        public AVLNode(int n) {
            left = null;
            right = null;
            key = n;
            height = 0;
        }
    }
}
