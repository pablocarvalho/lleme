package uff.ic.lleme.tic10002.aulas.s20171.arvoreB;

import uff.ic.lleme.tic10002.aulas.s20171.Empregado;

public class ArvoreB {

    private Pagina raiz = null;

    public void inserir(Empregado empregado) throws Exception {
        if (raiz == null) {
            raiz = new Pagina();
            raiz.inserir(empregado);
        } else {
            Divisao divisao = raiz.inserir(empregado);
            if (divisao != null) {
                raiz = new Pagina();
                raiz.inserir(divisao.empregado);
                raiz.PRIMEIRO.pagina = divisao.menores;
                raiz.PRIMEIRO.proximo.pagina = divisao.maiores;
            }
        }
    }

    public static class Pagina {

        private final int ORDEM = 2;
        private int n = 0;
        private final No PRIMEIRO = new No(null);

        private class No {

            public Empregado conteudo = null;
            public Pagina pagina = null;
            public No proximo = null;

            public No(Empregado conteudo) {
                super();
                this.conteudo = conteudo;
            }
        }

        public Divisao inserir(Empregado empregado) throws IndexOutOfBoundsException, Exception {
            if (empregado != null)
                return inserir(PRIMEIRO, empregado);
            return null;
        }

        private Divisao inserir(No noCorrente, Empregado empregado) {
            if (noCorrente.proximo == null || empregado.chave < noCorrente.proximo.conteudo.chave)
                if (noCorrente.pagina == null) {
                    No aux = noCorrente.proximo;
                    noCorrente.proximo = new No(empregado);
                    noCorrente.proximo.proximo = aux;
                    n++;
                    if (n > 2 * ORDEM)
                        return this.dividir();
                    return null;
                } else {
                    Divisao meio = inserir(noCorrente.pagina.PRIMEIRO, empregado);
                    if (meio != null) {
                        No aux = noCorrente.proximo;
                        noCorrente.proximo = new No(meio.empregado);
                        noCorrente.proximo.proximo = aux;
                        noCorrente.pagina = meio.menores;
                        noCorrente.proximo.pagina = meio.maiores;
                    }
                    if (n > 2 * ORDEM)
                        return this.dividir();
                    return null;
                }
            else
                return inserir(noCorrente.proximo, empregado);
        }

        private Divisao dividir() {
            Empregado empregado = this.PRIMEIRO.proximo.proximo.proximo.conteudo;
            Pagina menores = new Pagina();
            Pagina maiores = new Pagina();
            menores.PRIMEIRO.proximo = PRIMEIRO.proximo;
            maiores.PRIMEIRO.proximo = PRIMEIRO.proximo.proximo.proximo.proximo;
            PRIMEIRO.proximo.proximo.proximo = null;
            menores.n = 2;
            maiores.n = 2;
            return new Divisao(empregado, menores, maiores);
        }
    }

    public static class Divisao {

        public Empregado empregado = null;
        public ArvoreB.Pagina menores = null;
        public ArvoreB.Pagina maiores = null;

        public Divisao(Empregado empregado, ArvoreB.Pagina menores, ArvoreB.Pagina maiores) {
            super();
            this.empregado = empregado;
            this.menores = menores;
            this.maiores = maiores;
        }
    }
}
