def SubConjuntos(num):
    SubConjuntos = []
    SubConjuntosTotales = 2**num

    for i in range(SubConjuntosTotales):
        SubConjunto = []
        for j in range(num):
            if i & (1 << j):
                SubConjunto.append(j + 1)
        SubConjuntos.append(SubConjunto)

    return SubConjuntos


# Ejemplo de uso
num = int(input("Ingrese el numero: "))
SubConjuntos = SubConjuntos(num)
print("Todos los subconjuntos posibles:")
for SubConjunto in SubConjuntos:
    print(SubConjunto)
