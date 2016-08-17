package provas.s20141.p120141.mtx;

public class MatrizDiagonal extends MatrizEsparsa {

  public MatrizDiagonal(int linhas) {
    super(1, linhas);
  }

    @Override
    public double obter(int lin, int col) {
        if (lin >= 0 && col >= 0 && lin < numeroDeLinhas() && col < numeroDeColunas())
            return super.obter(1, col);
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void atribuir(int lin, int col, double valor) {
        if (lin >= 0 && col >= 0 && lin < numeroDeLinhas() && col < numeroDeColunas())
            atribuir(1, col, valor);
        else
            throw new ArrayIndexOutOfBoundsException();
    }

  @Override
  public int numeroDeLinhas() {
    return super.numeroDeColunas();
  }


}
