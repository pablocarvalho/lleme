package uff.ic.lleme.tic10002.aulas.arvores.estrutural;

public class ExpressaoMatematica {

    public static void main(String[] args) {
        NoBinario subtracao = Operacao.cria("-");
        NoBinario multiplicacao1 = Operacao.filhoDir(subtracao, "*");
        NoBinario a = Operacao.filhoDir(multiplicacao1, "a");
        NoBinario b = Operacao.filhoEsq(multiplicacao1, "b");
        NoBinario multiplicacao2 = Operacao.filhoEsq(subtracao, "*");
        NoBinario adicao = Operacao.filhoDir(multiplicacao2, "+");
        NoBinario f = Operacao.filhoDir(adicao, "f");
        NoBinario g = Operacao.filhoEsq(adicao, "g");
        NoBinario e = Operacao.filhoEsq(multiplicacao2, "e");

        System.out.println(Operacao.preOrdem(subtracao));
        System.out.println(Operacao.emOrdem(subtracao));
        System.out.println(Operacao.posOrdem(subtracao));
    }
}
