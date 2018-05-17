package uff.ic.lleme.tic10002.provas.s20172.P120172Q2;

public class ListaEncadeada {

    private class No {

        public int conteudo = 0;
        public No proximo = null;

        public No(int x) {
            conteudo = x;
        }
    }

    private No primeiro = null;

    public boolean incluir(int x) {
        if (primeiro == null) {
            primeiro = new No(x);
            return true;
        } else {
            No aux = primeiro;
            primeiro = new No(x);
            primeiro.proximo = aux;
            return true;
        }
    }

    public void imprimeAntecedentes() {
        imprimeAntecedentes(primeiro, new Pilha());
    }

    private void imprimeAntecedentes(No noCorrente, Pilha selecao) {
        if (noCorrente != null)
            if (noCorrente.conteudo >= 0) {
                selecao.empilhar(noCorrente.conteudo);
                imprimeAntecedentes(noCorrente.proximo, selecao);
            } else {
                Integer num, count = 0;
                while ((num = selecao.desempilhar()) != null && count < 5) {
                    System.out.print(num + "  ");
                    count++;
                }
                System.out.println("");
                imprimeAntecedentes(noCorrente.proximo, new Pilha());
            }
    }

}
