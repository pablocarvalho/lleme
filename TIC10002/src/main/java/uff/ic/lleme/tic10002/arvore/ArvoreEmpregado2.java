package uff.ic.lleme.tic10002.arvore;

import uff.ic.lleme.tic10002.ColecaoEmpregado;
import uff.ic.lleme.tic10002.Empregado;

public class ArvoreEmpregado2 implements ColecaoEmpregado {

    private No raiz = null;
    private int qtd = 0;

    private class No {

        Empregado conteudo = null;
        No direita = null;
        No esquerda = null;
        No pai = null;

        private No(Empregado emp) {
            conteudo = emp;
        }

        private No(Empregado emp, No raiz) {
            conteudo = emp;
            pai = raiz;
        }
    }

    @Override
    public Empregado buscar(String cpf) {
        return buscar(raiz, cpf);
    }

    private Empregado buscar(No raiz, String cpf) {
        if (raiz != null)
            if (raiz.conteudo.compararChave(cpf) == 0)
                return raiz.conteudo;
            else if (raiz.conteudo.compararChave(cpf) > 0)
                return buscar(raiz.direita, cpf);
            else
                return buscar(raiz.esquerda, cpf);
        else
            return null;
    }

    @Override
    public Empregado incluir(Empregado emp) {
        if (raiz == null)
            return (raiz = new No(emp)).conteudo;
        else
            return incluir(raiz, emp);
    }

    private Empregado incluir(No raiz, Empregado emp) {
        if (raiz != null)
            if (raiz.conteudo.compararInstancia(emp) == 0)
                return null;
            else if (raiz.conteudo.compararInstancia(emp) > 0)
                if (raiz.direita == null)
                    raiz.direita = new No(emp, raiz);
                else
                    return incluir(raiz.direita, emp);
            else if (raiz.esquerda == null)
                raiz.esquerda = new No(emp, raiz);
            else
                return incluir(raiz.esquerda, emp);
        else
            return null;
    }

    @Override
    public Empregado excluir(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
