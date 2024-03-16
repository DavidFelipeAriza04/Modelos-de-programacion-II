def fibonacci(n, memo={}):
    if n in memo:
        return memo[n]
    elif n <= 2:
        return 1
    else:
        memo[n] = fibonacci(n-1, memo) + fibonacci(n-2, memo)
        return memo[n]
    
n = int(input("Ingrese el número para calcular su fibonacci: "))
print(f"El fibonacci de {n} es {fibonacci(n)}")