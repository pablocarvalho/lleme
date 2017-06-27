package uff.ic.lleme.tic10002.trabalhos.s20171.gabrielalves;

public class TrabalhoEDA {

    public static void main(String[] args) {
        Venda v1 = new Venda("01", "201703", "0001", "37");
        Venda v2 = new Venda("07", "201611", "0013", "08");
        Venda v3 = new Venda("02", "201704", "0002", "61");
        Venda v4 = new Venda("10", "201701", "0007", "75");
        Venda v5 = new Venda("04", "201610", "0010", "28");
        Venda v6 = new Venda("11", "201612", "0001", "41");
        Venda v7 = new Venda("17", "201702", "0021", "33");
        Venda v8 = new Venda("18", "201705", "0009", "14");
        Venda v9 = new Venda("01", "201607", "0004", "59");
        Venda v10 = new Venda("01", "201608", "0015", "08");

        Arvore avlF = new Arvore();
        Arvore avlD = new Arvore();

        avlF.inserir(v1, 1);
        avlF.inserir(v2, 1);
        avlF.inserir(v3, 1);
        avlF.inserir(v4, 1);
        avlF.inserir(v5, 1);
        avlF.inserir(v6, 1);
        avlF.inserir(v7, 1);
        avlF.inserir(v8, 1);
        avlF.inserir(v9, 1);
        avlF.inserir(v10, 1);

        avlD.inserir(v1, 2);
        avlD.inserir(v2, 2);
        avlD.inserir(v3, 2);
        avlD.inserir(v4, 2);
        avlD.inserir(v5, 2);
        avlD.inserir(v6, 2);
        avlD.inserir(v7, 2);
        avlD.inserir(v8, 2);
        avlD.inserir(v9, 2);
        avlD.inserir(v10, 2);

        //chama a função calculaSoma, passando o intervalo de filiais
        double soma = avlF.calculaSoma(avlF.raiz, 1, 10);
        System.out.println("A soma entre o intervalo de filiais fornecido é: " + soma);

        //chama a função calculaSoma, passando o intervalo de datas
        soma = avlD.calculaSoma(avlD.raiz, 201601, 201705);
        System.out.println("A soma entre o intervalo de datas fornecido é: " + soma);

        //chama a função calculaSoma, passando o intervalo de filiais e o intervalo de datas
        soma = avlD.calculaSoma(avlD.raiz, 1, 10, 201611, 201703);
        System.out.println("A soma entre o intervalo de filiais e datas fornecido é: " + soma);
    }
}
