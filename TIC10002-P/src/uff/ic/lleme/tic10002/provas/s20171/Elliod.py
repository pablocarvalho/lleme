'''
Created on 5 de mai de 2017

@author: lapaesleme
'''
primeiro = True

def quickSort(lista):
    global primeiro

    if len(lista) <= 1:
        return lista
    else:
        menor, igual, maior = ([] for i in range(3))
        pivo = lista[0]
        for i in lista:
            if i < pivo:
                menor.append(i)
            elif i == pivo:
                igual.append(i)
            elif i > pivo:
                maior.append(i)

        if (primeiro == True):
            print ("\nPrimeiro Estagio: {}".format(lista))
            print ("Segundo Estagio: {}".format(menor + igual + maior))
            primeiro = False

        return quickSort(menor) + igual + quickSort(maior)

print ("Ultimo Estagio:   {}".format(quickSort([7, 81, 14, 52, 31, 43, 4, 3, 7, 31])))
print ("fim")
