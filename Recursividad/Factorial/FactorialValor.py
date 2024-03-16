def Factorial(num):
    if num == 0:
        return 1
    else:
        return num * Factorial(num - 1)

num = int(input("Ingrese un numero para calcular su factorial: "))
factorial = Factorial(num)
print(f"El factorial de {num} es {factorial}")