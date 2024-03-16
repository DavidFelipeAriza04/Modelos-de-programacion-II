def euclides(n, m):
    print(f"n: {n} m: {m}")
    if n % m == 0:
        return m
    else:
        return euclides(m, n % m)

n1 = int(input("Ingrese el primer número: "))
n2 = int(input("Ingrese el segundo número: "))
print(euclides(n1, n2))