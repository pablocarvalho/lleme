package patterns.factoryMethod.app1;

import java.util.LinkedList;
import java.util.Queue;
import patterns.command.framework.Command;
import patterns.command.framework.Pessoa;

public abstract class AppFwk {

    private Queue<Command> commands = new LinkedList<Command>();
    public Command opcao1 = null;
    public Command opcao2 = null;
    public Command opcao3 = null;

    // Factory Method
    public abstract Pessoa createPessoa();

    // Utilização do Factory Method
    public void imprimeNascimento() {
        Pessoa p = createPessoa();
        System.out.println(p.nascimento);
    }

    public void acionarOpcao1() throws CloneNotSupportedException {
        opcao1.execute();
        commands.add((Command) opcao1.clone());
    }

    public void acionarOpcao2() throws CloneNotSupportedException {
        opcao2.execute();
        commands.add((Command) opcao2.clone());
    }

    public void acionarOpcao3() throws CloneNotSupportedException {
        opcao3.execute();
        commands.add((Command) opcao3.clone());
    }

    public void desfazer() {
        commands.poll().desfazer();
    }
}
