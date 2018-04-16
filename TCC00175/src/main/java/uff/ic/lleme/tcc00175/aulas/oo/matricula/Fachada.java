package uff.ic.lleme.tcc00175.aulas.oo.matricula;

public class Fachada {

    public static boolean validarUsuario(int matricula, String senha) {
        Aluno aluno = new Aluno(matricula);
        return aluno.validarCredenciais(senha);
    }
}
