package provas.s20121.p120121ex1;

import java.util.Date;

public class Vendedor extends Funcionario {

    public Vendedor(String nome, Date admissao, float cargaHoraria) {
        super(nome, admissao, cargaHoraria);
    }

    @Override
    public void accept(Visitante visitante) {
        visitante.visitVendedor(this);
    }
}
