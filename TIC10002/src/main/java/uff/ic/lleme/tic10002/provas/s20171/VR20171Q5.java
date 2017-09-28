package uff.ic.lleme.tic10002.provas.s20171;

public class VR20171Q5 {

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
        public VR20171Q5.Pagina menores = null;
        public VR20171Q5.Pagina maiores = null;

        public Divisao(Integer chave, VR20171Q5.Pagina menores, VR20171Q5.Pagina maiores) {
            super();
            this.chave = chave;
            this.menores = menores;
            this.maiores = maiores;
        }
    }

    public Integer antecessor(int x) {
        if (raiz != null)
            return buscar(raiz.PRIMEIRO, x);
        return null;
    }

    public Integer buscar(Pagina.No no, int chave) {
        if (no.proximo != null && no.proximo.chave == chave)
            if (no.pagina != null)
                return antecessor(no.pagina.PRIMEIRO);
            else
                return no.chave;
        else if (no.proximo != null && no.proximo.chave < chave)
            return buscar(no.proximo, chave);
        else if (no.proximo != null && no.proximo.chave > chave)
            return buscar(no.pagina.PRIMEIRO, chave);
        else
            return null;
    }

    private Integer antecessor(Pagina.No no) {
        if (no.proximo != null)
            return antecessor(no.proximo);
        else if (no.pagina != null)
            return antecessor(no.pagina.PRIMEIRO);
        else
            return no.chave;
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

    public static void main(String[] args) throws Exception {
        VR20171Q5 a = new VR20171Q5();
        int[] nums = {34, 1, 78, 12, 3, 14, 67, 7, 6, 24};
        for (int num : nums)
            a.inserir(num);
        System.out.println("" + a.antecessor(14));
    }
}
