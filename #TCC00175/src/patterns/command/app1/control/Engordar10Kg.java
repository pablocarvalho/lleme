package patterns.command.app1.control;

import patterns.memento.app1.model.Paciente;
import patterns.command.framework.MacroCommand;

public class Engordar10Kg extends MacroCommand {

    public Engordar10Kg(Paciente pessoa) {
        for (int i = 0; i < 10; i++)
            commands.add(new Engordar1Kg(pessoa));
    }
}
