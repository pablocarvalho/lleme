package uff.ic.tcc00175.patterns.composite;

public class Cliente {

    public static void main(String[] args) {

        ItemComposto igpm = new ItemComposto("IGPM");
        ItemComposto alimentacao = new ItemComposto("Alimenta��o");
        ItemComposto vestuario = new ItemComposto("vestuario");
        igpm.addItem(alimentacao);
        igpm.addItem(vestuario);

        alimentacao.addItem(new Produto("Feij�o", 0.003));
        alimentacao.addItem(new Produto("Arroz", 0.001));
        vestuario.addItem(new Produto("Sapatos", 0.005));
        vestuario.addItem(new Produto("Roupas", 0.006));

        igpm.imprimir();
    }
}
