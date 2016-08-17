package provas.s20121.p120121ex2;

public class Sequencia extends Item {

    public Item item1;
    public Item item2;

    public Sequencia(Item item1, Item item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public String parse(String pedido, float desconto) throws Exception {
        pedido = item1.parse(pedido, desconto);
        pedido = item2.parse(pedido, desconto);
        return pedido;
    }
}
