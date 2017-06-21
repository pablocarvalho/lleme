/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.cleirissonsilva;

/**
 *
 * @author clerissonss
 */
public class ArvoreUtilAno_Mes {

    public static NoArvore_AnoMes pai(NoArvore_AnoMes no) {
        if (no != null)
            return no.getPai();
        return null;
    }

    public static NoArvore_AnoMes filhoEsquerdo(NoArvore_AnoMes no) {
        if (no != null)
            return no.getfE();
        return null;
    }

    public static NoArvore_AnoMes filhoDireito(NoArvore_AnoMes no) {
        if (no != null)
            return no.getfD();
        else
            return null;
    }

    public static double visite_PorData(NoArvore_AnoMes no, int anoMesMenor, int anoMesMaior) {
        if (no != null && no.getChave() >= anoMesMenor && no.getChave() <= anoMesMaior)
            return no.getListaVenda().buscarTotalVendidoFilial();
        return 0.0;
    }

    public static double em_ordem_DeData(NoArvore_AnoMes no, int anoMesMenor, int anoMesMaior) {
        double total = 0;

        if (no != null) {

            double aux1 = 0, aux2 = 0, aux3 = 0;
            if (no.getChave() <= anoMesMaior)
                aux1 = em_ordem_DeData(filhoDireito(no), anoMesMenor, anoMesMaior);

            aux2 = visite_PorData(no, anoMesMenor, anoMesMaior);

            if (no.getChave() >= anoMesMenor)
                aux3 = em_ordem_DeData(filhoEsquerdo(no), anoMesMenor, anoMesMaior);
            return aux1 + aux2 + aux3;
        }
        return 0;
    }
}
