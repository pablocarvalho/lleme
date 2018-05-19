package uff.ic.lleme.tic10002.aulas._old.s20171.arvoreB;

import uff.ic.lleme.tic10002.aulas.utils.Empregado;

public class ArvoreB {

    private Pagina raiz = null;

    public void incluir(Empregado empregado) {
        if (empregado != null) {
            if (raiz == null) raiz = new Pagina();

            raiz.inserir(empregado);
            if (raiz.tamanhoExedido()) {
                Divisao divisao = raiz.dividir();
                raiz = new Pagina();
                raiz.inserir(divisao.empregado);
                raiz.PRIMEIRO.pagina = divisao.menores;
                raiz.PRIMEIRO.proximo.pagina = divisao.maiores;
            }
        }
    }

    private class Pagina {

        private final int ORDEM = 2;
        private int n = 0;
        private No PRIMEIRO = new No(null);

        private class No {

            public Empregado conteudo = null;
            public No anterior = null;
            public No proximo = null;
            public Pagina pagina = null;

            public No(Empregado conteudo) {
                this.conteudo = conteudo;
            }

        }

        private void inserir(Empregado empregado) {
            inserir(PRIMEIRO, empregado);
        }

        private void inserir(No noCorrente, Empregado empregado) {
            if (noCorrente.proximo == null || empregado.chave() < noCorrente.proximo.conteudo.chave())
                if (noCorrente.pagina == null) {
                    No noAEsquerdaDoPontoDeInsercao = noCorrente.proximo;
                    No novoNo = new No(empregado);

                    noCorrente.proximo = novoNo;
                    novoNo.anterior = noCorrente;
                    if (noAEsquerdaDoPontoDeInsercao != null) {
                        novoNo.proximo = noAEsquerdaDoPontoDeInsercao;
                        noAEsquerdaDoPontoDeInsercao.anterior = novoNo;
                    }
                    n++;
                } else {
                    noCorrente.pagina.inserir(empregado);

                    if (noCorrente.pagina.tamanhoExedido()) {
                        Divisao divisao = noCorrente.pagina.dividir();

                        No noAEsquerdaDoPontoDeInsercao = noCorrente.proximo;
                        No novoNo = new No(divisao.empregado);

                        noCorrente.proximo = novoNo;
                        novoNo.anterior = noCorrente;
                        if (noAEsquerdaDoPontoDeInsercao != null) {
                            novoNo.proximo = noAEsquerdaDoPontoDeInsercao;
                            noAEsquerdaDoPontoDeInsercao.anterior = novoNo;
                        }

                        noCorrente.pagina = divisao.menores;
                        novoNo.pagina = divisao.maiores;
                        n++;
                    }
                }
            else if (empregado.chave() > noCorrente.proximo.conteudo.chave())
                inserir(noCorrente.proximo, empregado);
        }

        private Divisao dividir() {
            No meio = meio();

            Empregado empregado = meio.conteudo;
            Pagina menores = new Pagina();
            Pagina maiores = new Pagina();

            menores.PRIMEIRO = PRIMEIRO;
            meio.anterior.proximo = null;

            meio.anterior = null;
            meio.conteudo = null;
            maiores.PRIMEIRO = meio;

            menores.n = ORDEM;
            maiores.n = ORDEM;

            return new Divisao(empregado, menores, maiores);
        }

        private boolean tamanhoExedido() {
            return n > 2 * ORDEM;
        }

        private No meio() {
            No primeiro = PRIMEIRO.proximo;
            No avancoLento = primeiro;
            No avancoRapido = primeiro != null && primeiro.proximo != null ? primeiro.proximo : null;
            while (avancoLento != null && avancoRapido != null && avancoRapido.proximo != null) {
                avancoLento = avancoLento.proximo;
                avancoRapido = avancoRapido.proximo != null ? avancoRapido.proximo.proximo : null;
            }
            return avancoLento;
        }

        public void print(int ident) {
            No aux = PRIMEIRO;
            if (aux.proximo != null) {
                for (int i = 0; i < ident; i++)
                    System.out.print("|  ");

                while ((aux = aux.proximo) != null)
                    System.out.print(aux.conteudo.chave() + " ");
                System.out.println("");

                No aux2 = PRIMEIRO;
                while (aux2 != null) {
                    if (aux2.pagina != null) aux2.pagina.print(ident + 1);
                    aux2 = aux2.proximo;
                }
            }

        }
    }

    private static class Divisao {

        public Empregado empregado = null;
        public ArvoreB.Pagina menores = null;
        public ArvoreB.Pagina maiores = null;

        public Divisao(Empregado empregado, ArvoreB.Pagina menores, ArvoreB.Pagina maiores) {
            this.empregado = empregado;
            this.menores = menores;
            this.maiores = maiores;
        }
    }

    public void print() {
        if (raiz != null)
            raiz.print(0);
        else
            System.out.println("Arvore vazia.");
    }
}
