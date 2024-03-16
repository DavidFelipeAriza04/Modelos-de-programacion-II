def Factorial(num, resultado):
    if num == 1:
        return
    else:
        resultado[0] *= num
        Factorial(num-1, resultado)

resultado = [1]
num = int(input(f"Ingrese un numero para calcular su factorial: "))
Factorial(num, resultado)
print(f"El factorial de {num} es {resultado[0]}")