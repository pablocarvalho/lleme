package uff.ic.biblioteca.oldmodel.patterns.mediator;

import uff.ic.biblioteca.oldmodel.Biblioteca;
import uff.ic.biblioteca.oldmodel.Exemplar;
import uff.ic.biblioteca.oldmodel.Material;
import uff.ic.biblioteca.oldmodel.Sistema;
import uff.ic.biblioteca.oldmodel.patterns.adapter.MaterialColecao;
import uff.ic.biblioteca.oldmodel.patterns.factory.Factory;

import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

public class ExemplarMediador {

    private HashSet lnkErrosCollection = null;
    private Sistema lnkSistema = null;
    private MaterialColecao lnkMaterialCollection = null;
    private Exemplar lnkExemplar = null;
    private Material lnkMaterial = null;
    private MaterialMediador lnkMaterialMediator = null;

    @SuppressWarnings("unchecked")
    public Exemplar getExemplar(HttpServletRequest request,
            HashSet lnkErrosCollection) {
        this.lnkSistema = Sistema.getInstance();
        String mensagem = null;
        this.lnkMaterialMediator = new MaterialMediador();
        this.lnkMaterialCollection = ((Biblioteca) lnkSistema.getLnkBiblioteca().get("Inform�tica")).getLnkMaterial();
        this.lnkExemplar = Factory.createKeyExemplar(request,
                this.lnkErrosCollection);
        this.lnkMaterial = this.lnkMaterialMediator.getMaterial(request,
                lnkErrosCollection);
        if (lnkMaterial == null) {
            lnkErrosCollection.add("Erro: material n�o cadastrado.");
        } else {
            this.lnkExemplar.setLnkrevMaterial(lnkMaterial);
        }

        this.lnkExemplar = this.lnkMaterialCollection.get(lnkMaterial.getKey()).getLnkExemplar().get(lnkExemplar.getKey());
        if (lnkErrosCollection.isEmpty()) {
            if (this.lnkExemplar == null) {
                mensagem = "Recupera��o mal sucedida!";
                mensagem += "\nErro: exemplar n�o est� cadastrado.";
            }
        } else {
            Iterator iter = lnkErrosCollection.iterator();
            mensagem = "Recupera��o mal sucedida!";
            while (iter.hasNext()) {
                mensagem = mensagem.concat("\n" + (String) iter.next());
            }
        }
        request.getSession().setAttribute("exemplar", lnkExemplar);
        request.getSession().setAttribute("mensagem", mensagem);
        return lnkExemplar;
    }
}