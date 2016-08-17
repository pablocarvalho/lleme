package provas.s20141.vr20141.q2;

public class Colecao<T extends Comparavel> {

    private No<T> primeiro;
    private No<T> ultimo;

    public void incluir(T objeto) {
        if (objeto != null)
            if (ultimo == null) {
                No<T> novoNo = new No(null, null, objeto);
                primeiro = novoNo;
                ultimo = novoNo;
            } else {
                No<T> corrente = primeiro;
                //insere conforme ordem
                while (corrente != null) {
                    if (objeto.comparar(corrente.objeto) < 0) {
                        No<T> novoNo = new No(corrente.anterior, corrente, objeto);
                        if (corrente.anterior != null)
                            corrente.anterior.proximo = novoNo;
                        corrente.anterior = novoNo;
                        if (corrente == primeiro)
                            primeiro = novoNo;
                        return;
                    }
                    corrente = corrente.proximo;
                }
                //se nao for menor do nehum existente insere no final
                No<T> novoNo = new No(ultimo, null, objeto);
                ultimo.proximo = novoNo;
                ultimo = novoNo;
            }
    }

    public void imprimir() {
        No<T> corrente = this.primeiro;
        System.out.print("{");
        while (corrente != null) {
            if (corrente.proximo != null)
                System.out.print(corrente.objeto.toString() + ",");
            else
                System.out.print(corrente.objeto.toString() + "");
            corrente = corrente.proximo;
        }
        System.out.println("}");
    }

}
