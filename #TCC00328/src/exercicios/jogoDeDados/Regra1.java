package exercicios.jogoDeDados;

public class Regra1 extends Regra {

    @Override
    public Resultado decidirResultado(Integer pontoInicial, Integer pontosObtidos) {
        if (pontosObtidos != null && pontosObtidos >= 2 && pontosObtidos <= 12)
            if (pontoInicial == null)
                return decidirPrimeiraJogada(pontosObtidos);
            else
                return decidirJogadaNormal(pontoInicial, pontosObtidos);
        else
            return Resultado.INDEFINIDO;
    }

    private Resultado decidirPrimeiraJogada(Integer pontosObtidos) {
        if (pontosObtidos == 7 || pontosObtidos == 11)
            return Resultado.GANHOU;
        else if (pontosObtidos == 2 || pontosObtidos == 3 || pontosObtidos == 12)
            return Resultado.PERDEU;
        else
            return Resultado.INDEFINIDO;
    }

    private Resultado decidirJogadaNormal(int pontoInicial, int pontosObtidos) {
        if (pontosObtidos == 7)
            return Resultado.PERDEU;
        else if (pontosObtidos == pontoInicial)
            return Resultado.GANHOU;
        else
            return Resultado.INDEFINIDO;
    }
}
