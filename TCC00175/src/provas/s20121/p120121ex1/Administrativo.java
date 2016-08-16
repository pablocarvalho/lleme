package provas.s20121.p120121ex1;

import java.util.Date;

public class Administrativo extends Funcionario {

    public Administrativo(String nome, Date admissao, float cargaHoraria) {
        super(nome, admissao, cargaHoraria);
    }

    @Override
    public void accept(Visitante visitante) {
        visitante.visitAdministrativo(this);
    }
}
