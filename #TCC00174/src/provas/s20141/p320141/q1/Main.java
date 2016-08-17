package provas.s20141.p320141.q1;

public class Main {

    public static void main(String[] args) {
        Lista<Integer> l1 = new Lista();
        Lista<Integer> l2 = new Lista();

        l2.incluir(7);
        l2.incluir(13);
        l2.incluir(27);

        l1.incluir(1);
        l1.incluir(2);
        l1.incluir(3);
        l1.incluir(4);
        l1.incluir(5);
        l1.incluir(6);

        l1.imprimir();
        l2.imprimir();
        
        l1.intercalarCom(l2);
        l1.imprimir();

        l1.subdividirLista().imprimir();
        l1.imprimir();

    }

}
