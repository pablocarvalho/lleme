package provas.s20141.p220141;

public class MapaProduto {

    private int pos = -1;
    private int tamanhoPadrao = 10;
    private Produto[] produtos = new Produto[tamanhoPadrao];

    protected void incluir(Produto produto) {
        if (pos >= 0)
            if (pos >= produtos.length) {
                if (produto != null) {
                    produtos = expandir(produtos, pos);
                    produtos[pos] = produto;
                }
            } else
                produtos[pos] = produto;
    }

    protected Produto obter(int codigo) {
        for (Produto produto : produtos)
            if (produto.getCodigo() == codigo)
                return produto;
        return null;
    }

    private Produto[] expandir(Produto[] produtos, int pos) {
        int qtd = (pos / tamanhoPadrao) + 1;
        Produto[] produtosNovo = new Produto[qtd * tamanhoPadrao];
        for (int i = 0; i < produtosNovo.length; i++)
            produtosNovo[i] = produtos[i];
        return produtosNovo;
    }

}
