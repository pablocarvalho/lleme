package uff.ic.lleme.tic10002.aulas._old.s20171.poo;

public class Pessoa {

    String nome = null;
    Integer cpf = null;
    String endereco = null;
    private Reserva[] reservas = null;

    public Pessoa() {
        nome = null;
        cpf = null;
        endereco = null;
    }

    public Pessoa(String nome, Integer cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        reservas = new Reserva[100];
    }

    public void incluirReserva(Reserva r) {
        reservas[0] = r;
    }

    public Reserva[] getReservas() {
        return reservas;
    }

    public void metodo1(int v1) {

    }

    public void metodo1(int v1, int v2) {

    }

    public void metodo1() {

    }

}
