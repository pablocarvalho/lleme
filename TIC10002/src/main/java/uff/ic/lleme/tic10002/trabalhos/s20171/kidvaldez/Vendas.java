/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.kidvaldez;

import java.util.Date;
import javafx.scene.chart.PieChart;

/**
 *
 * @author jim_k
 */
public class Vendas {

    int codFial;
    Date fecha;
    String cod_vendedor;
    double total;

    public Vendas(int codFial, Date fecha, String cod_vendedor, double total) {
        this.codFial = codFial;
        this.fecha = fecha;
        this.cod_vendedor = cod_vendedor;
        this.total = total;
    }
}
