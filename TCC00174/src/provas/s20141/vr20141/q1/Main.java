package provas.s20141.vr20141.q1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        backtracking(new Mapa(), 1);
    }

    private static boolean eSol(Mapa mapa) {
        return mapa.estaCompleto() && !mapa.haCorAdjacenteIgual();
    }

    private static void processaSol(Mapa mapa) {
        mapa.imprimir();
    }

    private static void backtracking(Mapa mapa, int regiao) {
        if (eSol(mapa))
            processaSol(mapa);
        else {
            List<Coloracao> cand = gerarCand(mapa, regiao);
            for (Coloracao p : cand) {
                mapa.colorir(p);
                if (!mapa.haCorAdjacenteIgual())
                    backtracking(mapa, regiao + 1);
                mapa.descolorir(p);
            }
        }

    }

    private static List<Coloracao> gerarCand(Mapa mapa, int regiao) {
        List<Coloracao> cand = new ArrayList();
        if (mapa.contemRegiao(regiao))
            for (int i = 1; i < 5; i++)
                cand.add(new Coloracao(regiao, i));
        return cand;
    }
}
