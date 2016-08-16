package aulas.colecoes;

import aulas.polimorfismo.listbox.Aluno;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class Main2 {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Luiz");
        Set<Aluno> s = new HashSet();
        s.add(aluno1);

        for (Aluno a : s)
            System.out.println("faz alguma coisa");

        List<Aluno> l = new ArrayList();
        l.add(aluno1);
        for (Aluno a : l)
            System.out.println("faz alguma coisa");

        Queue<Aluno> q = new ArrayDeque<>();
        while (!q.isEmpty())
            q.poll();

        Map<Integer, Aluno> m = new TreeMap();
        m.get(345);
        for (Integer n : m.keySet())
            m.get(n);

        for (Map.Entry<Integer, Aluno> entry : m.entrySet())
            entry.getValue();

    }
}
