package exercicios.letreiro.model;

public abstract class Fabrica {

    public abstract Mostrador criarMostrador();

    public abstract Caractere obterCaractere(char caractere);
}
