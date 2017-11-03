#include "stdafx.h"
#include <iostream>
#include "QuickSortVinicius.h"

using namespace std;


int main() {
	QuickSortVinicius *Lista = new QuickSortVinicius();
    Lista->imprime();
    Lista->ordena();
    cout << "fim";
    return 0;
}
