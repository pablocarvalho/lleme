package uff.ic.lleme.tic10002;

import java.io.InvalidObjectException;
import uff.ic.lleme.tic10002.arvore.ArvoreEmpregado;

public class Main2 {

    public static void main(String[] args) throws InvalidObjectException {

        ColecaoEmpregado col = new ArvoreEmpregado();
        col.incluir(new Empregado("06"));
        col.incluir(new Empregado("04"));
        col.incluir(new Empregado("03"));
        col.incluir(new Empregado("05"));
        col.incluir(new Empregado("02"));
        col.incluir(new Empregado("09"));
        col.incluir(new Empregado("08"));
        col.incluir(new Empregado("10"));
        col.incluir(new Empregado("07"));

        Empregado e = col.excluir("06");
        if (e != null)
            System.out.println(e.cpf);
        else
            System.out.println("Nao encontrado.");

        System.out.println("Fim.");
    }
}
