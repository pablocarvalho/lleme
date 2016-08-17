package patterns.strategy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(0, "A");
        Pessoa p2 = new Pessoa(1, "C");
        Pessoa p3 = new Pessoa(1, "B");

        Pessoa[] pessoas = new Pessoa[3];
        pessoas[0] = p1;
        pessoas[1] = p2;
        pessoas[2] = p3;
        Arrays.sort(pessoas, new ComparaIdNome());

        for (Pessoa pessoa : pessoas)
            System.out.println(pessoa.nome);
    }
}
