package uff.ic.lleme.ttic10002.poo;

public class Main {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Luiz", 123, "endereco");
        Pessoa p2 = new Pessoa();
        p1.cpf = 123456;
        p1.nome = "Luiz";
        p1.metodo1();
        Reserva r1 = new Reserva();
        r1.dono = p1;
        p1.incluirReserva(r1);
        System.out.println(r1.dono.nome);
        r1.dono.metodo1();

        Hospede h1 = new Hospede();
        h1.nome = "Luiz";
        h1.incluirReserva(r1);
        h1.getReservas();

        Pessoa2 p = new HPJ();

        PF p3;
        if (p instanceof PF)
            p3 = (PF) p;

    }
}
