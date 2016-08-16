package oo.disciplina;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainDisciplina {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Disciplina disciplina = new Disciplina("arq1.txt", "arq2.txt");
        float media;
        for (int i = 0; i < 10; i++)
            disciplina.media(i);

    }
}
