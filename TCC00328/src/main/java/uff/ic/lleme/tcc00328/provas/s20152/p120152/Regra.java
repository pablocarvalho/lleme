package uff.ic.lleme.tcc00328.provas.s20152.p120152;

import java.util.List;

public interface Regra {

    public abstract List<Resultado> calcularResultado(Carnaval carnaval);

    public abstract void registrarQuesitoDesempate(Quesito quesito);
}
