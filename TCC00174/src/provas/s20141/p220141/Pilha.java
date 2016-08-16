package provas.s20141.p220141;

public class Pilha {

    private int fim = -1;
    private Vetor vetor = new Vetor();

    public void empilha(Venda venda) {
        vetor.atualizar(++fim, venda);
    }

    public Venda desempilha() {
        Venda venda = null;
        if (fim >= 0) {
            venda = vetor.obter(fim);
            vetor.atualizar(fim--, null);
        }
        return venda;
    }

}
