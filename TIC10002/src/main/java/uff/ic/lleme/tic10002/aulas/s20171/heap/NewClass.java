/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.aulas.s20171.heap;

/**
 *
 * @author lapaesleme
 */
public class NewClass {

    public static void main(String[] args) {
        for (int i = 0; i < 32; i++)
            System.out.println("" + i + "-" + (((int) (Math.log(i + 1) / Math.log(2))) + 1));
    }
}
