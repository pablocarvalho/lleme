package provas.s20141.p220141;

public class Vetor {

    private int tamanhoPadrao = 10;
    private Venda[] vendas = new Venda[tamanhoPadrao];

    protected void atualizar(int i, Venda venda) {
        if (i >= 0){
            if (i >= vendas.length) {
                if (vendas != null) {
                    vendas = expandir(vendas, i);
                    vendas[i] = venda;
                }
            } else
                vendas[i] = venda;
        }else
          throw new ArrayIndexOutOfBoundsException();
    }

    protected Venda obter(int i) {
        if (i < 0)
            throw new ArrayIndexOutOfBoundsException();
        else if (i < vendas.length)
            return vendas[i];
        else
            return null;
    }

    private Venda[] expandir(Venda[] vendas, int pos) {
        int qtd = (pos / tamanhoPadrao) + 1;
        Venda[] vendasNovo = new Venda[qtd * tamanhoPadrao];
        for (int i = 0; i < vendas.length; i++)
            vendasNovo[i] = vendas[i];
        return vendasNovo;
    }

    private void aparar() {
        int qtd1 = 0;
        int qtd2 = 0;
        while (vendas[qtd1] == null)
            qtd1++;
        while (vendas[vendas.length - qtd2 - 1] == null)
            qtd2++;
        int novoTamanho = vendas.length - qtd1 - qtd2;
        Venda[] vendasNovo = new Venda[novoTamanho];
        for (int i = 0; i < vendasNovo.length; i++)
            vendasNovo[i] = vendas[i + qtd1];
    }

}
