package uff.ic.lleme.tic10002.trabalhos._20171.diogoperdomo;

public class Hash {

    ListaFilial[] HashTable = new ListaFilial[100];
    ListaFilial l_data = new ListaFilial(0);
    ListaFilial l_conjuntos = new ListaFilial(0);

    public void insertHash(ListaFilial Lista) {
        int chave = Lista.getChave();
        int indice = chave % 100;

        if (HashTable[indice] == null)
            HashTable[indice] = Lista;
        else {
            Lista.proxlista = HashTable[indice];
            HashTable[indice] = Lista;

        }
    }

    public void insertHash_data(ListaFilial Lista) {

        //percorrer lista e colocar na lista de conjuntos
        ListaFilial.No no = Lista.getPrimeiroNo();
        while (no != null) {
            l_conjuntos.incluir(no.Filial, no.Ano_mes, no.cod_vendedor, no.totalvendido);
            no = no.atras;
        }

    }

    public void limpa_lista() {
        l_data.proxlista = null;
        l_conjuntos.limpa();

    }

    public double pesquisaHash(int chave) {
        int indice = chave % 100;
        ListaFilial lista;
        double total = 0.0;

        if (HashTable[indice] != null) {
            //System.out.println("INCICE = " + indice);
            lista = HashTable[indice];
            while (lista != null) {
                total += lista.imprime_lista();
                lista = lista.proxlista;
            }
        }

        return total;
    }

    public boolean pesquisaHash_join(int chave) {
        int indice = chave % 100;
        ListaFilial lista;
        lista = HashTable[indice];

        while (lista != null) {
            if (lista.getChave() == chave)
                return true;
            lista = lista.proxlista;
        }

        return false;
    }

    public double imprime_hash_join(Hash hash) {
        return l_conjuntos.imprime_lista_2(hash);
    }
}
