package provas.s20121.p220121ex2;

public class ConstrutorXML extends Construtor {

    private ElementoXML doc;
    private ElementoXML linhaCorrente;

    @Override
    public void construirDocumento(String nome) {
        doc = new ElementoXML(nome);
    }

    @Override
    public void construirLinha(int colunas) {
        linhaCorrente = new ElementoXML("linha");
        doc.filhos.add(linhaCorrente);
    }

    @Override
    public void construirCelula(String coluna, String valor) {
        ElementoXML celula = new ElementoXML(coluna);
        celula.filhos.add(new Valor(valor));
        linhaCorrente.filhos.add(celula);
    }

    public DocumentoXML getDocumentoXML() {
        return new DocumentoXML(doc);
    }
}
