package trabalhos.s20141.teste1;

public class AdicaoEscalar extends ExpressaoBinaria {

  private Expressao<Escalar> arg1;
  private Expressao<Escalar> arg2;

  public AdicaoEscalar(Expressao<Escalar> arg1, Expressao<Escalar> arg2) {
    this.arg1 = arg1;
    this.arg2 = arg2;
  }

  @Override
  public Escalar calcular() {
    Escalar resultado;
    resultado = new Escalar (arg1.calcular().getValor() + arg2.calcular().getValor());
    return resultado;
  }
}
