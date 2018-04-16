package uff.ic.lleme.tcc00175.provas.s20121.p220121ex1;

public class Caso {

    public int numero;
    public int usuario;
    public String descricao;
    public String resposta;
    public Estado estado;

    public Caso(int numero, String desccricao) {
        this.numero = numero;
        this.descricao = desccricao;
        this.estado = new Registrado(this);
    }

    public void distribuir(int usuario) {
        this.usuario = usuario;
        estado.distribuir(usuario);
    }

    public void resolver(String resposta) {
        this.resposta = resposta;
        estado.resolver();
    }

    public void cancelar(String motivo) {
        this.resposta = motivo;
        estado.cancelar();
    }

    public void reabrir(int usuario) {
        this.usuario = usuario;
        estado.reabrir();
    }

    public String getEstado() {
        return estado.getNome();
    }
}
