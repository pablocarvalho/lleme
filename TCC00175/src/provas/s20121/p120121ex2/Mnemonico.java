package provas.s20121.p120121ex2;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Mnemonico extends Item {

    public String mnemonico;
    public float valor = 0;

    public Mnemonico(String mnemonico, float valor) {
        this.mnemonico = mnemonico;
        this.valor = valor;
    }

    @Override
    public String parse(String pedido, float desconto) throws Exception {
        Scanner in = new Scanner(pedido.trim());
        if (in.next().equals(mnemonico)) {
            total += valor * desconto;
            try {
                pedido = in.nextLine().trim();
            } catch (NoSuchElementException e) {
                pedido = null;
            }
            return pedido;
        } else
            throw new Exception();
    }
}
