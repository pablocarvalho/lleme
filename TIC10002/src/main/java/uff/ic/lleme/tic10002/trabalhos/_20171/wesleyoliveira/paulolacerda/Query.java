package uff.ic.lleme.tic10002.trabalhos._20171.wesleyoliveira.paulolacerda;

public class Query {

    Query() {

    }

    public double totaliza(ArvoreAVL arvore, int inicio, int fim) {
        double total = 0;
        Node root = arvore.getRoot();
        if (root != null)
            total = doTotaliza(0, root, inicio, fim);
        return total;
    }

    private double doTotaliza(double total, Node root, int inicio, int fim) {
        double novoTotal = 0;
        if ((root.getKey() >= inicio) && (root.getKey() <= fim)) {
            novoTotal += soma(root.getLista());
            if ((root.getLeft() != null) && (root.getLeft().getKey() >= inicio))
                novoTotal += doTotaliza(total, root.getLeft(), inicio, fim);
            if ((root.getRight() != null) && (root.getRight().getKey() <= fim))
                novoTotal += doTotaliza(total, root.getRight(), inicio, fim);
        }
        return novoTotal;
    }

    public double hashJoin(ArvoreAVL arvore1, int inicio1, int fim1, ArvoreAVL arvore2, int inicio2, int fim2) {
        Hash hash = new Hash(100);
        // Hash phase
        buildHashTable(hash, arvore1, inicio1, fim1);
        double total = 0;
        // Join phase
        return doHashJoin(hash, total, arvore2.getRoot(), inicio2, fim2);
    }

    private double doHashJoin(Hash hash, double total, Node root, int inicio, int fim) {
        double novoTotal = 0;
        if ((root.getKey() >= inicio) && (root.getKey() <= fim)) {
            novoTotal += soma(root.getLista(), hash);
            if ((root.getLeft() != null) && (root.getLeft().getKey() >= inicio))
                novoTotal += doHashJoin(hash, total, root.getLeft(), inicio, fim);
            if ((root.getRight() != null) && (root.getRight().getKey() <= fim))
                novoTotal += doHashJoin(hash, total, root.getRight(), inicio, fim);
        }
        return novoTotal;
    }

    private void buildHashTable(Hash hash, ArvoreAVL arvore, int inicio, int fim) {
        Node root = arvore.getRoot();
        if (root != null)
            doBuildHashTable(hash, root, inicio, fim);
    }

    private void doBuildHashTable(Hash hash, Node root, int inicio, int fim) {
        if ((root.getKey() >= inicio) && (root.getKey() <= fim)) {
            // adiciona cada venda à tabela hash
            Lista lista = root.getLista();
            Venda venda = lista.getNext();
            while (venda != null) {
                hash.put(venda);
                venda = lista.getNext();
            }
            lista.resetCursor();

            // navega pela árvore para compor o intervalo
            if ((root.getLeft() != null) && (root.getLeft().getKey() >= inicio))
                doBuildHashTable(hash, root.getLeft(), inicio, fim);
            if ((root.getRight() != null) && (root.getRight().getKey() <= fim))
                doBuildHashTable(hash, root.getRight(), inicio, fim);
        }
    }

    private double soma(Lista lista) {
        double total = 0;
        Venda venda = lista.getNext();
        while (venda != null) {
            total += venda.getTotal();
            venda = lista.getNext();
        }
        lista.resetCursor();
        return total;
    }

    private double soma(Lista lista, Hash hash) {
        double total = 0;
        Venda venda = lista.getNext();
        while (venda != null) {
            if (hash.exists(venda)) // soma apenas se a venda está no hash
                total += venda.getTotal();
            venda = lista.getNext();
        }
        lista.resetCursor();
        return total;
    }
}
