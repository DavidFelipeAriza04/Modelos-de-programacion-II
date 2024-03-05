def Factorial(num):
    if num == 0:
        print(id(num))
        return 1
    else:
        print(id(num))
        return num * Factorial(num - 1)


num = int(input("Ingrese un numero para calcular su factorial: "))
print(f"{id(num)} num")
factorial = Factorial(num)
print(f"El factorial de {num} es {factorial}")