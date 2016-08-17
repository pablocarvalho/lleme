package provas.s20121.p220121ex2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Cliente {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ConstrutorCSV construtor1 = new ConstrutorCSV();
        LeitorTXT leitor1 = new LeitorTXT(construtor1);
        leitor1.converter("./dat/notas.txt");
        construtor1.getDocumentoCSV().save();

        ConstrutorXML construtor2 = new ConstrutorXML();
        LeitorTXT leitor2 = new LeitorTXT(construtor2);
        leitor2.converter("./dat/notas.txt");
        construtor2.getDocumentoXML().save();
    }
}
