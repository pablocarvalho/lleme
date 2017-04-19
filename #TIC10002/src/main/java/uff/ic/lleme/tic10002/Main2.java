package uff.ic.lleme.tic10002;

import java.util.ArrayList;
import java.util.List;
import uff.ic.lleme.tic10002.lista.ListaDinamicaEmpregado;

public class Main2 {

    public static void main(String[] args) {
        ListaDinamicaEmpregado lista = new ListaDinamicaEmpregado();

        lista.incluir(new Empregado());
        Empregado emp = lista.buscar("123");

        List<Empregado> lista2 = new ArrayList<>();
        lista2.add(new Empregado());
    }
}
