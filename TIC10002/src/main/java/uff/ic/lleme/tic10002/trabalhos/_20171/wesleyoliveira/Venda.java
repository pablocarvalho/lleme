/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.wesleyoliveira;

/**
 *
 * @author Wesley Oliveira
 */
public class Venda
{
       private String numero_filial;
       private String data_venda;
       private String numero_vendedor;
       private String numero_vendas;
       
      public Venda(String filial, String data, String vendedor, String vendas)
      {
           this.numero_filial = filial;
           this.data_venda = data;
           this.numero_vendedor = vendedor;
           this.numero_vendas = vendas;
      }
      
      public String getvenda()
      {
          return this.numero_vendas;
      }
      public String getdata()
      {
          return this.data_venda;
      }
      public String getvendedor()
      {
          return this.numero_vendedor;
      }
      public String getfilial()
      {
          return this.numero_filial;
      }
}
