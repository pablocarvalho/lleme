package uff.ic.tcc00174.trabalhos.s20141.teste2;

public abstract class Expressao {

    public abstract Expressao calcular();

    public void imprimir() {
        calcular().imprimir();
    }

}
