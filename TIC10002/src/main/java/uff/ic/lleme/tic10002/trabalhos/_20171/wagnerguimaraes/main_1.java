/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.wagnerguimaraes;

import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author Thiago
 */
public class main_1 {

    public static void main(String[] args) throws ParseException, IOException {
        ArvoreB b = new ArvoreB(4);

        b.insere(2);
        b.insere(3);
        b.insere(5);
        b.insere(1);
        b.insere(10);
        b.insere(6);
        b.insere(8);
        b.insere(22);
        b.insere(33);
        b.insere(14);
        b.insere(12);
        b.insere(21);
        b.insere(31);

        b.dis(b.getRaiz(), b.getOrdem());

    }

}
