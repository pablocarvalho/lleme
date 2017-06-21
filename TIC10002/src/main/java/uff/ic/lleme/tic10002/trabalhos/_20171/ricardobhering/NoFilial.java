package uff.ic.lleme.tic10002.trabalhos._20171.ricardobhering;

public class NoFilial {

    protected int altura;
    protected int chave;//filial

    protected NoFilial esquerda, direita;
    protected AnoMes arvore_ano_mes;
    //Construtor - inicializa

    public NoFilial(int filial, int ano_mes, int cod_funcionario, float venda) {
        this(filial, ano_mes, cod_funcionario, venda, null, null);
    }

    public NoFilial(int filial, int ano_mes, int cod_funcionario, float venda, NoFilial esq, NoFilial dir) {
        chave = filial;

        esquerda = esq;
        direita = dir;
        altura = 0;
        arvore_ano_mes = new AnoMes();
        arvore_ano_mes.inserir(ano_mes, cod_funcionario, venda);
    }
}
