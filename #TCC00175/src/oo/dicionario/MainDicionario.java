package oo.dicionario;

import java.util.Scanner;

public class MainDicionario {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Dicionario dic = new Dicionario();
        String[] segmentos;

        do {
            System.out.println("Entre comando >>");
            String entrada = in.nextLine();
            segmentos = entrada.split(">>");
            if (segmentos[0].equals("excluir")) {
                dic.excluir(segmentos[1]);
                System.out.println("excluido");
            } else if (segmentos.length < 2)
                System.out.println(dic.consultar(segmentos[0]));
            else {
                dic.incluir(segmentos[0], segmentos[1]);
                System.out.println("ok");
            }
        } while (!segmentos[0].equals("sair"));
    }
}
