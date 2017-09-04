package uff.ic.lleme.tic10002.aulas.s20171.heap;

import javax.naming.LimitExceededException;
import uff.ic.lleme.tic10002.aulas.s20171.Tarefa;

public class MainHeapMinMax {

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
        Tarefa t10 = new Tarefa("t10");
        Tarefa t11 = new Tarefa("t11");
        Tarefa t12 = new Tarefa("t12");
        Tarefa t13 = new Tarefa("t13");
        Tarefa t14 = new Tarefa("t14");
        Tarefa t15 = new Tarefa("t15");

        HeapMinMax hp = new HeapMinMax();
        hp.inserir(t1, 4);
        hp.inserir(t2, 70);
        hp.inserir(t3, 38);
        hp.inserir(t4, 20);
        hp.inserir(t5, 8);
        hp.inserir(t6, 35);
        hp.inserir(t7, 19);
        hp.inserir(t8, 30);
        hp.inserir(t9, 28);
        hp.inserir(t10, 18);
        hp.inserir(t11, 25);
        hp.inserir(t12, 36);
        hp.inserir(t13, 37);
        hp.inserir(t14, 26);
        hp.inserir(t15, 22);
        hp.printHeap();

        //hp.alterarPrioridade(5, 98);
        //hp.printHeap();
        //hp.alterarPrioridade(0, 66);
        //hp.remover();
        //hp.printHeap();
    }
}
