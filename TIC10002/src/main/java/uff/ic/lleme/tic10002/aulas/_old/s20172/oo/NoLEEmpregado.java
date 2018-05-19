package uff.ic.lleme.tic10002.aulas._old.s20172.oo;

public class NoLEEmpregado {

    public Empregado empregado = null;
    public NoLEEmpregado proximo = null;
    public NoLEEmpregado anterior = null;

    public NoLEEmpregado(Empregado e) {
        empregado = e;
    }
}
