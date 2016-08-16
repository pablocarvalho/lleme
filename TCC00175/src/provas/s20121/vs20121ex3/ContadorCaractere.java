package provas.s20121.vs20121ex3;

import provas.s20121.vs20121ex1.Paragrafo;

public class ContadorCaractere extends Observador {

    public int contador = 0;
    private Paragrafo paragrafo;

    public ContadorCaractere(Paragrafo paragrafo) {
        this.paragrafo = paragrafo;
        paragrafo.registrar(this);
    }

    @Override
    public void atualizar(Sujeito sujeito) {
        contador = 0;
        if (sujeito == paragrafo)
            for (String linha : ((Paragrafo) sujeito).getTextoAlinhado())
                for (char c : linha.toCharArray())
                    if (c != ' ')
                        contador++;
    }
}
