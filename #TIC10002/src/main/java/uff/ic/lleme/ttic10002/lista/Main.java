package uff.ic.lleme.ttic10002.lista;

import uff.ic.lleme.ttic10002.Empregado;

public class Main {

    public static void main(String[] args) {
        Empregado e1 = new Empregado();
        e1.cpf = "123";
        e1.nome = "Luiz";
        Empregado e2 = new Empregado();
        e2.cpf = "456";
        e2.nome = "Andre";
        Empregado e3 = new Empregado();
        e3.cpf = "789";
        e3.nome = "Luiz Andre";
        Empregado e4 = new Empregado();
        e4.cpf = "111";
        e4.nome = "Luiz";
        Empregado e5 = new Empregado();
        e5.cpf = "888";
        e5.nome = "Luiz 2";

        ListaEstaticaOrdenada<String, Empregado> lista = new ListaEstaticaOrdenada<>();

        Empregado e = lista.buscar("789");

        lista.incluir(e2);
        lista.incluir(e5);
        lista.incluir(e1);
        lista.incluir(e4);
        lista.incluir(e3);

        lista.excluir("456");

        System.out.println(lista.buscar("123").nome);
        //System.out.println(lista.buscar("456").nome);

        //lista.excluir("456");
        System.out.println(lista.buscar("789").nome);
        System.out.println(lista.buscar("111").nome);
        System.out.println(lista.buscar("888").nome);

        //Predicate<Empregado> luiz = (e) -> e.nome.equals("Luiz");
        //ListaEstaticaNaoOrdenada<String, Empregado> resultado = lista.buscar(luiz);
        System.out.println("fim");
    }
}
