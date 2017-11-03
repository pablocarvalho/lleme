package uff.ic.lleme.tic10002.provas.s20171.VR20171Q2;

import uff.ic.lleme.tic10002.provas.s20171.P220171Q3.P220171Q3;
import java.util.ArrayList;
import java.util.List;

public class VR20171Q2 {

    private No raiz = null;

    public class No {

        public Integer chave = null;
        public No direita = null;
        public No esquerda = null;

        public No(int chave) {
            this.chave = chave;
        }

    }

    public List<Integer> buscar(int a, int b) {
        List<Integer> resultado = new ArrayList<>();
        buscar(raiz, a, b, resultado);
        return resultado;
    }

    private void buscar(No no, int a, int b, List<Integer> resultado) {
        if (no.chave >= a && no.chave <= b)
            resultado.add(no.chave);
        if (no.chave > a)
            buscar(no.direita, a, b, resultado);
        if (no.chave < b)
            buscar(no.esquerda, a, b, resultado);
    }

    public void incluir(int chave) {
        if (raiz == null)
            raiz = new No(chave);
        else
            incluir(raiz, new No(chave));
    }

    private void incluir(No no, No novoNo) {
        if (novoNo.chave > no.chave)
            if (no.esquerda == null)
                no.esquerda = novoNo;
            else
                incluir(no.esquerda, novoNo);
        else if (novoNo.chave < no.chave)
            if (no.direita == null)
                no.direita = novoNo;
            else
                incluir(no.direita, novoNo);
    }

    public static void main(String[] args) {
        P220171Q3 a = new P220171Q3();
        int[] nums = {34, 1, 78, 12, 3, 14, 67, 7, 6, 24};
        for (int num : nums)
            a.incluir(num);
        System.out.println("" + a.ehAVL());
    }
}
