/*
 * Trabalho de Estruturas de Dados.
 * Professor: Luis André Portes Paes Leme
 */
package uff.ic.lleme.tic10002.trabalhos.s20172.Mario_Joao;

/**
 *
 * @author Mario João Jr.
 */
public class HashTable {

    private static final int TAM = 10;
    private ListaHash[] vet = new ListaHash[TAM];

    public int hash(int setor, int dia) {
        return (setor + dia) % TAM;
    }

    public HashTable() {
        for (int i = 0; i < vet.length; i++)
            vet[i] = new ListaHash();
    }

    public TAcumulado busca(int setor, int dia) {
        int h;

        h = hash(setor, dia);

        return vet[h].buscar(setor, dia);
    }

    public boolean inserir(int setor, int dia, int fluxo) {
        TAcumulado no = new TAcumulado(setor, dia, fluxo, fluxo);
        int h;

        h = hash(setor, dia);
        vet[h].inserir(no);
        return true;
    }

    public boolean inserir(TAcumulado no) {
        int h;

        h = hash(no.setor, no.dia);
        vet[h].inserir(no);
        return true;
    }
}
