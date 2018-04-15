package uff.ic.lleme.tcc00175.patterns.command.app1.control;

import uff.ic.lleme.tcc00175.patterns.command.framework.Command;
import uff.ic.lleme.tcc00175.patterns.memento.app1.model.Paciente;

public class Emagrecer1Kg extends Command {

    public Paciente paciente;
    private Paciente.MementoPaciente mm;

    public Emagrecer1Kg(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public void execute() {
        mm = paciente.createMemento();
        paciente.peso--;
    }

    @Override
    public void desfazer() {
        paciente.setMemento(mm);
    }
}
