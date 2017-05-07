package uff.ic.tcc00328.provas.s20152.p120152;

public class Resultado {

    public Escola escola = null;
    public Float nota = 0.0f;
    public Float notaDesempate = 0.0f;

    public Resultado(Escola escola, float nota, float notaDesempate) {
        this.escola = escola;
        this.nota = nota;
        this.notaDesempate = notaDesempate;
    }
}
