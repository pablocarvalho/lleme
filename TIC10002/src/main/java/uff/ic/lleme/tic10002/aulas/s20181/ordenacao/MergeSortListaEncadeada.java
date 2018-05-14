package uff.ic.lleme.tic10002.aulas.s20181.ordenacao;

public class MergeSortListaEncadeada {

    private No pripeiro;

    private class No {

        int data = 0;
        No next = null;
    }

    public No mergeSort(No primeiro) {
        if (primeiro == null || primeiro.next == null)
            return primeiro;

        No middle = meio(primeiro);
        No nextofMiddle = middle.next;
        middle.next = null;

        No left = mergeSort(primeiro);
        No right = mergeSort(nextofMiddle);

        No sortdList = merge(left, right);

        return sortdList;
    }

    private No merge(No esquerda, No direita) {
        if (esquerda == null)
            return direita;

        if (direita == null)
            return esquerda;
        No temp = null;
        if (esquerda.data < direita.data) {
            temp = esquerda;
            temp.next = merge(esquerda.next, direita);
        } else {
            temp = direita;
            temp.next = merge(esquerda, direita.next);
        }

        return temp;
    }

    private No meio(No head) {
        No slow = head;
        No fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
