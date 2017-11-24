package uff.ic.lleme.tic10002.trabalhos.s20171.Paulo_Lacerda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private String fileName;
    private int codInicio;
    private int codFim;
    private int dataInicio;
    private int dataFim;
    private ArvoreAVL arvoreFiliais;
    private ArvoreAVL arvoreDatas;

    public Main(String fileName, int codInicio, int codFim, int dataInicio, int dataFim) {
        this.fileName = fileName;
        this.codInicio = codInicio;
        this.codFim = codFim;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    private void run() {
        // cria e carrega as arvores
        this.arvoreFiliais = new ArvoreAVL();
        this.arvoreDatas = new ArvoreAVL();
        this.load(fileName, arvoreFiliais, arvoreDatas);

        // calcula os totais
        Query query = new Query();
        double totalFiliais = query.totaliza(arvoreFiliais, codInicio, codFim);
        double totalDatas = query.totaliza(arvoreDatas, dataInicio, dataFim);
        double totalJoined = query.hashJoin(arvoreDatas, dataInicio, dataFim, arvoreFiliais, codInicio, codFim);

        // imprime resultado
        this.report(totalFiliais, totalDatas, totalJoined);
    }

    private void load(String fileName, ArvoreAVL arvoreFiliais, ArvoreAVL arvoreDatas) {
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            inputStream.nextLine(); // skip first line
            while (inputStream.hasNext()) {
                String[] data = inputStream.next().split("\\s*,\\s*");
                Venda venda = new Venda(Integer.parseInt(data[0]),
                        Integer.parseInt(data[1]),
                        Integer.parseInt(data[2]),
                        Double.parseDouble(data[3]));
                arvoreFiliais.insert(venda.getFilial(), venda);
                arvoreDatas.insert(venda.getDate(), venda);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void report(double totalFiliais, double totalDatas, double totalJoined) {
        // resumo
        System.out.println("\nRESULTADO");
        System.out.print("Filtro: filiais (" + codInicio + " a " + codFim + ")");
        System.out.print(" periodo (" + dataInicio + " a " + dataFim + ")\n");
        System.out.println("Total filiais: " + totalFiliais);
        System.out.println("Total periodo: " + totalDatas);
        System.out.println("Total filiais/periodo: " + totalJoined);

        // árvores (pré-ordem)
        System.out.println("\nArvores AVL");
        System.out.println("Arvore filiais (pre-ordem): ");
        arvoreFiliais.showPreOrder();
        System.out.println("Arvore datas (pre-ordem): ");
        arvoreDatas.showPreOrder();
    }

    /**
     * Parâmetros de entrada fileName: caminho do arquivo de entrada codInicio:
     * código de filial inicial para consulta codFim: código de filial final
     * para consulta dataInicio: data inicial da consulta dataFim: data final da
     * consulta
     */
    public static void main(String[] args) {
        // parâmetros
        String fileName = args[0];
        int codInicio = Integer.parseInt(args[1]);
        int codFim = Integer.parseInt(args[2]);
        int dataInicio = Integer.parseInt(args[3]);
        int dataFim = Integer.parseInt(args[4]);

        Main main = new Main(fileName, codInicio, codFim, dataInicio, dataFim);
        main.run();
    }

}
