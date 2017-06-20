/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.raphaelbernardino;
/**
 *
 * @author Thiago
 */
public class NoB 
{
    public int n; //Atributo que guarda a quantidade de chaves no nó
    public int [] chave; //vetor das chaves
    public NoB [] filho;//vetor dos filhos
    public boolean folha;//Atributo que indica se a nó eh folha ou nao
    public int X;//Atributo que guarda a posicao X onde o Nó deve aparecer na tela
    public int Y;//Atributo que guarda a posicao Y onde o Nó deve aparecer na tela
    public int larguraFilho;            
    final int DIFERENCA_ALTURA = 30;
    final int DIFERENCA_IRMAOS = 5;

    public NoB(int n) 
    {
        this.chave = new int[(n - 1)];
        this.filho = new NoB[n];
        this.folha = true;
        this.n = 0;
    }

   
    public int computeSize() {
        return n * 28 + 12;
    }


    public void updateCoordenates(NoB parent, int x) {
        if (parent == null) {
            if (x == 0) {
                UpdateLFilho();
            }
            Y = 0;
        } else {
            Y = parent.Y + DIFERENCA_ALTURA;
        }
        if (!folha) {
            X = (larguraFilho / 2) + x;
            //X = x - (larguraFilho / 2);
            int xAcumuladoLocal = x;
            for (int i = 0; i < n + 1; i++) {
                filho[i].updateCoordenates(this, xAcumuladoLocal);
                xAcumuladoLocal += filho[i].larguraFilho + DIFERENCA_IRMAOS;
            }
        } else {
            X = x;
        }
    }

     public int UpdateLFilho() {
        larguraFilho = 0;
        if (!folha) {
            for (int i = 0; i < n + 1; i++) {
                larguraFilho += filho[i].UpdateLFilho();
            }
        } else {
            larguraFilho = computeSize() + DIFERENCA_IRMAOS;
        }
        return larguraFilho;
    }
}
