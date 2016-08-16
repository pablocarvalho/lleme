package aulas.heranca.exemplos.pessoa;

import aulas.heranca.exemplos.pessoa.Aluno;
import aulas.heranca.exemplos.pessoa.Pessoa;
import aulas.heranca.exemplos.pessoa.Professor;
import aulas.heranca.exemplos.pessoa.Pesquisador;

public class Main {

    public Main() {
        super();
        Professor prof = new Professor();
        Integer inteiro = new Integer(10);
        Pesquisador pesq = prof;
        System.out.println(pesq.metodo());
        Object obj = prof;
        pesq = (Pesquisador) obj;
        Pessoa pess = new Aluno();

    }
}
