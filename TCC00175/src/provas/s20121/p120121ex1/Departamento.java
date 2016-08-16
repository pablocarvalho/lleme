package provas.s20121.p120121ex1;

import java.util.ArrayList;
import java.util.List;

public class Departamento {

    public String nome;
    public List<Funcionario> quadro = new ArrayList<>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    public void accpet(Visitante visitante) {
        for (Funcionario func : quadro)
            func.accept(visitante);
    }
}
