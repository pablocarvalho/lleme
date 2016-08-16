package ic.tcc00175.biblioteca.view;

import ic.tcc00175.biblioteca.oldmodel.Sistema;
import ic.tcc00175.biblioteca.oldmodel.Usuario;
import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.UsuarioColecao;

public class TabelaUsuario extends Tabela {

    private UsuarioColecao colecao = null;

    public TabelaUsuario(int linhas) {
        super(Sistema.getInstance().getLnkUsuario());
        colecao = (UsuarioColecao) getColecao();
        setLinhas(linhas);
    }

    public TabelaUsuario() {
        super(Sistema.getInstance().getLnkUsuario());
        colecao = (UsuarioColecao) getColecao();
        setLinhas(0);
    }

    private String getLinha(int linha) {
        String retorno = "";
        if (linha < -1) {
            retorno += "<TH COLSPAN=\"4\">";
            retorno += "<DIV ALIGN=\"center\">Usu&aacute;rios cadastrados</DIV>";
            retorno += "</TH>";
            return retorno;
        } else if (linha == -1) {
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Id</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Nome</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Admissao</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Classe</TH>";
            return retorno;
        }
        retorno += "<TD>"
                + (colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : Long.toString(colecao.get(getPos() + linha).getId())) + "</TD>";
        retorno += "<TD>"
                + (colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : (colecao.get(getPos() + linha).getNome().equals(
                "") ? "&nbsp;    " : colecao.get(
                getPos() + linha).getNome())) + "</TD>";
        java.text.SimpleDateFormat dataBrasileira = new java.text.SimpleDateFormat(
                "dd/MM/yyyy");
        retorno += "<TD>"
                + (colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : (colecao.get(getPos() + linha).getAdmissao() == null ? "&nbsp;    "
                : dataBrasileira.format(colecao.get(
                getPos() + linha).getAdmissao())))
                + "</TD>";

        if (colecao.get(getPos() + linha) == null) {
            retorno += "<TD>&nbsp;    </TD>";
        } else {
            String nome = colecao.get(getPos() + linha).getClass().getName();
            retorno += "<TD>" + nome.substring(nome.lastIndexOf(".") + 1)
                    + "</TD>";
        }
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

    @SuppressWarnings("unchecked")
    public String getDropDown(Usuario usuario) {
        String retorno = "";
        retorno += "<select name=\"id\" onchange=\"selectUsuario();\">";
        retorno += "<option value=\"0\"></option>";
        for (int i = 0; i < colecao.size(); i++) {
            retorno += "<option "
                    + (usuario.getKey().compareTo(colecao.get(i).getKey()) == 0 ? "selected=\"selected\""
                    : "") + " value=\"" + colecao.get(i).getId()
                    + "\">";
            retorno += colecao.get(i).getNome();
            retorno += "</option>";
        }
        retorno += "</select>";
        return retorno;
    }
}
