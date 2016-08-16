
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sorteio {

    public static void main(String[] args) {

        String fAlunos = "./dat/Alunos.txt";
        String fAlunosTemp = "./dat/AlunosTemp.txt";
        String fSorteados = "./dat/Sorteados.txt";
        Scanner in = new Scanner(System.in);
        boolean presente = true;
        do {
            int sorteio = (int) (Math.random() * contAlunos(fAlunos) + 1);
            String nome = encontraAluno(sorteio, fAlunos);
            if (nome == null) {

                inverteArquivos(fAlunos, fSorteados);
                sorteio = (int) (Math.random() * contAlunos(fAlunos) + 1);
                nome = encontraAluno(sorteio, fAlunos);
            }
            System.out.println(nome);
            System.out.println("O aluno está presente? ");
            presente = in.nextBoolean();
            if (presente == true) {
                registraSorteado(sorteio, fAlunos, fAlunosTemp, fSorteados);
            }
        } while (!presente);
    }

    public static void inverteArquivos(String nome, String nome2) {
        File fNome = new File(nome);
        File fNome2 = new File(nome2);
        fNome.delete();
        fNome2.renameTo(fNome);

    }

    public static void registraSorteado(int indice, String alunos, String alunosTemp, String sorteados) {
        try (OutputStream output = new FileOutputStream(alunosTemp, false);
                OutputStreamWriter writer = new OutputStreamWriter(output);
                BufferedWriter bw = new BufferedWriter(writer);
                OutputStream output2 = new FileOutputStream(sorteados, true);
                OutputStreamWriter writer2 = new OutputStreamWriter(output2);
                BufferedWriter bwSorteados = new BufferedWriter(writer2);
                InputStream input = new FileInputStream(alunos)) {

            int contador;
            String linha;
            Scanner in = new Scanner(input);
            contador = 1;
            while (in.hasNext()) {
                linha = in.nextLine();
                if (contador == indice) {
                    bwSorteados.write(linha + "\n");
                } else {
                    bw.write(linha + "\n");
                }
                contador++;
            }
            bw.flush();
            bwSorteados.flush();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sorteio.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sorteio.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        File fAlunosTemp = new File(alunosTemp);
        File fAlunos = new File(alunos);
        fAlunos.delete();
        fAlunosTemp.renameTo(fAlunos);
    }

    public static String encontraAluno(int n, String arquivo) {
        String retorno = null;
        try (InputStream input = new FileInputStream(arquivo)) {
            Scanner in = new Scanner(input);
            int indice, matricula, contador;
            String nome = null;

            contador = 1;
            while (in.hasNext()) {
                indice = in.nextInt();
                matricula = in.nextInt();
                nome = in.nextLine();
                if (contador == n) {
                    retorno = nome;
                }
                contador++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Sorteio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public static int contAlunos(String arquivo) {

        int contador = 0;
        try (InputStream input = new FileInputStream(arquivo)) {
            Scanner in = new Scanner(input);
            while (in.hasNext()) {
                contador++;
                in.nextLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Sorteio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contador;
    }
}
