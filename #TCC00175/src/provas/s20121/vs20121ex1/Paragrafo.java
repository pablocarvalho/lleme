package provas.s20121.vs20121ex1;

import java.util.ArrayList;
import java.util.List;
import provas.s20121.vs20121ex3.Sujeito;

public class Paragrafo extends Sujeito {

    private List<String> linhas = new ArrayList<>();
    public Formatador formatador;

    public List<String> getTextoAlinhado() {
        return formatador.formatar(linhas);
    }

    public String getLinha(int i) {
        return linhas.get(i);
    }

    public int getContagemLinhas() {
        return linhas.size();
    }

    public void incluirLinha(String linha) {
        linhas.add(linha);
        avisar();
    }
}
