package ic.tcc00175.biblioteca.view;

import ic.tcc00175.biblioteca.oldmodel.Biblioteca;
import ic.tcc00175.biblioteca.oldmodel.Material;
import ic.tcc00175.biblioteca.oldmodel.Sistema;
import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.MaterialColecao;

public class TabelaMaterial extends Tabela {

    private MaterialColecao colecao = null;

    public TabelaMaterial(int linhas) {
        super(((Biblioteca) Sistema.getInstance().getLnkBiblioteca().get(
                "Informática")).getLnkMaterial());
        this.colecao = (MaterialColecao) getColecao();
        setLinhas(linhas);
    }

    public TabelaMaterial() {
        super(((Biblioteca) Sistema.getInstance().getLnkBiblioteca().get(
                "Informática")).getLnkMaterial());
        this.colecao = (MaterialColecao) getColecao();
        setLinhas(0);
    }

    private String getLinha(int linha) {
        String retorno = "";
        if (linha < -1) {
            retorno += "<TH COLSPAN=\"3\">";
            retorno += "<DIV ALIGN=\"center\">Usu&aacute;rios cadastrados</DIV>";
            retorno += "</TH>";
            return retorno;
        } else if (linha == -1) {
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Codigo</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Titulo</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Classe</TH>";
            return retorno;
        }
        retorno += "<TD>"
                + (this.colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : Long.toString(this.colecao.get(getPos() + linha)
                .getCodigo())) + "</TD>";
        retorno += "<TD>"
                + (this.colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : (this.colecao.get(getPos() + linha).getTitulo()
                .equals("") ? "&nbsp;    " : this.colecao.get(
                getPos() + linha).getTitulo())) + "</TD>";
        if (this.colecao.get(getPos() + linha) == null) {
            retorno += "<TD>&nbsp;    </TD>";
        } else {
            String nome = this.colecao.get(getPos() + linha).getClass()
                    .getName();
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
    public String getDropDown(Material material) {
        String retorno = "";
        retorno += "<select name=\"codigo\" onchange=\"selectMaterial();\">";
        retorno += "<option value=\"0\"></option>";
        for (int i = 0; i < this.colecao.size(); i++) {
            retorno += "<option "
                    + (material != null ? (material.getKey().compareTo(
                    colecao.get(i).getKey()) == 0 ? "selected=\"selected\""
                    : "")
                    : "") + " value=\"" + colecao.get(i).getCodigo()
                    + "\">";
            retorno += colecao.get(i).getTitulo();
            retorno += "</option>";
        }
        retorno += "</select>";
        return retorno;
    }
}