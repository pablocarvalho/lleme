package uff.ic.lleme.tic10002.trabalhos.s20171.leandro_miranda;

public class Venda {

    private String filial;
    private String anoMes;
    private String codVendedor;
    private String totalVendido;

    public Venda() {

    }

    public Venda(String filial, String anoMes, String codVendedor,
            String totalVendido) {
        this.filial = filial;
        this.anoMes = anoMes;
        this.codVendedor = codVendedor;
        this.totalVendido = totalVendido;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public String getAnoMes() {
        return anoMes;
    }

    public void setAnoMes(String anoMes) {
        this.anoMes = anoMes;
    }

    public String getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(String codVendedor) {
        this.codVendedor = codVendedor;
    }

    public String getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(String totalVendido) {
        this.totalVendido = totalVendido;
    }

    /**
     * ----------------- *
     */
    public String getChave(String tipo) {
        if (tipo == "filial")
            return filial;
        else if (tipo == "ano_mes")
            return anoMes;
        else if (tipo == "cod_vendedor")
            return codVendedor;
        else if (tipo == "total_vendido")
            return totalVendido;
        else
            return null;
    }

    // public int compareTo(Venda venda,String tipo) {
    // return getChave(tipo).compareTo(venda.getChave(tipo));
    // }
    public Integer compararChave(String venda, String tipo) {
        if (tipo == "filial" || (tipo == "total_vendido")) {
            Integer valorObjeto = Integer.parseInt(getChave(tipo));
//			Integer valorComparado = Integer.parseInt(venda.getChave(tipo));
            Integer valorComparado = Integer.parseInt(venda);
            if (valorObjeto < valorComparado)
                return -1;
            else if (valorObjeto > valorComparado)
                return 1;
            else
                return 0;
        } else if (getChave(tipo) != null && venda != null)
            return getChave(tipo).compareTo(venda);
        else
            return null;
    }

    public Integer compararInstancia(Venda venda, String tipo) {
        if (tipo == "filial" || (tipo == "total_vendido")) {
            Integer valorObjeto = Integer.parseInt(getChave(tipo));
            Integer valorComparado = Integer.parseInt(venda.getChave(tipo));
            if (valorObjeto < valorComparado)
                return -1;
            else if (valorObjeto > valorComparado)
                return 1;
            else
                return 0;
        } else if (getChave(tipo) != null && venda != null
                && venda.getChave(tipo) != null)
            return getChave(tipo).compareTo(venda.getChave(tipo));
        else
            return null;
    }

}
