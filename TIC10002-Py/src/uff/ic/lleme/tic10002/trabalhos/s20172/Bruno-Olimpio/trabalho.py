# -*- coding: utf-8 -*-
"""
Created on Mon Nov  6 17:59:51 2017

@author: Bruno
"""

# -*- coding: utf-8 -*-
"""
Created on Mon Oct 16 14:20:17 2017

@author: Bruno Olímpio
"""

### Trabalho 1 ED ###

import csv
from AVL import AVL

def processaFluxos(arquivo):
    with open(arquivo, newline='') as csvfile:
        fluxos = csv.reader(csvfile,delimiter=',');
        for row in fluxos:
            dia = int(row[2]);
            setor = row[0];
            fluxo = int(row[3]);
#            print(row);    
            atualizaMapaDia(dia, setor, fluxo);


    
def atualizaMapaDia(dia, setor, fluxo): 
    setorDia = setor + str(dia)
    mapaFluxo = [[fluxo, setorDia]]
#    print(mapaFluxo)
    i = hash(setorDia)
    tabelaHash[i] = mapaFluxo
    fluxoTotal = mapaFluxo[0][0]
    if not fluxoTotal:
        fluxoTotal = 0;       
    fluxoTotal = fluxoTotal + fluxo 
#    mapaFluxo.update({setor: fluxoTotal})
#    mapaDia.update({dia: mapaFluxo})

tabelaHash = [[0 for i in range(10)]for i in range(50)];
def hash(setorDia):
    soma = 0
    for i in range(len(setorDia)):
        soma = soma + ord(setorDia[i])
    hashSetorDia = soma%len(tabelaHash)
    return(hashSetorDia)

def calculaDelta(minFluxo, maxFluxo):
    delta = maxFluxo - minFluxo;
    print("minFluxo: {} ---- maxFluxo: {} ---- Delta: {} \n".format(minFluxo,maxFluxo, delta))
    return delta       

def criaLimite(minFluxo,delta):
    limite = minFluxo + int(0.8 * delta)
    return limite

############### --------------------- #################
    
arvore = AVL()
processaFluxos('fluxo.csv')
for mapaFluxo in tabelaHash:
    if (mapaFluxo[0]) != 0:
        arvore.inclui(mapaFluxo[0][0], mapaFluxo[0][1])

arvore.imprime()
minFluxo = arvore.percorre()[0]
maxFluxo = arvore.percorre()[-1]
delta = calculaDelta(minFluxo, maxFluxo)
lim = criaLimite(minFluxo, delta)
arvore.relatorioLimite(lim)
