/*
 * Trabalho de Estruturas de Dados.
 * Professor: Luis André Portes Paes Leme
 */
package uff.ic.lleme.tic10002.trabalhos.s20172.mariojoao;

/**
 *
 * @author Mario João Junior
 */
public class ArvoreAVL {

    NoAVL raiz = null;
    int cont = 0;

    private class WrapNoAVL {

        NoAVL valor;

        WrapNoAVL(NoAVL no) {
            valor = no;
        }
    }

    public boolean inserir(TFluxo info) {
        NoAVL aux;

        if (raiz == null) {
            raiz = new NoAVL(info);
            cont++;
            return true;
        }

        aux = inserir(raiz, info);

        if (aux == null)
            return false;

        raiz = aux;
        return true;
    }

    private NoAVL inserir(NoAVL p, TFluxo info) {
        NoAVL aux;
        int ad, ae;

        if (p == null) {
            cont++;
            return new NoAVL(info);
        }

        if (p.info == info.getChave()) {
            // inserir na lista do nó
            TSetorDia sd = new TSetorDia(info.setor, info.dia);
            p.lista.inserir(sd);
            return null;
        }

        if (info.getChave() < p.info) {
            aux = inserir(p.esq, info);

            if (aux == null)
                return null;

            ad = altura(p.dir);
            if (Math.abs(aux.altura - ad) <= 1)
                if (aux.altura == p.altura) {
                    p.altura++;
                    p.esq = aux;
//                    System.out.printf("insercao de %d a esq de %d.\n", info, p.info);
                } else
                    p.esq = aux;
            else {
                // rotação a esq.
//                System.out.printf("RE em %d, v = %d.\n", p.info, aux.info);
                aux = rotacaoEsq(p, aux);
                p = aux;
            }

        } else {
            aux = inserir(p.dir, info);

            if (aux == null)
                return null;

            ae = altura(p.esq);
            if (Math.abs(ae - aux.altura) <= 1)
                if (aux.altura == p.altura) {
                    p.altura++;
                    p.dir = aux;
//                    System.out.printf("insercao de %d a dir de %d.\n", info, p.info);
                } else
                    p.dir = aux;
            else {
                // rotação a dir.
//                System.out.printf("RD em %d, v = %d.\n", p.info, aux.info);
                aux = rotacaoDir(p, aux);
                p = aux;
            }

        }

        return p;

    }

    private NoAVL rotacaoEsq(NoAVL p, NoAVL v) {
        int aev, adv;
        NoAVL aux, u;

        aev = altura(v.esq);
        adv = altura(v.dir);

        if (aev >= adv) {
            // RSE
            aux = v.dir;
            v.dir = p;
            p.esq = aux;
            p.altura = v.altura - 1;
            return v;
        }
        // RDE
        u = v.dir;
        v.dir = u.esq;
        u.esq = v;
        aux = u.dir;
        u.dir = p;
        p.esq = aux;
        v.altura--;
        p.altura = v.altura;
        u.altura = v.altura + 1;

        return u;
    }

    private NoAVL rotacaoDir(NoAVL p, NoAVL v) {
        int aev, adv;
        NoAVL aux, u;

        aev = altura(v.esq);
        adv = altura(v.dir);

        if (adv >= aev) {
            // RSD
            aux = v.esq;
            v.esq = p;
            p.dir = aux;
            p.altura = v.altura - 1;
            return v;
        }

        // RDD
        u = v.esq;
        v.esq = u.dir;
        u.dir = v;
        aux = u.esq;
        u.esq = p;
        p.dir = aux;
        v.altura--;
        p.altura = v.altura;
        u.altura = v.altura + 1;

        return u;
    }

    public boolean remover(TFluxo info) {
        NoAVL aux;
        WrapNoAVL ret = new WrapNoAVL(null);
        if (raiz == null)
            return false;

        aux = remover(raiz, info, ret);
        if (ret.valor != null) {
            raiz = aux;
            return true;
        }

        return false;
    }

    private NoAVL balancear(NoAVL no) {
        int ae, ad;
        NoAVL aux;

        if (no == null)
            return null;

        ae = altura(no.esq);
        ad = altura(no.dir);

        if (Math.abs(ae - ad) <= 1) {
            no.altura = Math.max(ae, ad) + 1;
            return no;
        }

        if (ae > ad)
            aux = rotacaoEsq(no, no.esq);
        else
            aux = rotacaoDir(no, no.dir);

        ae = altura(aux.esq);
        ad = altura(aux.dir);
        aux.altura = Math.max(ae, ad) + 1;

        return aux;
    }

    private NoAVL removerUltDir(NoAVL no, WrapNoAVL ret) {
        NoAVL aux;
        if (no.dir != null) {
            no.dir = removerUltDir(no.dir, ret);
            aux = balancear(no);
            return aux;
        }

        ret.valor = no;
        return no.esq;
    }

    private NoAVL remover(NoAVL no, TFluxo info, WrapNoAVL ret) {
        NoAVL aux;
        WrapNoAVL dir;
        int ae, ad;

        if (no == null) {
            ret.valor = null;
            return null;
        }

        if (info.getChave() < no.info) {
            aux = remover(no.esq, info, ret);
            // balancear
            no.esq = aux;
            aux = balancear(no);
            return aux;
        }

        if (info.getChave() > no.info) {
            aux = remover(no.dir, info, ret);
            // balancear
            no.dir = aux;
            aux = balancear(no);
            return aux;
        }

        // encontrou...
        ret.valor = no;

        // Remove da lista.
        no.lista.remove(info);

        // Se a lista não ficou vazia, não precisa alterar a árvore.
        if (!no.lista.listaVazia())
            return no;

        // remoção de uma folha
        if (no.esq == null && no.dir == null)
            return null;

        // Só possui filho à esquerda
        if (no.dir == null)
            return no.esq;

        // Só possui filho à direita
        if (no.esq == null)
            return no.dir;

        dir = new WrapNoAVL(null);
        aux = removerUltDir(no.esq, dir);
        dir.valor.esq = aux;
        dir.valor.dir = no.dir;
        ae = altura(dir.valor.esq);
        ad = altura(dir.valor.dir);
        dir.valor.altura = Math.max(ae, ad) + 1;

        return dir.valor;
    }

    private int altura(NoAVL p) {
        if (p == null)
            return 0;
        return p.altura;
    }

    public int menor() {
        NoAVL p;

        if (raiz == null)
            return -1;

        for (p = raiz; p.esq != null; p = p.esq);

        return p.info;
    }

    public int maior() {
        NoAVL p;

        if (raiz == null)
            return -1;

        for (p = raiz; p.dir != null; p = p.dir);

        return p.info;
    }

    public void imprimeMaior(int maior) {
        if (raiz == null)
            return;
        imprimeMaior(raiz, maior);
    }

    private void imprimeMaior(NoAVL p, int maior) {
        if (p == null)
            return;

        if (p.info >= maior) {
            imprimeMaior(p.esq, maior);
            System.out.printf("Fluxo %d: ", p.info);
            p.lista.imprimir();
            System.out.println();
        }
        imprimeMaior(p.dir, maior);
    }
}
