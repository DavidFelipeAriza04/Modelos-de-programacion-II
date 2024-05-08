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
        System.out.println("Cabeza:" + posCabeza[0] + posCabeza[1]);
        System.out.println("Cuerpo:");
        for (int[] coordenada : posCuerpo) {
            System.out.println(coordenada[0] + " " + coordenada[1]);
        }
        System.out.println("Cola:" + posCola[0] + posCola[1]);
    }

    public void mostrarTablero(int rows, int cols, int[] posCabeza, ArrayList<int[]> posCuerpo, int[] posCola, int[] posComida) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    System.out.print("||");
                } else if (i == posComida[0] && j == posComida[1]) {
                    System.out.print("# ");
                } else {
                    if (i == posCabeza[0] && j == posCabeza[1]) {
                        System.out.print("> ");
                    } else if (i == posCola[0] && j == posCola[1]) {
                        System.out.print(" 0");
                    } else {
                        for (int[] coor : posCuerpo) {
                            if (i == coor[0] && j == coor[1]) {
                                System.out.print("==");
                            }
                            if (i != coor[0] || j != coor[1]) {
                                System.out.print("  ");
                            }
                        }
                    }
                }
            }
            System.out.print("\n");
        }
    }
}
