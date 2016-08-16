package provas.s20121.p120121ex2;

import java.util.Scanner;

public class Combinacao extends Item {

    public Item item1;
    public Item item2;

    public Combinacao(Item item1, Item item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public String parse(String pedido, float desconto) throws Exception {
        pedido = item1.parse(pedido, 0.9f);
        Scanner in = new Scanner(pedido.trim());
        if (in.next().equals(":"))
            pedido = in.nextLine().trim();
        else
            throw new Exception("Mensagem inválida");
        pedido = item2.parse(pedido, 0.9f);
        return pedido;
    }
}
