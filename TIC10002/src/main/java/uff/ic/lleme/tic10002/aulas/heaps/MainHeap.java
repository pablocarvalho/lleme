package uff.ic.lleme.tic10002.aulas.heaps;

import javax.naming.LimitExceededException;

public class MainHeap {

    public static void main(String[] args) throws LimitExceededException {
        Tarefa t1 = new Tarefa("t1");
        Tarefa t2 = new Tarefa("t2");
        Tarefa t3 = new Tarefa("t3");
        Tarefa t4 = new Tarefa("t4");
        Tarefa t5 = new Tarefa("t5");
        Tarefa t6 = new Tarefa("t6");
        Tarefa t7 = new Tarefa("t7");
        Tarefa t8 = new Tarefa("t8");
        Tarefa t9 = new Tarefa("t9");

        Heap hp = new Heap();
        hp.incluir(t1, 95);
        hp.incluir(t2, 60);
        hp.incluir(t3, 78);
        hp.incluir(t4, 39);
        hp.incluir(t5, 28);
        hp.incluir(t6, 66);
        hp.incluir(t7, 70);
        hp.incluir(t8, 33);
        hp.printHeap();

        hp.alterarPrioridade(5, 1);
        hp.printHeap();
        //hp.alterarPrioridade(0, 66);
        //hp.remover();
        //hp.printHeap();
    }
}
