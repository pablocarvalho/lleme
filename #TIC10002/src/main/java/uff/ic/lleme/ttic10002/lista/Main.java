package uff.ic.lleme.ttic10002.lista;

import java.util.function.Predicate;
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

        ListaEstaticaNaoOrdenada<String, Empregado> lista = new ListaEstaticaNaoOrdenada<>();

        lista.incluir(e1);
        lista.incluir(e2);

        System.out.println(lista.buscar("123").nome);
        System.out.println(lista.buscar("456").nome);

        lista.incluir(e3);
        lista.excluir("456");

        System.out.println(lista.buscar("789").nome);

        Predicate<Empregado> cpf123 = (e) -> e.cpf.equals("123");
    }
}
