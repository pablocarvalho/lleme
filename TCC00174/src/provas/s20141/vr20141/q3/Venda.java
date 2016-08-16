package provas.s20141.vr20141.q3;

public class Venda {

    public int qtd;
    public float preco;

    public Venda(int qtd, float preco) {
        this.qtd = qtd;
        this.preco = preco;
    }

    public float valor() {
        return qtd * preco;
    }

}
