/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.raphaelbernardino;

/**
 *
 * @author Wagner
 */
public class  ListaEncadeadaMeses{
    
    public  NoMes primeiro = null;
    private NoMes aux = null; 
   
    
    
    public void Inserir(NoFilial valor){
        /* Este algotitmo está funcionando
        if (primeiro==null){
            primeiro = new NoMes(valor);
        }
        else{
            NoMes novo = new NoMes(valor);
            novo.setProx(primeiro.getProx());
            primeiro.setProx(novo);
        }
        */
        NoMes prox,p,novo;
        if (primeiro==null){
            primeiro = new NoMes(valor);
        }
        else{
            novo = new NoMes(valor);
            prox = primeiro.getProx();
            p = primeiro;
            while (prox!=null && prox.getChave()<=valor.getFilial().ano_mes){
                p=prox;
                prox=prox.getProx();
            }
            if (p.getChave()==valor.getFilial().ano_mes)
                p.setSaldo(novo.getSaldo());
            else{
                novo.setProx(prox);
                p.setProx(novo);
            }
        }
    }
        
    public NoMes Busca (int chave){
        
        NoMes busca;
        busca = primeiro;
        if (busca != null){
            while (busca.getProx()!=null && busca.getChave()!=chave){
                aux = busca;
                busca=busca.getProx();
            }
            if (busca.getChave()==chave )
                return (busca);
        }
        aux=null;
        return null;
    }
    
    // Busca o saldo em um intervalo de filiais.
    public double BuscaSaldo (int pInicial, int pFinal){
        
        NoMes no=new NoMes();
        
        double Saldo=0;
        //Busca a filial e saldo no intervalo informado.
        for (int k=pInicial; k<=pFinal;k++){

            no = Busca(k);
            if (no!=null){
                Saldo+=no.getSaldo();
                System.out.printf("\nO Saldo do período %d é %f", k, Saldo);
            }
        }
        no=null;
        return Saldo;
        
    }
}