#include "stdafx.h" 
#include <stdio.h>
#include <iostream>

using namespace std;

int a[10] = { 7,81,14,52,31,43,4,3,7,31 };

void imprime() {
	for (int i = 0; i < 10; i++) {
		cout << a[i] << "   ";
	}
	cout << "\n";
}

int partition(int e, int d) {
	int v, i, j;
	v = a[d]; i = e - 1; j = d; int t;
	do {
		do {
			i = i + 1; /* esquerda*/
		} while ((a[i]<v) && (i<d));

		do {
			j = j - 1; /* direita*/
		} while ((a[j] > v) && (j > 0));

		t = a[i]; a[i] = a[j]; a[j] = t;
		imprime();


	} while (j > i);

	a[j] = a[i]; a[i] = a[d]; a[d] = t;
	imprime();

	return (i);
}

void quicksort(int e, int d) {
	int i;

	if (d > e) {
		i = partition(e, d); /* importante */
		quicksort(e, i - 1);
		quicksort(i + 1, d);
	}
}


int main() {
	imprime();
	quicksort(0, 9);
	imprime();
	return 0;
}

