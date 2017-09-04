package uff.ic.lleme.tic10002.aulas.s20171.lista;

import uff.ic.lleme.tic10002.aulas.s20171.ColecaoEmpregado;
import uff.ic.lleme.tic10002.aulas.s20171.Empregado;

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

    public Empregado excluir(String chave) {
        No corrente = primeiro;
        No anterior = null;
        while (corrente.proximo != null && !((Empregado) corrente.conteudo).cpf.equals(chave)) {
            anterior = corrente;
            corrente = corrente.proximo;
        }
        if (((Empregado) corrente.conteudo).cpf.equals(chave))
            if (anterior != null)
                anterior.proximo = corrente.proximo;
            else
                primeiro = corrente.proximo;

        return (Empregado) corrente.conteudo;
    }

    public Empregado buscar(String chave) {
        No corrente = primeiro;
        while (corrente.proximo != null && !((Empregado) corrente.conteudo).cpf.equals(chave))
            corrente = corrente.proximo;
        if (((Empregado) corrente.conteudo).cpf.equals(chave))
            return (Empregado) corrente.conteudo;
        return null;
    }

}
