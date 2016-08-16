package provas.s20141.p120141;

public class Main {

    public static void main(String[] args) {
        Matriz<Aluno> m = new Matriz<>();
        Aluno aluno1 = new Aluno(2);
        Aluno aluno2 = new Aluno(9);

        m.set(3, 4, aluno1);
        m.set(6, 40, aluno1);
        System.out.println(m.linhas());
        System.out.println(m.colunas());
        System.out.println(m.get(500, 70));

        m.salvar("m.dat");

        Matriz<Aluno> modelo = new Matriz<>();
        Matriz<Aluno> m2 = Matriz.carregar("m.dat", modelo);
        System.out.println(m2.get(3, 4).matricula);

        //MatrizEscalar m = new MatrizEscalar<MyDouble>();
    }
}
