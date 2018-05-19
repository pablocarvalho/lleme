package uff.ic.lleme.tic10002.aulas._old.s20171.lista;

import uff.ic.lleme.tic10002.aulas._old.s20171.ColecaoEmpregado;
import uff.ic.lleme.tic10002.aulas.utils.Empregado;

public class ListaDinamicaEmpregado implements ColecaoEmpregado {

    private No primeiro = null;

    private class No {

        public Object conteudo = null;
        public No proximo = null;

        public No(Empregado emp) {
            conteudo = emp;
        }

    }

    public Empregado incluir(Empregado emp) {
        if (primeiro == null) {
            primeiro = new No(emp);
            return emp;
        } else {
            No novo = new No(emp);
            novo.proximo = this.primeiro;
            this.primeiro = novo;
            return emp;
        }
    }

    public Empregado excluir(Integer chave) {
        No corrente = primeiro;
        No anterior = null;
        while (corrente.proximo != null && !((Empregado) corrente.conteudo).chave().equals(chave)) {
            anterior = corrente;
            corrente = corrente.proximo;
        }
        if (((Empregado) corrente.conteudo).chave().equals(chave))
            if (anterior != null)
                anterior.proximo = corrente.proximo;
            else
                primeiro = corrente.proximo;

        return (Empregado) corrente.conteudo;
    }

    public Empregado buscar(Integer chave) {
        No corrente = primeiro;
        while (corrente.proximo != null && !((Empregado) corrente.conteudo).chave().equals(chave))
            corrente = corrente.proximo;
        if (((Empregado) corrente.conteudo).chave().equals(chave))
            return (Empregado) corrente.conteudo;
        return null;
    }

}
