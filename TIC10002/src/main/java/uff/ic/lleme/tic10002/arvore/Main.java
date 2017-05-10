package uff.ic.lleme.tic10002.arvore;

public class Main {

    public static void main(String[] args) {
        ArvoreUtil.No subtracao = ArvoreUtil.cria("-");
        ArvoreUtil.No multiplicacao1 = ArvoreUtil.filho_dir(subtracao, "*");
        ArvoreUtil.No a = ArvoreUtil.filho_dir(multiplicacao1, "a");
        ArvoreUtil.No b = ArvoreUtil.filho_esq(multiplicacao1, "b");
        ArvoreUtil.No multiplicacao2 = ArvoreUtil.filho_esq(subtracao, "*");
        ArvoreUtil.No adicao = ArvoreUtil.filho_dir(multiplicacao2, "+");
        ArvoreUtil.No f = ArvoreUtil.filho_dir(adicao, "f");
        ArvoreUtil.No g = ArvoreUtil.filho_esq(adicao, "g");
        ArvoreUtil.No e = ArvoreUtil.filho_esq(multiplicacao2, "e");

        System.out.println(ArvoreUtil.em_ordem(subtracao));
    }
}
