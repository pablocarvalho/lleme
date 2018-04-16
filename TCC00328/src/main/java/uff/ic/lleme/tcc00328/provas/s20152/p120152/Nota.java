package uff.ic.lleme.tcc00328.provas.s20152.p120152;

public class Nota {

    public Quesito quesito = null;
    public Jurado jurado = null;
    public float valor = 0;

    private Nota() {
    }

    public Nota(Quesito quesito, Jurado jurado, float valor) throws Exception {
        verificarHbilitacaoJurado(jurado, quesito);
        this.quesito = quesito;
        this.jurado = jurado;
        this.valor = valor;
    }

    private void verificarHbilitacaoJurado(Jurado jurado, Quesito quesito) throws Exception {
        if (jurado.quesito != quesito)
            throw new Exception("Jurado não habilitado para o quesito");
    }
}
