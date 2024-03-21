def Decimal_Binario(decimal):
    binario = ""
    mascara = 1 << 31  # Máscara para extraer el bit más significativo

    for i in range(32):  # 32 bits en Python
        if decimal & mascara != 0:
            binario += "1"  # Si el bit en la posición i es 1, agregamos '1' al resultado
        else:
            binario += "0"  # Si el bit en la posición i es 0, agregamos '0' al resultado

        mascara >>= 1  # Desplazamos la máscara un bit a la derecha

    return binario


# Ejemplo de uso
decimal = int(input("Ingrese el número decimal: "))
binario = Decimal_Binario(decimal)
print(f"El número decimal {decimal} en binario es: {binario}")
