package uff.ic.lleme.tic10002.trabalhos.s20172.Arthur_Allysson;

/**
 *
 * @author allyssoncc
 */
public class ListaEstatica {

    private Trafego[] listaObjetos;
    private int totalDeObjetos = 0;
    private Double min = null;
    private Double max = null;

    public ListaEstatica(int tam) {
        listaObjetos = new Trafego[tam];
    }

    public Double max() {
        return max;
    }

    public Double min() {
        return min;
    }

    public int tamanho() {
        return totalDeObjetos;
    }

    public boolean estaVazia() {
        return totalDeObjetos == 0;
    }

    public void adicionar(Trafego objeto) {
        Double aux;
        if (totalDeObjetos == 0)
            min = max = objeto.getFluxo();
        int posicao = pesquisar(objeto.getChave());
        if (posicao < 0) {
            listaObjetos[totalDeObjetos] = objeto;
            aux = listaObjetos[totalDeObjetos].getFluxo();
            totalDeObjetos++;
        } else {
            Double total = listaObjetos[posicao].getFluxo() + objeto.getFluxo();
            listaObjetos[posicao].setFluxo(total);
            min = max;
            aux = listaObjetos[posicao].getFluxo();
        }
        if (aux > max)
            max = aux;
    }

    public void findMin() {
        min = max;
        for (int i = 0; i < totalDeObjetos; i++)
            if (listaObjetos[i].getFluxo() < min)
                min = listaObjetos[i].getFluxo();
    }

    public void referenciar(Trafego objeto) {
//        verificarTamanhoLista();
        int posicao = pesquisar(objeto.getChave());
        if (posicao < 0) {
            listaObjetos[totalDeObjetos] = objeto.copia();
            totalDeObjetos++;
        }
    }

    public void adicionar(int posicao, Trafego objeto) {
        verificarTamanhoLista();
        if (!posicaoValida(posicao))
            System.out.println("Posicao invalida");
        for (int i = totalDeObjetos - 1; i >= posicao; i--)
            listaObjetos[i + 1] = listaObjetos[i];
        listaObjetos[posicao] = objeto;
        totalDeObjetos++;
    }

    public void remover(int chave) {
        int posicao = pesquisar(chave);
        if (posicao >= 0) {
            listaObjetos[posicao] = listaObjetos[tamanho() - 1];
            totalDeObjetos--;
        }
    }

    public void removerFluxo(double fluxo) {
        if (pesquisarFluxo(fluxo) == true) {
            int pos = retornaPos(fluxo);
            remover(pos);
        }
    }

    public int pesquisar(int chave) {
        for (int i = 0; i < totalDeObjetos; i++)
//            System.out.println(listaObjetos[i]);
            if (listaObjetos[i].getChave() == chave)
                return i;
        return -1;
    }

    public boolean pesquisarFluxo(double fluxo) {
        for (int i = 0; i < totalDeObjetos; i++)
            if (fluxo == listaObjetos[i].getFluxo())
                return true;
        return false;
    }

    public Trafego buscar(int chave) {
//        if (pos >= 0 && pos < totalDeObjetos)
//            return listaObjetos[pos];
        int posicao = pesquisar(chave);
        if (posicao >= 0)
            return listaObjetos[posicao];
        return null;
    }

    public int retornaPos(double fluxo) {
        for (int i = 0; i < totalDeObjetos; i++)
            if (fluxo == listaObjetos[i].getFluxo())
                return i;
        return -1;
    }

    public void imprimirLista() {
        for (int i = 0; i < this.totalDeObjetos; i++)
            System.out.print(this.obter(i));
        System.out.println();
    }

    public void imprimirListaLn() {
        for (int i = 0; i < this.totalDeObjetos; i++)
            System.out.println(this.obter(i));
    }

    public Trafego obter(int posicao) {
        if (!posicaoOcupada(posicao))
            System.out.println("Posicao invalida");
        return listaObjetos[posicao];
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < totalDeObjetos;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= totalDeObjetos;
    }

    private void verificarTamanhoLista() {
        if (totalDeObjetos == listaObjetos.length) {
            Trafego[] novaArray = new Trafego[listaObjetos.length * 2];

            for (int i = 0; i < listaObjetos.length; i++)
                novaArray[i] = listaObjetos[i];
            listaObjetos = novaArray;
        }
    }
}
