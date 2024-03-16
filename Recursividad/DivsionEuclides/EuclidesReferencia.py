def euclides(n):
    if n[0] % n[1] == 0:
        return n[1]
    else:
        n[0],n[1] = n[1],(n[0] % n[1])
        return euclides(n)


n1 = int(input("Ingrese el primer número: "))
n2 = int(input("Ingrese el segundo número: "))
numeros = [n1, n2]
print(euclides(numeros))