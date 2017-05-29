#include "stdafx.h"
#include "QuickSortVinicius.h"
#include <iostream>
using namespace std;

QuickSortVinicius::QuickSortVinicius() {

}

int QuickSortVinicius::ordena() {

    return ordena(0, tam-1);


}
int QuickSortVinicius::ordena(int inicio, int fim){
    if (inicio <= fim){
        int k = escolhe_pivo(inicio,fim);
        int pivo = vetor[k++];
        int i = inicio;
        int j = fim;

        while (i< j){
            while(vetor[i] < pivo) i++;
            while(vetor[j] >= pivo) j--;

            if (i<j){
                troca(i,j);
                if ((vetor[i] != pivo) || (vetor[(inicio+fim)/2] == pivo))i++;
                if ((vetor[j] != pivo) || (vetor[(inicio+fim)/2] == pivo))j--;
                if ((k >= 5)) k = k-1;
            }

            //DIDATICO
            //cout << "\npivo: " << pivo << endl;
            //for (int l = 0; l < tam; ++l) {
            //    cout << vetor[l] << ", ";
            //}

        }


        if (j>inicio) ordena(inicio,k);
        if (i<fim) ordena(k+1,fim);
    }
    return 0;
}

int QuickSortVinicius::troca(int i, int j) {
    int aux = vetor[i];
    vetor[i] = vetor[j];
    vetor[j] = aux;
	imprime();
    return 0;
}

void QuickSortVinicius::imprime() {
    for (int i = 0; i < tam; i++) {
        cout << vetor[i] << "\t" ;
    }
	cout << "\n";
}

int QuickSortVinicius::escolhe_pivo(int inicio, int fim) {
    int p = (inicio+fim)/2;
    if ((inicio >= 5) && (fim <=7))troca(inicio,fim);
    return  p;

}
