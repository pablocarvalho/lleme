/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.sydneyaraujo;

/**
 *
 * @author SidneyMelo
 */
public class Venda {

    public int filial;
    public int data;
    public int vendedor;
    public float total_vendido;

    public Venda(int filial, int data, int vendedor, float total_vendido) {
        this.filial = filial;
        this.data = data;
        this.vendedor = vendedor;
        this.total_vendido = total_vendido;
    }

    public void print() {
        System.out.println(this.filial + ", " + this.data + ", " + this.vendedor + ", " + total_vendido + "\n");
    }
}
