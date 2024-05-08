/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contrlador;

import Modelo.Comida;
import Modelo.Snake;
import Vista.Vista;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Estudiantes
 */
public class Tablero {

    private Snake snake;
    private Comida comida = new Comida();
    private int columnas = 15;
    private int filas = 15;
    private Vista vista;

    public Tablero() {
        vista = new Vista();
        ArrayList<int[]> posicionCuerpo = new ArrayList<>();
        posicionCuerpo.add(new int[]{(int) (filas / 2), (int) ((columnas / 2) - 1)});
        int posicionCabeza[] = {(int) (filas / 2), (int) (columnas / 2)};
        int posicionCola[] = {(int) (filas / 2), (int) ((columnas / 2) - posicionCuerpo.size() - 1)};
        snake = new Snake(posicionCabeza, posicionCuerpo, posicionCola);
        crearComida();
        vista.mostrarPosicionComida(comida.getPosicion());
        vista.mostrarPosicionSnake(snake.getCabeza(), snake.getCuerpo(), snake.getCola());
        vista.mostrarTablero(filas, columnas, snake.getCabeza(), snake.getCuerpo(), snake.getCola(), comida.getPosicion());
    }

    public void crearComida() {
        int x = new Random().nextInt(1, columnas - 1);
        int y = new Random().nextInt(1, filas - 1);
        int posicion[] = {y, x};
        comida.setPosicion(posicion);
    }
}
