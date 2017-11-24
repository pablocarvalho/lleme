package uff.ic.lleme.tic10002.trabalhos.s20171.leandro_miranda;

import java.io.InvalidObjectException;
import javax.swing.JOptionPane;
import uff.ic.lleme.tic10002.trabalhos.s20171.leandro_miranda.ArvoreVenda.No;

public class Intermediaria {

    private int TAMANHO_DE_VENDAS;
    private GeracaoDeDados geracaoDeDados;
    private TabelaHash tabela;
    private ListaDinamicaDeVenda listaLetraA;
    private ListaDinamicaDeVenda listaLetraC;
    private ArvoreVenda arvoreFilialLista;
    private ListaDinamicaDeVenda sells;
    private ArvoreVenda arvoreCodVendedorLista;

    public ArvoreVenda getArvoreCodVendedorLista() {
        return arvoreCodVendedorLista;
    }

    public int getTamanhoDeVendas() {
        return TAMANHO_DE_VENDAS;
    }

    public GeracaoDeDados getGeracaoDeDados() {
        return geracaoDeDados;
    }

    public TabelaHash getTabela() {
        return tabela;
    }

    public ListaDinamicaDeVenda getListaLetraA() {
        return listaLetraA;
    }

    public ListaDinamicaDeVenda getListaLetraC() {
        return listaLetraC;
    }

    public ArvoreVenda getArvoreFilialLista() {
        return arvoreFilialLista;
    }

    public ListaDinamicaDeVenda getSells() {
        return sells;
    }

//	BTreePrinter.printNode(arvoreFilialLista.getRaiz());
    public void incluirDados(Venda venda) throws InvalidObjectException {
        sells.incluir(venda);
        arvoreFilialLista.incluir(venda);
        arvoreCodVendedorLista.incluir(venda);
        tabela.put(venda.getAnoMes(), venda);
    }

    public void removerDados(String venda, String tipo) throws InvalidObjectException {

        sells.setTipo(tipo);
        Venda vendaAuxiliar = sells.buscar(venda);
        if (vendaAuxiliar == null)
            JOptionPane.showMessageDialog(null, "Nao tem essa chave");
        else {
            sells.setTipo(tipo);
            if (tipo == "filial")
                sells.excluir(vendaAuxiliar.getFilial());
            else if (tipo == "ano_mes")
                sells.excluir(vendaAuxiliar.getAnoMes());
            else if (tipo == "cod_vendedor")
                sells.excluir(vendaAuxiliar.getCodVendedor());
            else if (tipo == "total_vendido")
                sells.excluir(vendaAuxiliar.getTotalVendido());

            arvoreFilialLista.excluir(vendaAuxiliar.getFilial());
            arvoreCodVendedorLista.excluir(vendaAuxiliar.getCodVendedor());
            tabela.remover(vendaAuxiliar.getAnoMes());
            JOptionPane.showMessageDialog(null, "Chave excluida com sucesso");
        }

    }

    public void buscarDados(String chave, String tipo) throws InvalidObjectException {
        if (tipo == "filial") {
            No inf = arvoreFilialLista.buscar(chave);
            if (inf != null)
                JOptionPane.showMessageDialog(null, "foi encontrado");
            else
                JOptionPane.showMessageDialog(null, "Nao foi encontrado");
        } else if (tipo == "ano_mes")
            tabela.buscar(chave);
        else if (tipo == "cod_vendedor") {
            No inf = arvoreCodVendedorLista.buscar(chave);
            if (inf != null)
                JOptionPane.showMessageDialog(null, "foi encontrado");
            else
                JOptionPane.showMessageDialog(null, "Nao foi encontrado");
        } else
            JOptionPane.showMessageDialog(null, "Nao h?? como buscar");

    }

    public void carregarDadosNasEDs(int nDatasets) throws InvalidObjectException {
        System.out.println("=========INFORMACAO SOBRE O DATASET INICIAL GERADO ==============");
        TAMANHO_DE_VENDAS = nDatasets;
        geracaoDeDados = new GeracaoDeDados(TAMANHO_DE_VENDAS);
        tabela = new TabelaHash();
        arvoreFilialLista = new ArvoreVenda("filial");
        arvoreCodVendedorLista = new ArvoreVenda("cod_vendedor");
        sells = geracaoDeDados.gerarDados();
        geracaoDeDados.printDados();

        for (int i = 0; i < sells.getTAMANHO(); i++) {
            sells.setTipo("filial");
            arvoreFilialLista.incluir(sells.get(i));
            sells.setTipo("cod_vendedor");
            arvoreCodVendedorLista.incluir(sells.get(i));
            tabela.put(geracaoDeDados.getSells().get(i).getAnoMes(),
                    geracaoDeDados.getSells().get(i));
        }

        System.out.println("================================");
    }

    public int resolverLetraB(ListaDinamicaDeVenda listaLetraA,
            ListaDinamicaDeVenda listaLetraC) {

        int sum = 0;
        ListaDinamicaDeVenda listaAC = new ListaDinamicaDeVenda();

        for (int i = 0; i < listaLetraA.getTAMANHO(); i++)
            for (int j = 0; j < listaLetraC.getTAMANHO(); j++)
                if (listaLetraA.get(i).equals(listaLetraC.get(j))) {
                    Venda vdAux = listaLetraA.get(i);
                    listaAC.incluir(vdAux);
                    sum += Integer.parseInt(vdAux.getTotalVendido());
                }

        System.out.println("####### RESULTADO FINALLL #############");
        listaAC.print();
        return sum;
    }

    public int resolverLetraC(ListaDinamicaDeVenda listaLetraC, String inicioMesAno, String fimMesAno) throws InvalidObjectException {

        // CORRECAO: onde está a busaca na árvore?
        tabela.printIntervalo(inicioMesAno, fimMesAno,
                listaLetraC);
        listaLetraC.print();
        int sum = 0;
        for (int i = 0; i < listaLetraC.getTAMANHO(); i++) {
            Venda venda = listaLetraC.get(i);
            sum += Integer.parseInt(venda.getTotalVendido());
        }
        return sum;
    }

    public int resolverLetraA(ListaDinamicaDeVenda listaLetraA, int inicioChave, int fimChave) {

//		ImpressaoEmArvores.imprimirNo(arvoreFilialLista.getRaiz());
        arvoreFilialLista.printIntervalo(arvoreFilialLista.getRaiz(), inicioChave, fimChave,
                listaLetraA);

        listaLetraA.print();

        ////
        int sum = 0;
        for (int i = 0; i < listaLetraA.getTAMANHO(); i++) {
            Venda venda = listaLetraA.get(i);
            sum += Integer.parseInt(venda.getTotalVendido());
        }
        return sum;

    }

}
