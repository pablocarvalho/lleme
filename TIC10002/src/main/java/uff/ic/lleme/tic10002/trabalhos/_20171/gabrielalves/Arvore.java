package uff.ic.lleme.tic10002.trabalhos._20171.gabrielalves;

public class Arvore {

    public ArvoreNo raiz;

    public void inserir(Venda conteudo, int key) {
        ArvoreNo n = new ArvoreNo(conteudo);
        inserirAVL(this.raiz, n, key);
    }

    public void inserirAVL(ArvoreNo noDaArvore, ArvoreNo noInserir, int key) {
        if (noDaArvore == null)
            this.raiz = noInserir;
        else if (noInserir.getConteudo().getValor(key) < noDaArvore.getConteudo().getValor(key))
            if (noDaArvore.getEsq() == null) {
                noDaArvore.setEsq(noInserir);
                noInserir.setPai(noDaArvore);
                verificarBalanceamento(noDaArvore);
            } else
                inserirAVL(noDaArvore.getEsq(), noInserir, key);
        else if (noInserir.getConteudo().getValor(key) > noDaArvore.getConteudo().getValor(key))
            if (noDaArvore.getDir() == null) {
                noDaArvore.setDir(noInserir);
                noInserir.setPai(noDaArvore);
                verificarBalanceamento(noDaArvore);
            } else
                inserirAVL(noDaArvore.getDir(), noInserir, key);
        else if (noDaArvore.next == null) {
            noDaArvore.next = noInserir;
            noInserir.back = noDaArvore;
        } else {
            while (noDaArvore.next != null)
                noDaArvore = noDaArvore.next;
            noDaArvore.next = noInserir;
            noInserir.back = noDaArvore;
        }
    }

    public void verificarBalanceamento(ArvoreNo atual) {
        setBalanceamento(atual);
        int balanceamento = atual.getBalanceamento();
        if (balanceamento == -2)
            if (altura(atual.getEsq().getEsq()) >= altura(atual.getEsq().getDir()))
                atual = rotacaoDireita(atual);
            else
                atual = duplaRotacaoEsquerdaDireita(atual);
        else if (balanceamento == 2)
            if (altura(atual.getDir().getDir()) >= altura(atual.getDir().getEsq()))
                atual = rotacaoEsquerda(atual);
            else
                atual = duplaRotacaoDireitaEsquerda(atual);
        if (atual.getPai() != null)
            verificarBalanceamento(atual.getPai());
        else
            this.raiz = atual;
    }

    public ArvoreNo duplaRotacaoEsquerdaDireita(ArvoreNo inicial) {
        inicial.setEsq(rotacaoEsquerda(inicial.getEsq()));
        return rotacaoDireita(inicial);
    }

    public ArvoreNo duplaRotacaoDireitaEsquerda(ArvoreNo inicial) {
        inicial.setDir(rotacaoDireita(inicial.getDir()));
        return rotacaoEsquerda(inicial);
    }

    public ArvoreNo rotacaoDireita(ArvoreNo inicial) {
        ArvoreNo esquerda = inicial.getEsq();
        esquerda.setPai(inicial.getPai());
        inicial.setEsq(esquerda.getDir());
        if (inicial.getEsq() != null)
            inicial.getEsq().setPai(inicial);
        esquerda.setDir(inicial);
        inicial.setPai(esquerda);
        if (esquerda.getPai() != null)
            if (esquerda.getPai().getDir() == inicial)
                esquerda.getPai().setDir(esquerda);
            else if (esquerda.getPai().getEsq() == inicial)
                esquerda.getPai().setEsq(esquerda);
        setBalanceamento(inicial);
        setBalanceamento(esquerda);
        return esquerda;
    }

    public ArvoreNo rotacaoEsquerda(ArvoreNo inicial) {
        ArvoreNo direita = inicial.getDir();
        direita.setPai(inicial.getPai());
        inicial.setDir(direita.getEsq());
        if (inicial.getDir() != null)
            inicial.getDir().setPai(inicial);
        direita.setEsq(inicial);
        inicial.setPai(direita);
        if (direita.getPai() != null)
            if (direita.getPai().getDir() == inicial)
                direita.getPai().setDir(direita);
            else if (direita.getPai().getEsq() == inicial)
                direita.getPai().setEsq(direita);
        setBalanceamento(inicial);
        setBalanceamento(direita);
        return direita;
    }

    public ArvoreNo sucessor(ArvoreNo q) {
        if (q.getDir() != null) {
            ArvoreNo r = q.getDir();
            while (r.getEsq() != null)
                r = r.getEsq();
            return r;
        } else {
            ArvoreNo p = q.getPai();
            while (p != null && q == p.getDir()) {
                q = p;
                p = q.getPai();
            }
            return p;
        }
    }

    private int altura(ArvoreNo atual) {
        if (atual == null)
            return -1;
        if (atual.getEsq() == null && atual.getDir() == null)
            return 0;
        else if (atual.getEsq() == null)
            return 1 + altura(atual.getDir());
        else if (atual.getDir() == null)
            return 1 + altura(atual.getEsq());
        else
            return 1 + Math.max(altura(atual.getEsq()), altura(atual.getDir()));
    }

    private void setBalanceamento(ArvoreNo no) {
        no.setBalanceamento(altura(no.getDir()) - altura(no.getEsq()));
    }

    public double totalVendido(ArvoreNo no, int min, int max) {
        double calc = no.getConteudo().total_vendido;
        if (no != null)
            if ((no.getConteudo().filial >= min && no.getConteudo().filial <= max)
                    || (no.getConteudo().ano_mes >= min && no.getConteudo().ano_mes <= max))
                if (no.next != null) {
                    while (no.next != null) {
                        calc += no.next.getConteudo().total_vendido;
                        no = no.next;
                    }
                    return calc;
                } else
                    return no.getConteudo().total_vendido;
            else
                return 0;
        else
            return 0;
    }

    public double totalVendido(ArvoreNo no, int min1, int max1, int min2, int max2) {
        if (no != null)
            if (((no.getConteudo().filial >= min1 && no.getConteudo().filial <= max1)
                    || (no.getConteudo().ano_mes >= min1 && no.getConteudo().ano_mes <= max1))
                    && ((no.getConteudo().filial >= min2 && no.getConteudo().filial <= max2)
                    || (no.getConteudo().ano_mes >= min2 && no.getConteudo().ano_mes <= max2)))

                return no.getConteudo().total_vendido;
            else
                return 0;
        else
            return 0;
    }

    public double calculaSoma(ArvoreNo no, int min, int max) {
        double total;
        if (no != null) {
            total = calculaSoma(no.getDir(), min, max);
            total += totalVendido(no, min, max);
            total += calculaSoma(no.getEsq(), min, max);
            return total;
        } else
            return 0;
    }

    public double calculaSoma(ArvoreNo no, int min1, int max1, int min2, int max2) {
        double total;
        // CORRECAO: extrai de duas arvores e depois faz a juncao
        if (no != null) {
            total = calculaSoma(no.getDir(), min1, max1, min2, max2);
            total += totalVendido(no, min1, max1, min2, max2);
            total += calculaSoma(no.getEsq(), min1, max1, min2, max2);
            return total;
        } else
            return 0;
    }
}
