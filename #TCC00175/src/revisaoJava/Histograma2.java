package revisaoJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Histograma2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        int faixas = 3, qtd = 0;
        float[] histograma = new float[faixas];
        InputStream input = new FileInputStream("notas.txt");
        Scanner in = new Scanner(input);
        float nota;
        int pos;
        while (in.hasNext()) {
            nota = in.nextFloat();
            pos = (int) (nota / (10.0 / faixas));
            if (pos >= faixas)
                pos = faixas - 1;
            histograma[pos]++;
            ++qtd;
        }
        for (int i = 0; i < faixas; i++)
            histograma[i] /= qtd;

        input.close();
    }
}
