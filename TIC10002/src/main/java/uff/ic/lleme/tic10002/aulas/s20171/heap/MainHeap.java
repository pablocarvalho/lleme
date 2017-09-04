package uff.ic.lleme.tic10002.aulas.s20171.heap;

import javax.naming.LimitExceededException;
import uff.ic.lleme.tic10002.aulas.s20171.Tarefa;

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
        hp.inserir(t1, 95);
        hp.inserir(t2, 60);
        hp.inserir(t3, 78);
        hp.inserir(t4, 39);
        hp.inserir(t5, 28);
        hp.inserir(t6, 66);
        hp.inserir(t7, 70);
        hp.inserir(t8, 33);
        //hp.inserir(t9, 73);
        hp.printHeap();

        //hp.alterarPrioridade(5, 98);
        //hp.printHeap();
        //hp.alterarPrioridade(0, 66);
        //hp.remover();
        //hp.printHeap();
    }
}
