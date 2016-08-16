package provas.s20121.p120121ex2;

public class P120121Ex3 {

    public static void main(String[] args) {

        Item sfo = new Mnemonico("SFO", 5);
        Item scn = new Mnemonico("SCN", 6);
        Item fri = new Mnemonico("FRI", 2);
        Item sal = new Mnemonico("SAL", 1);
        Item ref = new Mnemonico("REF", 3);
        Item suc = new Mnemonico("SUC", 4);

        Item escolha1 = new Alternativa(sfo, scn);
        Item escolha2 = new Alternativa(ref, suc);
        Item promocao = new Combinacao(escolha1, escolha2);// desconto de 10%

        Item seq2 = new Sequencia(promocao, escolha1);
        Item seq3 = new Sequencia(escolha1, promocao);

        Item pedido1 = new Alternativa(seq3, seq2);
        Item pedido2 = new Alternativa(escolha1, promocao);
        Item pedido = new Alternativa(pedido1, pedido2);

        try {
            // valor = 5 + ( 6 + 3 ) * 0.9 = 13.1
            System.out.println(pedido.valor("SFO SCN : REF", 1));
            System.out.println(pedido.parse("SFO SCN : FRI", 1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
