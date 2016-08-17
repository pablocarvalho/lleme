package provas.s20152.vr20152;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Sistema {

    private static Map<String, Disciplina> disciplinas = new HashMap<>();
    private static Map<String, Aluno> alunos = new HashMap<>();

    public static Aluno cadastrarAluno(String matricula, String nome) {
        Aluno a;
        if (!alunos.containsKey(matricula)) {
            a = new Aluno(matricula, nome);
            alunos.put(matricula, a);
        } else {
            a = alunos.get(matricula);
            System.out.println("Disciplina já cadastrada.");
        }
        return a;
    }

    public static Disciplina criarDisciplina(String codigo, String nome) {
        Disciplina d;
        if (!disciplinas.containsKey(codigo)) {
            d = new Disciplina(codigo, nome);
            disciplinas.put(codigo, d);
        } else {
            d = disciplinas.get(codigo);
            System.out.println("Disciplina já cadastrada.");
        }
        return d;
    }

    static Turma criarTurma(String a120152, Disciplina d1) {
        return d1.criarTurma(a120152);
    }

    static void inscreverAluno(Aluno aluno, Turma t1) {
        t1.inscreverAluno(aluno);
    }

    public static void capturarNotas(String turma, Disciplina d1) {
        Turma t = d1.getTurma(turma);
        if (t == null)
            System.out.println("Turma inexistente");
        else {
            Scanner sc = new Scanner(System.in);
            Map<String, Aluno> inscritos = t.listAlunos();
            for (Entry<String, Aluno> e : inscritos.entrySet()) {
                Aluno a = e.getValue();
                System.out.println("P1 de " + a.nome);
                float p1 = sc.nextFloat();
                System.out.println("P2 de " + a.nome);
                float p2 = sc.nextFloat();
                t.incluirNotas(p1, p2, a);
            }
        }
    }

    public static void listarSituacao() {
        for (Entry<String, Disciplina> d : disciplinas.entrySet()) {
            System.out.println(d.getValue().name);
            for (Entry<String, Turma> t : d.getValue().turmas.entrySet()) {
                System.out.println(t.getValue().codigo);
                for (Entry<String, Notas> n : t.getValue().notas.entrySet()) {
                    Notas notas = n.getValue();
                    System.out.println(notas.aluno.nome + " situação: " + notas.situacao());
                }
            }
        }
    }

    public static void gravar(String filename) {
        try (OutputStream out = new FileOutputStream(filename, false);
            ObjectOutputStream s = new ObjectOutputStream(out)) {
            s.writeObject(disciplinas);
            s.writeObject(alunos);
            s.flush();
        } catch (Exception e) {
        }
    }

    public static void carregar(String filename) {
        try {
            InputStream in = new FileInputStream(filename);
            ObjectInputStream s = new ObjectInputStream(in);
            disciplinas = (Map<String, Disciplina>) s.readObject();
            alunos = (Map<String, Aluno>) s.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.toString());
            disciplinas = new HashMap<>();
            alunos = new HashMap<>();
        }
    }

}
