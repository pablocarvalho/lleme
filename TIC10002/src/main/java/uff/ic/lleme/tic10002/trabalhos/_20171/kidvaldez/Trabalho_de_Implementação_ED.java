package uff.ic.lleme.tic10002.trabalhos._20171.kidvaldez;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Trabalho_de_Implementação_ED {

    public static void main(String[] args) throws ParseException {
        // Usando consola, com entradas estaticas
        Consola();
        //Usando interfaz, com entradas dinamicas
        Principal2 p2 = new Principal2();
        p2.show();

    }

    public static void Consola() throws ParseException {
        System.out.println("------------SISTEMAS DE CONSULTAS DE VENDAS (ESTATICO)---------------");
        Dados d = new Dados();
        String path = "vendas2.txt";
        // Lemos e carregamos os dados
        d.readAndLoadFile(path);
        // Obtendo os arboles
        AVLTree arFial = d.getArvoreFial();
        AVLTree arDate = d.getArvoreDate();
        // Para guardar os dados da consulta feita
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        List<Vendas> resultFial = new ArrayList<>(); //só para mostrar dados
        List<Vendas> resultDate = new ArrayList<>(); //só para mostrar dados

        // Consulta 1
        System.out.println("CONSULTA 1: Vendas das filiais com códigos entre 10 e 20:");
        resultFial = arFial.consultaFilial(10, 20); // consulta FILIAL em arvore
        for (int j = 0; j < resultFial.size(); j++)
            System.out.println((j + 1) + " ) " + resultFial.get(j).codFial + " " + formatter.format(resultFial.get(j).fecha) + " " + resultFial.get(j).cod_vendedor + " " + resultFial.get(j).total);
        System.out.println("     TOTAL DE VENTAS:  " + arFial.getSumaVendas());
        System.out.println("---------------------------------------------------------");

        // Consulta 2
        System.out.println("CONSULTA 2: Vendas de todas as filiais nos meses de 17/06/2017 até 17/07/2017:");
        resultDate = arDate.consultaDate(formatter.parse("17/06/2017"), formatter.parse("17/07/2017")); // Consulta Data
        for (int j = 0; j < resultDate.size(); j++)
            System.out.println((j + 1) + " ) " + " " + resultDate.get(j).codFial + " " + formatter.format(resultDate.get(j).fecha) + " " + resultDate.get(j).cod_vendedor + " " + resultDate.get(j).total);
        System.out.println("     TOTAL DE VENTAS:   " + arDate.getSumaVendas());
        System.out.println("---------------------------------------------------------");

        // Consulta 3
        // Para a operação de interseção de conjuntos uso-se o hashJoin,
        // já que resulto ser eficiente, considerando que se tem que ter já as duas consultas já feitas, como são a de Filiais e de lhes data.
        System.out.println("CONSULTA 3: Vendas das filiais com códigos entre 10 e 20 nos meses de 17/06/2017 até 17/07/2017:");
        HashJoin hj = new HashJoin();
        double suma = 0;
        List<Vendas> resultadosQuery = hj.hashJoin(resultFial, resultDate);
        for (int j = 0; j < resultadosQuery.size(); j++) {
            System.out.println((j + 1) + " ) " + " " + resultadosQuery.get(j).codFial + " " + formatter.format(resultadosQuery.get(j).fecha) + " " + resultadosQuery.get(j).cod_vendedor + " " + resultadosQuery.get(j).total);
            suma = suma + resultadosQuery.get(j).total;
        }
        System.out.println("     TOTAL DE VENTAS:   " + suma);
    }

}
