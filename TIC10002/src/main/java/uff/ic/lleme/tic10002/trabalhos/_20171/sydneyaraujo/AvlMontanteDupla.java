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
public class AvlMontanteDupla extends Avl {

    @Override
    public void inserir(int chave, Object conteudo) {
        //Crio um novo nó e insiro neste o conteúdo
        NoAvl novoNo = new NoAvl(chave);
        novoNo.setConteudo(conteudo);

        //Passo o nó recém criado e tento inseri-lo na árvore a partir da raiz.
        //A função inserirAvl é recursiva e insere o novo nó na posição correta
        //segundo as regras da AVL.
        inserirAvl(this.raiz, novoNo);
    }

    @Override
    protected void inserirAvl(NoAvl atualNo, NoAvl novoNo) {
        //Se antigoNo é vazio, então significa que a arvore está vazia
        if (atualNo == null) {
            AvlMontanteSimples avl = new AvlMontanteSimples();
            Venda v = (Venda) novoNo.getConteudo();
            avl.inserir(v.data, v.total_vendido);
            novoNo.setConteudo(avl);
            this.raiz = novoNo;
        } else //Checo se o Nó deve ser colocado à esquerda do nó atual
        if (atualNo.getChave() > novoNo.getChave())
            //System.out.print("Insere"+novoNo.getChave()+" na esquerda\n");
            //Não havendo filhos à esquerda, insere-se o novoNó como filho à esquerda
            if (atualNo.getEsquerda() == null) {
                AvlMontanteSimples avl = new AvlMontanteSimples();
                Venda v = (Venda) novoNo.getConteudo();
                avl.inserir(v.data, v.total_vendido);
                novoNo.setConteudo(avl);
                atualNo.setEsquerda(novoNo);
                novoNo.setPai(atualNo);
                verificarBalanceamento(atualNo);
            } else
                //Caso o nó atual possua filhos à esquerda, então novo No deve ser inserido na subarvore esquerda do nó atual
                inserirAvl(atualNo.getEsquerda(), novoNo);
        //Checo se o Nó deve ser colocado à direita do nó atual
        else if (atualNo.getChave() < novoNo.getChave())
            //System.out.print("Insere"+novoNo.getChave()+" na direita\n");
            //Não havendo filhos à direita, insere-se o novoNó como filho à direita
            if (atualNo.getDireita() == null) {
                AvlMontanteSimples avl = new AvlMontanteSimples();
                Venda v = (Venda) novoNo.getConteudo();
                avl.inserir(v.data, v.total_vendido);
                novoNo.setConteudo(avl);
                atualNo.setDireita(novoNo);
                novoNo.setPai(atualNo);
                verificarBalanceamento(atualNo);
            } else
                //Caso o nó atual possua filhos à direita, então o novo No deve ser inserido na subarvore direita do nó atual
                inserirAvl(atualNo.getDireita(), novoNo);
        else
            //Nó já existente
            inserirEmConteudo(atualNo, novoNo);
    }

    @Override
    protected void inserirEmConteudo(NoAvl atualNo, NoAvl novoNo) {
        AvlMontanteSimples avl = (AvlMontanteSimples) atualNo.getConteudo();
        Venda v = (Venda) novoNo.getConteudo();
        avl.inserir(v.data, v.total_vendido);
    }

    public float montanteDosIntervalos(int a, int b, int da, int db) {
        return calcularMontanteDoIntervalos(this.raiz, a, b, da, db);
    }

    private float calcularMontanteDoIntervalos(NoAvl no, int a, int b, int da, int db) {
        float montante = 0;
        if (no == null)
            return montante;
        else //System.out.println(no.getChave());
        if (no.getChave() <= b && no.getChave() >= a) {
            //System.out.println("Estou no intervalo");
            AvlMontanteSimples avl = (AvlMontanteSimples) no.getConteudo();
            montante += avl.montanteDoIntervalo(da, db);
            montante += calcularMontanteDoIntervalos(no.getDireita(), a, b, da, db);
            montante += calcularMontanteDoIntervalos(no.getEsquerda(), a, b, da, db);
        } else if (no.getChave() < a)
            montante += calcularMontanteDoIntervalos(no.getDireita(), a, b, da, db);
        else if (no.getChave() > b)
            montante += calcularMontanteDoIntervalos(no.getEsquerda(), a, b, da, db);
        //System.out.println("Montante: "+montante);
        return montante;

    }

    @Override
    protected void printArvore(NoAvl inicial, int altura) {
        if (inicial == null)
            return;
        for (int i = 0; i < altura; i++)
            System.out.print(">>");
        System.out.println("Filial :" + inicial.getChave());
        AvlMontanteSimples avl = (AvlMontanteSimples) inicial.getConteudo();
        avl.printArvore(avl.raiz, 0);
        printArvore(inicial.getEsquerda(), altura + 1);
        printArvore(inicial.getDireita(), altura + 1);
    }
}
