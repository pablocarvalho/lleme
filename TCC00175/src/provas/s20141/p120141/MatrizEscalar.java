package provas.s20141.p120141;

public class MatrizEscalar<E extends Escalar<? extends Number>> extends Matriz<E> {

    public MatrizEscalar<E> produto(MatrizEscalar<E> b) {
        MatrizEscalar<E> produto = new MatrizEscalar<>();
        int linhasA = this.linhas();
        int colunasA = this.colunas();
        int linhasB = b.linhas();
        int colunasB = b.colunas();
        Escalar<? extends Number> valor = null;

        if (colunasA == linhasB)
            for (int i = 0; i < linhasA; i++)
                for (int j = 0; j < colunasB; j++)
                    for (int k = 0; k < colunasA; k++) {
                        //valor = this.get(i, k).produto(b.get(k, j));
                        //produto.set(i, j, valor);
                    }
        return produto;
    }
}
