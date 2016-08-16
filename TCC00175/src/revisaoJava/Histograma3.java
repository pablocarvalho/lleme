package revisaoJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Histograma3 {

    public static void main(String[] args) {

        String arquivo = "entrada.txt";
        List<Float> notas = carregarDados(arquivo);
        float[] hist = calcularHistograma(notas, 0.0f, 10.0f, 3);

        // apresentar histograma
    }

    private static List<Float> carregarDados(String arquivo) {
        InputStream input;
        try {
            input = new FileInputStream(arquivo);
            Scanner in = new Scanner(input);
            List<Float> dados = new ArrayList<Float>();
            while (in.hasNext()) {
                in.nextInt();
                dados.add(in.nextFloat());
            }
            input.close();
            return dados;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Histograma3.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Histograma3.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static float[] calcularHistograma(List<Float> notas, float inicio,
            float fim, int faixas) {
        float[] histograma = new float[faixas];
        int faixa, contador = 0;
        for (float nota : notas)
            if (nota >= inicio && nota <= fim) {
                faixa = identificarFaixa(nota, inicio, fim, faixas);
                contador++;
                histograma[faixa]++;
            }
        for (int i = 0; i < histograma.length; i++)
            histograma[i] /= contador;
        return histograma;
    }

    private static int identificarFaixa(float nota, float inicio, float fim,
            int faixas) {
        float delta = (fim - inicio) / faixas;
        int faixa;
        faixa = (int) ((nota - inicio) / delta);
        if (faixa == faixas)
            faixa--;
        return faixa;
    }
}
