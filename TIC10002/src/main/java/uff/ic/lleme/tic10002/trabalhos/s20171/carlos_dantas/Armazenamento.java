package uff.ic.lleme.tic10002.trabalhos.s20171.carlos_dantas;

/**
 *
 * @author Carlos
 */
public class Armazenamento {

    private AVLMesAno avlMesAno;
    private AVLFilial avlFilial;

    public Armazenamento() {
        avlMesAno = new AVLMesAno();
        avlFilial = new AVLFilial();
    }

    public void insere(int id_filial, MesAno mesAno, int id_vendedor, float valor) {
        Venda venda = new Venda(id_filial, mesAno, id_vendedor, valor);
        avlMesAno.insere(venda);
        avlFilial.insere(venda);
    }

    public float totalVendido(int id_filialInicial, int id_filialFinal, MesAno mInicial, MesAno mFinal) {
        if (id_filialInicial > 0 && id_filialFinal > 0)
            if (mInicial.eValido() && mFinal.eValido()) {
                // CORRECAO: as duas consultas armazenar vendas em hash
                TabelaHash hash = avlFilial.buscaFiliais(id_filialInicial, id_filialFinal);
                ListaVendas vendas = avlMesAno.buscaVendas(mInicial, mFinal);
                Venda venda = vendas.pop();
                float soma = 0;
                while (venda != null) {
                    if (hash.contem(venda.getIdLoja())) {
                        System.out.println(venda);
                        soma += venda.getValor();
                    }

                    venda = vendas.pop();
                }
                return soma;
            } else //Somente os id das lojas
            {
                ListaVendas lista = avlFilial.buscaVendas(id_filialInicial, id_filialFinal);
                return lista.somaVendas();
            }
        else //Somente os meses e anos
        {
            ListaVendas lista = avlMesAno.buscaVendas(mInicial, mFinal);

            return lista.somaVendas();
        }
    }
}
