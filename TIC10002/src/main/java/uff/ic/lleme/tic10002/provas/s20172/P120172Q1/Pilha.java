package uff.ic.lleme.tic10002.provas.s20172.P120172Q1;

public class Pilha {

    private Fila conteudo = new FilaEncadeada();
    private Fila aux = new FilaEncadeada();

    public void empilhar(int x) {
        Integer num;
        while ((num = conteudo.desenfileirar()) != null)
            aux.enfileirar(num);
        conteudo.enfileirar(x);
        while ((num = aux.desenfileirar()) != null)
            conteudo.enfileirar(num);
    }

    public Integer desempilhar() {
        return conteudo.desenfileirar();
    }

}
