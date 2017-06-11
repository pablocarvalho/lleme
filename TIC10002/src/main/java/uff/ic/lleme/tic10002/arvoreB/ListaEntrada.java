package uff.ic.lleme.tic10002.arvoreB;

import uff.ic.lleme.tic10002.Empregado;

public class ListaEntrada {

    private final int ORDEM = 4;
    private int n = 0;
    private final No PRIMEIRO = new No(null);

    private class No {

        public Empregado conteudo = null;
        public ListaEntrada pagina = null;
        public No proximo = null;

        public No(Empregado conteudo) {
            this.conteudo = conteudo;
        }
    }

    public Insercao inserir(Empregado empregado) throws IndexOutOfBoundsException, Exception {
        if (empregado != null)
            return inserir(PRIMEIRO, empregado);
        else
            throw new Exception();

    }

    private Insercao inserir(No no, Empregado empregado) {
        if (no.proximo == null || empregado.chave < no.proximo.conteudo.chave)
            if (no.pagina == null) {
                No aux = no.proximo;
                no.proximo = new No(empregado);
                no.proximo = aux;
                n++;
                if (n > ORDEM)
                    return this.dividir();
                return null;
            } else {
                Insercao meio = inserir(no.pagina.PRIMEIRO, empregado);
                No aux = no.proximo;
                no.proximo = new No(meio.empregado);
                no.proximo = aux;
                no.pagina = meio.menores;
                no.proximo.pagina = meio.maiores;
                if (n > ORDEM)
                    return this.dividir();
                return null;
            }
        else
            return inserir(no.proximo, empregado);
    }

    private Insercao dividir() {
        ListaEntrada menores = new ListaEntrada();
        ListaEntrada maiores = new ListaEntrada();
        menores.PRIMEIRO.proximo = PRIMEIRO.proximo;
        maiores.PRIMEIRO.proximo = PRIMEIRO.proximo.proximo.proximo.proximo;
        PRIMEIRO.proximo.proximo.proximo = null;
        menores.n = 2;
        maiores.n = 2;
        Empregado empregado = this.PRIMEIRO.proximo.proximo.proximo.conteudo;
        return new Insercao(empregado, menores, maiores);
    }
}
