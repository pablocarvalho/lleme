package uff.ic.lleme.tic10002.trabalhos._20171.emersonsouza;

public class Arvore {

    //Busca na arvore
    public double getTotalVendido(No no, int menor1, int maior1, int chave) {
        if (no != null)
            if (no.getConteudo().getValor(chave) >= menor1 && no.getConteudo().getValor(chave) <= maior1)
                return no.getConteudo().totalVendido;
            else
                return 0;
        else
            return 0;
    }

    public double efetuaSoma(No no, int menor1, int maior1, int chave) {
        double soma;
        if (no != null) {
            soma = efetuaSoma(no.getDireita(), menor1, maior1, chave);
            soma += getTotalVendido(no, menor1, maior1, chave);
            soma += efetuaSoma(no.getEsquerda(), menor1, maior1, chave);
            return soma;
        } else
            return 0;
    }

    public double getTotalVendido(No no, int menor1, int maior1, int menor2, int maior2, int chave1, int chave2) {
        if (no != null)
            if ((no.getConteudo().getValor(chave1) >= menor1 && no.getConteudo().getValor(chave1) <= maior1)
                    && (no.getConteudo().getValor(chave2) >= menor2 && no.getConteudo().getValor(chave2) <= maior2))
                return no.getConteudo().totalVendido;
            else
                return 0;
        else
            return 0;
    }

    public double efetuaSoma(No no, int menor1, int maior1, int menor2, int maior2, int chave1, int chave2) {
        double soma;
        if (no != null) {
            soma = efetuaSoma(no.getDireita(), menor1, maior1, menor2, maior2, chave1, chave2);
            soma += getTotalVendido(no, menor1, maior1, menor2, maior2, chave1, chave2);
            soma += efetuaSoma(no.getEsquerda(), menor1, maior1, menor2, maior2, chave1, chave2);
            return soma;
        } else
            return 0;
    }

    //ArvoreAVL
    public No raiz;

    public void inserir(Venda conteudo, int chave) {
        No n = new No(conteudo);
        inserirAVL(this.raiz, n, chave);
    }

    public void inserirAVL(No aComparar, No aInserir, int chave) {
        if (aComparar == null)
            this.raiz = aInserir;
        else if (aInserir.getConteudo().getValor(chave) < aComparar.getConteudo().getValor(chave))

            if (aComparar.getEsquerda() == null) {
                aComparar.setEsquerda(aInserir);
                aInserir.setPai(aComparar);
                verificarBalanceamento(aComparar);
            } else
                inserirAVL(aComparar.getEsquerda(), aInserir, chave);
        else if (aInserir.getConteudo().getValor(chave) > aComparar.getConteudo().getValor(chave))
            if (aComparar.getDireita() == null) {
                aComparar.setDireita(aInserir);
                aInserir.setPai(aComparar);
                verificarBalanceamento(aComparar);
            } else
                inserirAVL(aComparar.getDireita(), aInserir, chave);
        else if (aComparar.getEsquerda() == null) {
            aComparar.setEsquerda(aInserir);
            aInserir.setPai(aComparar);
            verificarBalanceamento(aComparar);
        } else
            inserirAVL(aComparar.getEsquerda(), aInserir, chave);
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

    public No rotacaoEsquerda(No inicial) {
        No direita = inicial.getDireita();
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

    public No rotacaoDireita(No inicial) {
        No esquerda = inicial.getEsquerda();
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

    public No duplaRotacaoEsquerdaDireita(No inicial) {
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }

    public No duplaRotacaoDireitaEsquerda(No inicial) {
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }

    public No sucessor(No q) {
        if (q.getDireita() != null) {
            No r = q.getDireita();
            while (r.getEsquerda() != null)
                r = r.getEsquerda();
            return r;
        } else {
            No p = q.getPai();
            while (p != null && q == p.getDireita()) {
                q = p;
                p = q.getPai();
            }
            return p;
        }
    }

    private int altura(No atual) {
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

    private void setBalanceamento(No no) {
        no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

    /*public void imprimeArvore(No no){
        if(no!= null){
            System.out.println(""+no.conteudo.filial+"\n"+no.conteudo.anoMes);
            imprimeArvore(no.getDireita());
            imprimeArvore(no.getEsquerda());
        }
    }*/
}
