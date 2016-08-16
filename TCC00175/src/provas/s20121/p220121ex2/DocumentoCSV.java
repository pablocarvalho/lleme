package provas.s20121.p220121ex2;

import java.io.*;
import java.util.List;

public class DocumentoCSV {

    private List<String[]> doc;

    public DocumentoCSV(List<String[]> doc) {
        this.doc = doc;
    }

    public void save() throws FileNotFoundException, IOException {
        try (OutputStream output = new FileOutputStream("./dat/notas.csv", false);
                OutputStreamWriter writer = new OutputStreamWriter(output);
                BufferedWriter bw = new BufferedWriter(writer);) {
            for (String[] linha : doc) {
                for (int i = 0; i < linha.length - 1; i++)
                    bw.write(linha[i] + ";");
                bw.write(linha[linha.length - 1] + "\n");
            }
        }
    }
}
