package uff.ic.lleme.tic10002.trabalhos._20171.leandromiranda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uff.ic.lleme.tic10002.trabalhos._20171.leandromiranda.ArvoreVenda.No;

public class ImpressaoEmArvores {

    public static <T extends Comparable<?>> void imprimirNo(No raiz) {
        int maxLevel = ImpressaoEmArvores.maxLevel(raiz);

        imprimirNoInterno(Collections.singletonList(raiz), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void imprimirNoInterno(List<No> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || ImpressaoEmArvores.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        ImpressaoEmArvores.printWhitespaces(firstSpaces);

        List<No> newNodes = new ArrayList<No>();
        for (No node : nodes) {
            if (node != null) {
//            	if(node.pai() != null)
//            		System.out.print(node.getConteudoComTipo()+" , "+node.pai().getConteudoComTipo());
//            	else
            	System.out.print(node.getConteudoComTipo());
                newNodes.add(node.esquerda());
                newNodes.add(node.direita());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            ImpressaoEmArvores.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                ImpressaoEmArvores.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    ImpressaoEmArvores.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).esquerda() != null)
                    System.out.print("/e");
                else
                    ImpressaoEmArvores.printWhitespaces(1);

                ImpressaoEmArvores.printWhitespaces(i + i - 1);

                if (nodes.get(j).direita() != null)
                    System.out.print("\\d");
                else
                    ImpressaoEmArvores.printWhitespaces(1);

                ImpressaoEmArvores.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        imprimirNoInterno(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(No node) {
        if (node == null)
            return 0;

        return Math.max(ImpressaoEmArvores.maxLevel(node.esquerda()), ImpressaoEmArvores.maxLevel(node.direita())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<No> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
