package trabalhos.s20141.teste2;

public abstract class Expressao {

    public abstract Expressao calcular();

    public void imprimir() {
        calcular().imprimir();
    }

}
