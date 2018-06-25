from classCliente import Cliente
from classEstatisticas import Estatisticas
from classHeapNo import Heap
from datetime import datetime
from time import sleep

class PF(object):
    def __init__(self):
        self.fila = Heap()
        self.estatisticas = Estatisticas()
        print('\nPolicia Federal aberta.')
        #sleep(2)

    def recepcionar(self, cliente):
        self.cliente = cliente
        self.horaChegada = datetime.now()
        self.fila.inserir(self.cliente, self.horaChegada)
        print(f'\n{self.cliente.nome} chegou.\n')
        self.fila.estadoHeap()

    def atender(self):
        if self.fila.isEmpty() == True:
            print('\n[33mAtendimentos encerrados.')

        else:
            print(f'\nQual proximo cliente?\n')
            self.fila.estadoHeap()
            proximo = self.fila.remover()
            proximo.horaAtendimento = datetime.now()
            print(f'\n{proximo.cliente.nome} em atendimento.')

            for i in range(0, proximo.cliente.nAssuntos):
                proximo.duracaoAtendimento += proximo.cliente.assuntos[i].tempomin

            print(f'Duracao atendimento: {proximo.duracaoAtendimento} minutos.')

            for i in range(0, proximo.cliente.nAssuntos):
                self.estatisticas.contarTempo(proximo.cliente.assuntos[i].tipo, proximo.cliente.assuntos[i].tempomin)
            sleep(proximo.duracaoAtendimento)
            self.encerrar(proximo)

    def encerrar(self, proximo):
        print(f'\nProvidencia(s) para {proximo.cliente.nome}:\n')
        for i in range(0, proximo.cliente.nAssuntos):
            print(f'{i+1}: {proximo.cliente.assuntos[i].providencia}')

    def gerarEstatisticas(self):
        print('\n[33mAtendimentos encerrados.\n')
        self.estatisticas.construirHash()
        self.estatisticas.imprimirEstatisticas()


cliente1 = Cliente(124, 'Carolina', 28, ['informacoes', 'cancelar agendamento','requerimento de passaporte eletronico'])
cliente2 = Cliente(12890937763, 'Clara', 27, ['emissao de GRU', 'emissao de certidao de antecedentes criminais'])
cliente3 = Cliente(4565767, 'Alice', 55, ['credenciamento de instrutores de armamento e tiro', 'comunicacao de ocorrencia com documentos de viagem'])
cliente4 = Cliente(234654, 'Soterio', 59, ['comunicacao de ocorrencia com arma de fogo'])
cliente5 = Cliente(6565674, 'Ayla', 20, ['informacoes', 'credenciamento de instrutores de armamento e tiro'])
cliente6 = Cliente(685475, 'Laura', 30, ['Criticas', 'consultar agendamento', 'reagendar fotografia','requerimento de passaporte para estrangeiro'])
cliente7 = Cliente(685475, 'Lara', 29, ['porte de arma de fogo'])

policia_federal = PF()

# Carolina chega
policia_federal.recepcionar(cliente1)

#sleep(1)
# Clara chega
policia_federal.recepcionar(cliente2)

#sleep(1)
# Alice chega
policia_federal.recepcionar(cliente3)

#sleep(1)
# Soterio chega
policia_federal.recepcionar(cliente4)

#sleep(1)
# Proximo eh atendido
policia_federal.atender()

# Ayla chega
policia_federal.recepcionar(cliente5)

#sleep(1)
# Proximo eh atendido
policia_federal.atender()

# Proximo eh atendido
policia_federal.atender()

# Proximo eh atendido
policia_federal.atender()

# Laura chega
policia_federal.recepcionar(cliente6)

#sleep(1)
# Proximo eh atendido
policia_federal.atender()

#Lara chega
policia_federal.recepcionar(cliente7)

# Proximo eh atendido
policia_federal.atender()

# Proximo eh atendido
policia_federal.atender()

#Estatisticas
policia_federal.gerarEstatisticas()