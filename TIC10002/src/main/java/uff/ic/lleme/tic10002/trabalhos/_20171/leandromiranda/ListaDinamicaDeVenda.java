package uff.ic.lleme.tic10002.trabalhos._20171.leandromiranda;

public class ListaDinamicaDeVenda {

    public NoLista cabeca = null;
    private String tipo;
    private int TAMANHO;

    public ListaDinamicaDeVenda() {
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ListaDinamicaDeVenda(String tipo) {
        this.tipo = tipo;
        TAMANHO = 0;
    }

    public int getTAMANHO() {
        return TAMANHO;
    }

    class NoLista {

        public Venda conteudo = null;
        public NoLista anterior = null;
        public NoLista proximo = null;

        public NoLista(Venda emp) {
            conteudo = emp;
        }

    }

    // public void add(Object data, int index) {
    // Node crunchifyTemp = new Node(data);
    // Node crunchifyCurrent = head;
    //
    // // Let's check for NPE before iterate over crunchifyCurrent
    // if (crunchifyCurrent != null) {
    // // crawl to the requested index or the last element in the list,
    // whichever comes first
    // for (int i = 0; i < index && crunchifyCurrent.getNext() != null; i++) {
    // crunchifyCurrent = crunchifyCurrent.getNext();
    // }
    // }
    //
    // // set the new node's next-node reference to this node's next-node
    // reference
    // crunchifyTemp.setNext(crunchifyCurrent.getNext());
    //
    // // now set this node's next-node reference to the new node
    // crunchifyCurrent.setNext(crunchifyTemp);
    //
    // // increment the number of elements variable
    // incrementCounter();
    // }
    public void incluir(Venda emp) {
        if (cabeca == null) {
            NoLista no = new NoLista(emp);
            cabeca = no;
        } else {
            NoLista ptr = cabeca;
            while (ptr.proximo != null)
                ptr = ptr.proximo;

            NoLista novo = new NoLista(emp);
            ptr.proximo = novo;
            novo.anterior = ptr;
        }
        TAMANHO++;
    }

    public Venda excluir(String chave) {
        NoLista corrente = cabeca;

        if (corrente != null)
            while ((corrente.proximo != null)
                    && !(corrente.conteudo.getChave(tipo).equals(chave)))
                corrente = corrente.proximo;
        else
            return null;

        if ((corrente.conteudo.getChave(tipo) == chave)
                && (corrente.proximo == null))
            corrente = null; // return cabeca.conteudo;
        else if (corrente == cabeca) {
            cabeca = cabeca.proximo;
            cabeca.anterior = cabeca;
        } else {
            NoLista aux = corrente;
            corrente.anterior.proximo = corrente.proximo;
            aux.proximo.anterior = aux.anterior;

        }

        TAMANHO--;
        return cabeca.conteudo;

    }

    public Venda buscar(String chave) {
        NoLista corrente = cabeca;
        while (corrente.proximo != null
                && !((Venda) corrente.conteudo).getChave(tipo).equals(chave))
            corrente = corrente.proximo;
        if (((Venda) corrente.conteudo).getChave(tipo).equals(chave))
            return (Venda) corrente.conteudo;
        return null;
    }

    public Venda get(int index) // returns the element at the specified position in this list.
    {
        NoLista head = cabeca;
        // index must be 1 or higher
        if (index < 0)
            return null;
        NoLista crunchifyCurrent = null;
        if (head != null) {
            crunchifyCurrent = head;
            for (int i = 0; i < index; i++) {
                if (crunchifyCurrent.proximo == null)
                    return null;

                crunchifyCurrent = crunchifyCurrent.proximo;
            }
            return crunchifyCurrent.conteudo;
        }
        return null;

    }

    public void print() {
        NoLista ptr = cabeca;
        while (ptr != null) {
            System.out.println(ptr.conteudo.getFilial() + ","
                    + ptr.conteudo.getAnoMes() + ","
                    + ptr.conteudo.getCodVendedor() + ","
                    + ptr.conteudo.getTotalVendido());
            ptr = ptr.proximo;
        }
    }

    public String printString() {
        String string = "filial, ano_mês, cod_vendedor, total_vendido";
        string += String.format("\n");
        NoLista ptr = cabeca;
        while (ptr != null) {
            System.out.println(ptr.conteudo.getFilial() + ","
                    + ptr.conteudo.getAnoMes() + ","
                    + ptr.conteudo.getCodVendedor() + ","
                    + ptr.conteudo.getTotalVendido());
            string += String.format(ptr.conteudo.getFilial() + ","
                    + ptr.conteudo.getAnoMes() + ","
                    + ptr.conteudo.getCodVendedor() + ","
                    + ptr.conteudo.getTotalVendido());
            string += String.format("\n");
            ptr = ptr.proximo;
        }

        return string;
    }

}
