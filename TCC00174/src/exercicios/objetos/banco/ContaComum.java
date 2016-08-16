package exercicios.objetos.banco;

public class ContaComum extends Conta {

  public ContaComum(int numero){
    super(numero);
  }
  
  @Override
  public boolean temSaldo(Movimentacao mov) {
    if (this.saldo() > mov.valor)
      return true;
    return false;
  }
}