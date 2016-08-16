package ic.tcc00175.biblioteca.view;

import ic.tcc00175.biblioteca.oldmodel.Usuario;
import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.BusinessObjectCollection;
import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.ReservaColecao;

public class TabelaReserva extends Tabela {

    private ReservaColecao colecao = null;

    public TabelaReserva(int linhas, Usuario usuario) {
        super(usuario.getLnkReserva());
        this.colecao = (ReservaColecao) getColecao();
        setLinhas(linhas);
    }

    public TabelaReserva(int linhas) {
        super(new ReservaColecao());
        this.colecao = (ReservaColecao) super.getColecao();
        setLinhas(linhas);
    }

    public void setColecao(BusinessObjectCollection colecao) {
        super.setColecao(colecao);
        this.colecao = (ReservaColecao) super.getColecao();
    }

    private String getLinha(int linha) {
        String retorno = "";
        if (linha < -1) {
            retorno += "<TH COLSPAN=\"2\">";
            retorno += "<DIV ALIGN=\"center\">Reservas cadastradas</DIV>";
            retorno += "</TH>";
            return retorno;
        } else if (linha == -1) {
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Data</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Livro</TH>";
            return retorno;
        }
        java.text.SimpleDateFormat dataBrasileira = new java.text.SimpleDateFormat(
                "dd/MM/yyyy");
        retorno += "<TD>"
                + (this.colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : (this.colecao.get(getPos() + linha).getData() == null ? "&nbsp;    "
                : dataBrasileira.format(this.colecao.get(
                getPos() + linha).getData())))
                + "</TD>";

        retorno += "<TD>"
                + (this.colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : (this.colecao.get(getPos() + linha).getLnkrevLivro() == null ? "&nbsp;    "
                : this.colecao.get(getPos() + linha).getLnkrevLivro().getTitulo()))
                + "</TD>";
        return retorno;
    }

    public String getTabela() {
        String retorno = "";
        retorno += "<TABLE BORDER=\"1\">";
        for (int linha = -2; linha <= getLinhas() - 1; linha++) {
            retorno += "<tr>";
            retorno += getLinha(linha);
            retorno += "</tr>";
        }
        retorno += "</TABLE>";
        return retorno;
    }
}