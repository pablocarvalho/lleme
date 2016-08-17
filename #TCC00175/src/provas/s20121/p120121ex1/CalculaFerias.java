package provas.s20121.p120121ex1;

import java.util.Calendar;
import java.util.Date;

public class CalculaFerias extends Visitante {

    @Override
    public void visitAdministrativo(Administrativo adm) {
        long milisegundosEmUmAno = 1000l * 60l * 60l * 24l * 365l;
        long agora = Calendar.getInstance().getTime().getTime();
        adm.ferias = new Date();
        long anosCompletos = (agora - adm.admissao.getTime()) / milisegundosEmUmAno;
        adm.ferias.setTime(adm.admissao.getTime() + (anosCompletos + 1) * milisegundosEmUmAno);
    }

    @Override
    public void visitVendedor(Vendedor vend) {
        long milisegundosEmUmSemestre = 1000l * 60l * 60l * 24l * 30l * 6l;
        long agora = Calendar.getInstance().getTime().getTime();
        vend.ferias = new Date();
        long semestresCompletos = (agora - vend.admissao.getTime()) / milisegundosEmUmSemestre;
        vend.ferias.setTime(vend.admissao.getTime() + (semestresCompletos + 1) * milisegundosEmUmSemestre);
    }
}
