package uff.ic.tcc00328.exercicios;

public class P2_20111 {

    public static void main(String[] args) {
        float[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        imprimeMatriz(mat);
        imprimeMatriz(cofator(mat, 1, 1));
    }

    public static float determinante(float[][] matriz) {
        int i = 0;
        float det = 0f;
        if (matriz[0].length == 1)
            return matriz[0][0];
        else {
            for (int j = 0; j <= matriz[0].length; j++)
                det += matriz[i][j] * Math.pow(-1, i + j) * determinante(cofator(matriz, i, j));
            return det;
        }

    }

    public static float[][] cofator(float[][] a, int i, int j) {
        int n = a[0].length - 1;
        int coluna = 0;
        float b[][] = new float[n][n];

        int linha = 0;
        for (int k = 0; k < n + 1; k++)
            if (k != i) {
                coluna = 0;
                for (int l = 0; l < n + 1; l++)
                    if (l != j) {
                        b[linha][coluna] = a[k][l];
                        coluna++;
                    }
                linha++;
            }

        return b;
    }

    public static void imprimeMatriz(float[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++)
                System.out.print(a[i][j] + "\t");
            System.out.println("\n");
        }
    }
}
