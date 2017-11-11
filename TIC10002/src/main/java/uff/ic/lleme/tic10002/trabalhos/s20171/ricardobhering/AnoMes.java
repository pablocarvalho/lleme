package uff.ic.lleme.tic10002.trabalhos.s20171.ricardobhering;

public class AnoMes {

    private NoAnoMes raiz = null;

    //Retorna a altura da �rvore
    private static int altura(NoAnoMes no) {
        return no == null ? -1 : no.altura;
    }

    //Retorna o maior valor ente altura-esquerda e altura-direita.
    private static int maximo(int altura_esq, int altura_dir) {
        return altura_esq > altura_dir ? altura_esq : altura_dir;
    }
    //Retorna o fator de balanceamento da �rvore

    private int getFatorBalanceamento(NoAnoMes no) {
        return altura(no.esquerda) - altura(no.direita);
    }

    public boolean inserir(int ano_mes, int cod_funcionario, float venda) {
        raiz = inserir(ano_mes, cod_funcionario, venda, raiz);
        return true;
    }

    private NoAnoMes inserir(int ano_mes, int cod_funcionario, float venda, NoAnoMes no) {
        if (no == null)
            no = new NoAnoMes(ano_mes, cod_funcionario, venda, null, null);
        else if (ano_mes < no.chave)
            no.esquerda = inserir(ano_mes, cod_funcionario, venda, no.esquerda);
        else if (ano_mes > no.chave)
            no.direita = inserir(ano_mes, cod_funcionario, venda, no.direita);
        else if (no.chave == ano_mes)

            no.lista_vendas.adicionar(cod_funcionario, venda);
        no = balanceia(no);
        return no;
    }

    public NoAnoMes balanceia(NoAnoMes no) {
        if (getFatorBalanceamento(no) == 2)
            if (getFatorBalanceamento(no.esquerda) > 0)
                no = rotacionarDireita(no);
            else
                no = duplaRotacaoDireita(no);
        else if (getFatorBalanceamento(no) == -2)
            if (getFatorBalanceamento(no.direita) < 0)
                no = rotacionarEsquerda(no);
            else
                no = duplaRotacaoEsquerda(no);
        no.altura = maximo(altura(no.esquerda), altura(no.direita)) + 1;
        return no;
    }
    //Faz Rota��o simples a direita

    private static NoAnoMes rotacionarDireita(NoAnoMes no) {
        NoAnoMes aux = no.esquerda;
        no.esquerda = aux.direita;
        aux.direita = no;
        no.altura = maximo(altura(no.esquerda), altura(no.direita)) + 1;
        aux.altura = maximo(altura(aux.esquerda), no.altura) + 1;
        return aux;
    }
    //Rota��o simples � esquerda

    private static NoAnoMes rotacionarEsquerda(NoAnoMes no) {
        NoAnoMes aux = no.direita;
        no.direita = aux.esquerda;
        aux.esquerda = no;
        no.altura = maximo(altura(no.esquerda), altura(no.direita)) + 1;
        aux.altura = maximo(altura(aux.direita), no.altura) + 1;
        return aux;
    }
    //Rota��o dupla � direita

    private static NoAnoMes duplaRotacaoDireita(NoAnoMes no) {
        no.esquerda = rotacionarEsquerda(no.esquerda);
        return rotacionarDireita(no);
    }
    //Rota��o dupla � esquerda

    private static NoAnoMes duplaRotacaoEsquerda(NoAnoMes no) {
        no.direita = rotacionarDireita(no.direita);
        return rotacionarEsquerda(no);
    }

    public NoAnoMes busca(int ano_mes) {
        return busca(raiz, ano_mes);
    }

    protected NoAnoMes busca(NoAnoMes no, int ano_mes) {
        while (no != null)
            if (ano_mes == no.chave)
                return no;
            else if (ano_mes < no.chave)
                no = no.esquerda;
            else
                no = no.direita;

        return null;
    }

    public float vendasPorIntervaloAno_mes(int ano_mes1, int ano_mes2) {
        if (maximo(ano_mes1, ano_mes2) == ano_mes1) {
            int aux = ano_mes1;
            ano_mes1 = ano_mes2;
            ano_mes2 = aux;
        }
        return vendasPorIntervaloAno_mes(this.raiz, ano_mes1, ano_mes2);
    }//Busca

    private float vendasPorIntervaloAno_mes(NoAnoMes no, int ano_mes1, int ano_mes2) {
        float soma = 0;
        if (no == null)
            return soma;
        if (no.chave >= ano_mes1 && no.chave <= ano_mes2) {

            System.out.println("            Data " + no.chave + ": vendeu " + no.lista_vendas.somaVenda());
            soma += no.lista_vendas.somaVenda();
        }
        if (no.chave >= ano_mes1)
            soma += vendasPorIntervaloAno_mes(no.esquerda, ano_mes1, ano_mes2);
        if (no.chave <= ano_mes2)
            soma += vendasPorIntervaloAno_mes(no.direita, ano_mes1, ano_mes2);
        if (no == this.raiz)
            System.out.println("\n            Total de vendas: " + soma);
        return soma;
    }

    protected float getTotalzudo() {
        return getTotalzudo(this.raiz);
    }

    private float getTotalzudo(NoAnoMes no) {
        float soma = 0;
        if (no == null)
            return soma;
        soma += no.lista_vendas.somaVenda();
        soma += getTotalzudo(no.esquerda);
        soma += getTotalzudo(no.direita);
        return soma;
    }
}
