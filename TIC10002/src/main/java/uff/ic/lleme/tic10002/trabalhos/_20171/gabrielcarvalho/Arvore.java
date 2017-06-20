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
public class Arvore {
    private No raiz = null;
    int tamanho = 0;   
    
    public int busca(int filialMenor, int filialMaior, MesAno dataMenor, MesAno dataMaior){
        
        if(filialMenor > filialMaior){
            int aux = filialMenor;
            filialMenor = filialMaior;
            filialMaior = aux;
        }
        if(dataMenor.distancia(dataMaior) > 0){
            MesAno aux = dataMenor;
            dataMenor = dataMaior;
            dataMaior = aux;
        }
        
        return busca(raiz, filialMenor, filialMaior, dataMenor, dataMaior);
    }
    
    private int busca(No atual, int filialMenor, int filialMaior, MesAno dataMenor, MesAno dataMaior){
        if(atual != null){
            if(atual.getChave() < filialMenor) return busca(atual.dir, filialMenor, filialMaior, dataMenor, dataMaior);
            if(atual.getChave() > filialMaior) return busca(atual.esq, filialMenor, filialMaior, dataMenor, dataMaior);
            int total = atual.busca(dataMenor, dataMaior);
            total += busca(atual.dir, filialMenor, filialMaior, dataMenor, dataMaior);
            return total + busca(atual.esq, filialMenor, filialMaior, dataMenor, dataMaior);
        }
        return 0;
    }
    
    public void incluir(Venda v){
        
        if(raiz == null){
            raiz = new No(v.getChave(true));
            raiz.incluir(v);
            tamanho++;
        }
        else this.incluir(raiz,v);
    }
    
    private void incluir(No atual, Venda v){
        if(atual == null) return;
        
        if(atual.getChave() == v.getChave(true)){
            atual.incluir(v);
        }else{
        
            boolean b = atual.getChave() > v.getChave(true);
            No novo;

            if(b){
                if(atual.esq == null){
                    novo = new No(v.getChave(true));
                    novo.incluir(v);
                    atual.esq = novo;
                    novo.pai = atual;
                    tamanho++;
                }
                else incluir(atual.esq,v);
            }else{

                if(atual.dir == null){
                    novo = new No(v.getChave(true));
                    novo.incluir(v);
                    atual.dir = novo;
                    novo.pai = atual;
                    tamanho++;
                }
                else incluir(atual.dir,v);
            }
            atual.altura = Math.max(No.altura(atual.dir),No.altura(atual.esq))+1;
            int fb = atual.fatorBalanceamento();
            No pai = null;
            No aux = atual;

            if(atual != raiz) pai = atual.pai;
            boolean filhoDireita = pai != null && atual.equals(pai.dir);

            if(fb > 1){
                if(atual.esq.fatorBalanceamento() > -1){
                    aux = rotacaoDireita(atual);
                }
                else{
                    aux = rotacaoDuplaDireita(atual);
                }
            }else if(fb < -1){

                if(atual.dir.fatorBalanceamento() < 1){
                    aux = rotacaoEsquerda(atual);
                }
                else{
                    aux = rotacaoDuplaEsquerda(atual);
                }
            }
            if(pai != null){
                aux.pai = pai;
                if(filhoDireita) pai.dir = aux;
                else pai.esq = aux;
            }else{
                raiz = aux;
            }
        }
    }
    
    private No rotacaoDuplaDireita(No no){
        No aux = rotacaoEsquerda(no.esq);
        
        no.esq = aux;
        aux.pai = no;
        
        return rotacaoDireita(no);
    }
    
    private No rotacaoDuplaEsquerda(No no){
        No aux = rotacaoDireita(no.dir);
        
        no.dir = aux;
        aux.pai = no;
        
        return rotacaoEsquerda(no);
    }
    
    private No rotacaoDireita(No desbalanceado){
        No n2 = desbalanceado.esq;
        No t1 = n2.esq,t2 = n2.dir;
        
        desbalanceado.esq = t2;
        if(t2 != null) t2.pai = desbalanceado;
        
        n2.dir = desbalanceado;
        desbalanceado.pai = n2;
        
        desbalanceado.altura = Math.max(No.altura(desbalanceado.dir), No.altura(desbalanceado.esq)) + 1;
        n2.altura = Math.max(No.altura(n2.esq), No.altura(n2.dir)) + 1;
        return n2;
    }
    
    private No rotacaoEsquerda(No desbalanceado){
        No n2 = desbalanceado.dir;
        No t1 = n2.dir,t2 = n2.esq;
        
        desbalanceado.dir = t2;
        if(t2 != null) t2.pai = desbalanceado;
        
        n2.esq = desbalanceado;
        desbalanceado.pai = n2;
        
        desbalanceado.altura = Math.max(No.altura(desbalanceado.dir), No.altura(desbalanceado.esq)) + 1;
        n2.altura = Math.max(No.altura(n2.esq), No.altura(n2.dir)) + 1;
        return n2;
    }
    
    /**
     * @param imprimir é igual a 0 se for para imprimir a árvore e a sub árvore, 1 se for só a árvore e 2 se for só as sub árvores
     */
    public void imprime(byte imprimir){
        switch (imprimir) {
            case 0:
                raiz.printTree();
                this.imprime(raiz);
                break;
            case 1:
                raiz.printTree();
                break;
            default:
                this.imprime(raiz);
                break;
        }
        
    }
    
    private void imprime(No  atual){
        if(atual == null) return;
        
        System.out.print("||"+atual.cont.getChave());
        atual.cont.imprime();
        System.out.println("\n\n\n");
        //System.out.print("\\\\" + atual.fatorBalanceamento() + "||\n");
        this.imprime(atual.esq);
        this.imprime(atual.dir);
        
    }
    
}
