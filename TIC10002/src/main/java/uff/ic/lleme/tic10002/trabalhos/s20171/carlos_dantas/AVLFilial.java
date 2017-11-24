package uff.ic.lleme.tic10002.trabalhos.s20171.carlos_dantas;

/**
 *
 * @author Carlos
 */
public class AVLFilial {

    private static class No {

        private int id_filial;
        private No esquerda;
        private No direita;
        private int altura;
        private ListaVendas valores;

        public No(int id_filial) {
            this.id_filial = id_filial;
            esquerda = null;
            direita = null;
            valores = new ListaVendas();
        }

        public No(int id_filial, No esquerda, No direita) {
            this.id_filial = id_filial;
            this.esquerda = esquerda;
            this.direita = direita;
        }
    }

    private No raiz;

    public AVLFilial() {
        raiz = null;
    }

    private int altura(No t) {
        if (t == null)
            return -1;
        return t.altura;
    }

    public void insere(int x) {
        raiz = insere(x, raiz);
    }

    private No insere(int x, No t) {
        if (t == null)
            t = new No(x);
        else if (x < t.id_filial) {
            t.esquerda = insere(x, t.esquerda);

            if (altura(t.esquerda) - altura(t.direita) == 2)
                if (x < t.esquerda.id_filial)
                    t = rotacaoParaEsquerda(t);
                else
                    t = rotacaoParaDireitaDepoisEsquerda(t);
        } else if (x > t.id_filial) {
            t.direita = insere(x, t.direita);

            if (altura(t.direita) - altura(t.esquerda) == 2)
                if (x > t.direita.id_filial)
                    t = rotacaoParaDireita(t);
                else
                    t = rotacaoParaEsquerdaDepoisDireita(t);
        }

        t.altura = Integer.max(altura(t.esquerda), altura(t.direita)) + 1;
        return t;
    }

    private No rotacaoParaEsquerda(No no) {
        No aux = no.esquerda;

        no.esquerda = aux.direita;
        aux.direita = no;

        no.altura = Integer.max(altura(no.esquerda), altura(no.direita)) + 1;
        aux.altura = Integer.max(altura(aux.esquerda), no.altura) + 1;

        return aux;
    }

    private No rotacaoParaDireitaDepoisEsquerda(No no) {
        no.esquerda = rotacaoParaDireita(no.esquerda);
        return rotacaoParaEsquerda(no);
    }

    private No rotacaoParaDireita(No no) {
        No aux = no.direita;

        no.direita = aux.esquerda;
        aux.esquerda = no;

        no.altura = Integer.max(altura(no.esquerda), altura(no.direita)) + 1;
        aux.altura = Integer.max(altura(aux.direita), no.altura) + 1;

        return aux;
    }

    private No rotacaoParaEsquerdaDepoisDireita(No no) {
        no.direita = rotacaoParaEsquerda(no.direita);
        return rotacaoParaDireita(no);
    }

    public void imprime() {
        imprimeNo(raiz);
    }

    private void imprimeNo(No no) {
        if (no != null) {
            imprimeNo(no.esquerda);
            System.out.println(no.id_filial);
            imprimeNo(no.direita);
        }
    }

    private No busca(int id_filial, No no) {
        if (no == null)
            return null;
        if (no.id_filial == id_filial)
            return no;
        if (id_filial < no.id_filial)
            return busca(id_filial, no.esquerda);
        else
            return busca(id_filial, no.direita);
    }

    public void insere(Venda venda) {
        No no = busca(venda.getIdLoja(), raiz);
        if (no != null)
            no.valores.insere(venda);
        else {
            insere(venda.getIdLoja());
            no = busca(venda.getIdLoja(), raiz);
            no.valores.insere(venda);
        }
    }

    public void inserefilial(int id_filal) {
        No no = busca(id_filal, raiz);
        if (no != null)
            return;
        insere(id_filal);
    }

    public ListaVendas buscaVendas(int id_filialMin, int id_filialMax) {
        ListaVendas lista = new ListaVendas();
        buscaVendas(id_filialMin, id_filialMax, raiz, lista);

        return lista;
    }

    private void buscaVendas(int id_filialMin, int id_filialMax, No no, ListaVendas lista) {
        if (no == null)
            return;
        if (no.id_filial >= id_filialMin && no.id_filial <= id_filialMax)
            lista.copyList(no.valores);
        if (no.esquerda != null && no.esquerda.id_filial >= id_filialMin)
            buscaVendas(id_filialMin, id_filialMax, no.esquerda, lista);
        if (no.direita != null && no.direita.id_filial <= id_filialMax)
            buscaVendas(id_filialMin, id_filialMax, no.direita, lista);
    }

    public TabelaHash buscaFiliais(int id_filialMin, int id_filialMax) {
        TabelaHash hash = new TabelaHash();
        buscaFiliais(id_filialMin, id_filialMax, raiz, hash);
        return hash;
    }

    private void buscaFiliais(int id_filialMin, int id_filialMax, No no, TabelaHash hash) {
        if (no == null)
            return;
        if (no.id_filial >= id_filialMin && no.id_filial <= id_filialMax)
            hash.insere(no.id_filial);
        if (no.esquerda != null && id_filialMin < no.esquerda.id_filial)
            buscaFiliais(id_filialMin, id_filialMax, no.esquerda, hash);
        if (no.direita != null && id_filialMax > no.direita.id_filial)
            buscaFiliais(id_filialMin, id_filialMax, no.direita, hash);
    }
}
