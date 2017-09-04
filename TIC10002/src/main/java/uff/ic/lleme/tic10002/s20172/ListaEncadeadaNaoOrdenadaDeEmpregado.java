package uff.ic.lleme.tic10002.s20172;

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

    private Empregado buscar(NoLEEmpregado p, int matricula) {
        if (p != null)
            if (p.empregado.matricula == matricula)
                return p.empregado;
            else
                return buscar(p.proximo, matricula);
        else
            return null;
    }

    public Empregado buscar(String nome) {
        return null;
    }
}
