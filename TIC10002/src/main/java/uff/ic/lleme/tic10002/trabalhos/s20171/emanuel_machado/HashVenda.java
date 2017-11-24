package uff.ic.lleme.tic10002.trabalhos.s20171.emanuel_machado;

// Tabela Hash de listas encadeadas
public class HashVenda {

    public ListaVenda[] tabelaHash;
    private int tamanho_utilizado = 0;

    public HashVenda() {
        this.tabelaHash = new ListaVenda[100000];
    }

    //Método da divisão
    private int determinaPosicao(int filial, int m) {
        return (filial & 0x7fffffff) % m;
    }

    public int incluir(Venda venda) {

        int m = tabelaHash.length;

        int posicao = determinaPosicao(venda.getFilial(), m);

        for (int i = 0; i < tabelaHash.length; i++) {

            // Se não houver uma lista criada no índice atual
            if (this.tabelaHash[posicao] == null) {
                this.tabelaHash[posicao] = new ListaVenda();
                this.tabelaHash[posicao].incluir(venda);
                tamanho_utilizado++;
                return 1;
                //Se existir uma venda da mesma filial
            } else if (this.tabelaHash[posicao].primeiro.conteudo.getFilial() == venda.getFilial()) {
                this.tabelaHash[posicao].incluir(venda);
                return 1;
            }
            //tratamento de colisão por sondagem linear
            posicao = determinaPosicao(posicao + i, m);
        }

        //overflow
        return 0;
    }

    public double totalVendas(int filial1, int filial2) {

        double soma = 0;
        int posicao;

        // Percorre a tabela Hash somando as vendas das filiais desejadas
        for (int i = filial1; i <= filial2; i++) {
            posicao = buscaPosicao(i);

            // Se existir venda para a filial
            if (posicao != -1)
                soma += tabelaHash[posicao].SomaTotalLista();
        }

        return soma;
    }

    private int buscaPosicao(int filial) {
        int m = tabelaHash.length;

        int posicao;

        posicao = determinaPosicao(filial, m);

        for (int i = 0; i < tabelaHash.length; i++) {

            // Se for = a null quer dizer que não existe lista para a filial (Não existem vendas para a filial)
            if (this.tabelaHash[posicao] == null)
                return -1;
            if (this.tabelaHash[posicao].primeiro.conteudo.getFilial() == filial)
                return posicao;
            //colisão
            posicao = determinaPosicao(posicao + i, m);
        }
        return -1;
    }

    public double totalVendas(int filial1, int filial2, String data1, String data2) {

        double soma = 0;
        int posicao;

        // CORRECAO: buscar em arvore é mais eficiente
        // Percorre a tabela Hash somando as vendas das filiais desejadas
        for (int i = filial1; i <= filial2; i++) {
            posicao = buscaPosicao(i);

            // Se existir venda para a filial
            if (posicao != -1)
                soma += tabelaHash[posicao].SomaTotalLista(data1, data2);
        }

        return soma;
    }
}
