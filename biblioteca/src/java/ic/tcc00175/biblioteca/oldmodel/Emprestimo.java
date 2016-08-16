package ic.tcc00175.biblioteca.oldmodel;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Emprestimo extends Operacao {

    private class Key implements Serializable, Comparable {

        private static final long serialVersionUID = 5648905668712195801L;
        private Date data = null;
        private Comparable exemplar = null;

        @SuppressWarnings("unchecked")
        public int compareTo(Object o) {
            Key key = (Key) o;
            if (this.data.compareTo(key.data) == 0) {
                return this.exemplar.compareTo(key.exemplar);
            }
            return this.data.compareTo(key.data);
        }
    }
    private static final long serialVersionUID = -5647399629972428903L;
    private Key key = null;

    public Emprestimo() {
        super();
        this.key = new Key();
        this.key.data = getData();
    }
    private Devolucao lnkDevolucao = null;
    private Exemplar lnkrevExemplar = null;
    private Usuario lnkrevUsuario;

    public Comparable getKey() {
        return key;
    }

    public void setData(Date data) {
        if (data != null) {
            super.setData(data);
            this.key.data = data;
        }
    }

    public void setKey(Date data, Exemplar exemplar) {
        setData(data);
        setLnkrevExemplar(exemplar);
    }

    public boolean isPendente() {
        if (this.lnkDevolucao == null) {
            return true;
        }
        return false;
    }

    public Devolucao getLnkDevolucao() {
        if (lnkDevolucao != null) {
            return lnkDevolucao;
        }
        GregorianCalendar gregCal = new GregorianCalendar();
        gregCal.setTime(getData());
        gregCal.add(Calendar.DATE, getLnkrevUsuario().getTempoEmprestimo());
        Devolucao devolucaoPrevisao = new Devolucao();
        devolucaoPrevisao.setData(gregCal.getTime());
        return devolucaoPrevisao;
    }

    public void setLnkDevolucao(Devolucao lnkDevolucao) {
        this.lnkDevolucao = lnkDevolucao;
    }

    public Exemplar getLnkrevExemplar() {
        return lnkrevExemplar;
    }

    public void setLnkrevExemplar(Exemplar lnkrevExemplar) {
        this.lnkrevExemplar = lnkrevExemplar;
        this.key.exemplar = lnkrevExemplar.getKey();
    }

    public Usuario getLnkrevUsuario() {
        return lnkrevUsuario;
    }

    public void setLnkrevUsuario(Usuario lnkrevUsuario) {
        this.lnkrevUsuario = lnkrevUsuario;
    }

    public Material getLnkMaterial() {
        if (getLnkrevExemplar() == null) {
            return null;
        }
        return getLnkrevExemplar().getLnkrevMaterial();
    }
}
