package uff.ic.lleme.tic10002.arvore;

public class ArvoreUtil {

    public static class No {

        public String conteudo;
        private No pai = null;
        private No esquerda = null;
        private No direita = null;

        public No(String conteudo) {
            this.conteudo = conteudo;
        }

    }

    public static No cria(String conteudo) {
        return new No(conteudo);
    }

    public static String visite(No no) {
        if (no != null)
            return no.conteudo;
        else
            return null;
    }

    public static No esquerda(No no) {
        if (no != null)
            return no.esquerda;
        else
            return null;
    }

    public static No direita(No no) {
        if (no != null)
            return no.direita;
        else
            return null;
    }

    public static No pai(No no) {
        if (no != null)
            return no.pai;
        else
            return null;
    }

    public static No irmao(No no) {
        if (no != null && pai(no) != null)
            if (esquerda(pai(no)) == no)
                return direita(pai(no));
            else
                return esquerda(pai(no));
        return null;
    }

    public static boolean eh_esq(No no) {
        if (no != null && pai(no) != null)
            return esquerda(pai(no)) == no;
        else
            return false;
    }

    public static boolean eh_dir(No no) {
        if (no != null && pai(no) != null)
            return direita(pai(no)) == no;
        else
            return false;
    }

    public static No filho_esq(No no, String conteudo) {
        if (esquerda(no) == null) {
            No filho = cria(conteudo);
            filho.pai = no;
            no.esquerda = filho;
            return filho;
        } else
            return null;
    }

    public static No filho_dir(No no, String conteudo) {
        if (direita(no) == null) {
            No filho = cria(conteudo);
            filho.pai = no;
            no.direita = filho;
            return filho;
        } else
            return null;
    }

    public static String pre_ordem2(No no) {
        String resultado = "";
        if (no != null) {
            resultado = visite(no);
            resultado += pre_ordem2(no.direita);
            resultado += pre_ordem2(no.esquerda);
        }
        return resultado;
    }

    public static String pos_ordem2(No no) {
        String resultado = "";
        if (no != null) {
            resultado = pos_ordem2(no.direita);
            resultado += pos_ordem2(no.esquerda);
            resultado += visite(no);
        }
        return resultado;
    }

    public static String em_ordem2(No no) {
        String resultado = "";
        if (no != null) {
            resultado = em_ordem2(no.direita);
            resultado += visite(no);
            resultado += em_ordem2(no.esquerda);
        }
        return resultado;
    }

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    public static String pre_ordem(No no) {
        if (no != null)
            return visite(no) + pre_ordem(direita(no)) + pre_ordem(esquerda(no));
        else
            return "";
    }

    public static String em_ordem(No no) {
        if (no != null)
            return em_ordem(direita(no)) + visite(no) + em_ordem(esquerda(no));
        else
            return "";
    }

    public static String pos_ordem(No no) {
        if (no != null)
            return pos_ordem(direita(no)) + pos_ordem(esquerda(no)) + visite(no);
        else
            return "";
    }

}
