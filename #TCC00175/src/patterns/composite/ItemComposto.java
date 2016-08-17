package patterns.composite;

import java.util.HashSet;
import java.util.Set;

public class ItemComposto extends Item {

    private Set<Item> itens = new HashSet<Item>();

    public ItemComposto(String nome) {
        super(nome, 0);
    }

    @Override
    public double getVariacao() {
        double variacao = 0;
        for (Item item : getItens())
            variacao += item.getVariacao();
        return variacao / getItens().size();
    }

    @Override
    public void setVariacao(double variacao) {
        // Não faz nada
    }

    public Set<Item> getItens() {
        return itens;
    }

    public void addItem(Item item) {
        getItens().add(item);
    }

    @Override
    public void imprimir() {
        System.out.println(getNome() + ", variação: " + getVariacao());
        for (Item item : getItens())
            item.imprimir();
    }
}
