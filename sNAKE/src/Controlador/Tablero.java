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
    private ArrayList<int[]> posicionInicialCuerpo;
    private int posicionCabeza[];
    private int posicionCola[];
    private char d;

    public Tablero() {
        vista = new Vista();
        posicionCabeza = new int[] { (int) (filas / 2), (int) (columnas / 2) };
        System.out.println(posicionCabeza[0] + " " + posicionCabeza[1]);
        posicionInicialCuerpo = new ArrayList<>();
        posicionInicialCuerpo.add(new int[] { (int) (filas / 2), (int) ((columnas / 2) - 1) });
        posicionInicialCuerpo.add(new int[] { (int) (filas / 2), (int) ((columnas / 2) - 2) });
        posicionInicialCuerpo.add(new int[] { (int) (filas / 2), (int) ((columnas / 2) - 3) });
        posicionCuerpo = (ArrayList<int[]>) posicionInicialCuerpo.clone();
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
        if (snake.getCabeza() == comida.getPosicion()) {
            System.out.println("Comiendo");
        }
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

        for (int i = 0; i < posicionCuerpo.size(); i++) {
            int[] posAnterior = i == 0 ? cabezaAnterior : posicionCuerpoAnterior.get(i - 1);
            posicionCuerpo.set(i, posAnterior);
        }

        snake.setCola(posicionCuerpoAnterior.get(posicionCuerpo.size() - 1));

    }

    public void run() {
        control.start();
        try {
            while (true) {
                d = control.obtenerDireccion();
                // vista.mostrarPosicionComida(comida.getPosicion());

                if (snake.getCabeza()[0] == 0 || snake.getCabeza()[1] == 0 || snake.getCabeza()[1] == columnas - 1
                        || snake.getCabeza()[0] == filas - 1) {
                    RestablecerSnake();
                } else {
                    if (snake.getCabeza()[0] == comida.getPosicion()[0]
                            && snake.getCabeza()[1] == comida.getPosicion()[1]) {
                        snake.getCuerpo().add(comida.getPosicion());
                        crearComida();
                    }
                    moverSerpiente(d);
                }
                vista.mostrarPosicionSnake(snake.getCabeza(), snake.getCuerpo(), snake.getCola());
                vista.mostrarTablero(filas, columnas, snake.getCabeza(), snake.getCuerpo(), snake.getCola(),
                        comida.getPosicion(), d);
                Thread.sleep(300);
                vista.limpiarPantalla();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void RestablecerSnake() {
        posicionCuerpo = (ArrayList<int[]>) posicionInicialCuerpo.clone();
        snake = new Snake(posicionCabeza, posicionCuerpo, posicionCola);
        d = 'd';
    }
}
