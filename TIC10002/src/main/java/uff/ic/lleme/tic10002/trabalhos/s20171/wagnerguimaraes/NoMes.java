/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.wagnerguimaraes;

/**
 *
 * @author Wagner
 */
public class NoMes {

    private NoMes prox;
    private int chave;
    private double Saldo = 0;

    public NoMes(NoFilial conteudo) {
        setChave(conteudo.getFilial().ano_mes);
        setSaldo(conteudo.getFilial().total_vendido);

    }

    public NoMes() {
        setChave(0);
        setSaldo(0);
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double aSaldo) {
        this.Saldo = Saldo + aSaldo;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public void setProx(NoMes n) {
        prox = n;
    }

    public NoMes getProx() {
        return prox;
    }
}
