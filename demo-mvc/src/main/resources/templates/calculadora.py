import math


def init():
    opcoes = {
        1: "Adição",
        2: "Subtração",
        3: "Divisão",
        4: "Multiplicação",
        5: "Expoente",
        6: "Raiz Quadrada",
        0: "Sair"
    }
    operacoes = {
        0: "sair",
        1: soma,
        2: subtracao,
        3: divisao,
        4: multiplicacao,
        5: expoente,
        6: raizQuad,
    }

    opcao = 9
    while opcao != 0:
        opcao = int(menu(opcoes))
        if not opcao in operacoes:
            print("opção invalida")

        elif opcao == 0:
            break
        elif opcao == 6:
            print("")
            print(
                "******* {} ********".format(operacoes[opcao](float(input("numero: ")))))
            print("")
        else:
            print("")
            print("******* {} ********".format(operacoes[opcao](float(input("primeiro numero: ")),
                                                                float(input("segundo numero: ")))))
            print("")


def menu(opcoes):
    for opcao in opcoes:
        print("{} - {}".format(opcao, opcoes[opcao]))
    return input("qual operação? ")


def soma(x, y): return x+y


def subtracao(x, y): return x-y


def multiplicacao(x, y): return x*y


def divisao(x, y): return x/y


def expoente(x, y): return x**y


def raizQuad(x): return math.sqrt(x)


init()
