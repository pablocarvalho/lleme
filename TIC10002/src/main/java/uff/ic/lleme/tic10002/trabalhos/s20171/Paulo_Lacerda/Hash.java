package uff.ic.lleme.tic10002.trabalhos.s20171.Paulo_Lacerda;

public class Hash {

    private int size;
    private ArvoreAVL[] table;

    public Hash(int size) {
        this.size = size;
        this.table = new ArvoreAVL[size];
    }

    public void put(Venda venda) {
        int hash = venda.hashCode();
        int pos = hash % size;
        if (this.table[pos] == null)
            this.table[pos] = new ArvoreAVL();
        ArvoreAVL arvore = this.table[pos];
        arvore.insert(hash, venda);
    }

    public boolean exists(Venda venda) {
        int hash = venda.hashCode();
        int pos = hash % size;
        ArvoreAVL arvore = this.table[pos];
        boolean encontrou = false;
        if (arvore != null)
            if (arvore.search(hash) != null)
                encontrou = true;
        return encontrou;
    }

}
