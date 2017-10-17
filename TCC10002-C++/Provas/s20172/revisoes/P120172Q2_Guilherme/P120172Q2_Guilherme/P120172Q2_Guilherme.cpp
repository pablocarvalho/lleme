#include<iostream>
#include<stdlib.h>
#include "stdafx.h"

using namespace std;

typedef struct sNo {
	int valor;
	struct sNo *prox;
}No;

bool vazia(No *no) {
	return(no == NULL);
}

bool inicializar(No **no) {
	*no = NULL;
	return(true);
}

No* novoNo() {
	return((No*)malloc(sizeof(No)));
}

bool inserirInicio(No **no, int valor) {
	No *novo = novoNo();
	if (novo == NULL)
		return(false);
	novo->valor = valor;
	novo->prox = NULL;
	if (!vazia(*no)) {
		novo->prox = *no;
	}
	*no = novo;
	return(true);
}

bool inserirFim(No **no, int valor) {
	if (vazia(*no))
		return(inserirInicio(no, valor));

	No *aux = *no;
	No *novo = novoNo();
	if (novo == NULL)
		return(false);
	novo->valor = valor;
	novo->prox = NULL;
	while (aux->prox != NULL)
		aux = aux->prox;
	aux->prox = novo;
	return(true);
}

void funcao(No **no, No *aux, int *i) {
	if (no == NULL)
		return;
	if (aux == NULL)
		aux = *no;
	if (aux->valor >= 0) {
		*i = -1;
		funcao(no, aux->prox, i);
		if ((*i >= 0) && (*i < 5)) {
			*i += 1;
			cout << aux->valor << " ";
			aux->prox = NULL;
			free(aux);
		} if ((*i == 5) && (*no != NULL)) {
			cout << endl;
			aux = NULL;
			funcao(no, aux, i);
		}
	}
	else {
		*i = 0;
		*no = aux->prox;
		aux->prox = NULL;
		free(aux);
	}
}

int main() {
	No *no;
	int i;
	inicializar(&no);

	inserirFim(&no, 2);
	inserirFim(&no, 1);
	inserirFim(&no, 9);
	inserirFim(&no, 5);
	inserirFim(&no, 3);
	inserirFim(&no, -1);
	inserirFim(&no, 3);
	inserirFim(&no, 9);
	inserirFim(&no, 88);
	inserirFim(&no, 4);
	inserirFim(&no, 9);
	inserirFim(&no, -2);
	inserirFim(&no, 83);
	inserirFim(&no, 9);
	inserirFim(&no, -2);
	inserirFim(&no, 9);
	inserirFim(&no, 4);
	inserirFim(&no, 3);
	inserirFim(&no, 1);
	inserirFim(&no, 3);

	funcao(&no, no, &i);
	cout << endl;

	return(0);
}
