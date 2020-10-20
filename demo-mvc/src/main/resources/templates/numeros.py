import random


def sequencia(tamanho):
    saida = ""
    for i in range(5):
        saida += str(random.randint(0,  9))

    print(saida)


sequencia(6)
