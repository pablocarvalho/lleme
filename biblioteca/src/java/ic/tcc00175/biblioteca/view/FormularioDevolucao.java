package ic.tcc00175.biblioteca.view;

import ic.tcc00175.biblioteca.oldmodel.Material;
import ic.tcc00175.biblioteca.oldmodel.Usuario;

public class FormularioDevolucao {

    public String getFormulario(Usuario usuario, Material material) {
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

        retorno += "</TABLE>";
        return retorno;
    }
}