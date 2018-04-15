package uff.ic.lleme.tic10002.aulas.s20181.arvores.estruturais;

public class Operacao {

    public static NoBinario cria(String conteudo) {
        return new NoBinario(conteudo);
    }

    public static String visite(NoBinario no) {
        if (no != null) {
            return no.conteudo + " ";
        } else {
            return null;
        }
    }

    public static NoBinario esquerda(NoBinario no) {
        if (no != null) {
            return no.esquerda;
        } else {
            return null;
        }
    }

    public static NoBinario direita(NoBinario no) {
        if (no != null) {
            return no.direita;
        } else {
            return null;
        }
    }

    public static NoBinario pai(NoBinario no) {
        if (no != null) {
            return no.pai;
        } else {
            return null;
        }
    }

    public static NoBinario irmao(NoBinario no) {
        if (no != null && pai(no) != null) {
            if (esquerda(pai(no)) == no) {
                return direita(pai(no));
            } else {
                return esquerda(pai(no));
            }
        }
        return null;
    }

    public static boolean ehEsq(NoBinario no) {
        if (no != null && pai(no) != null) {
            return esquerda(pai(no)) == no;
        } else {
            return false;
        }
    }

    public static boolean ehDir(NoBinario no) {
        if (no != null && pai(no) != null) {
            return direita(pai(no)) == no;
        } else {
            return false;
        }
    }

    public static NoBinario filhoEsq(NoBinario no, String conteudo) {
        if (esquerda(no) == null) {
            NoBinario filho = cria(conteudo);
            filho.pai = no;
            no.esquerda = filho;
            return filho;
        } else {
            return null;
        }
    }

    public static NoBinario filhoDir(NoBinario no, String conteudo) {
        if (direita(no) == null) {
            NoBinario filho = cria(conteudo);
            filho.pai = no;
            no.direita = filho;
            return filho;
        } else {
            return null;
        }
    }

    public static String preOrdem(NoBinario no) {
        if (no != null) {
            return visite(no) + preOrdem(direita(no)) + preOrdem(esquerda(no));
        } else {
            return "";
        }
    }

    public static String emOrdem(NoBinario no) {
        if (no != null) {
            return emOrdem(direita(no)) + visite(no) + emOrdem(esquerda(no));
        } else {
            return "";
        }
    }

    public static String posOrdem(NoBinario no) {
        if (no != null) {
            return posOrdem(direita(no)) + posOrdem(esquerda(no)) + visite(no);
        } else {
            return "";
        }
    }

}
