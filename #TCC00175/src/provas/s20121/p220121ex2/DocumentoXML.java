package provas.s20121.p220121ex2;

import java.io.*;

public class DocumentoXML {

    private ElementoXML doc;

    public DocumentoXML(ElementoXML doc) {
        this.doc = doc;
    }

    public void save() throws FileNotFoundException, IOException {
        try (OutputStream output = new FileOutputStream("./dat/notas.xml", false);
                OutputStreamWriter writer = new OutputStreamWriter(output);
                BufferedWriter bw = new BufferedWriter(writer);) {
            bw.write("<" + doc.nome + ">\n");
            for (No linha : doc.filhos) {
                bw.write("<linha>\n");
                for (No celula : ((ElementoXML) linha).filhos) {
                    String nome = ((ElementoXML) celula).nome;
                    String valor = ((Valor) ((ElementoXML) celula).filhos.get(0)).literal;
                    bw.write("<" + nome + ">" + valor + "</" + nome + ">\n");
                }
                bw.write("</linha>\n");
            }
            bw.write("</" + doc.nome + ">\n");
        }
    }
}
