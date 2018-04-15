package uff.ic.lleme.tcc00175.exercicios.temporizador.view;

public interface Visitor {

    public abstract void VisitMostradorCronometro(MostradorCronometro mostrador);

    public abstract void VisitMostradorRegressivo(MostradorRegressivo mostrador);

    public abstract void VisitMostradorRelogio(MostradorRelogio mostrador);

    public abstract void VisitBotaoStartStop(BotaoStartStop botao);

    public abstract void VisitBotaoReset(BotaoReset botao);
}
