package uff.ic.lleme.tic10002;

import java.util.ArrayList;
import java.util.List;
import uff.ic.lleme.tic10002.arvore.ArvoreEmpregado2;
import uff.ic.lleme.tic10002.lista.ListaDinamicaEmpregado;

public class Main2 {

    public static void main(String[] args) {
        ColecaoEmpregado lista = new ListaDinamicaEmpregado();

        lista.incluir(new Empregado());
        Empregado emp = lista.buscar("123");
        lista.incluir(emp);

        List<Empregado> lista2 = new ArrayList<>();
        lista2.add(new Empregado());

        ColecaoEmpregado col2 = new ArvoreEmpregado2();
        col2.incluir(emp);
        col2.excluir("123");
        col2.buscar("123");

    }
}
