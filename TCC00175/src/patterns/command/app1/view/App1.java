package patterns.command.app1.view;

import patterns.command.app1.control.Engordar1Kg;
import patterns.command.app1.control.Emagrecer1Kg;
import patterns.command.app1.control.Engordar10Kg;
import patterns.command.framework.Pessoa;
import patterns.memento.app1.model.Paciente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import patterns.factoryMethod.app1.AppFwk;

public class App1 extends AppFwk {

    public Paciente paciente = null;

    public static void main(String[] args) throws ParseException, CloneNotSupportedException {
        App1 app = new App1();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String nascimentoStr = "30/04/1989";
        Date nascimento = sdf.parse(nascimentoStr);

        Paciente paciente1 = new Paciente("Paciente 1", 85.0f, 1.8f, nascimento, "123456789");
        app.opcao1 = new Emagrecer1Kg(paciente1);
        app.opcao2 = new Engordar1Kg(paciente1);
        app.opcao3 = new Engordar10Kg(paciente1);
        app.paciente = paciente1;

        // Utilização do Factory Method
        app.imprimeNascimento();

        System.out.println(paciente1.nome + " " + paciente1.peso);
        app.acionarOpcao3();
        System.out.println(paciente1.nome + " " + paciente1.peso);
        app.desfazer();
        System.out.println(paciente1.nome + " " + paciente1.peso);

        nascimentoStr = "17/10/1991";
        nascimento = sdf.parse(nascimentoStr);
        Paciente paciente2 = new Paciente("Paciente 2", 85.0f, 1.8f, nascimento, "987654321");
        app.opcao1 = new Emagrecer1Kg(paciente2);
        app.opcao2 = new Engordar1Kg(paciente2);
        app.opcao3 = new Engordar10Kg(paciente2);

        app.acionarOpcao2();
        System.out.println(paciente2.nome + " " + paciente2.peso);

    }

    @Override
    public Pessoa createPessoa() {
        return paciente;
    }
}
