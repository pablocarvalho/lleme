package provas.s20121.vs20121ex2;

import java.awt.HeadlessException;
import java.awt.TextArea;
import provas.s20121.vs20121ex1.Paragrafo;
import provas.s20121.vs20121ex3.ContadorCaractere;

public class AreaTextoFormatado extends TextArea {

    public Paragrafo paragrafo;
    private ContadorCaractere contadorCaractere;

    public AreaTextoFormatado() throws HeadlessException {
        paragrafo = new Paragrafo();
        contadorCaractere = new ContadorCaractere(paragrafo);
    }

    @Override
    public void append(String str) {
        paragrafo.incluirLinha(str);
    }

    @Override
    public String getText() {
        String text = "";
        for (String linha : paragrafo.getTextoAlinhado())
            text += linha + "\n";
        return text;
    }

    @Override
    public void setText(String str) {
        paragrafo.incluirLinha(str);
    }
}
