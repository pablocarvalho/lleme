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
public class Avl {
    protected NoAvl raiz;
    
    public void inserir(int chave, Object conteudo){
        //Crio um novo nó e insiro neste o conteúdo
        NoAvl novoNo = new NoAvl(chave);
        novoNo.setConteudo(conteudo);
        
        //Passo o nó recém criado e tento inseri-lo na árvore a partir da raiz.
        //A função inserirAvl é recursiva e insere o novo nó na posição correta
        //segundo as regras da AVL.
        inserirAvl(this.raiz, novoNo);
    }
    
    protected void inserirAvl(NoAvl atualNo, NoAvl novoNo){
        //Se antigoNo é vazio, então significa que a arvore está vazia
        if (atualNo == null){
            this.raiz = novoNo;
        } else {
            //Checo se o Nó deve ser colocado à esquerda do nó atual
            if (atualNo.getChave() > novoNo.getChave()){
                //System.out.print("Insere"+novoNo.getChave()+" na esquerda\n");
                //Não havendo filhos à esquerda, insere-se o novoNó como filho à esquerda
                if (atualNo.getEsquerda()==null){
                    atualNo.setEsquerda(novoNo);
                    novoNo.setPai(atualNo);
                    verificarBalanceamento(atualNo);
                } else {
                    //Caso o nó atual possua filhos à esquerda, então novo No deve ser inserido na subarvore esquerda do nó atual
                    inserirAvl(atualNo.getEsquerda(), novoNo);
                }
            } 
            //Checo se o Nó deve ser colocado à direita do nó atual
            else if (atualNo.getChave() < novoNo.getChave()){
                //System.out.print("Insere"+novoNo.getChave()+" na direita\n");
                //Não havendo filhos à direita, insere-se o novoNó como filho à direita
                if (atualNo.getDireita()==null){
                    atualNo.setDireita(novoNo);
                    novoNo.setPai(atualNo);
                    verificarBalanceamento(atualNo);
                } else {
                    //Caso o nó atual possua filhos à direita, então o novo No deve ser inserido na subarvore direita do nó atual
                    inserirAvl(atualNo.getDireita(), novoNo);
                }
            } else {
                //Nó já existente
                inserirEmConteudo(atualNo, novoNo);
            }
        }
    }
    
    protected void inserirEmConteudo(NoAvl atualNo, NoAvl novoNo){
        
    } 
    
    protected void verificarBalanceamento(NoAvl atual){
        //Os balanceamento variam entre -2 a 2, onde -2 significa que a árvore possui dois níveis à esquerda a mais que à direita.
        //e 2 significa que a árvore possui dois níveis à direita a mais que à esquerda. Valores -1, 0 e 1 representam que a árvore está balanceada.
        atual.updateBalanceamento();
        int b = atual.getBalanceamento();
        
        //Se arvore está desbalanceada à esquerda
        if (b == -2){
            if (atual.getEsquerda().getBalanceamento() <= 0){
                atual =  rotacaoDireita(atual);
            }
            else {
                atual = duplaRotacaoEsquerdaDireita(atual);
            }
        }
        else if (b == 2){
            if (atual.getDireita().getBalanceamento() >= 0){
                atual = rotacaoEsquerda(atual);
            }
            else {
                atual = duplaRotacaoDireitaEsquerda(atual);
            }
        }
        
        if (atual.getPai() != null){
            verificarBalanceamento(atual.getPai());
        } else {
            this.raiz = atual;
        }
    }
    
    public NoAvl rotacaoEsquerda(NoAvl inicial){
        NoAvl direita = inicial.getDireita();
        direita.setPai(inicial.getPai());
        
        inicial.setDireita(direita.getEsquerda());
        
        if (inicial.getDireita() != null){
            inicial.getDireita().setPai(inicial);
        }
        
        direita.setEsquerda(inicial);
        inicial.setPai(direita);
        
        if (direita.getPai()!=null){
            if (direita.getPai().getDireita() == inicial){
                direita.getPai().setDireita(direita);
            } else if (direita.getPai().getEsquerda() == inicial){
                direita.getPai().setEsquerda(direita);
            }
        }
        
        inicial.updateBalanceamento();
        direita.updateBalanceamento();
        
        return direita;
    }
    
    public NoAvl rotacaoDireita(NoAvl inicial){
        NoAvl esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());
        
        inicial.setEsquerda(esquerda.getDireita());
        
        if (inicial.getEsquerda() != null){
            inicial.getEsquerda().setPai(inicial);
        }
        
        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);
        
        if (esquerda.getPai() != null){
            if (esquerda.getPai().getDireita() == inicial){
                esquerda.getPai().setDireita(esquerda);
            } else if (esquerda.getPai().getEsquerda() == inicial){
                esquerda.getPai().setEsquerda(esquerda);
            }
        }
        
        inicial.updateBalanceamento();
        esquerda.updateBalanceamento();
        
        return esquerda;
    }
    
    public NoAvl duplaRotacaoEsquerdaDireita(NoAvl inicial){
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }
    
    public NoAvl duplaRotacaoDireitaEsquerda(NoAvl inicial){
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }
    
    public void print(){
        printArvore(this.raiz, 0);
    }
    
    protected void printArvore(NoAvl inicial, int altura)
    {
        if (inicial==null)  return;
        for(int i = 0; i < altura ; i++){
            System.out.print("--");
        }
        System.out.print(inicial.getChave()+", "+inicial.getConteudo().toString()+"\n");
        printArvore(inicial.getEsquerda(), altura+1);
        printArvore(inicial.getDireita(), altura+1);
    }
}
