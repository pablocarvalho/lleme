package uff.ic.biblioteca.oldmodel;

import uff.ic.biblioteca.oldmodel.patterns.adapter.ExemplarColecao;

import java.io.Serializable;

abstract public class Material extends BusinessObject {

    private class Key implements Serializable, Comparable {

        private static final long serialVersionUID = -4034693390640375958L;
        private long codigoK = 0;

        public int compareTo(Object o) {
            Key key = (Key) o;
            Long keyCodigo = new Long(key.codigoK);
            Long thisCodigo = new Long(this.codigoK);
            return thisCodigo.compareTo(keyCodigo);
        }
    }
    private Key key = null;

    public Material() {
        super();
        lnkExemplar = new ExemplarColecao();
        this.key = new Key();
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
        this.key.codigoK = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInformacoes() {
        return null;
    }

    public ExemplarColecao getLnkExemplar() {
        return lnkExemplar;
    }

    public void setLnkExemplar(ExemplarColecao lnkExemplar) {
        this.lnkExemplar = lnkExemplar;
    }

    public void setKey(long codigo) {
        setCodigo(codigo);
    }

    public Comparable getKey() {
        return this.key;
    }
    private ExemplarColecao lnkExemplar = null;
    private long codigo;
    private String titulo = null;
}
