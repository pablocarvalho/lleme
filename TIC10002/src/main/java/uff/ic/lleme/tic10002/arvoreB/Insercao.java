/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.arvoreB;

import uff.ic.lleme.tic10002.Empregado;

/**
 *
 * @author lapaesleme
 */
public class Insercao {

    public Empregado empregado = null;
    public ListaEntrada menores = null;
    public ListaEntrada maiores = null;

    public Insercao(Empregado empregado, ListaEntrada menores, ListaEntrada maiores) {
        this.empregado = empregado;
        this.menores = menores;
        this.maiores = maiores;
    }

}
