package uff.ic.lleme.tic10002.trabalhos.s20171.Raphael_Bernardino;

/**
 * @author bernardino
 */
public class MapaHash {

    private final int TAM = 13;
    private final EntradaHash tab[] = new EntradaHash[TAM];
    private int colisoes = 0;

    private int calculaHash(int h) {
        return h ^ (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
    }

    private int encontraPosicaoHash(int hash) {
        return hash & (TAM - 1);
    }

    public void adicionaValor(String chave, Double valor) {
        adiciona("tudo", valor);
        adiciona(chave, valor);
    }

    private void adiciona(String c, Double v) {
        int hash = calculaHash(c.hashCode());
        int pos = encontraPosicaoHash(hash);
        EntradaHash e = tab[pos];

        while (e != null) {
            if (e.getChave().equals(c)) {
                e.incValor(v);
                return;
            } else
                //System.out.println("[!] Colisão detectada para a chave " + c + ", adicionando no final da lista.");
                colisoes++;

            e = e.proximo();
        }

        //System.out.println("[-] Adicionando chave: " + c + ", valor: " + v);
        EntradaHash hme = new EntradaHash(c, v);
        hme.setProximo(tab[pos]);
        tab[pos] = hme;
    }

    public EntradaHash busca(String c) {
        int hash = calculaHash(c.hashCode());
        int bucket = encontraPosicaoHash(hash);
        EntradaHash e = tab[bucket];

        // Se existe algum hash igual ao da chave, percorre a lista
        while (e != null) {
            //System.out.println("Percorrendo a lista do hash " + hash + " em busca da chave " + e.getChave());
            if (e.getChave().equals(c))
                return e;
            e = e.proximo();
        }

        // se não encontrou, retorna null
        return null;
    }

    public String[] getChaves() {
        String out = "";
        for (EntradaHash e : tab)
            if (e != null && !e.getChave().equals("tudo"))
                for (; e != null; e = e.proximo())
                    out += e.getChave() + ", ";
        return out.split(", ");
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < tab.length; i++)
            if (tab[i] != null) {
                out += i + "[ " + tab[i].toString() + " ]";
                if (i < tab.length - 1)
                    out += ", ";
            }
        return out;
    }
}
