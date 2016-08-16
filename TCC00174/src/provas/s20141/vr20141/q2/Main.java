package provas.s20141.vr20141.q2;

public class Main {

    public static void main(String[] args) {

        Colecao<MinhaClasse> col = new Colecao<>();

        col.incluir(new MinhaClasse("Luiz"));
        col.incluir(new MinhaClasse("André"));

        col.imprimir();

    }

}
