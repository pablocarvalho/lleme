package uff.ic.lleme.tic10002.prova.s20171;

public class VS20171Q5 {

    private Pagina raiz = null;

    private static class Pagina {

        public final int ORDEM = 2;
        public final No PRIMEIRO = new No(null);
        public int n = 0;

        public class No {

            public Integer chave = null;
            public Pagina pagina = null;
            public No proximo = null;

            public No(Integer conteudo) {
                this.chave = conteudo;
            }
        }

        public Divisao inserir(Integer chave) throws IndexOutOfBoundsException, Exception {
            if (chave != null)
                return inserir(PRIMEIRO, chave);
            else
                throw new Exception();
        }

        private Divisao inserir(No no, Integer chave) {
            if (no.proximo == null || chave < no.proximo.chave)
                if (no.pagina == null) {
                    No aux = no.proximo;
                    no.proximo = new No(chave);
                    no.proximo.proximo = aux;
                    n++;
                    if (n > 2 * ORDEM)
                        return this.dividir();
                    return null;
                } else {
                    Divisao meio = inserir(no.pagina.PRIMEIRO, chave);
                    if (meio != null) {
                        No aux = no.proximo;
                        no.proximo = new No(meio.chave);
                        no.proximo.proximo = aux;
                        no.pagina = meio.menores;
                        no.proximo.pagina = meio.maiores;
                    }
                    if (n > 2 * ORDEM)
                        return this.dividir();
                    return null;
                }
            else if (chave > no.proximo.chave)
                return inserir(no.proximo, chave);
            else
                return null;
        }

        private Divisao dividir() {
            Integer chave = this.PRIMEIRO.proximo.proximo.proximo.chave;
            Pagina menores = new Pagina();
            Pagina maiores = new Pagina();
            menores.PRIMEIRO.proximo = PRIMEIRO.proximo;
            maiores.PRIMEIRO.proximo = PRIMEIRO.proximo.proximo.proximo.proximo;
            PRIMEIRO.proximo.proximo.proximo = null;
            menores.n = 2;
            maiores.n = 2;
            return new Divisao(chave, menores, maiores);
        }
    }

    private static class Divisao {

        public Integer chave = null;
        public VS20171Q5.Pagina menores = null;
        public VS20171Q5.Pagina maiores = null;

        public Divisao(Integer chave, VS20171Q5.Pagina menores, VS20171Q5.Pagina maiores) {
            super();
            this.chave = chave;
            this.menores = menores;
            this.maiores = maiores;
        }
    }

    public Integer buscar(int chave) {
        if (raiz != null)
            return buscar(raiz.PRIMEIRO, chave);
        return null;
    }

    private Integer buscar(Pagina.No no, int chave) {
        if (no.proximo != null && no.proximo.chave == chave)
            return no.chave;
        else if (no.proximo != null && no.proximo.chave < chave)
            return buscar(no.proximo, chave);
        else if (no.proximo != null && no.proximo.chave > chave)
            return buscar(no.pagina.PRIMEIRO, chave);
        else
            return null;
    }

    public void inserir(int chave) throws Exception {
        if (raiz == null) {
            raiz = new Pagina();
            raiz.inserir(chave);
        } else {
            Divisao meio = raiz.inserir(chave);
            raiz = new Pagina();
        }
    }

}
