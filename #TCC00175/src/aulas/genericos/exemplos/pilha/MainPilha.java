package aulas.genericos.exemplos.pilha;

public class MainPilha {

    public static void main(String[] args) {
        Pilha<Integer> pilha = new Pilha<Integer>();
        pilha.push(new Integer(5));
        System.out.println(pilha.top());
    }
}
