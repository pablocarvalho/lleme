package provas.s20141.p120141.mtx;

public abstract class Matriz {

    private double[][] matriz = null;

    public Matriz(int linhas, int colunas) {
        if (linhas < 0 || colunas < 0)
            throw new IllegalArgumentException();
        matriz = new double[linhas][colunas];
    }

    public double obter(int lin, int col) {
        if (lin >= 0 && col >= 0 && lin < numeroDeLinhas() && col < numeroDeColunas())
            return matriz[lin][col];
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    public void atribuir(int lin, int col, double valor) {
        if (lin >= 0 && col >= 0 && lin < numeroDeLinhas() && col < numeroDeColunas())
            matriz[lin][col] = valor;
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    public int numeroDeLinhas() {
        return matriz.length;
    }

    public int numeroDeColunas() {
        return matriz[0].length;
    }

}
