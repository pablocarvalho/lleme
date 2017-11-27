package uff.ic.lleme.tic10002.trabalhos.s20172.Luana_Uchoa;

public class Arvore<E extends Elemento<String, Integer>> {

    No<E> raiz = null;
    int tamanho = 0;

    public void insere(E obj) {
        No<E> n = new No<E>(obj);
        insere(this.raiz, n);
        tamanho++;
    }

    public void insere(No<E> aComparar, No<E> aInserir) {

        if (aComparar == null)
            this.raiz = aInserir;
        else if ((Integer) aInserir.getChave() < (Integer) aComparar.getChave())

            if (aComparar.getEsquerda() == null) {
                aComparar.setEsquerda(aInserir);
                aInserir.setPai(aComparar);
                verificarBalanceamento(aComparar);

            } else
                insere(aComparar.getEsquerda(), aInserir);
        else if ((Integer) aInserir.getChave() > (Integer) aComparar.getChave())

            if (aComparar.getDireita() == null) {
                aComparar.setDireita(aInserir);
                aInserir.setPai(aComparar);
                verificarBalanceamento(aComparar);

            } else
                insere(aComparar.getDireita(), aInserir);
        else {
            // O n� j� existe
        }
    }

    public void verificarBalanceamento(No atual) {
        setBalanceamento(atual);
        int balanceamento = atual.getBalanceamento();

        if (balanceamento == -2)

            if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita()))
                atual = rotacaoDireita(atual);
            else
                atual = duplaRotacaoEsquerdaDireita(atual);
        else if (balanceamento == 2)

            if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda()))
                atual = rotacaoEsquerda(atual);
            else
                atual = duplaRotacaoDireitaEsquerda(atual);

        if (atual.getPai() != null)
            verificarBalanceamento(atual.getPai());
        else
            this.raiz = atual;
    }

    public void remover(int k) {
        remover(this.raiz, k);
    }

    public void remover(No atual, int k) {
        if (atual == null)
            return;
        else if ((Integer) atual.getChave() > k)
            remover(atual.getEsquerda(), k);
        else if ((Integer) atual.getChave() < k)
            remover(atual.getDireita(), k);
        else if ((Integer) atual.getChave() == k)
            removerNoEncontrado(atual);
    }

    public void removerNoEncontrado(No<E> aRemover) {
        No<E> r;

        if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {

            if (aRemover.getPai() == null) {
                this.raiz = null;
                aRemover = null;
                return;
            }
            r = aRemover;

        } else {
            r = sucessor(aRemover);
            aRemover.setChave(r.getChave());
        }

        No<E> p;
        if (r.getEsquerda() != null)
            p = r.getEsquerda();
        else
            p = r.getDireita();

        if (p != null)
            p.setPai(r.getPai());

        if (r.getPai() == null)
            this.raiz = p;
        else {
            if (r == r.getPai().getEsquerda())
                r.getPai().setEsquerda(p);
            else
                r.getPai().setDireita(p);
            verificarBalanceamento(r.getPai());
        }
        r = null;
    }

    public No<E> rotacaoEsquerda(No<E> inicial) {

        No<E> direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null)
            inicial.getDireita().setPai(inicial);

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null)

            if (direita.getPai().getDireita() == inicial)
                direita.getPai().setDireita(direita);
            else if (direita.getPai().getEsquerda() == inicial)
                direita.getPai().setEsquerda(direita);

        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;
    }

    public No<E> rotacaoDireita(No<E> inicial) {

        No<E> esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null)
            inicial.getEsquerda().setPai(inicial);

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null)

            if (esquerda.getPai().getDireita() == inicial)
                esquerda.getPai().setDireita(esquerda);
            else if (esquerda.getPai().getEsquerda() == inicial)
                esquerda.getPai().setEsquerda(esquerda);

        setBalanceamento(inicial);
        setBalanceamento(esquerda);

        return esquerda;
    }

    public No<E> duplaRotacaoEsquerdaDireita(No<E> inicial) {
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }

    public No<E> duplaRotacaoDireitaEsquerda(No<E> inicial) {
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }

    public No<E> sucessor(No<E> q) {
        if (q.getDireita() != null) {
            No<E> r = q.getDireita();
            while (r.getEsquerda() != null)
                r = r.getEsquerda();
            return r;
        } else {
            No<E> p = q.getPai();
            while (p != null && q == p.getDireita()) {
                q = p;
                p = q.getPai();
            }
            return p;
        }
    }

    private int altura(No<E> atual) {
        if (atual == null)
            return -1;

        if (atual.getEsquerda() == null && atual.getDireita() == null)
            return 0;
        else if (atual.getEsquerda() == null)
            return 1 + altura(atual.getDireita());
        else if (atual.getDireita() == null)
            return 1 + altura(atual.getEsquerda());
        else
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
    }

    private void setBalanceamento(No<E> no) {
        no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

}
