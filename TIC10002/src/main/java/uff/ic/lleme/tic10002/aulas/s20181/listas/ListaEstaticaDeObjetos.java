package uff.ic.lleme.tic10002.aulas.s20181.listas;

import uff.ic.lleme.tic10002.aulas.s20181.Objeto;

public class ListaEstaticaDeObjetos implements Lista {

    private Objeto[] lista = new Objeto[100];
    private int n = 0;

    @Override
    public Objeto busca(int chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Objeto[] busca(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Objeto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
