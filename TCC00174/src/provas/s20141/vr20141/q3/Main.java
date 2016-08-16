package provas.s20141.vr20141.q3;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Venda> vendas = new ArrayList();
        try (InputStream is = new FileInputStream("vendas.txt")) {
            Scanner sc = new Scanner(is);

            while (sc.hasNext())
                vendas.add(new Venda(sc.nextInt(), sc.nextFloat()));

        } catch (Exception e) {
            System.out.println("erro");
        }

    }

    public float calcularMedia(List<Venda> vendas) {
        float media = 0;
        for (Venda v : vendas)
            media += v.valor();
        media /= vendas.size();
        return media;
    }

    public float[] calcularHistograma(List<Venda> vendas, float media) {
        float[] histograma = new float[2];
        for (Venda v : vendas)
            if (v.valor() <= media)
                histograma[0]++;
            else
                histograma[1]++;
        for (int i = 0; i < histograma.length; i++)
            histograma[i] /= vendas.size();
        return histograma;
    }
}
