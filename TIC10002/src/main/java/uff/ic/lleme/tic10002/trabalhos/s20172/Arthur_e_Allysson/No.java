package uff.ic.lleme.tic10002.trabalhos.s20172.Arthur_e_Allysson;

/**
 *
 * @author allyssoncc
 */
public class No {

    private No proximo = null;
    private Trafego elemento;

    public No(No proximo, Trafego elemento) {
        this.proximo = proximo;
        this.elemento = elemento;
    }

    public No getProximo() {
        return proximo;
    }

    public Trafego getElemento() {
        return elemento;
    }

}
