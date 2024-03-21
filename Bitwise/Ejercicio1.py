
def distinto(n):
    a = 0;
    for i in n:
        a = a ^ i
    return a

print("Ingrese los numeros separados por un espacio: ")
lista =[int(x) for x in input().split()]
print(distinto(lista))