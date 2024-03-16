def fibonacci(n):
    if n == 1:
        return 1
    elif n == 2:
        return 1
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)


n = int(input("Ingrese el número para calcular su fibonacci: "))
print(f"El fibonacci de {n} es {fibonacci(n)}")