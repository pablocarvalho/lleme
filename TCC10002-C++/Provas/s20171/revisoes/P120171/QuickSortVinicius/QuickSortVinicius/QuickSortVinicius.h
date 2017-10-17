#ifndef EXERCICIOS_CPP_QUICKSORT_H
#define EXERCICIOS_CPP_QUICKSORT_H


class QuickSortVinicius {
    int tam = 10;
    int vetor[10] = {7,81,14,52,31,43,4,3,7,31};
    int troca (int i, int j);

public:
	QuickSortVinicius();
    int ordena();
    int ordena(int inicio, int fim);
    void imprime();
    int escolhe_pivo(int inicio, int fim);

};


#endif //EXERCICIOS_CPP_QUICKSORT_H
