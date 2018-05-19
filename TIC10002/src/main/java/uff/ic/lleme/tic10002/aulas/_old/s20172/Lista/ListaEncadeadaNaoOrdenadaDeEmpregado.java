package uff.ic.lleme.tic10002.aulas._old.s20172.Lista;

import uff.ic.lleme.tic10002.aulas._old.s20172.oo.Empregado;
import uff.ic.lleme.tic10002.aulas._old.s20172.oo.NoLEEmpregado;

public class ListaEncadeadaNaoOrdenadaDeEmpregado implements ListaDeEmpregado {

    private NoLEEmpregado primeiro = null;

    public boolean inserir(Empregado e) {
        if (primeiro == null) {
            primeiro = new NoLEEmpregado(e);
            return true;
        } else {
            NoLEEmpregado p = primeiro;
            primeiro = new NoLEEmpregado(e);
            primeiro.proximo = p;
            return true;
        }
    }

    public Empregado excluir(int matricula) {
        return null;
    }

    public Empregado buscar(int matricula) {
        return buscar(primeiro, matricula);
    }

    private Empregado buscar(NoLEEmpregado noCorrente, int matricula) {
        if (noCorrente != null)
            if (noCorrente.empregado.matricula == matricula)
                return noCorrente.empregado;
            else
                return buscar(noCorrente.proximo, matricula);
        else
            return null;
    }

    public Empregado buscar(String nome) {
        return null;
    }
}
