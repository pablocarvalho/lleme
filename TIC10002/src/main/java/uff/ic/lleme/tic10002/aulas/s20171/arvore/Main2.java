package uff.ic.lleme.tic10002.aulas.s20171.arvore;

public class Main2 {

    public static void main(String[] args) {

        ArvoreUtil.No sub = ArvoreUtil.cria("-");
        ArvoreUtil.No nult1 = ArvoreUtil.filho_dir(sub, "*");
        ArvoreUtil.No nult2 = ArvoreUtil.filho_esq(sub, "*");
    }
}
