package uff.ic.biblioteca.view;

import uff.ic.biblioteca.oldmodel.Usuario;
import uff.ic.biblioteca.oldmodel.patterns.adapter.BusinessObjectCollection;
import uff.ic.biblioteca.oldmodel.patterns.adapter.EmprestimoColecao;

public class TabelaEmprestimo extends Tabela {

    private EmprestimoColecao colecao = null;

    public TabelaEmprestimo(int linhas, Usuario usuario) {
        super(usuario.getLnkEmprestimo());
        this.colecao = (EmprestimoColecao) getColecao();
        setLinhas(linhas);
    }

    public TabelaEmprestimo(int linhas) {
        super(new EmprestimoColecao());
        this.colecao = (EmprestimoColecao) super.getColecao();
        setLinhas(linhas);
    }

    public void setColecao(BusinessObjectCollection colecao) {
        super.setColecao(colecao);
        this.colecao = (EmprestimoColecao) super.getColecao();
    }

    private String getLinha(int linha) {
        String retorno = "";
        if (linha < -1) {
            retorno += "<TH COLSPAN=\"5\">";
            retorno += "<DIV ALIGN=\"center\">Emprestimos cadastrados</DIV>";
            retorno += "</TH>";
            return retorno;
        } else if (linha == -1) {
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Data</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Retorno</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Titulo</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Exemplar</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Status</TH>";
            return retorno;
        }
        java.text.SimpleDateFormat dataBrasileira = new java.text.SimpleDateFormat(
                "dd/MM/yyyy");
        String valor = "";

        // Coluna 1
        valor = (this.colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : (this.colecao.get(getPos() + linha).getData() == null ? "&nbsp;    "
                : dataBrasileira.format(this.colecao.get(
                getPos() + linha).getData())));
        retorno += "<TD>" + valor + "</TD>";

        // Coluna 2
        valor = (this.colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : (this.colecao.get(getPos() + linha).getLnkDevolucao() == null ? dataBrasileira.format(this.colecao.get(getPos() + linha).getLnkDevolucao().getData())
                : dataBrasileira.format(this.colecao.get(
                getPos() + linha).getLnkDevolucao().getData())));
        retorno += "<TD>" + valor + "</TD>";

        // Coluna 3
        valor = (this.colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : (this.colecao.get(getPos() + linha).getLnkrevExemplar().getLnkrevMaterial().getTitulo() == null ? "&nbsp;    "
                : this.colecao.get(getPos() + linha).getLnkrevExemplar().getLnkrevMaterial().getTitulo()));
        retorno += "<TD>" + valor + "</TD>";

        // Coluna 4
        valor = (this.colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : Integer.toString(this.colecao.get(getPos() + linha).getLnkrevExemplar().getNum()));
        retorno += "<TD>" + valor + "</TD>";

        // Coluna 5
        valor = (this.colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : (this.colecao.get(getPos() + linha).isPendente() ? "Emprestado"
                : "Devolvido"));
        retorno += "<TD>" + valor + "</TD>";

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