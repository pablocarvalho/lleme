package provas.s20141.p120141.mtx;

public class MatrizNula extends MatrizEsparsa {

    private int linhas = 0;
    private int colunas = 0;

    public MatrizNula(int linhas, int colunas) {
        super(0, 0);
        if (linhas < 0 || colunas < 0)
            throw new IllegalArgumentException();
        this.linhas = linhas;
        this.colunas = colunas;
    }

    @Override
    public double obter(int lin, int col) {
        if (lin >= 0 && col >= 0 && lin < numeroDeLinhas() && col < numeroDeColunas())
            return 0;
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void atribuir(int lin, int col, double valor) {
        if (lin >= 0 && col >= 0 && lin < numeroDeLinhas() && col < numeroDeColunas()) {
            // nao faz nada
        } else
            throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public int numeroDeLinhas() {
        return linhas;
    }

    @Override
    public int numeroDeColunas() {
        return colunas;
    }

}