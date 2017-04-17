package uff.ic.lleme.ttic10002.lista;

import uff.ic.lleme.ttic10002.Empregado;

public class ListaDinamicaEmpregado {

    private No primeiro = null;

    public void incluir(Empregado emp) {
        if (primeiro == null)
            primeiro = new No(emp);
        else {
            No novo = new No(emp);
            novo.proximo = this.primeiro;
            this.primeiro = novo;
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
