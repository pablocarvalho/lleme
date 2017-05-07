package uff.ic.tcc00328.exercicios.letreiro.model.mostrador1;

import uff.ic.tcc00328.exercicios.letreiro.model.Caractere;

public class Fabrica extends uff.ic.tcc00328.exercicios.letreiro.model.Fabrica {

    @Override
    public Mostrador criarMostrador() {
        return new Mostrador();
    }

    @Override
    public Caractere obterCaractere(char caractere) {
        switch (caractere) {
            case 'A':
            case 'a':
                return A.obterInstancia();
            case 'E':
            case 'e':
                return E.obterInstancia();
            case 'I':
            case 'i':
                return I.obterInstancia();
            case 'U':
            case 'u':
                return U.obterInstancia();
            case 'D':
            case 'd':
                return D.obterInstancia();
            case 'L':
            case 'l':
                return L.obterInstancia();
            case 'N':
            case 'n':
                return N.obterInstancia();
            case 'R':
            case 'r':
                return R.obterInstancia();
            case 'Z':
            case 'z':
                return Z.obterInstancia();
            default:
                return Space.obterInstancia();
        }
    }
}
