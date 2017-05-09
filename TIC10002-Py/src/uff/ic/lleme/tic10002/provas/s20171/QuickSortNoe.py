class Object:
    def __init__(self, key=None, name=None):
        self.name = name
        self.key = key
        self.tipo = "foda-se"
    def name(self, name):
        self.name = name
    def key(self, key):
        self.key = key

def printlista(lista):
    for i in lista:
        print('\n', i.key)

def swap(List, a, b):
    temp = List[a]
    List[a] = List[b]
    List[b] = temp

def quicksort(List, left, right):
    if left < right:
        print("\nNova Chamada:")
        printlista(List)
        q = partition(List, left, right)
        quicksort(List, left, q - 1)
        quicksort(List, q + 1, right)

def partition(List, left, right):
    x = List[right]
    i = left - 1
    for j in range(left, right):
        if List[j].key <= x.key:
            i += 1
            swap(List, i, j)
    swap(List, i + 1, right)
    return i + 1

class node:
    def __init__(self, new):
        self.target = new
        self.next = None
        self.previous = None

class Lista:
    def __init__(self):
        self.actual = None
        self.n = 0
    def push(self, newObject):
        new = node(newObject)
        if self.n == 0:
            self.n += 1
            self.actual = new
            new.next = new
            new.previous = new
        else:
            temp = self.actual.previous
            temp.next = new
            new.previous = temp
            new.next = self.actual
            self.actual.previous = new
            self.n += 1
    def search(self, key):
        ref = self.actual
        if self.actual.target.key == key:
            return temp
        self.actual = self.actual.next
        while self.actual != ref:
            if self.actual.target.key == key:
                return self.actual
            self.actual = self.actual.next
        return None
    def pop(self, key):
        if self.search(key):
            temp = self.actual
            self.actual = self.actual.next
            temp.previous.next = self.actual
            self.actual.previous = temp.previous
            self.n -= 1
            return temp
        return None
    def printlinked(self):
        ref = self.actual
        print(self.actual.target.key)
        self.actual = self.actual.next
        while self.actual != ref:
            print(self.actual.target.key)
            self.actual = self.actual.next

# Instâncias de teste de lista encadeada
novalista = Lista()
novalista.push(Object(7))
novalista.push(Object(8))
novalista.push(Object(4))
novalista.push(Object(5))
novalista.push(Object(9))
novalista.push(Object(1))
novalista.push(Object(11))
novalista.push(Object(10))
novalista.push(Object(6))
novalista.push(Object(12))
novalista.push(Object(3))


