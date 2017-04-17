package uff.ic.lleme.ttic10002.poo;

public class Pessoa {

    String nome = null;
    Integer cpf = null;
    String endereco = null;
    private Reserva[] reservas = null;

    Pessoa() {
        nome = null;
        cpf = null;
        endereco = null;
    }

    Pessoa(String nome, Integer cpf, String endereco, int tamanho) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        reservas = new Reserva[tamanho];
    }

    void incluirReserva(Reserva r) {
        reservas[0] = r;
    }

    Reserva[] getReservas() {
        return reservas;
    }

    void metodo1(int v1) {

    }

    void metodo1(int v1, int v2) {

    }

}
