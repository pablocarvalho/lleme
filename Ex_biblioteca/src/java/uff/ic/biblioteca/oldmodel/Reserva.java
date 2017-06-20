package uff.ic.biblioteca.oldmodel;

import java.io.Serializable;
import java.util.Date;

public class Reserva extends Operacao {

    private static final long serialVersionUID = 7163949131045165449L;

    private class Key implements Serializable, Comparable {

        private static final long serialVersionUID = 5648905668712195801L;
        private Date data = null;
        private Comparable usuario = null;
        private Comparable livro = null;

        public int compareTo(Object o) {
            Key key = (Key) o;
            if (this.data.compareTo(key.data) == 0) {
                if (this.usuario.compareTo(key.usuario) == 0) {
                    return this.livro.compareTo(key.livro);
                }
                return this.usuario.compareTo(key.usuario);
            }
            return this.data.compareTo(key.data);
        }
    }
    private Key key = null;
    public static int limite = 0;
    private Usuario lnkrevUsuario;
    private Livro lnkrevLivro = null;

    public Reserva() {
        super();
        this.key = new Key();
        this.lnkrevUsuario = new AlunoGraduacao();
        this.lnkrevLivro = new Livro();
        this.key.data = getData();
    }

    public Comparable getKey() {
        return key;
    }

    public void setData(Date data) {
        if (data != null) {
            super.setData(data);
            this.key.data = data;
        }
    }

    public void setKey(Date data, Livro livro) {
        setData(data);
        setLnkrevLivro(livro);
    }

    public boolean isPendente() {
        return true;
    }

    public Usuario getLnkrevUsuario() {
        return lnkrevUsuario;
    }

    public void setLnkrevUsuario(Usuario lnkrevUsuario) {
        if (lnkrevUsuario != null) {
            this.lnkrevUsuario = lnkrevUsuario;
            this.key.usuario = lnkrevUsuario.getKey();
        }
    }

    public Livro getLnkrevLivro() {
        return lnkrevLivro;
    }

    public void setLnkrevLivro(Livro lnkrevLivro) {
        if (lnkrevLivro != null) {
            this.lnkrevLivro = lnkrevLivro;
            this.key.livro = lnkrevLivro.getKey();
        }
    }

    public Devolucao getLnkDevolucao() {
        return null;
    }

    public Material getLnkMaterial() {
        return getLnkrevLivro();
    }
}
