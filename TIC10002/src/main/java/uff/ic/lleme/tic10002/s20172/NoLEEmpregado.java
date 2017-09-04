package uff.ic.lleme.tic10002.s20172;

public class NoLEEmpregado {

    public Empregado empregado = null;
    public NoLEEmpregado proximo = null;
    public NoLEEmpregado anterior = null;

    public NoLEEmpregado(Empregado e) {
        empregado = e;
    }
}
