package provas.s20121.p120121ex1;

public class CalculaSalario extends Visitante {

    @Override
    public void visitAdministrativo(Administrativo adm) {
        adm.salario = adm.cargaHoraria * 1;
    }

    @Override
    public void visitVendedor(Vendedor vend) {
        vend.salario = vend.cargaHoraria * 2;
    }
}
