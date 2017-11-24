/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.wagner_oliveira;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 *
 * @author wagnerluizoliveiradossantos
 */
public class Trabalho {

    private ArvoreAVLComLista<Integer, Venda> avFilial = new ArvoreAVLComLista<>();
    private ArvoreAVLComLista<String, Venda> avAnoMes = new ArvoreAVLComLista<>();

    /**
     * Metodo responsavel por realizar geração de dados aleatorios simulando a
     * leitura de arquivos
     */
    public void lerVendas() {
        Random aleatorio = new Random();
        aleatorio.setSeed(0);
        for (int j = 0; j < 30; j++) {
            int dataAleatoria = ((aleatorio.nextInt(6) + 2007) * 100) + aleatorio.nextInt(12) + 1;
            String anoMes = new Integer(dataAleatoria).toString();

            Venda v = new Venda(j, 10 + aleatorio.nextInt(10),
                    anoMes,
                    aleatorio.nextInt(5),
                    aleatorio.nextDouble() * 100);

            System.out.println(v);
            avFilial.inserir(v.getFilial(), v);
            avAnoMes.inserir(v.getAnoMes(), v);

        }
        /**
         * Imprimir a arvore
         *
         */
        System.out.println("***********Arvore de Filial*********");
        avFilial.print();
        //avFilial.inorder();
        System.out.println("***********Arvore de Ano-Mes********");
        avAnoMes.print();
        //avAnoMes.inorder();

    }

    private ListaEncadeada<Integer, Venda> hashJoin(ListaEncadeada<Integer, Venda> l1, ListaEncadeada<Integer, Venda> l2) {
        ListaEncadeada<Integer, Venda> listaJoin = new ListaEncadeada<>();
        Hash<Integer, Venda> hash = new Hash();
        for (Venda v : l1)
            hash.put(v.getChave(), v);
        for (Venda v : l2) {
            Venda vendaEncontrada = hash.get(v.getChave());
            if (vendaEncontrada != null && vendaEncontrada.equals(v))
                listaJoin.incluir(v);
        }
        return listaJoin;
    }

    public static void main(String[] args) {
        int filial1 = 10;
        int filial2 = 12;
        Calendar calendar1 = new GregorianCalendar(2010, 0, 1);
        Calendar calendar2 = new GregorianCalendar(2012, 11, 1);
        Trabalho t = new Trabalho();
        System.out.println("******* CARREGANDO VENDAS*********");
        t.lerVendas();
        System.out.println("**********************************");
        double totaVendas = t.buscar(filial1, filial2, calendar1.getTime(), calendar2.getTime());
        System.out.println("\nTotal de vendas " + totaVendas);

    }

    public double buscar(int filial1, int filial2, Date data1, Date data2) {

        //converte o campo data
        DateFormat df = new SimpleDateFormat("yyyyMM");
        String dtStr1 = df.format(data1);
        String dtStr2 = df.format(data2);
        System.out.println("Busca Filial " + filial1 + " até " + filial2 + " de " + dtStr1 + " até " + dtStr2);
        ListaEncadeada<Integer, Venda> listaPorFilial = avFilial.buscar(filial1, filial2);
        ListaEncadeada<Integer, Venda> listaPorAnoMes = avAnoMes.buscar(dtStr1, dtStr2);

        System.out.println("Resultado do HashJoin");
        ListaEncadeada<Integer, Venda> listaJoin = this.hashJoin(listaPorFilial, listaPorAnoMes);
        double totalDeVendas = 0.0;
        for (Venda v : listaJoin) {
            System.out.println("filtrados " + v);
            totalDeVendas += v.getTotalVendido();
        }
        return totalDeVendas;
    }
}
