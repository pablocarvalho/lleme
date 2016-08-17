package provas.s20141.p220141;

import java.util.HashMap;
import java.util.Map;

public abstract class Estado {

    private int num = 1;
    private static String[][] transicoes = null;
    private static Map<Integer, Estado> estados = new HashMap();

    public Estado(int num) {
        if (num >= 0) {
            this.num = num;
            estados.put(num, this);
        } else
            throw new IndexOutOfBoundsException();
    }

    public int obterNum() {
        return num;
    }

    public static void ajustarTransicoes(String[][] transicoes) {
        int numEventos = obterNumEventos();
        if (transicoes != null 
                && transicoes.length == transicoes[0].length
                && transicoes.length == numEventos 
                && transicoes[0].length == numEventos)
            Estado.transicoes = transicoes;
        else
            throw new IndexOutOfBoundsException();
    }

    public Estado proximoEstado(String palavra) {
        for (int j = 0; j < transicoes[0].length; j++)
            if (palavra != null && transicoes[obterNum()][j].equals(palavra))
                return estados.get(j);
        return this;
    }

    private static int obterNumEventos() {
        int maxKey = -1;
        for (int key : estados.keySet())
            if (key > maxKey)
                maxKey = key;
        return maxKey + 1;
    }

    public abstract String decodificar();

}
