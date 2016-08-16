package provas.s20121.p120121ex2;

public class Repeticao extends Item {

    public Item item;

    public Repeticao(String simbolo, Item item) {
        this.item = item;
    }

    @Override
    public String parse(String pedido, float desconto) throws Exception {
        String pedidoOriginal = pedido;
        try {
            do
                pedido = item.parse(pedido, desconto);
            while (true);
        } catch (Exception e) {
            if (pedido.equals(pedidoOriginal))
                throw new Exception();
        }
        return pedido;
    }
}
