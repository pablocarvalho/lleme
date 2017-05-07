#include "stdafx.h"
#include "QuickSort.h"
#include <iostream>

using namespace std;

QuickSort::QuickSort() {

}

int QuickSort::ordena() {
	return ordena(0, tam - 1);
}
int QuickSort::ordena(int inicio, int fim) {
	if (inicio <= fim) {
		int pivo = vetor[(inicio + fim) / 2];


		int i = inicio;
		int j = fim;

		while (i< j) {
			while (vetor[i] < pivo) i++;
			while (vetor[j] > pivo) j--;

			if (i<j) {
				troca(i, j);
				if ((vetor[i] != pivo) || (vetor[(inicio + fim) / 2] == pivo))i++;
				if ((vetor[j] != pivo) || (vetor[(inicio + fim) / 2] == pivo))j--;
			}

			//DIDATICO
			cout << "\nVetor: ";
			for (int l = 0; l < tam; ++l) {
				cout << vetor[l] << "   ";
			}
			cout << "   |    pivo: " << pivo;



		}
		if (j>inicio) ordena(inicio, j - 1);
		if (i<fim) ordena(j + 1, fim - 1);
	}
	return 0;
}

int QuickSort::troca(int i, int j) {
	int aux = vetor[i];
	vetor[i] = vetor[j];
	vetor[j] = aux;
	return 0;
}

void QuickSort::imprime() {
	for (int i = 0; i < tam; i++) {
		cout << vetor[i] << "   ";
	}
}