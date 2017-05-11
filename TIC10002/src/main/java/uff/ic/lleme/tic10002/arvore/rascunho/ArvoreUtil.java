package uff.ic.lleme.tic10002.arvore.rascunho;

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
        return no.conteudo;
    }

    public static No esquerda(No no) {
        return no.esquerda;
    }

    public static No direita(No no) {
        return no.direita;
    }

    public static No pai(No no) {
        return no.pai;
    }

    public static No irmao(No no) {
        if (eh_esq(no))
            return no.pai.direita;
        else
            return no.pai.esquerda;
    }

    public static boolean eh_esq(No no) {
        if (no.pai.esquerda == no)
            return true;
        else
            return false;
    }

    public static boolean eh_dir(No no) {

    }

    public static No filho_esq(No no, String conteudo) {
        No filho = new No(conteudo);
        if (no.esquerda == null) {
            no.esquerda = filho;
            filho.pai = no;
            return filho;
        } else
            filho = null;
        return filho;
    }

    public static No filho_dir(No no, String conteudo) {

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

    public static String em_ordem(No no) {

    }

    public static String pos_ordem(No no) {

    }

}
