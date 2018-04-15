package uff.ic.lleme.tcc00328.provas.s20152.p120152;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Regra1 implements Regra {

    private Quesito quesitoDesempate = null;

    private class R1Comparator implements Comparator<Resultado> {

        @Override
        public int compare(Resultado o1, Resultado o2) {
            if (o1.nota.equals(o2.nota))
                return o2.notaDesempate.compareTo(o1.notaDesempate);
            else
                return o2.nota.compareTo(o1.nota);
        }
    }

    @Override
    public void registrarQuesitoDesempate(Quesito quesito) {
        this.quesitoDesempate = quesito;
    }

    @Override
    public List<Resultado> calcularResultado(Carnaval carnaval) {
        List<Resultado> resultados = new ArrayList<>();
        for (Escola escola : carnaval.escolas) {
            int index;
            float[] medias = new float[Quesito.values().length];
            float[] minimos = new float[Quesito.values().length];
            for (int i = 0; i < minimos.length; i++)
                minimos[i] = 10f;
            int[] qtds = new int[Quesito.values().length];
            for (Nota nota : escola.notas) {
                index = nota.quesito.ordinal();
                medias[index] += nota.valor;
                qtds[index]++;
                if (nota.valor < minimos[index])
                    minimos[index] = nota.valor;
            }
            for (int i = 0; i < medias.length; i++) {
                medias[i] -= minimos[i];
                medias[i] = (qtds[i] - 1 > 0) ? medias[i] / (qtds[i] - 1) : 0f;
            }
            float mediaFinal = 0f;
            for (int i = 0; i < medias.length; i++)
                mediaFinal += medias[i];
            mediaFinal /= medias.length;
            Resultado resultado = new Resultado(escola, mediaFinal, medias[quesitoDesempate.ordinal()]);
            resultados.add(resultado);
        }
        Collections.sort(resultados, new R1Comparator());
        return resultados;
    }
}
