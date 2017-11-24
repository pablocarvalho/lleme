/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.thiago_malheiros.lista;

/**
 *
 * @author Thiago Malheiros Porcino
 */
//Classe do objeto venda, com todos os atributos da venda
public class Venda {

    public String cod_Filial;
    public String data;
    public String cod_Vendedor;
    public String total_Vendido;

    public Venda(String sCodFilial, String sData, String sCodVendedor, String sTotalVendido) {
        this.cod_Filial = sCodFilial;
        this.data = sData;
        this.cod_Vendedor = sCodVendedor;
        this.total_Vendido = sTotalVendido;
    }
}
