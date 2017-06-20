/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.gabrielcarvalho;

/**
 *
 * @author Frog33
 */
public class Venda {
    private int filial;
    private MesAno ma;
    private String codVen;
    private int total;

    public Venda(int filial, String ma, String codVen, int total) {
        this.filial = filial;
        this.ma = new MesAno(ma);
        this.codVen = codVen;
        this.total = total;
    }
    public String getData(){
        return ma.toString();
    }
    public int getChave(boolean ehFilial){
        if(ehFilial) return this.getchave();
        return ma.getChave();
    }

    public void setTotal(int total) {
        this.total += total;
    }
    
    private int getchave(){
        return filial;
    }
    
    public int getTotal() {
        return total;
    }
    
    @Override
    public String toString(){
        return "||"+filial + ", " + ma + ", " + total + "|| ";
    }
}
