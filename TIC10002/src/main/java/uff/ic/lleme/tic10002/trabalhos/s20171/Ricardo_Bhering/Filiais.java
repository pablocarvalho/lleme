package uff.ic.lleme.tic10002.trabalhos.s20171.Ricardo_Bhering;

public class Filiais {

    private NoFilial raiz = null;

    //Retorna a altura da �rvore
    private static int altura(NoFilial no) {
        return no == null ? -1 : no.altura;
    }

    //Retorna o maior valor ente altura-esquerda e altura-direita..
    private static int maximo(int altura_esq, int altura_dir) {
        return altura_esq > altura_dir ? altura_esq : altura_dir;
    }
    //Retorna o fator de balanceamento da �rvore

    private int getFatorBalanceamento(NoFilial no) {
        return altura(no.esquerda) - altura(no.direita);
    }//Recebe os parametros para inclus�o a partir do carrega estrutura.

    public boolean inserir(int filial, int ano_mes, int cod_funcionario, float venda) {
        //raiz do conteiner
        raiz = inserir(filial, ano_mes, cod_funcionario, venda, raiz);
        return true;
    }//Faz os testes para inserir.

    private NoFilial inserir(int filial, int ano_mes, int cod_funcionario, float venda, NoFilial no) {

        if (no == null)
            no = new NoFilial(filial, ano_mes, cod_funcionario, venda, null, null);
        else if (filial < no.chave)
            no.esquerda = inserir(filial, ano_mes, cod_funcionario, venda, no.esquerda);
        else if (filial > no.chave)
            no.direita = inserir(filial, ano_mes, cod_funcionario, venda, no.direita);

        else if (no.chave == filial)

            no.arvore_ano_mes.inserir(ano_mes, cod_funcionario, venda); //Finalizada a inser��o testa o balanceamento da �rvore.
        no = balanceia(no);
        return no;
    }//Recebe de retorno do m�todo (getFatorBalanceamento) e executa as rota��es para balanceamento.

    public NoFilial balanceia(NoFilial no) {
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

    private static NoFilial rotacionarDireita(NoFilial no) {
        NoFilial aux = no.esquerda;
        no.esquerda = aux.direita;
        aux.direita = no;
        no.altura = maximo(altura(no.esquerda), altura(no.direita)) + 1;
        aux.altura = maximo(altura(aux.esquerda), no.altura) + 1;
        return aux;
    }
    //Rota��o simples � esquerda

    private static NoFilial rotacionarEsquerda(NoFilial no) {
        NoFilial aux = no.direita;
        no.direita = aux.esquerda;
        aux.esquerda = no;
        no.altura = maximo(altura(no.esquerda), altura(no.direita)) + 1;
        aux.altura = maximo(altura(aux.direita), no.altura) + 1;
        return aux;
    }
    //Rota��o dupla � direita

    private static NoFilial duplaRotacaoDireita(NoFilial no) {
        no.esquerda = rotacionarEsquerda(no.esquerda);
        return rotacionarDireita(no);
    }
    //Rota��o dupla � esquerda

    private static NoFilial duplaRotacaoEsquerda(NoFilial no) {
        no.direita = rotacionarDireita(no.direita);
        return rotacionarEsquerda(no);
    }

    public NoFilial busca(int valor) {
        return busca(raiz, valor);
    }

    protected NoFilial busca(NoFilial no, int valor) {
        while (no != null)
            if (valor == no.chave)
                return no;
            else if (valor < no.chave)
                no = no.esquerda;
            else
                no = no.direita;

        return null;
    }

    //Verifica se os valores informados est�o ordenados para executar a busca.
    public float relatorioVendas1(int filial1, int filial2) {
        if (maximo(filial1, filial2) == filial1) {
            int aux = filial1;
            filial1 = filial2;
            filial2 = aux;
        }

        return vendasPorIntervaloFilial(this.raiz, filial1, filial2);
    }
    //Verifica se os valores informados est�o ordenados para executar a busca.

    public void relatorioVendas2(int filial1, int filial2, int data1, int data2) {
        if (maximo(filial1, filial2) == filial1) {
            int aux = filial1;
            filial1 = filial2;
            filial2 = aux;
        }
        vendasPorDataFilial(this.raiz, filial1, filial2, data1, data2);
    }

    public void relatorioVendas3(int data1, int data2) {
        vendasPorData(this.raiz, data1, data2);
    }//Buscas

    private float vendasPorIntervaloFilial(NoFilial no, int filial1, int filial2) {
        if (no == null)
            return 0;
        float totalzudo = 0;
        if (no.chave >= filial1 && no.chave <= filial2) {//ano_mes = chave.

            System.out.println("Filial " + no.chave + ": " + no.arvore_ano_mes.getTotalzudo());
            totalzudo += no.arvore_ano_mes.getTotalzudo();
        }
        if (no.chave >= filial1)
            totalzudo += vendasPorIntervaloFilial(no.esquerda, filial1, filial2);
        if (no.chave <= filial2)
            totalzudo += vendasPorIntervaloFilial(no.direita, filial1, filial2);
        if (no == this.raiz)
            System.out.println("\nTotal geral de vendas: " + totalzudo + "\n\n");
        return totalzudo;
    }

    private float vendasPorDataFilial(NoFilial no, int filial1, int filial2, int data1, int data2) {
        if (no == null)
            return 0;
        float totalzudo = 0;
        if (no.chave >= filial1 && no.chave <= filial2) {
            System.out.println("Filial " + no.chave + ": ");
            totalzudo += no.arvore_ano_mes.vendasPorIntervaloAno_mes(data1, data2);
        }
        if (no.chave >= filial1)
            totalzudo += vendasPorDataFilial(no.esquerda, filial1, filial2, data1, data2);
        if (no.chave <= filial2)
            totalzudo += vendasPorDataFilial(no.direita, filial1, filial2, data1, data2);
        if (no == this.raiz)
            System.out.println("\nTotal geral de vendas: " + totalzudo);
        return totalzudo;
    }

    private float vendasPorData(NoFilial no, int data1, int data2) {
        if (no == null)
            return 0;
        float totalzudo = 0;
        System.out.println("Filial " + no.chave + ": ");
        totalzudo += no.arvore_ano_mes.vendasPorIntervaloAno_mes(data1, data2);
        totalzudo += vendasPorData(no.esquerda, data1, data2);
        totalzudo += vendasPorData(no.direita, data1, data2);
        if (no == this.raiz)
            System.out.println("\nTotal geral de vendas por data: " + totalzudo);
        return totalzudo;
    }
}
