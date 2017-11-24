package uff.ic.lleme.tic10002.trabalhos.s20171.paulo_lacerda;

/**
 * Implementa uma árvore binária AVL
 */
public class ArvoreAVL {

    private Node root;

    public ArvoreAVL() {
        this(null);
    }

    private ArvoreAVL(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public Node search(int key) {
        if (this.root == null)
            return null;
        else
            return doSearch(this.root, key);
    }

    ;

  private Node doSearch(Node node, int key) {
        if (node == null)
            return null;
        else if (key == node.getKey())
            return node;
        else if (key > node.getKey())
            return doSearch(node.getRight(), key);
        else
            return doSearch(node.getLeft(), key);
    }

    ;

  public void insert(int key, Venda venda) {
        if (this.root == null)
            this.root = new Node(key, venda);
        else
            doInsert(this.root, key, venda);
    }

    ;

  public Node doInsert(Node noderoot, int key, Venda venda) {

        if (noderoot == null)
            return (new Node(key, venda));

        if (key < noderoot.getKey())
            noderoot.setLeft(doInsert(noderoot.getLeft(), key, venda));
        else if (key > noderoot.getKey())
            noderoot.setRight(doInsert(noderoot.getRight(), key, venda));
        else { // já existe, adiciona na lista
            noderoot.getLista().add(venda);
            return noderoot;
        }

        int height = 1 + max(nodeHeight(noderoot.getLeft()), // atualiza altura
                nodeHeight(noderoot.getRight()));
        noderoot.setHeight(height);

        int balance = getBalance(noderoot); // obtem balanço do nó

        // faz a rotação necessária:
        //  left left
        if (balance > 1 && key < noderoot.getLeft().getKey())
            return rightRotate(noderoot);

        // right right
        if (balance < -1 && key > noderoot.getRight().getKey())
            return leftRotate(noderoot);

        // left right
        if (balance > 1 && key > noderoot.getLeft().getKey()) {
            noderoot.setLeft(leftRotate(noderoot.getLeft()));
            return rightRotate(noderoot);
        }

        // right left
        if (balance < -1 && key < noderoot.getRight().getKey()) {
            noderoot.setRight(rightRotate(noderoot.getRight()));
            return leftRotate(noderoot);
        }

        return noderoot;

    }

    Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(max(nodeHeight(y.getLeft()), nodeHeight(y.getRight())) + 1);
        x.setHeight(max(nodeHeight(x.getLeft()), nodeHeight(x.getRight())) + 1);

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        // Perform rotation
        y.setLeft(x);
        x.setRight(T2);

        //  Update heights
        x.setHeight(max(nodeHeight(x.getLeft()), nodeHeight(x.getRight())) + 1);
        y.setHeight(max(nodeHeight(y.getLeft()), nodeHeight(y.getRight())) + 1);

        // Return new root
        return y;
    }

    private int nodeHeight(Node node) {
        if (node == null)
            return 0;
        return node.getHeight();
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private int getBalance(Node node) {
        if (node == null)
            return 0;
        else
            return nodeHeight(node.getLeft()) - nodeHeight(node.getRight());
    }

    public void showPreOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

}
