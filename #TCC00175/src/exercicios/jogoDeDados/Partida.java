package exercicios.jogoDeDados;

public class Partida {

    private MesaDeDado mesaDeDado = null;

    private Partida() {
    }

    public Partida(MesaDeDado mesaDeDado) {
        this.mesaDeDado = mesaDeDado;
    }

    public Integer obterPontoInicial() {
        return mesaDeDado.obterPontoInicial(this);
    }

    public Integer obterUltimoPonto() {
        return mesaDeDado.obterUltimoPonto(this);
    }

    public Resultado obterResultado() {
        return mesaDeDado.obterResultado(this);
    }

    public Resultado jogar() {
        Dado[] dados = mesaDeDado.obterDados();
        for (Dado dado : dados)
            dado.sortear();
        return mesaDeDado.decidirResultado(dados, this);
    }
}
