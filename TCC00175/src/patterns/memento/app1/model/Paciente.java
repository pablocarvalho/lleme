package patterns.memento.app1.model;

import patterns.command.framework.Pessoa;
import java.util.Date;

public class Paciente extends Pessoa {

    public class MementoPaciente extends MementoPessoa {

        private String id;

        protected MementoPaciente(String id, String nome, float peso, float altura, Date nascimento) {
            super(nome, peso, altura, nascimento);
            this.id = id;
        }
    }
    public String id;

    public Paciente(String nome, float peso, float altura, Date nascimento, String id) {
        super(nome, peso, altura, nascimento);
        this.id = id;
    }

    public MementoPaciente createMemento() {
        return new MementoPaciente(id, nome, peso, altura, nascimento);
    }

    public void setMemento(MementoPaciente mp) {
        super.setMemento(mp);
        this.id = mp.id;
    }
}
