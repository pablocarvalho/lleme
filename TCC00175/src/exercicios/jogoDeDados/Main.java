package exercicios.jogoDeDados;

public class Main {

    public static void main(String[] args) {
        MesaDeDado mesa = new MesaDeDado(new Regra1());
        Partida partida = new Partida(mesa);
        int jogada = 0;

        imprimirAndamento(partida, jogada++);
        while (partida.obterResultado() == Resultado.INDEFINIDO) {
            partida.jogar();
            imprimirAndamento(partida, jogada++);
        }
    }

    private static void imprimirAndamento(Partida partida, int jogada) {
        System.out.println("Jogada: " + jogada);
        System.out.println("Ponto inicial: " + partida.obterPontoInicial());
        System.out.println("Ultimo ponto: " + partida.obterUltimoPonto());
        System.out.println("Resultado: " + partida.obterResultado());
        System.out.println("");
    }
}
