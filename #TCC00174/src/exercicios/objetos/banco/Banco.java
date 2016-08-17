package exercicios.objetos.banco;

import java.util.Calendar;
import java.util.Date;

public class Banco {

  public int numero;
  public String nome;
  public Conta[] contas = new Conta[10];

  public Banco(int numero, String nome) {
      this.numero=numero;
      this.nome=nome;
  }

  public void criarConta(Conta conta) {
    for (int i = 0; i < contas.length; i++)
      if (contas[i] == null)
        contas[i] = conta;
  }

  public void excluirConta(Conta conta) {
    for (int i = 0; i < contas.length; i++)
      if (contas[i].numero == conta.numero)
        contas[i] = null;
  }

  public void saque(Conta conta, float valor) {
    valor = -1 * Math.abs(valor);
    Date agora = Calendar.getInstance().getTime();
    Movimentacao mov = new Movimentacao(agora, valor);
    if (conta.temSaldo(mov))
      conta.saque(mov);
  }

  public void deposito(Conta conta, float valor) {
    valor = Math.abs(valor);
    Date agora = Calendar.getInstance().getTime();
    Movimentacao mov = new Movimentacao(agora, valor);
    conta.deposito(mov);
  }

  public Conta obterConta(int numero) {
    for (int i = 0; i < contas.length; i++)
      if (contas[i].numero == numero)
        return contas[i];
    return null;
  }

  public void transferencia(Conta de, Conta para, float valor) {
    float valorDeb = -1 * Math.abs(valor);
    float valorCred = Math.abs(valor);
    Date agora = Calendar.getInstance().getTime();
    Movimentacao movDeb = new Movimentacao(agora, valorDeb);
    Movimentacao movCred = new Movimentacao(agora, valorCred);
    if (de.temSaldo(movDeb)) {
      de.saque(movDeb);
      para.deposito(movCred);
    }
  }
  
}
