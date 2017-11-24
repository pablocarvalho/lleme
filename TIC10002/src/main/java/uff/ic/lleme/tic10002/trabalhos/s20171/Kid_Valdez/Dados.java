/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.Kid_Valdez;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Dados {

    private List<String> line;
    private AVLTree arvoreFial = new AVLTree();
    private AVLTree arvoreDate = new AVLTree();

    public AVLTree getArvoreFial() {
        return arvoreFial;
    }

    public AVLTree getArvoreDate() {
        return arvoreDate;
    }

    public void readAndLoadFile(String path) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(path);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            int n = 0;
            while ((linea = br.readLine()) != null) {
                if (n > 0) {
                    Vendas nuevo = separaDados(linea);
                    arvoreFial.insertFilial(nuevo); // add to tree for Filial
                    arvoreDate.insertDate(nuevo);   // add to tree for Date
                }
                n++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr)
                    fr.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static Vendas separaDados(String linea) throws ParseException {
        String dadoslinea[] = linea.split("\t");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Vendas nuevo = new Vendas(Integer.parseInt(dadoslinea[0]), formatter.parse(dadoslinea[1]), dadoslinea[2], Double.parseDouble(dadoslinea[3]));
        return nuevo;
    }
}
