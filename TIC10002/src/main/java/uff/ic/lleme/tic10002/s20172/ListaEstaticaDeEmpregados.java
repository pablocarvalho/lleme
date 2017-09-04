package uff.ic.lleme.tic10002.s20172;

public class ListaEstaticaDeEmpregados implements ListaDeEmpregado {

    private Empregado[] lista = new Empregado[10000];
    int contador = 0;

    public boolean inserir(Empregado e) {
        if (contador < lista.length) {
            lista[contador++] = e;
            return true;
        } else
            return false;
    }

    public Empregado excluir(int matricula) {
        return null;
    }

    public Empregado buscar(int matricula) {
        for (int i = 0; i < contador; i++)
            if (lista[i].matricula == matricula)
                return lista[i];
        return null;
    }

    public Empregado buscar(String nome) {
        return null;
    }
}
