package uff.ic.lleme.tic10002.trabalhos.s20171.leandro_miranda;

public class GeracaoDeDados {

    private int TAMANHO_DE_VENDAS;
    ListaDinamicaDeVenda sells;

    public GeracaoDeDados(int tamanhoDeDados) {
        this.TAMANHO_DE_VENDAS = tamanhoDeDados;
        sells = new ListaDinamicaDeVenda();
    }

    public ListaDinamicaDeVenda gerarDados() {

        MersenneTwister geradorMersene = new MersenneTwister();
        for (int i = 0; i < TAMANHO_DE_VENDAS; i++) {

            int filial = geradorMersene.nextInt(100);
            int mes = 1 + geradorMersene.nextInt(11);
            int ano = geradorMersene.nextInt(100);
            int ano_final = 2050 - ano;

            int hash_vendedor = geradorMersene.nextInt(10000);
            String codigo_vendedor = "COD" + hash_vendedor;

            int total = geradorMersene.nextInt(80);
            String totalDeVendas = Integer.toString(total);

            sells.incluir(new Venda(Integer.toString(filial), mes + "/"
                    + ano_final, codigo_vendedor, totalDeVendas));
        }

        return sells;
    }

    public void incluirDados(String filial, String mesAno, String codigo_vendedor, String totalDeVendas) {
        sells.incluir(new Venda(filial, mesAno, codigo_vendedor, totalDeVendas));
    }

    public int getTAMANHO_DE_VENDAS() {
        return TAMANHO_DE_VENDAS;
    }

    public ListaDinamicaDeVenda getSells() {
        return sells;
    }

    public void printDados() {
        for (int i = 0; i < sells.getTAMANHO(); i++)
            System.out.println(sells.get(i).getFilial() + ","
                    + sells.get(i).getAnoMes() + ","
                    + sells.get(i).getCodVendedor() + ","
                    + sells.get(i).getTotalVendido());

    }

}
