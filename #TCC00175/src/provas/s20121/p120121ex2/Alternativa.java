package provas.s20121.p120121ex2;

public class Alternativa extends Item {

    public Item item1;
    public Item item2;

    public Alternativa(Item item1, Item item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public String parse(String pedido, float desconto) throws Exception {
        String pedidoSalvo = pedido;
        float totalSalvo = total;
        try {
            pedido = item1.parse(pedido, desconto);
        } catch (Exception ex) {
            pedido = pedidoSalvo;
            total = totalSalvo;
            pedido = item2.parse(pedido, desconto);
        }
        return pedido;
    }
}
