package provas.s20121.p120121ex1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P120121Ex1 {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String admissaoStr = "15/07/2002";
        Date admissao = sdf.parse(admissaoStr);
        Administrativo adm = new Administrativo("Luiz", admissao, 8);

        admissaoStr = "15/07/2002";
        admissao = sdf.parse(admissaoStr);
        Vendedor vend = new Vendedor("André", admissao, 10);

        Departamento depto = new Departamento("Depto");
        depto.quadro.add(adm);
        depto.quadro.add(vend);

        Visitante visitante1 = new CalculaSalario();
        Visitante visitante2 = new CalculaFerias();

        depto.accpet(visitante1);
        depto.accpet(visitante2);

        for (Funcionario func : depto.quadro)
            System.out.println(func.salario + " " + func.ferias.toLocaleString());

    }
}
