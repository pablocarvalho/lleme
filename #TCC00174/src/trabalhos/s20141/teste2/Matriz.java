package trabalhos.s20141.teste2;

public class Matriz extends Expressao {

    private double[][] matriz = null;

    public Matriz(int linhas, int colunas) {
        if (linhas < 0 || colunas < 0)
            throw new IllegalArgumentException();
        matriz = new double[linhas][colunas];
    }

    public double obter(int lin, int col) {
        if (lin < linhas() && col < colunas())
            return matriz[lin][col];
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    public void atribuir(int lin, int col, double valor) {
        if (lin < linhas() && col < colunas())
            matriz[lin][col] = valor;
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    public int linhas() {
        return matriz.length;
    }

    public int colunas() {
        return matriz[0].length;
    }

    @Override
    public Expressao calcular() {
        return this;
    }

    @Override
    public void imprimir() {
        for (int i = 0; i < linhas(); i++) {
            for (int j = 0; j < colunas(); j++)
                System.out.println(obter(i, j) + "t");
            System.out.println("");
        }
    }

}
