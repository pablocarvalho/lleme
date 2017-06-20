package uff.ic.biblioteca.oldmodel.patterns.mediator;

import uff.ic.biblioteca.oldmodel.Biblioteca;
import uff.ic.biblioteca.oldmodel.Material;
import uff.ic.biblioteca.oldmodel.Sistema;
import uff.ic.biblioteca.oldmodel.patterns.adapter.MaterialColecao;
import uff.ic.biblioteca.oldmodel.patterns.factory.Factory;

import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

public class MaterialMediador {

    private HashSet lnkErrosCollection = null;
    private Sistema lnkSistema = null;
    private MaterialColecao lnkMaterialCollection = null;
    private Material lnkMaterial = null;

    public Material getMaterial(HttpServletRequest request,
            HashSet lnkErrosCollection) {
        String mensagem = null;
        this.lnkSistema = Sistema.getInstance();
        this.lnkMaterialCollection = ((Biblioteca) lnkSistema.getLnkBiblioteca().get("Inform�tica")).getLnkMaterial();
        this.lnkMaterial = lnkMaterialCollection.get(Factory.createKeyMaterial(
                request, this.lnkErrosCollection));
        if (lnkErrosCollection.isEmpty()) {
            if (lnkMaterial == null) {
                mensagem = "Recupera��o mal sucedida!";
                mensagem += "\nErro: material n�o est� cadastrado.";
            }
        } else {
            Iterator iter = lnkErrosCollection.iterator();
            mensagem = "Recupera��o mal sucedida!";
            while (iter.hasNext()) {
                mensagem = mensagem.concat("\n" + (String) iter.next());
            }
        }
        request.getSession().setAttribute("material", lnkMaterial);
        request.getSession().setAttribute("mensagem", mensagem);
        return lnkMaterial;
    }
}
