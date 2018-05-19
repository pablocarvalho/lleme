package uff.ic.lleme.tic10002.aulas.poo;

import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CalcularSalario {

    static class Empregado {

        int matricula;
        String nome;
        double salario;
        int dependentes;
        String departamento;
    }

    static class Departamento {

        String sigla;
        String nome;
        double participacao;
    }

    static String SAMPLE_CSV_FILE_PATH_1 = "./dat/Empregados.csv";
    static String SAMPLE_CSV_FILE_PATH_2 = "./dat/Departamentos.csv";

    public static void main(String[] args) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH_1));
                CSVReader csvReader = new CSVReader(reader, ';', '"', 1);) {

            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {

                Empregado emp = new Empregado();
                emp.matricula = Integer.parseInt(nextRecord[0]);
                emp.nome = nextRecord[1];
                emp.salario = Double.parseDouble(nextRecord[2]);
                emp.dependentes = Integer.parseInt(nextRecord[3]);
                emp.departamento = nextRecord[4];

                Departamento depto = null;
                try (Reader reader2 = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH_2));
                        CSVReader csvReader2 = new CSVReader(reader2, ';', '"', 1);) {

                    String[] nextRecord2;
                    while ((nextRecord2 = csvReader2.readNext()) != null) {

                        depto = new Departamento();
                        depto.sigla = nextRecord2[0];
                        depto.nome = nextRecord2[1];
                        depto.participacao = Double.parseDouble(nextRecord2[2]);
                        if (depto.sigla.equals(emp.departamento))
                            break;
                        else
                            depto = null;

                    }
                }

                System.out.println(emp.nome + " " + emp.salario * (1 + emp.dependentes * 0.005 + depto.participacao));

            }
        }
    }
}
