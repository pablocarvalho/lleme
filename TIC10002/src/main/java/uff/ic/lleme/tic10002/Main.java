package uff.ic.lleme.tic10002;

import uff.ic.lleme.tic10002.lista.ListaEstaticaNaoOrdenada;
import uff.ic.lleme.tic10002.lista.ListaNaoOrdenada;
import uff.ic.lleme.tic10002.sort.Sort;

public class Main {

    public static void main(String[] args) {
        Empregado e1 = new Empregado();
        e1.cpf = "1";
        e1.nome = "A";
        Empregado e2 = new Empregado();
        e2.cpf = "2";
        e2.nome = "B";
        Empregado e3 = new Empregado();
        e3.cpf = "3";
        e3.nome = "C";
        Empregado e4 = new Empregado();
        e4.cpf = "4";
        e4.nome = "D";
        Empregado e5 = new Empregado();
        e5.cpf = "5";
        e5.nome = "E";

        ListaNaoOrdenada<String, Empregado> lista = new ListaEstaticaNaoOrdenada<>();

        lista.incluir(e4);
        lista.incluir(e2);
        lista.incluir(e5);
        lista.incluir(e1);
        lista.incluir(e3);

        Sort.selectSort(lista);

        System.out.println(lista.buscar(0).nome);
        System.out.println(lista.buscar(1).nome);
        System.out.println(lista.buscar(2).nome);
        System.out.println(lista.buscar(3).nome);
        System.out.println(lista.buscar(4).nome);

        System.out.println("fim");
    }
}
