package uff.ic.lleme.tic10002.trabalhos.s20171.Emerson_Souza;

public class Main {

    public static void main(String[] args) {
        Venda v1 = new Venda("01", "201703", "0001", "20");
        Venda v2 = new Venda("07", "201611", "0013", "80");
        Venda v3 = new Venda("10", "201705", "0009", "60");
        Venda v4 = new Venda("10", "201701", "0007", "45");
        Venda v5 = new Venda("04", "201610", "0010", "35");
        Venda v6 = new Venda("07", "201612", "0001", "90");
        Venda v7 = new Venda("15", "201703", "0021", "65");
        Venda v8 = new Venda("08", "201705", "0009", "50");
        Venda v9 = new Venda("07", "201707", "0001", "20");
        Venda v10 = new Venda("15", "201607", "0002", "10");

        Arvore arvorelFilial = new Arvore();
        Arvore arvoreData = new Arvore();

        arvorelFilial.inserir(v1, 1);
        arvorelFilial.inserir(v2, 1);
        arvorelFilial.inserir(v3, 1);
        arvorelFilial.inserir(v4, 1);
        arvorelFilial.inserir(v5, 1);
        arvorelFilial.inserir(v6, 1);
        arvorelFilial.inserir(v7, 1);
        arvorelFilial.inserir(v8, 1);
        arvorelFilial.inserir(v9, 1);
        arvorelFilial.inserir(v10, 1);

        arvoreData.inserir(v1, 2);
        arvoreData.inserir(v2, 2);
        arvoreData.inserir(v3, 2);
        arvoreData.inserir(v4, 2);
        arvoreData.inserir(v5, 2);
        arvoreData.inserir(v6, 2);
        arvoreData.inserir(v7, 2);
        arvoreData.inserir(v8, 2);
        arvoreData.inserir(v9, 2);
        arvoreData.inserir(v10, 2);

        //Define intervalo entre filias
        int filialp = 1;
        int filialu = 8;
        //Define intervalo entre datas
        int datavendap = 201612;
        int datavendau = 201705;
        //Define intervalo entre filias e datas
        int filialcompp = 9;
        int filialcompu = 15;
        int datacompp = 201611;
        int datacompu = 201708;

        double totalVendido = arvorelFilial.efetuaSoma(arvorelFilial.raiz, filialp, filialu, 1);
        System.out.println("Total de vendido das filias " + filialp + " a " + filialu + " : " + totalVendido);

        totalVendido = arvoreData.efetuaSoma(arvoreData.raiz, datavendap, datavendau, 2);
        System.out.println("Total de vendido das entre as datas " + datavendap + " a " + datavendau + " : " + totalVendido);

        // CORRECAO: extrair das duas arvores, jogar em um hash e depois verificar vendas que atendem aos dois critérios
        totalVendido = arvorelFilial.efetuaSoma(arvorelFilial.raiz, filialcompp, filialcompu, datacompp, datacompu, 1, 2);
        System.out.println("Total de vendido das filias " + filialcompp + " a " + filialcompu + " e entre as datas " + datacompp + " a " + datacompu + " : " + totalVendido);

    }

}
