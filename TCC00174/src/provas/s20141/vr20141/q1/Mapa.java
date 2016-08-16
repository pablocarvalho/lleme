package provas.s20141.vr20141.q1;

public class Mapa {

    private final int[][] mapa
        = {{1, 1, 1, 2, 2, 2, 2},
        {3, 4, 5, 5, 6, 7, 2},
        {3, 3, 3, 8, 8, 8, 2},
        {2, 2, 2, 2, 2, 2, 2}};
    private final int[][] cores = new int[mapa.length][mapa[0].length];

    boolean haCorAdjacenteIgual() {
        for (int i = 0; i < mapa.length; i++)
            for (int j = 0; j < mapa[0].length; j++)
                if (haCorAdjacenteIgual(i, j))
                    return true;
        return false;
    }

    private boolean haCorAdjacenteIgual(int i, int j) {
        int k, l;
        k = i - 1;
        l = j;
        if (k >= 0 && k < cores.length
            && l >= 0 && l < cores[0].length
            && cores[k][l] != 0 && cores[i][j] != 0
            && cores[k][l] == cores[i][j]
            && mapa[k][l] != mapa[i][j])
            return true;
        k = i;
        l = j - 1;
        if (k >= 0 && k < cores.length
            && l >= 0 && l < cores[0].length
            && cores[k][l] != 0 && cores[i][j] != 0
            && cores[k][l] == cores[i][j]
            && mapa[k][l] != mapa[i][j])
            return true;
        k = i + 1;
        l = j;
        if (k >= 0 && k < cores.length
            && l >= 0 && l < cores[0].length
            && cores[k][l] != 0 && cores[i][j] != 0
            && cores[k][l] == cores[i][j]
            && mapa[k][l] != mapa[i][j])
            return true;
        k = i;
        l = j + 1;
        if (k >= 0 && k < cores.length
            && l >= 0 && l < cores[0].length
            && cores[k][l] != 0 && cores[i][j] != 0
            && cores[k][l] == cores[i][j]
            && mapa[k][l] != mapa[i][j])
            return true;
        return false;
    }

    void imprimir() {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++)
                System.out.print(cores[i][j] + " ");
            System.out.println("");
        }
        System.out.println("\n\n");
    }

    boolean estaCompleto() {
        for (int i = 0; i < mapa.length; i++)
            for (int j = 0; j < mapa[0].length; j++)
                if (cores[i][j] == 0)
                    return false;
        return true;
    }

    void colorir(Coloracao p) {
        for (int i = 0; i < mapa.length; i++)
            for (int j = 0; j < mapa[0].length; j++)
                if (mapa[i][j] == p.regiao)
                    cores[i][j] = p.cor;
    }

    void descolorir(Coloracao p) {
        for (int i = 0; i < mapa.length; i++)
            for (int j = 0; j < mapa[0].length; j++)
                if (mapa[i][j] == p.regiao)
                    cores[i][j] = 0;
    }

    boolean contemRegiao(int regiao) {
        for (int i = 0; i < mapa.length; i++)
            for (int j = 0; j < mapa[0].length; j++)
                if (mapa[i][j] == regiao)
                    return true;
        return false;
    }

}
