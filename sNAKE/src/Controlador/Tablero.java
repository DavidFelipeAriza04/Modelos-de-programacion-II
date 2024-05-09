/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

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
    private int columnas = 40;
    private int filas = 20;
    private Vista vista;
    private Controles control;
    private ArrayList<int[]> posicionCuerpo;
    private int posicionCabeza[];
    private int posicionCola[];

    public Tablero() {
        vista = new Vista();
        posicionCabeza = new int[] { (int) (filas / 2), (int) (columnas / 2) };
        System.out.println(posicionCabeza[0] + " " + posicionCabeza[1]);
        posicionCuerpo = new ArrayList<>();
        posicionCuerpo.add(new int[] { (int) (filas / 2), (int) ((columnas / 2) - 1) });
        posicionCuerpo.add(new int[] { (int) (filas / 2), (int) ((columnas / 2) - 2) });
        posicionCuerpo.add(new int[] { (int) (filas / 2), (int) ((columnas / 2) - 3) });
        posicionCola = new int[] { (int) (filas / 2), (int) ((columnas / 2) - posicionCuerpo.size() - 1) };
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

    public void moverSerpiente(char mov) {
        int[] cabezaAnterior = snake.getCabeza().clone();
        ArrayList<int[]> posicionCuerpoAnterior = (ArrayList<int[]>) snake.getCuerpo().clone();

        int[] colaAnterior = snake.getCola().clone();

        // Mueve la cabeza según la dirección de movimiento
        switch (mov) {
            case 'd': // Derecha
                snake.setCabeza(new int[] { cabezaAnterior[0], cabezaAnterior[1] + 1 });
                break;
            case 'w': // Arriba
                snake.setCabeza(new int[] { cabezaAnterior[0] - 1, cabezaAnterior[1] });
                break;
            case 'a': // Izquierda
                snake.setCabeza(new int[] { cabezaAnterior[0], cabezaAnterior[1] - 1 });
                break;
            case 's': // Abajo
                snake.setCabeza(new int[] { cabezaAnterior[0] + 1, cabezaAnterior[1] });
                break;
            default:
                break;
        }

        ArrayList<int[]> posicionCuerpo = snake.getCuerpo();

        for(int i = 0; i < posicionCuerpo.size();i++){
            int[] posAnterior = i == 0 ?  cabezaAnterior : posicionCuerpoAnterior.get(i-1);
            posicionCuerpo.set(i, posAnterior);
        }

        snake.setCola(posicionCuerpoAnterior.get(posicionCuerpo.size()-1));


    }

    public void run() {
        control.start();
        try {
            while (true) {
                char d = control.obtenerDireccion();
                // vista.mostrarPosicionComida(comida.getPosicion());

                if (snake.getCabeza()[0] == 1 || snake.getCabeza()[1] == 1 || snake.getCabeza()[1] == columnas-2 || snake.getCabeza()[0] == filas-2) {
                    posicionCuerpo = new ArrayList<>();
                    posicionCuerpo.add(new int[] { (int) (filas / 2), (int) ((columnas / 2) - 1) });
                    snake = new Snake(posicionCabeza, posicionCuerpo, posicionCola);
                } else {
                    moverSerpiente(d);
                }
                vista.mostrarPosicionSnake(snake.getCabeza(), snake.getCuerpo(), snake.getCola());
                vista.mostrarTablero(filas, columnas, snake.getCabeza(), snake.getCuerpo(), snake.getCola(),
                        comida.getPosicion(),d);
                Thread.sleep(500);
                vista.limpiarPantalla();
                System.out.print(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
