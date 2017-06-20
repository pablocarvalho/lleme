package uff.ic.biblioteca.view;

import uff.ic.biblioteca.oldmodel.Usuario;

import java.text.SimpleDateFormat;

public class FormularioUsuario {

    public String getFormulario(Usuario usuario) {
        String retorno = "";
        retorno += "<TABLE BORDER=\"0\">";
        retorno += "<tr>";
        retorno += "<TH BORDERCOLOR=\"#FFFFFF\" COLSPAN=\"2\">Formul&aacute;rio de cadastro</TH>";
        retorno += "</tr>";

        retorno += "<tr>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\"></TD>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\"><select name=\"classe\">";
        retorno += "<option "
                + (usuario.getClass().getName().equals(
                "ic.tcc00175.biblioteca.model.AlunoGraduacao") ? "SELECTED=\"selected\""
                : "")
                + " value=\"AlunoGraduacao\">AlunoGradua&ccedil;&atilde;o</option>";
        retorno += "<option "
                + (usuario.getClass().getName().equals(
                "ic.tcc00175.biblioteca.model.AlunoPosGraduacao") ? "SELECTED=\"selected\""
                : "")
                + " value=\"AlunoPosGraduacao\">AlunoP&oacute;sGradua&ccedil;&atilde;o</option>";
        retorno += "<option "
                + (usuario.getClass().getName().equals(
                "ic.tcc00175.biblioteca.model.Professor") ? "SELECTED=\"selected\""
                : "") + " value=\"Professor\">Professor</option>";
        retorno += "</select></TD>";
        retorno += "</tr>";

        retorno += "<TR>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">Id: (C*)</TD>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\"><INPUT TYPE=\"text\" NAME=\"id\" SIZE=\"18\"";
        retorno += "MAXLENGTH=\"6\" VALUE=\"" + usuario.getId() + "\"></TD>";
        retorno += "</TR>";

        retorno += "<TR>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">Nome: (*)</TD>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\"><INPUT TYPE=\"text\" NAME=\"nome\" SIZE=\"20\"";
        retorno += "MAXLENGTH=\"80\"";
        retorno += "VALUE=\""
                + (usuario.getNome() == null ? "" : usuario.getNome())
                + "\"></TD>";
        retorno += "</TR>";

        retorno += "<TR>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">Admissao \"dd/mm/aaaa\": (*)</TD>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\"><INPUT TYPE=\"text\" NAME=\"admissao\" SIZE=\"10\"";
        retorno += "MAXLENGTH=\"10\" VALUE=\""
                + (usuario.getAdmissao() == null ? "" : (new SimpleDateFormat(
                "dd/MM/yyyy")).format(usuario.getAdmissao()))
                + "\"></TD>";
        retorno += "</TR>";

        retorno += "<TR>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">Cancelamento \"dd/mm/aaaa\":</TD>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\"><INPUT TYPE=\"text\" NAME=\"cancelamento\" SIZE=\"10\" MAXLENGTH=\"10\" VALUE=\""
                + (usuario.getCancelamento() == null ? ""
                : (new SimpleDateFormat("dd/MM/yyyy")).format(usuario.getCancelamento())) + "\"></TD>";
        retorno += "</TR>";

        retorno += "</TABLE>";
        return retorno;
    }
}
