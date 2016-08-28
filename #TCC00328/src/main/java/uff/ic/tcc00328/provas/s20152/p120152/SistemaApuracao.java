package uff.ic.tcc00328.provas.s20152.p120152;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaApuracao {

    private static final Map<Integer, Carnaval> APURACOES = new HashMap<>();
    public static Regra regra = null;

    private SistemaApuracao() {
    }

    public static Carnaval registrarNovoCarnaval(int ano) throws Exception {
        Carnaval carnaval = new Carnaval();
        if (!APURACOES.containsKey(ano)) {
            APURACOES.put(carnaval.ano, carnaval);
            return carnaval;
        } else
            throw new Exception();
    }

    public static Jurado registrarNovoJurado(Carnaval carnaval, String nome, Quesito quesito) throws Exception {
        Jurado jurado = new Jurado(nome, quesito);
        carnaval.registrarJurado(jurado);
        return jurado;
    }

    public static Nota registrarNota(Carnaval carnaval, Escola escola, Quesito quesito, Jurado jurado, float valor) throws Exception {
        Nota nota_ = new Nota(quesito, jurado, valor);
        escola.registrarNota(nota_);
        return nota_;
    }

    public static Escola registrarNovaEscola(Carnaval carnaval, String nome) throws Exception {
        Escola escola = new Escola(nome);
        carnaval.registrarEscola(escola);
        return escola;
    }

    static List<Resultado> computarResulado(Carnaval carnaval) {
        List<Resultado> resultados = regra.calcularResultado(carnaval);
        return resultados;
    }
}
