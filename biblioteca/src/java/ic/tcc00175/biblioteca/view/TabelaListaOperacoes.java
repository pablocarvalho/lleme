package ic.tcc00175.biblioteca.view;

import ic.tcc00175.biblioteca.oldmodel.AlunoGraduacao;
import ic.tcc00175.biblioteca.oldmodel.Usuario;
import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.BusinessObjectCollection;
import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.OperacaoColecao;

public class TabelaListaOperacoes extends Tabela {

    private OperacaoColecao colecao = null;

    public TabelaListaOperacoes(int linhas, Usuario usuario) {
        super(usuario.getLnkOperacao());
        this.colecao = (OperacaoColecao) getColecao();
        setLinhas(linhas);
    }

    public TabelaListaOperacoes(int linhas) {
        super(new OperacaoColecao(new AlunoGraduacao()));
        this.colecao = (OperacaoColecao) super.getColecao();
        setLinhas(linhas);
    }

    public void setColecao(BusinessObjectCollection colecao) {
        super.setColecao(colecao);
        this.colecao = (OperacaoColecao) super.getColecao();
    }

    private String getLinhaReserva(int linha) {
        String retorno = "";
        if (linha < -1) {
            retorno += "<TH COLSPAN=\"6\">";
            retorno += "<DIV ALIGN=\"center\">Opera&ccedil;&atilde;es cadastradas</DIV>";
            retorno += "</TH>";
            return retorno;
        } else if (linha == -1) {
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Opera&ccedil;&atilde;o</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Data</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Retorno</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Material</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Titulo</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Status</TH>";
            return retorno;
        }
        String operacao = null;
        if (this.colecao.get(getPos() + linha) == null) {
            retorno += "<TD>&nbsp;    </TD>";
        } else {
            operacao = this.colecao.get(getPos() + linha).getClass().getName();
            operacao = operacao.substring(operacao.lastIndexOf(".") + 1);
            retorno += "<TD>" + operacao + "</TD>";
        }

        java.text.SimpleDateFormat data = new java.text.SimpleDateFormat(
                "dd/MM/yyyy");
        retorno += "<TD>"
                + (this.colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : (this.colecao.get(getPos() + linha).getData() == null ? "&nbsp;    "
                : data.format(this.colecao.get(getPos() + linha).getData())))
                + "</TD>";

        retorno += "<TD>"
                + (this.colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : (this.colecao.get(getPos() + linha).getLnkDevolucao() == null ? "&nbsp;    "
                : data.format(this.colecao.get(getPos() + linha).getLnkDevolucao().getData())))
                + "</TD>";

        if (this.colecao.get(getPos() + linha) == null) {
            retorno += "<TD>&nbsp;    </TD>";
        } else {
            String nome = this.colecao.get(getPos() + linha).getLnkMaterial().getClass().getName();
            retorno += "<TD>" + nome.substring(nome.lastIndexOf(".") + 1)
                    + "</TD>";
        }

        retorno += "<TD>"
                + (this.colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : (this.colecao.get(getPos() + linha).getLnkMaterial() == null ? "&nbsp;    "
                : this.colecao.get(getPos() + linha).getLnkMaterial().getTitulo()))
                + "</TD>";

        retorno += "<TD>"
                + (this.colecao.get(getPos() + linha) == null
                || operacao.equals("Reserva") ? "&nbsp;    "
                : (this.colecao.get(getPos() + linha).isPendente() ? "emprestado"
                : "devolvido")) + "</TD>";
        return retorno;
    }

    public String getTabela() {
        String retorno = "";
        retorno += "<TABLE BORDER=\"1\">";
        for (int linha = -2; linha <= getLinhas() - 1; linha++) {
            retorno += "<tr>";
            retorno += getLinhaReserva(linha);
            retorno += "</tr>";
        }
        retorno += "</TABLE>";
        return retorno;
    }
}
