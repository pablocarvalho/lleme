package exercicios.objetos.banco;

public abstract class Conta {

  public int numero = 0;
  public Movimentacao[] movimentacoes = new Movimentacao[10];
  public int pos = 0;

  public Conta(int numero){
    this.numero=numero;
  }
  public abstract boolean temSaldo(Movimentacao mov);

  public void saque(Movimentacao mov) {
    movimentacoes[pos++] = mov;
  }

  public void deposito(Movimentacao mov) {
    movimentacoes[pos++] = mov;
  }

  public float saldo() {
    float saldo = 0;
    for (int i = 0; i < movimentacoes.length; i++)
      saldo += movimentacoes[i].valor;
    return saldo;
  }
}
