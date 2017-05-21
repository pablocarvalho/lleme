class No:
    def __init__(self, val, esq=None, dir=None):
        self.val = val
        self.esq = esq
        self.dir = dir


# algoritmo de insercao arvore binaria
def insere(A, val):
    if A is None:  # caso base
        return No(val)  # retorna o novo noh
    else:
        if A.val > val:  # insere esquerda
            # devo descer a arvore ???
            A.esq = insere(A.esq, val)
        else:
            A.dir = insere(A.dir, val)

        return A


def buscaMMval(aux):  # # busca o valor mais a direita do noh (se existir)
    while aux.dir is not None:
        aux = aux.dir
    return aux.val

# Algoritmo de REMOCAO
def remove(A, val):
    if A is not None:
        if A.val < val:  # procurar valor na subarvore a direita
            A.dir = remove(A.dir, val)
        elif A.val > val:  # procurar valor na subarvore a esquerda
            A.esq = remove(A.esq, val)
        else:  # valor encontrado
            if A.esq is None and A.dir is None:  # remove folha
                A = None  # deleta A

            elif A.esq is not None:  # existe subarvore a esquerda: buscar maior menor valor
                mmVal = buscaMMval(A.esq)
                A.val = mmVal
                A.esq = remove(A.esq, mmVal)
            else:  # existe suarvore a direita e nao a esquerda
                A = A.dir

    return A


def visita(A):
    print (A.val)


def percorre(A, n):
    if A is not None:
        percorre(A.esq, n + 1)

        for i in range(n):
            print ("\t"),
        visita(A)

        percorre(A.dir, n + 1)


A = None
op = 0
while (op != 4):
    op = int(input("Digite a opcao:\n1-Inserir\n2-Imprimir\n3-Remover\n4-Sair\n"))
    if op == 1:
        val = int(input("Digite o novo valor:\n"))
        A = insere(A, val)
    elif op == 2:
        percorre(A, 0)
    elif op == 3:
        val = int(input("Digite o valor:\n"))
        A = remove(A, val)
