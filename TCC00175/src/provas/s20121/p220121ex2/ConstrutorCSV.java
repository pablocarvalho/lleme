package provas.s20121.p220121ex2;

import java.util.ArrayList;
import java.util.List;

public class ConstrutorCSV extends Construtor {

    private List<String[]> doc;
    private int linhaCorrente = -1;
    private int colunaCorrente;

    @Override
    public void construirDocumento(String nome) {
        doc = new ArrayList<>();
    }

    @Override
    public void construirLinha(int colunas) {
        if (linhaCorrente == -1) {
            doc.add(new String[colunas]);
            linhaCorrente++;
        }
        doc.add(new String[colunas]);
        linhaCorrente++;
        colunaCorrente = 0;
    }

    @Override
    public void construirCelula(String coluna, String valor) {
        doc.get(0)[colunaCorrente] = coluna;
        doc.get(linhaCorrente)[colunaCorrente] = valor;
        colunaCorrente++;
    }

    public DocumentoCSV getDocumentoCSV() {
        return new DocumentoCSV(doc);
    }
}
