package uff.ic.lleme.tic10002.aulas.s20171.arvoreB;

import uff.ic.lleme.tic10002.aulas.s20171.Empregado;

public class ArvoreB {

    private Pagina raiz = null;

    public void inserir(Empregado empregado) throws Exception {
        if (raiz == null) {
            raiz = new Pagina();
            raiz.inserir(empregado);
        } else {
            Divisao meio = raiz.inserir(empregado);
            raiz = new Pagina();

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
            else
                throw new Exception();
        }

        private Divisao inserir(No no, Empregado empregado) {
            if (no.proximo == null || empregado.chave < no.proximo.conteudo.chave)
                if (no.pagina == null) {
                    No aux = no.proximo;
                    no.proximo = new No(empregado);
                    no.proximo.proximo = aux;
                    n++;
                    if (n > 2 * ORDEM)
                        return this.dividir();
                    return null;
                } else {
                    Divisao meio = inserir(no.pagina.PRIMEIRO, empregado);
                    if (meio != null) {
                        No aux = no.proximo;
                        no.proximo = new No(meio.empregado);
                        no.proximo.proximo = aux;
                        no.pagina = meio.menores;
                        no.proximo.pagina = meio.maiores;
                    }
                    if (n > 2 * ORDEM)
                        return this.dividir();
                    return null;
                }
            else
                return inserir(no.proximo, empregado);
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
