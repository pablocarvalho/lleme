package uff.ic.lleme.tic10002.aulas.s20172.Lista;

public class FilaEstaticaComRotacaoDePonteiro {

    public int[] lista = new int[50];
    public int i = 0;
    public int j = 0;
    public int n = 0;

    private void incJ() {
        j = ++j % lista.length;
    }

    private void incI() {
        i = ++i % lista.length;
    }

    public void incluir(int num) throws Exception {
        if (n < lista.length) {
            lista[j] = num;
            n++;
            incJ();
        } else
            throw new Exception("Capacidade esgotada");
    }

    public int retirar() throws Exception {
        if (n > 0) {
            int num = lista[i];
            n--;
            incI();
            return num;
        } else
            throw new Exception("Capacidade esgotada");
    }
}
