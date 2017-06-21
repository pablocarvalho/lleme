package uff.ic.lleme.tic10002.trabalhos._20171.ricardobhering;

public class NoAnoMes {

    protected int altura;
    protected int chave; //ano_mes

    protected ListaVenda lista_vendas;
    protected NoAnoMes esquerda, direita;

    //Construtor - inicializa
    public NoAnoMes(int ano_mes, int cod_vendedor, float venda) {
        this(ano_mes, cod_vendedor, venda, null, null);
    }

    public NoAnoMes(int ano_mes, int cod_vendedor, float venda, NoAnoMes esq, NoAnoMes dir) {
        chave = ano_mes;

        esquerda = esq;
        direita = dir;
        altura = 0;
        lista_vendas = new ListaVenda();
        lista_vendas.adicionar(cod_vendedor, venda);
    }
}
