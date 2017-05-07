#include "stdafx.h"
#include <iostream>
#include "QuickSort.h"


using namespace std;

int main() {
	QuickSort Lista;
	cout << "Vetor Original: ";
	Lista.imprime();
	Lista.ordena();
	cout << "\n\nFinal" << endl;
	return 0;
}