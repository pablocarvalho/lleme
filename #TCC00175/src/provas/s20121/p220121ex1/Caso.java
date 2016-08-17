package provas.s20121.p220121ex1;

public class Caso {

    public int numero;
    public int usuario;
    public String descrição;
    public String resposta;
    public Estado estado;

    public Caso(int numero, String desccrição) {
        this.numero = numero;
        this.descrição = desccrição;
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
