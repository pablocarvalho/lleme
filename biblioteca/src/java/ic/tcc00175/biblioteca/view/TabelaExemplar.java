package ic.tcc00175.biblioteca.view;

import ic.tcc00175.biblioteca.oldmodel.Biblioteca;
import ic.tcc00175.biblioteca.oldmodel.Exemplar;
import ic.tcc00175.biblioteca.oldmodel.Material;
import ic.tcc00175.biblioteca.oldmodel.Sistema;
import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.ExemplarColecao;

public class TabelaExemplar extends Tabela {

    private ExemplarColecao colecao = null;

    public TabelaExemplar(Material material) {
        if (material != null) {
            material = ((Biblioteca) Sistema.getInstance().getLnkBiblioteca()
                    .get("Informática")).getLnkMaterial()
                    .get(material.getKey());
        }
        if (material != null) {
            this.colecao = ((Biblioteca) Sistema.getInstance()
                    .getLnkBiblioteca().get("Informática")).getLnkMaterial()
                    .get(material.getKey()).getLnkExemplar();
        } else {
            this.colecao = new ExemplarColecao();
        }
        setColecao(this.colecao);
        setLinhas(0);
    }

    @SuppressWarnings("unchecked")
    public String getDropDown(Exemplar exemplar) {
        String retorno = "";
        retorno += "<select name=\"num\">";
        retorno += "<option value=\"0\"></option>";
        if (colecao != null) {
            for (int i = 0; i < this.colecao.size(); i++) {
                retorno += "<option "
                        + (exemplar != null ? (exemplar.getKey().compareTo(
                        colecao.get(i).getKey()) == 00 ? "selected=\"selected\""
                        : "")
                        : "") + " value=\"" + colecao.get(i).getNum()
                        + "\">";
                retorno += colecao.get(i).getNum();
                retorno += "</option>";
            }
        }

        retorno += "</select>";
        return retorno;
    }

    public String getTabela() {
        return null;
    }
}