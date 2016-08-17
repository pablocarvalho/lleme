package patterns.command.app1.control;

import patterns.memento.app1.model.Paciente;
import patterns.command.framework.Command;

public class Engordar1Kg extends Command {

    public Paciente paciente;
    private Paciente.MementoPaciente mm;

    public Engordar1Kg(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public void execute() {
        mm = paciente.createMemento();
        paciente.peso++;
    }

    @Override
    public void desfazer() {
        paciente.setMemento(mm);
    }
}
