/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public class Vista {

    public void mostrarPosicionComida(int[] posComida) {
        System.out.println("Comida:" + posComida[0] + " " + posComida[1]);
    }

    public void mostrarPosicionSnake(int[] posCabeza, ArrayList<int[]> posCuerpo, int[] posCola) {
        /*System.out.println("Cabeza:" + posCabeza[0] + posCabeza[1]);
        System.out.println("Cuerpo:");
        for (int[] coordenada : posCuerpo) {
            System.out.println(coordenada[0] + " " + coordenada[1]);
        }
        System.out.println("Cola:" + posCola[0] + posCola[1]);
        */
    }

    public void mostrarTablero(int filas, int columnas, int[] posCabeza, ArrayList<int[]> posCuerpo, int[] posCola,
            int[] posComida, char direccion) {
        // Construye una cadena para imprimir el tablero
        StringBuilder tablero = new StringBuilder();

        // Recorrer cada fila y columna del tablero
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Manejar bordes del tablero
                if (i == 0 || i == filas - 1 || j == 0 || j == columnas - 1) {
                    tablero.append("|");
                }
                // Manejar comida
                else if (i == posComida[0] && j == posComida[1]) {
                    tablero.append("#");
                }
                // Manejar cabeza de la serpiente
                else if (i == posCabeza[0] && j == posCabeza[1]) {
                    tablero.append(obtenerSimboloCabeza(direccion));
                }
                // Manejar cuerpo de la serpiente
                else if (esCuerpo(posCuerpo, i, j)) {
                    tablero.append("o");
                }
                // Manejar cola de la serpiente
                else if (i == posCola[0] && j == posCola[1]) {
                    tablero.append("o");
                }
                // Espacio vacío
                else {
                    tablero.append(" ");
                }
            }
            tablero.append("\n");
        }

        // Imprimir el tablero construido
        System.out.print(tablero.toString());
    }

    // Método para verificar si una posición coincide con alguna parte del cuerpo de
    // la serpiente
    private boolean esCuerpo(ArrayList<int[]> posCuerpo, int i, int j) {
        for (int[] coordenada : posCuerpo) {
            if (coordenada[0] == i && coordenada[1] == j) {
                return true;
            }
        }
        return false;
    }

    // Método para obtener el símbolo de la cabeza de la serpiente según la
    // dirección
    private char obtenerSimboloCabeza(char direccion) {
        switch (direccion) {
            case 'd':
                return '>';
            case 'w':
                return '^';
            case 'a':
                return '<';
            case 's':
                return 'v';
            default:
                return ' ';
        }
    }

    public void limpiarPantalla() {
        try {
            // Verifica el sistema operativo
            String os = System.getProperty("os.name");
            ProcessBuilder pb;

            if (os.contains("Windows")) {
                // Comando para limpiar la pantalla en Windows
                pb = new ProcessBuilder("cmd", "/c", "cls");

            } else {
                // Comando para limpiar la pantalla en Unix (Linux/macOS)
                pb = new ProcessBuilder("clear");
            }

            // Inicia el proceso para ejecutar el comando
            pb.inheritIO();
            Process process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
