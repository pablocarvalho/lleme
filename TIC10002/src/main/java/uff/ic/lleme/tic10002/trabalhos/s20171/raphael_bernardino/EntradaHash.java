package uff.ic.lleme.tic10002.trabalhos.s20171.raphael_bernardino;

/**
 * @author bernardino
 */
public class EntradaHash {

    private final String chave;
    private Double valor;
    private EntradaHash prox;

    EntradaHash(String c, Double v) {
        chave = c;
        valor = v;
    }

    public Double getValor() {
        return valor;
    }

    public void incValor(Double valor) {
        this.valor += valor;
    }

    public String getChave() {
        return chave;
    }

    public EntradaHash proximo() {
        return prox;
    }

    public void setProximo(EntradaHash next) {
        this.prox = next;
    }

    @Override
    public String toString() {
        String out = this.valor.toString();
        if (this.prox != null)
            out += ", " + this.prox.toString();
        return out;
    }
}
