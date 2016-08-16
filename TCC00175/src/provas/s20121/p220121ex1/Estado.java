package provas.s20121.p220121ex1;

public abstract class Estado {

    protected Caso caso;
    private String nome;

    public Estado(Caso caso, String nome) {
        this.caso = caso;
        this.nome = nome;
    }

    public abstract void distribuir(int usuario);

    public abstract void resolver();

    public abstract void cancelar();

    public abstract void reabrir();

    public String getNome() {
        return nome;
    }
}
