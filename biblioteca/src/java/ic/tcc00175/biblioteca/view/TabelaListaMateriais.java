package ic.tcc00175.biblioteca.view;

import ic.tcc00175.biblioteca.oldmodel.Biblioteca;
import ic.tcc00175.biblioteca.oldmodel.Livro;
import ic.tcc00175.biblioteca.oldmodel.Material;
import ic.tcc00175.biblioteca.oldmodel.Sistema;
import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.BusinessObjectCollection;
import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.MaterialColecao;

public class TabelaListaMateriais extends Tabela {

    private MaterialColecao colecao = null;
    private Material lnkMaterial = null;

    public TabelaListaMateriais(int linhas) {
        super(((Biblioteca) Sistema.getInstance().getLnkBiblioteca().get(
                "Informática")).getLnkMaterial());
        this.colecao = (MaterialColecao) getColecao();
        setLinhas(linhas);
    }

    public TabelaListaMateriais() {
        super(((Biblioteca) Sistema.getInstance().getLnkBiblioteca().get(
                "Informática")).getLnkMaterial());
        this.colecao = (MaterialColecao) getColecao();
        setLinhas(0);
    }

    public void setColecao(BusinessObjectCollection colecao) {
        super.setColecao(colecao);
        this.colecao = (MaterialColecao) super.getColecao();
    }

    private String getLinha(int linha) {
        String retorno = "";
        if (linha < -1) {
            retorno += "<TH COLSPAN=\"4\">";
            retorno += "<DIV ALIGN=\"center\">Materiais cadastrados</DIV>";
            retorno += "</TH>";
            return retorno;
        } else if (linha == -1) {
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Tipo</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Codigo</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Titulo</TH>";
            retorno += "<TH BGCOLOR=\"#C0C0C0\">Informa&ccedil;&otilde;es</TH>";
            return retorno;
        }
        String material = null;
        this.lnkMaterial = this.colecao.get(getPos() + linha);

        // Coluna 1
        if (this.colecao.get(getPos() + linha) == null) {
            retorno += "<TD>&nbsp;    </TD>";
        } else {
            material = this.colecao.get(getPos() + linha).getClass().getName();
            material = material.substring(material.lastIndexOf(".") + 1);
            retorno += "<TD>" + material + "</TD>";
        }

        // Coluna 2
        retorno += "<TD>"
                + (this.colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : Long.toString(this.colecao.get(getPos() + linha).getCodigo())) + "</TD>";

        // Coluna 3
        retorno += "<TD>"
                + (this.colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : (this.colecao.get(getPos() + linha).getTitulo().equals("") ? "&nbsp;    " : this.colecao.get(
                getPos() + linha).getTitulo())) + "</TD>";

        // Coluna 4
        retorno += "<TD>"
                + (this.colecao.get(getPos() + linha) == null ? "&nbsp;    "
                : (this.colecao.get(getPos() + linha).getInformacoes().equals("") ? "&nbsp;    " : this.colecao.get(
                getPos() + linha).getInformacoes())) + "</TD>";

        return retorno;
    }

    public String getTabela() {
        String retorno = "";
        retorno += "<TABLE BORDER=\"1\">";
        for (int linha = -2; linha <= getLinhas() - 1; linha++) {
            retorno += "<tr>";
            retorno += getLinha(linha);
            retorno += "</tr>";

            if (linha >= 0 && lnkMaterial != null) {
                retorno += "<tr>";
                retorno += "<td colspan=\"4\">";
                retorno += "<table border=\"0\">";
                try {
                    if (Class.forName("ic.tcc00175.biblioteca.model.Livro").isInstance(lnkMaterial)) {
                        Livro livro = (Livro) lnkMaterial;
                        int reservas = livro.getLnkReserva().size();
                        if (reservas > 0) {
                            retorno += "<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Existe(m) "
                                    + Integer.toString(reservas)
                                    + " reserva(s)em nome de: ";
                            retorno += livro.getLnkReserva().get(0).getLnkrevUsuario().getNome();
                            for (int i = 1; i < livro.getLnkReserva().size(); i++) {
                                retorno += ", "
                                        + livro.getLnkReserva().get(i).getLnkrevUsuario().getNome();
                            }
                            retorno += "</td></tr>";
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < lnkMaterial.getLnkExemplar().size(); i++) {
                    retorno += "<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td>Exemplar #"
                            + lnkMaterial.getLnkExemplar().get(i).getNum()
                            + " est&aacute;";
                    if (lnkMaterial.getLnkExemplar().get(i).getLnkEmprestimo() == null) {
                        retorno += " dispon&iacute;vel.";
                    } else {
                        java.text.SimpleDateFormat data = new java.text.SimpleDateFormat(
                                "dd/MM/yyyy");
                        String data1 = data.format(lnkMaterial.getLnkExemplar().get(i).getLnkEmprestimo().getData());
                        String data2 = data.format(lnkMaterial.getLnkExemplar().get(i).getLnkEmprestimo().getLnkDevolucao().getData());
                        retorno += " emprestado para "
                                + lnkMaterial.getLnkExemplar().get(i).getLnkEmprestimo().getLnkrevUsuario().getNome() + " de " + data1
                                + " at&eacute; " + data2 + "</td></tr>";
                    }
                }
                retorno += "</table>";
                retorno += "</td>";
                retorno += "</tr>";
            }
        }
        retorno += "</TABLE>";
        return retorno;
    }
}
