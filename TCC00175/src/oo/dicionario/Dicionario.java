package oo.dicionario;

public class Dicionario {

    private Entrada[] entradas = new Entrada[5];

    public String consultar(String vocabulo) {
        for (Entrada entrada : entradas)
            if (entrada.getVocabulo().equals(vocabulo))
                return entrada.getSignificado();
        return "*** palavra desconhecida ***";
    }

    public String excluir(String vocabulo) {
        for (int i = 0; i < entradas.length; i++)
            if (entradas[i].getVocabulo().equals(vocabulo)) {
                entradas[i] = null;
                return "vocábulo excluído";
            }
        return "*** vocábulo desconhecido ***";
    }

    public String incluir(String vocabulo, String significado) {
        for (int i = 0; i < entradas.length; i++)
            if (entradas[i] == null) {
                entradas[i] = new Entrada(vocabulo, significado);
                return "vocábulo incluído";
            }
        return "*** não há espaço ***";
    }
}
