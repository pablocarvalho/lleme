package revisaoJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Histograma {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe número de faixas");
        int h;
        h = in.nextInt();
        float hist[] = new float[h];
        System.out.println("Informe limite inferior");
        float li = in.nextFloat();
        System.out.println("Informa limite superior");
        float ls = in.nextFloat();
        InputStream input = new FileInputStream("notas.txt");
        in = new Scanner(input);
        float nota;
        int qtdNotas = 0;
        while (in.hasNext()) {
            nota = in.nextFloat();
            if (nota >= li && nota <= ls) {
                qtdNotas++;
                hist[faixa(nota, li, ls, h)]++;
            }
        }
        for (int i = 0; i < hist.length; i++) {
            hist[i] /= qtdNotas;
            System.out.println("hist[" + i + "]=" + hist[i]);
        }

    }

    private static int faixa(float nota, float li, float ls, int faixas) {
        float h = (ls - li) / faixas;
        int faixa = (int) ((nota - li) / h);
        if (nota == ls)
            faixa--;
        return faixa;
    }
}
