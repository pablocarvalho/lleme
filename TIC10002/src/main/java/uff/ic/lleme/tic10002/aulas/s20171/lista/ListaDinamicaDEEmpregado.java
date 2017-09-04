package uff.ic.lleme.tic10002.aulas.s20171.lista;

import uff.ic.lleme.tic10002.aulas.s20171.Empregado;

public class ListaDinamicaDEEmpregado {

    private No primeiro = null;
    private No ultimo = null;
    private No corrente = null;

    private class No {

        public Object conteudo = null;
        public No atras = null;
        public No frente = null;

        public No(Empregado emp) {
            conteudo = emp;
        }

    }

    public void incluir(Empregado emp) {
        if (primeiro == null) {
            No no = new No(emp);
            primeiro = no;
            ultimo = no;
        } else {
            No novo = new No(emp);
            ultimo.atras = novo;
            novo.frente = ultimo;
            ultimo = novo;
        }
    }

    public Empregado excluir(String chave) {
        if (corrente == null)
            corrente = primeiro;
        No anterior = null;
        while (corrente.atras != null && !((Empregado) corrente.conteudo).cpf.equals(chave))
            corrente = corrente.atras;
        if (((Empregado) corrente.conteudo).cpf.equals(chave)) {
            if (corrente.frente != null) {
                No F = corrente.frente;
                No A = corrente.atras;
                F.atras = A;
                A.frente = F;
            } else {
                No F = null;
                No A = corrente.atras;
                A.frente = F;
                primeiro = A;
            }
            if (corrente == ultimo) {
                ultimo = corrente.frente;
                ultimo.atras = null;
            }
        }

        return (Empregado) corrente.conteudo;
    }

    public Empregado buscar(String chave) {
        No corrente = primeiro;
        while (corrente.atras != null && !((Empregado) corrente.conteudo).cpf.equals(chave))
            corrente = corrente.atras;
        if (((Empregado) corrente.conteudo).cpf.equals(chave))
            return (Empregado) corrente.conteudo;
        return null;
    }
}
