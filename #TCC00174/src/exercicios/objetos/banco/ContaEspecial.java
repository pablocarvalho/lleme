package exercicios.objetos.banco;

public class ContaEspecial extends Conta {

  public float limite = 0;

  public ContaEspecial(int numero, float limite) {
    super(numero);
    this.limite = limite;
  }

  @Override
  public boolean temSaldo(Movimentacao mov) {
    if (this.saldo() + limite > mov.valor)
      return true;
    return false;
  }
}
