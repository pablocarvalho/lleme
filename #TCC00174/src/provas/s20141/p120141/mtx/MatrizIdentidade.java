package provas.s20141.p120141.mtx;

public class MatrizIdentidade extends MatrizDiagonal {

    private int linhas = 0;

    public MatrizIdentidade(int linhas) {
        super(0);
        if (linhas < 0)
            throw new IllegalArgumentException();
        this.linhas = linhas;
    }

    @Override
    public double obter(int lin, int col) {
        if (lin >= 0 && col >= 0 && lin < numeroDeLinhas() && col < numeroDeColunas())
            if (lin == col)
                return 1;
            else
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
        return linhas;
    }

}