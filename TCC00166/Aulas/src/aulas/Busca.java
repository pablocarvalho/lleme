package aulas;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Scanner;

public class Busca {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //criarArquivo(100000000);
        //indexarArquivo();
        double inicio, fim;
        inicio = Calendar.getInstance().getTimeInMillis();
        System.out.println("Nome do aluno: " + busca(9999999));
        fim = Calendar.getInstance().getTimeInMillis();
        System.out.println("Duração: " + (fim - inicio) / 1000 + " milisegundos");
        inicio = Calendar.getInstance().getTimeInMillis();
        System.out.println("Nome do aluno: " + buscaIndexada(9999999));
        fim = Calendar.getInstance().getTimeInMillis();
        System.out.println("Duração: " + (fim - inicio) / 1000 + " milisegundos");
    }

    public static String busca(long matriculaInformada) throws FileNotFoundException, IOException {
        String nome = null;
        long matricula;
        boolean achou = false;
        try (InputStream input = new FileInputStream("./dat/alunos.txt");
                Scanner in = new Scanner(input)) {
            while (in.hasNext() && !achou) {
                matricula = in.nextLong();
                if (matricula == matriculaInformada) {
                    nome = in.nextLine();
                    achou = true;
                } else
                    in.nextLine();
            }
        }
        return nome;
    }

    public static String buscaIndexada(long matriculaInformada) throws FileNotFoundException, IOException {
        String nome = null;
        long matricula = 0;
        boolean achou = false;
        try (FileInputStream input = new FileInputStream("./dat/alunos.txt");) {
            long inicio = getInicio(matriculaInformada);
            if (inicio >= 0) {
                System.out.println(input.getChannel().position());
                input.getChannel().position(inicio + 1);
                Scanner in = new Scanner(input);
                if (in.hasNext())
                    in.nextLine();
                while (in.hasNext() && !achou) {
                    matricula = in.nextLong();
                    if (matricula == matriculaInformada) {
                        nome = in.nextLine();
                        achou = true;
                    } else
                        in.nextLine();
                }
            }
        }
        return nome;
    }

    public static void indexarArquivo() throws FileNotFoundException, IOException {
        long pos = 0, matricula = 0;
        String linha = "";
        try (OutputStream output = new FileOutputStream("./dat/indice.txt", false);
                BufferedOutputStream writer = new BufferedOutputStream(output);
                DataOutputStream bw = new DataOutputStream(writer)) {
            try (FileInputStream input = new FileInputStream("./dat/alunos.txt");
                    Scanner in = new Scanner(input);) {
                while (in.hasNext()) {
                    pos = input.getChannel().position() - 8192;
                    linha = in.nextLine();
                    Scanner in2 = new Scanner(linha);
                    matricula = in2.nextLong();
                    bw.writeLong(matricula);
                    bw.writeLong(pos);
                    if (in.hasNext())
                        in.nextLine();
                }
            }
            bw.flush();
        }
    }

    public static void criarArquivo(int qtd) throws FileNotFoundException, IOException {
        try (OutputStream output = new FileOutputStream("./dat/alunos.txt", false);
                OutputStreamWriter writer = new OutputStreamWriter(output);
                BufferedWriter bw = new BufferedWriter(writer)) {
            for (long i = 1; i <= qtd; i++)
                bw.write(i + " Nome do aluno " + i + " Endereco do Aluno " + i + "\r\n");
            bw.flush();
        }
    }

    private static long getInicio(long matriculaInformada) throws FileNotFoundException, IOException {
        long posicao = -1, temp = 0, temp2 = 0;
        boolean achou = false;
        try (InputStream input = new FileInputStream("./dat/indice.txt");
                DataInputStream in = new DataInputStream(new BufferedInputStream(input));) {
            try {
                while (!achou) {
                    temp = in.readLong();
                    if (temp == matriculaInformada) {
                        posicao = in.readLong();
                        achou = true;
                    } else
                        temp2 = in.readLong();
                }
            } catch (EOFException e) {
            }
        }
        return posicao;
    }
}
