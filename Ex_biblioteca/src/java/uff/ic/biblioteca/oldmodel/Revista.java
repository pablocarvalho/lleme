package uff.ic.biblioteca.oldmodel;

public class Revista extends Material {

    private static final long serialVersionUID = 4308269702641227466L;

    public Revista() {
        super();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getInformacoes() {
        return "N�mero: " + getNumero() + " - " + getMes() + "/" + getAno();
    }
    private int numero = 0;
    private String mes = null;
    private int ano = 0;
}
