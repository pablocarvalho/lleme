package provas.s20121.p220121ex2;

import java.util.ArrayList;
import java.util.List;

public class ElementoXML extends No {

    public List<No> filhos = new ArrayList<>();
    public String nome;

    public ElementoXML(String nome) {
        this.nome = nome;
    }
}
