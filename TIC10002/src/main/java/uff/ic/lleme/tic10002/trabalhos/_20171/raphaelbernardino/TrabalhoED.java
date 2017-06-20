package uff.ic.lleme.tic10002.trabalhos._20171.raphaelbernardino;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

/**
 * @author bernardino
 */
public class TrabalhoED {

    private static String gera_menu() {
        String o = "";
        o += "=== Trabalho de Estrutura de Dados - 2017.1 - Raphael Bernardino ===\n";
        o += "\n";
        o += "Escolha uma das consultas abaixo:\n";
        o += "    1. Consulta 1 (Exemplo: total de vendas das filiais com códigos entre 10 e 20)\n";
        o += "    2. Consulta 2 (Exemplo: total de vendas das filiais com códigos entre 10 e 20 nos meses de Jan/17 até Jun/17)\n";
        o += "    3. Consulta 3 (Exemplo: total de vendas de todas as filiais nos meses de Ago/17 até Out/17)\n";
        o += "    0. Sair\n";
        o += "[?] ";
        return o;
    }

    private static String[] le_arquivo(String filename) throws IOException {
        byte[] cbytes = Files.readAllBytes(Paths.get(filename));
        String c = new String(cbytes, StandardCharsets.UTF_8);
        return c.split("\n");
    }

    private static void monta_arvore(Arvore arv, String[] lines) {
        for (String line : lines) {
            String[] l = line.replaceAll(" ", "").split(",");
            if (l.length > 0) {
                Integer fid = Integer.parseInt(l[0]);
                String data = StringUtils.getInstance().mapeia_mes_ano(l[1]);
                Double valor = Double.parseDouble(l[3]);

                arv.incluir(fid, data, valor);
            }
        }
    }

    private static void insere_dados(Arvore a) {
        try {
            String[] linhas = le_arquivo("./exemplo.txt");
            monta_arvore(a, linhas);
        } catch (FileNotFoundException fnf) {
            System.err.println("[!] Arquivo de exemplo não encontrado!");
            System.exit(1);
        } catch (IOException io) {
            System.err.println("[!] Erro inesperado ocorreu: " + io.getMessage());
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        boolean continua = true;
        String menu = gera_menu();
        Scanner in = new Scanner(System.in);

        Arvore a = new Arvore();
        insere_dados(a);

        while (continua) {
            System.out.print(menu);
            int opcao = in.nextInt();
            Integer c1, c2;
            String d1, d2;

            switch (opcao) {
                case 0:
                    continua = false;
                    break;
                case 1:
                    System.out.print("[?] Código inicial: ");
                    c1 = in.nextInt();
                    System.out.print("[?] Código final  : ");
                    c2 = in.nextInt();
                    System.out.println("[+] Consulta 1 = " + a.consulta1(c1, c2) + "\n");
                    break;
                case 2:
                    System.out.print("[?] Código inicial: ");
                    c1 = in.nextInt();
                    System.out.print("[?] Código final  : ");
                    c2 = in.nextInt();
                    System.out.print("[?] Data inicial  : ");
                    d1 = StringUtils.getInstance().mapeia_mes_ano(in.next());
                    System.out.print("[?] Data final    : ");
                    d2 = StringUtils.getInstance().mapeia_mes_ano(in.next());
                    System.out.println("[+] Consulta 2 = " + a.consulta2(c1, c2, d1, d2) + "\n");
                    break;
                case 3:
                    System.out.print("[?] Data inicial  : ");
                    d1 = StringUtils.getInstance().mapeia_mes_ano(in.next());
                    System.out.print("[?] Data final    : ");
                    d2 = StringUtils.getInstance().mapeia_mes_ano(in.next());
                    System.out.println("[+] Consulta 2 = " + a.consulta3(d1, d2) + "\n");
                    break;
                default:
                    System.err.println("[!] Opção inválida! Verifique a opção e tente novamente.");
                    break;
            }
        }

        System.exit(0);
    }
}
