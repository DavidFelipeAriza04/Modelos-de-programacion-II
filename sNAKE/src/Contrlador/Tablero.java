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
public class Tablero extends Thread {

    private Snake snake;
    private Comida comida = new Comida();
    private int columnas = 15;
    private int filas = 15;
    private Vista vista;
    private Controles control;
    private ArrayList<int[]> posicionCuerpo;
    private int posicionCabeza[];
    private int posicionCola[];
    public Tablero() {
        vista = new Vista();
        posicionCuerpo = new ArrayList<>();
        posicionCuerpo.add(new int[] { (int) (filas / 2), (int) ((columnas / 2) - 1) });
        posicionCabeza = new int[]{ (int) (filas / 2), (int) (columnas / 2) };
        posicionCola = new int[]{ (int) (filas / 2), (int) ((columnas / 2) - posicionCuerpo.size() - 1) };
        snake = new Snake(posicionCabeza, posicionCuerpo, posicionCola);
        control = new Controles();
        crearComida();
        this.start();
    }

    public void crearComida() {
        int x = new Random().nextInt(1, columnas - 1);
        int y = new Random().nextInt(1, filas - 1);
        int posicion[] = { y, x };
        comida.setPosicion(posicion);
    }

    public void run() {
        control.start();
        try {
            while (true) {
                char d = control.obtenerDireccion();
                // vista.mostrarPosicionComida(comida.getPosicion());
                vista.mostrarPosicionSnake(snake.getCabeza(), snake.getCuerpo(), snake.getCola());

                if (snake.getCabeza()[1] + 1 == 14) {
                    snake = new Snake(posicionCabeza, posicionCuerpo, posicionCola);
                } else {
                    snake.setCabeza(new int[] { snake.getCabeza()[0], snake.getCabeza()[1] + 1 });

                    for (int[] pos : snake.getCuerpo()) {
                        pos[1] += 1;
                    }
                    snake.setCola(new int[] { snake.getCola()[0], snake.getCola()[1] + 1 });
                }

                vista.mostrarTablero(filas, columnas, snake.getCabeza(), snake.getCuerpo(), snake.getCola(),
                        comida.getPosicion());
                this.sleep(1000);
                vista.limpiarPantalla();
                System.out.print(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
