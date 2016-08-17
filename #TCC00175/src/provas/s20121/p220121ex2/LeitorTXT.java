package provas.s20121.p220121ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class LeitorTXT {

    public Construtor construtor;

    public LeitorTXT(Construtor construtor) {
        this.construtor = construtor;
    }

    public void converter(String arquivo) throws FileNotFoundException, IOException {
        try (InputStream input = new FileInputStream(arquivo)) {
            Scanner in = new Scanner(input);
            construtor.construirDocumento("notas");
            while (in.hasNext()) {
                construtor.construirLinha(5);
                int matricula = in.nextInt();
                construtor.construirCelula("matricula", matricula + "");
                float p1 = in.nextFloat();
                construtor.construirCelula("p1", p1 + "");
                float p2 = in.nextFloat();
                construtor.construirCelula("p2", p2 + "");
                float media = (p1 + p2) / 2;
                float vs = 0;
                if (media >= 4 && media <= 6)
                    vs = in.nextFloat();
                construtor.construirCelula("vs", vs + "");
                String nome = in.nextLine();
                construtor.construirCelula("nome", nome);
            }
        }
    }
}
