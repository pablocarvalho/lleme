package uff.ic.lleme.tic10002.trabalhos.s20171.Carlos_Dantas;

/**
 *
 * @author Carlos
 */
public class AVLMesAno {

    private static class No {

        private MesAno mesAno;
        private No esquerda;
        private No direita;
        private int altura;
        private ListaVendas valores;

        public No(MesAno mesAno) {
            this.mesAno = mesAno;
            esquerda = null;
            direita = null;
            valores = new ListaVendas();
        }

        public No(MesAno mesAno, No esquerda, No direita) {
            this.mesAno = mesAno;
            this.esquerda = esquerda;
            this.direita = direita;
        }
    }

    private No raiz;

    public AVLMesAno() {
        raiz = null;
    }

    private No getRaiz() {
        return raiz;
    }

    private int altura(No t) {
        if (t == null)
            return -1;
        return t.altura;
    }

    public void insere(MesAno x) {
        raiz = insere(x, raiz);
    }

    private No insere(MesAno x, No t) {
        if (t == null)
            t = new No(x);
        else if (x.compareTo(t.mesAno) < 0) {
            t.esquerda = insere(x, t.esquerda);

            if (altura(t.esquerda) - altura(t.direita) == 2)
                if (x.compareTo(t.esquerda.mesAno) < 0)
                    t = rotacaoParaEsquerda(t);
                else
                    t = rotacaoParaDireitaDepoisEsquerda(t);
        } else if (x.compareTo(t.mesAno) > 0) {
            t.direita = insere(x, t.direita);

            if (altura(t.direita) - altura(t.esquerda) == 2)
                if (x.compareTo(t.direita.mesAno) > 0)
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
            System.out.println(no.mesAno);
            imprimeNo(no.direita);
        }
    }

    public boolean contem(MesAno mesAno) {
        return busca(mesAno, raiz) != null;
    }

    private No busca(MesAno mesAno, No no) {
        if (no == null)
            return null;
        if (no.mesAno.compareTo(mesAno) == 0)
            return no;
        if (mesAno.compareTo(no.mesAno) < 0)
            return busca(mesAno, no.esquerda);
        else
            return busca(mesAno, no.direita);
    }

    public void insere(Venda venda) {
        No no = busca(venda.getMesAno(), raiz);
        if (no == null) {
            insere(venda.getMesAno());
            no = busca(venda.getMesAno(), raiz);
        }
        no.valores.insere(venda);
    }

    public ListaVendas buscaVendas(MesAno inicio, MesAno fim) {
        ListaVendas lista = new ListaVendas();
        buscaVendas(inicio, fim, raiz, lista);

        return lista;
    }

    private void buscaVendas(MesAno inicio, MesAno fim, No no, ListaVendas lista) {
        if (no == null)
            return;
        if (no.mesAno.compareTo(inicio) >= 0 && no.mesAno.compareTo(fim) <= 0)
            lista.copyList(no.valores);
        if (no.esquerda != null && no.esquerda.mesAno.compareTo(inicio) >= 0)
            buscaVendas(inicio, fim, no.esquerda, lista);
        if (no.direita != null && no.direita.mesAno.compareTo(fim) <= 0)
            buscaVendas(inicio, fim, no.direita, lista);
    }
}
