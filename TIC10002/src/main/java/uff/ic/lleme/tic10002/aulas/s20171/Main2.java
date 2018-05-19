package uff.ic.lleme.tic10002.aulas.s20171;

import uff.ic.lleme.tic10002.utils.Empregado;
import java.io.InvalidObjectException;
import uff.ic.lleme.tic10002.aulas.s20171.arvore.ArvoreEmpregado;

public class Main2 {

    public static void main(String[] args) throws InvalidObjectException {

        ColecaoEmpregado col = new ArvoreEmpregado();
        col.incluir(new Empregado(6));
        col.incluir(new Empregado(4));
        col.incluir(new Empregado(3));
        col.incluir(new Empregado(5));
        col.incluir(new Empregado(2));
        col.incluir(new Empregado(9));
        col.incluir(new Empregado(8));
        col.incluir(new Empregado(10));
        col.incluir(new Empregado(7));

        Empregado e = col.excluir(6);
        if (e != null)
            System.out.println(e.cpf());
        else
            System.out.println("Nao encontrado.");

        System.out.println("Fim.");
    }
}
