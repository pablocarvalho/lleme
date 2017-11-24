/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.cleirisson_silva;

/**
 *
 * @author clerissonss
 */
public class ArvoreUtil_Filial {

    public static NoArvoreFilial pai(NoArvoreFilial no) {
        if (no != null)
            return no.getPai();
        return null;
    }

    public static NoArvoreFilial filhoEsquerdo(NoArvoreFilial no) {
        if (no != null)
            return no.getfE();
        return null;
    }

    public static NoArvoreFilial filhoDireito(NoArvoreFilial no) {
        if (no != null)
            return no.getfD();
        else
            return null;
    }

    public static double visite(NoArvoreFilial no, int cod_filial1, int cod_filial2) {
        if (no != null && no.getChave() >= cod_filial1 && no.getChave() <= cod_filial2)
            return no.getListaVenda().buscarTotalVendidoFilial();
        return 0.0;
    }

    public static double visiteDataFilial(NoArvoreFilial no, int cod_filial1, int cod_filial2, int anoMesMenor, int anoMesMaior) {
        if (no != null && no.getChave() >= cod_filial1 && no.getChave() <= cod_filial2)
            return no.getListaVenda().buscarTotalVendidoPorData(anoMesMenor, anoMesMaior);
        return 0.0;
    }

    public static double em_ordemFilial(NoArvoreFilial no, int cod_filial1, int cod_filial2) {
        double total = 0;

        /**
         * ***************************************************************************************
         ** retorna de forma ordenada as filiais, percorrendo somente filiais
         * contidas no intervalo requisitado**
         * *************************************************************************
         */
        if (no != null) {

            double aux1 = 0, aux2 = 0, aux3 = 0;
            if (no.getChave() <= cod_filial2)
                aux1 = em_ordemFilial(filhoDireito(no), cod_filial1, cod_filial2);

            aux2 = visite(no, cod_filial1, cod_filial2);

            if (no.getChave() >= cod_filial1)
                aux3 = em_ordemFilial(filhoEsquerdo(no), cod_filial1, cod_filial2);
            return aux1 + aux2 + aux3;
        }
        return 0;
    }

    public static double em_ordemDataFilial(NoArvoreFilial no, int cod_filial1, int cod_filial2, int anoMesMenor, int anoMesMaior) {
        double total = 0;
        /**
         * *************************************************************************
         ** retorna de forma ordenada as filiais, percorrendo somente filiais
         * contidas no intervalo requisitado de datas requisitados**
         * *************************************************************************
         */

        if (no != null) {

            double aux1 = 0, aux2 = 0, aux3 = 0;
            if (no.getChave() <= cod_filial2)
                aux1 = em_ordemDataFilial(filhoDireito(no), cod_filial1, cod_filial2, anoMesMenor, anoMesMaior);

            aux2 = visiteDataFilial(no, cod_filial1, cod_filial2, anoMesMenor, anoMesMaior);

            if (no.getChave() >= cod_filial1)
                aux3 = em_ordemDataFilial(filhoEsquerdo(no), cod_filial1, cod_filial2, anoMesMenor, anoMesMaior);
            return aux1 + aux2 + aux3;
        }
        return 0;
    }
}
