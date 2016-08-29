package uff.ic.biblioteca.view;

import uff.ic.biblioteca.oldmodel.Emprestimo;
import uff.ic.biblioteca.oldmodel.Exemplar;
import uff.ic.biblioteca.oldmodel.Material;
import uff.ic.biblioteca.oldmodel.Usuario;

import java.text.SimpleDateFormat;

public class FormularioEmprestimo {

    public String getFormulario(Usuario usuario, Material material,
            Exemplar exemplar, Emprestimo emprestimo) {
        TabelaUsuario tabelaUsuario = new TabelaUsuario();
        TabelaMaterial tabelaMaterial = new TabelaMaterial();
        TabelaExemplar tabelaExemplar = new TabelaExemplar(material);

        String retorno = "";
        retorno += "<TABLE BORDER=\"0\">";
        retorno += "<tr>";
        retorno += "<TH BORDERCOLOR=\"#FFFFFF\" COLSPAN=\"2\">Formul&aacute;rio de cadastro</TH>";
        retorno += "</tr>";

        retorno += "<tr>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">Usu&aacute;rio:(*)</TD>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">"
                + tabelaUsuario.getDropDown(usuario) + "</TD>";
        retorno += "</tr>";

        retorno += "<tr>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">Material:(C*)</TD>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">"
                + tabelaMaterial.getDropDown(material) + "</TD>";
        retorno += "</tr>";

        retorno += "<tr>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">Exemplar:(C*)</TD>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">"
                + tabelaExemplar.getDropDown(exemplar) + "</TD>";
        retorno += "</tr>";

        retorno += "<TR>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">Data: (C*)</TD>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\"><INPUT TYPE=\"text\" NAME=\"data\" SIZE=\"10\"";
        retorno += "MAXLENGTH=\"10\" VALUE=\""
                + (emprestimo.getData() == null ? "" : (new SimpleDateFormat(
                "dd/MM/yyyy")).format(emprestimo.getData()))
                + "\"></TD>";
        retorno += "</TR>";

        retorno += "</TABLE>";
        return retorno;
    }
}
