# -*- coding: utf-8 -*-
"""
Created on Sun Nov  5 20:46:31 2017

@author: Bruno
"""

class No():
    def __init__(self, chave=None, valor=None, esquerda = None, direita = None):
        self.valor = []
        self.chave = chave
        self.valor.append(valor)
        self.esquerda = esquerda
        self.direita = direita
        
    def retornaValor(self, chave):
        if self.chave == chave:
            print("Fluxo: {} --> Dia-setor: {}".format(self.chave, self.valor))
            
        elif self.chave < chave:
            self.direita.retornaValor(chave)
            
        elif self.chave > chave:
            self.esquerda.retornaValor(chave)
            
#    def retornaMin(self):
#        if self.esquerda.no:
#            self.esquerda.no.retornaMin()
#        else:
#            minFluxo = self.chave
#
#    def retornaMax(self):
#        if self.direita:
#            self.direita.no.retornaMax(self)
#        else:
#            maxFluxo = self.chave
#        return maxFluxo
#    
class AVL():
    def __init__(self):
        self.no = None
        self.altura = -1
        self.saldo = 0
    
    def inclui(self, chave, valor):
        no = No(chave, valor)  
        
        if self.no == None:
            self.no = no
            self.no.esquerda = AVL()
            self.no.direita = AVL()
        elif chave < self.no.chave:
            self.no.esquerda.inclui(chave, valor)
        elif chave > self.no.chave:
            self.no.direita.inclui(chave, valor)
        elif self.no.chave == chave:
            self.no.valor.append(valor)
        self.equilibra()
        
    def remove(self, chave):
        if self.no != None:
            if self.no.chave == chave:
                if not self.no.esquerda.no and not self.no.direita.no:
                    self.no = None
                    
                elif not self.no.direita.no:
                    self.no = self.no.esquerda.no
                    
                elif not self.no.esquerda.no:
                    self.no = self.no.direita.no
                    
                else:
                    sucessor = self.no.direita.no
                    while sucessor and sucessor.esquerda.no:
                        sucessor = sucessor.esquerda.no
                        
                    if sucessor:
                        self.no.chave = sucessor.chave
                        self.no.direita.remove(sucessor.chave)
                        
            elif chave < self.no.chave:
                self.no.esquerda.remove(chave)
                
            elif chave > self.no.chave:
                self.no.direita.remove(chave)
            
            self.equilibra()
            
    def equilibra(self):
        self.atualizaAlturas(recursiva=False)
        self.atualizaSaldos(False)

        while self.saldo < -1 or self.saldo > 1:
            if self.saldo > 1:
                if self.no.esquerda.saldo < 0:
                    self.no.esquerda.trocaEsquerda()
                    self.atualizaSaldos()
                    self.atualizaAlturas()
                self.trocaDireita()
                self.atualizaSaldos()
                self.atualizaAlturas()
            if self.saldo < -1:
                if self.node.direita.saldo > 0:
                    self.no.direita.trocaDireita()
                    self.atualizaSaldos()
                    self.atualizaAlturas()
                self.trocaEsquerda()
                self.atualizaSaldos()
                self.atualizaAlturas()             
    
    def atualizaSaldos(self, recursiva=True):
        if self.no:
            if recursiva:
                if self.no.esquerda:
                    self.no.esquerda.atualizaSaldos()
                if self.no.direita:
                    self.no.direita.atualizaSaldos()
            self.saldo = self.no.esquerda.saldo - self.no.direita.saldo
        else:
            self.saldo = 0
#        print("Saldo = {}".format(self.saldo))
            
    def atualizaAlturas(self, recursiva=True):
        if self.no:
            if recursiva:
                if self.no.esquerda:
                    self.no.esquerda.atualizaAlturas()
                if self.no.direita:
                    self.no.direita.atualizaAlturas()
            self.altura = 1 + max(self.no.direita.altura, self.no.esquerda.altura)
        else:
            self.altura = -1
            
    def trocaEsquerda(self):
        novo_raiz = self.no.direita.no
        novo_esquerda = novo_raiz.esquerda.no
        raiz = self.no
        self.no = novo_raiz
        raiz.direita.no = novo_esquerda
        novo_raiz.esquerda.no = raiz

    def trocaDireita(self):
        novo_raiz = self.no.esquerda.no
        novo_esquerda = novo_raiz.direita.no
        raiz = self.no
        self.no = novo_raiz
        raiz.esquerda.no = novo_esquerda
        novo_raiz.direita.no = raiz
        
    def percorre(self):
        resultado = []
        if not self.no:
            return resultado
        resultado.extend(self.no.esquerda.percorre())
        resultado.append(self.no.chave)
        resultado.extend(self.no.direita.percorre())
        return resultado
    
    def imprime(self, no=None, nivel=0):
        if not no:
            no = self.no

        if no.direita.no:
            self.imprime(no.direita.no, nivel + 1)
            print(('\t' * nivel), ('    /'))
            
        print(('\t' * nivel), no.chave)
        
        if no.esquerda.no:
            print(('\t' * nivel), ('    \\'))
            self.imprime(no.esquerda.no, nivel + 1)
            
        
    def relatorioLimite(self,limite):
        relatorio = []
        resultado = self.percorre()
        for chave in resultado:
            if chave > limite:
                relatorio.append(chave)
        print("Os fluxos maiores do que o limite de {} são: {}".format(limite,relatorio))
        for chave in relatorio:
            self.retornaValor(chave)
        
    def retornaValor(self, chave):
        self.no.retornaValor(chave)
        
    def retornaMin(self):
        return self.no.retornaMin
    
    def retornaMax(self):
        self.no.retornaMax
        
