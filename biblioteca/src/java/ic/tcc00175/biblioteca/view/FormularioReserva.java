package ic.tcc00175.biblioteca.view;

import ic.tcc00175.biblioteca.oldmodel.Material;
import ic.tcc00175.biblioteca.oldmodel.Reserva;
import ic.tcc00175.biblioteca.oldmodel.Usuario;

import java.text.SimpleDateFormat;

public class FormularioReserva {

    public String getFormulario(Usuario usuario, Material material,
            Reserva reserva) {
        TabelaUsuario tabelaUsuario = new TabelaUsuario();
        TabelaMaterial tabelaMaterial = new TabelaMaterial();
        String retorno = "";
        retorno += "<TABLE BORDER=\"0\">";
        retorno += "<tr>";
        retorno += "<TH BORDERCOLOR=\"#FFFFFF\" COLSPAN=\"2\">Formul&aacute;rio de cadastro</TH>";
        retorno += "</tr>";

        retorno += "<tr>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">Usu&aacute;rio:(C*)</TD>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">"
                + tabelaUsuario.getDropDown(usuario) + "</TD>";
        retorno += "</tr>";

        retorno += "<tr>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">Material:(C*)</TD>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">"
                + tabelaMaterial.getDropDown(material) + "</TD>";
        retorno += "</tr>";

        retorno += "<TR>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\">Data: (C*)</TD>";
        retorno += "<TD BORDERCOLOR=\"#FFFFFF\"><INPUT TYPE=\"text\" NAME=\"data\" SIZE=\"10\"";
        retorno += "MAXLENGTH=\"10\" VALUE=\""
                + (reserva.getData() == null ? "" : (new SimpleDateFormat(
                "dd/MM/yyyy")).format(reserva.getData())) + "\"></TD>";
        retorno += "</TR>";

        retorno += "</TABLE>";
        return retorno;
    }
}
