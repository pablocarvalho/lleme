/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.Sydney_Araujo;

/**
 *
 * @author SidneyMelo
 */
public class AvlMontanteSimples extends Avl {

    /**
     * Essa função é utilizada para atualizar o montante de um determinado nó
     *
     * @param atualNo
     * @param novoNo
     */
    @Override
    protected void inserirEmConteudo(NoAvl atualNo, NoAvl novoNo) {
        float montante_atual = (float) atualNo.getConteudo();
        montante_atual += (float) novoNo.getConteudo();
        atualNo.setConteudo(montante_atual);
    }

    public float montanteDoIntervalo(int a, int b) {
        return calcularMontanteDoIntervalo(this.raiz, a, b);
    }

    private float calcularMontanteDoIntervalo(NoAvl no, int a, int b) {
        float montante = 0;
        if (no == null)
            return montante;
        else //System.out.println(no.getChave());
        if (no.getChave() <= b && no.getChave() >= a) {
            //System.out.println("Estou no intervalo");
            montante = (float) no.getConteudo();
            montante += calcularMontanteDoIntervalo(no.getDireita(), a, b);
            montante += calcularMontanteDoIntervalo(no.getEsquerda(), a, b);
        } else if (no.getChave() < a)
            montante += calcularMontanteDoIntervalo(no.getDireita(), a, b);
        else if (no.getChave() > b)
            montante += calcularMontanteDoIntervalo(no.getEsquerda(), a, b);
        //System.out.println("Montante: "+montante);
        return montante;

    }
}
