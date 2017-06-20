package uff.ic.lleme.tic10002.trabalhos._20171.emanuelmachado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Vendas {

    private ArvoreVenda arvore = null;
    private HashVenda hash = null;

    Vendas() {
        carregar();
    }

    private void carregar() {      
        try {

            FileReader arquivo = new FileReader(getClass().getResource("/T1_20171_emanuel/carregar.txt").getFile());
            BufferedReader buffer = new BufferedReader(arquivo);

            buffer.readLine();
            String linha;

            arvore = new ArvoreVenda();
            hash = new HashVenda();
            
            // Linha
            while ((linha = buffer.readLine()) != null) {

                String[] celula = linha.split(" ; ");

                //Instancia uma venda
                Venda novaVenda = new Venda(Integer.parseInt(celula[0]), celula[1], Integer.parseInt(celula[2]), Double.parseDouble(celula[3]));

                //Inclui a venda na AVL para busca por intervalos
                arvore.incluir(novaVenda);

                //Inclui a venda na tabela Hash
                hash.incluir(novaVenda);
            }
        } catch (java.io.FileNotFoundException el) {
            System.out.println("Arquivo não Encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public double totalVenda(String data_inicial, String data_final) {
        return arvore.totalVendas(data_inicial, data_final);
    }

    public double totalVenda(int filial1, int filial2) {
        return hash.totalVendas(filial1, filial2);
    }

    public double totalVenda(int filial1, int filial2, String data_inicial, String data_final) {
        return hash.totalVendas(filial1, filial2, data_inicial, data_final);
    }
        
}
 