package aulas.polimorfismo.listbox;

import java.util.Iterator;

public class ListBox {

    private Iterator<Nomeavel> iterator;

    public ListBox(SelecionavelPorNome colecao, String nome) {
        this.iterator = colecao.getIteratorPorNome(nome);
    }

    public void geraListBox() {
        while (iterator.hasNext())
            System.out.println(iterator.next().getNome());
    }
}
