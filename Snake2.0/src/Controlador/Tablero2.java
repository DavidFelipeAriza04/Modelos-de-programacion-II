/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Comida;
import Modelo.Snake;
import Vista.Vista2;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Estudiantes
 */
public class Tablero2 extends Tablero implements KeyListener {

    protected Snake snake;
    protected Comida comida;
    protected final int columnas = 40;
    protected final int filas = 20;
    protected Vista2 vista;
    protected ArrayList<int[]> posicionCuerpo;
    protected ArrayList<int[]> posicionInicialCuerpo;
    protected int posicionCabeza[];
    protected int posicionCola[];
    protected char d = 'd';
    private int dx = 1; // Dirección x inicial
    private int dy = 0; // Dirección y inicial

    @Override
    public void iniciar() {
        posicionInicialCuerpo = new ArrayList<>();
        iniciarSnake(posicionInicialCuerpo);
        this.comida = new Comida();
        crearComida();
        this.vista = new Vista2(snake.getCabeza(), snake.getCuerpo(), snake.getCola(), comida.getPosicion());
        this.vista.frame.addKeyListener(this);
        this.start();
    }

    // VALIDA TODAS LA COLICIONES
    @Override
    public Boolean colision() {
        int[] cabeza = snake.getCabeza();
        int[] cola = snake.getCola();
        if ((cabeza[0] == cola[0] && cabeza[1] == cola[1])
                || (snake.getCabeza()[0] <= 0 || snake.getCabeza()[1] <= 0 || snake.getCabeza()[1] >= columnas - 1
                || snake.getCabeza()[0] >= filas - 1)) {
            return true;
        }
        for (int[] cuerpo : snake.getCuerpo()) {
            if (cabeza[0] == cuerpo[0] && cabeza[1] == cuerpo[1]) {
                return true;
            }
        }
        return false;
    }

    // GENERA LA POCICION INICIAL DE LA SERPIENTE
    @Override
    public void iniciarSnake(ArrayList<int[]> posicionInicialCuerpo) {
        posicionCabeza = new int[]{(int) (filas / 2), (int) (columnas / 2)};
        for (int i = 1; i <= 3; i++) {
            posicionInicialCuerpo.add(new int[]{(int) (filas / 2), (int) ((columnas / 2) - i)});
        }
        posicionCuerpo = (ArrayList<int[]>) posicionInicialCuerpo.clone();
        posicionCola = new int[]{(int) (filas / 2), (int) ((columnas / 2) - posicionCuerpo.size() - 1)};
        snake = new Snake(posicionCabeza, posicionCuerpo, posicionCola);
    }

    // RESTSBLECE EL JUEGO
    @Override
    public void restablecerSnake() {
        posicionCuerpo = (ArrayList<int[]>) posicionInicialCuerpo.clone();
        snake = new Snake(posicionCabeza, posicionCuerpo, posicionCola);
        d = 'd';
        dy = 0;
        dx = 1;
        crearComida();
    }

    @Override
    public void crearComida() {
        int x = (new Random().nextInt(this.columnas - 2) + 1);
        int y = (new Random().nextInt(filas - 3) + 1);
        int posicion[] = {y, x};
        comida.setPosicion(posicion);
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (colision()) {
                    restablecerSnake();
                } else {
                    if (snake.getCabeza()[0] == comida.getPosicion()[0]
                            && snake.getCabeza()[1] == comida.getPosicion()[1]) {
                        snake.comer(comida);
                        crearComida();
                    } else {
                        for (int[] cuerpo : snake.getCuerpo()) {
                            if (cuerpo[0] == comida.getPosicion()[0] && cuerpo[1] == comida.getPosicion()[1]) {
                                snake.comer(comida);
                                crearComida();
                                break;
                            }
                        }
                    }
                    snake.mover(d, comida.getPosicion());
                }
                vista.mostrarTablero(filas, columnas, snake.getCabeza(), snake.getCuerpo(), snake.getCola(),
                        comida.getPosicion(), d);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (dy != 1) {
                    dx = 0;
                    dy = -1;
                    d = 'w';
                }
                break;
            case KeyEvent.VK_DOWN:
                if (dy != -1) {
                    dx = 0;
                    dy = 1;
                    d = 's';

                }
                break;
            case KeyEvent.VK_LEFT:
                if (dx != 1) {
                    dx = -1;
                    dy = 0;
                    d = 'a';

                }
                break;
            case KeyEvent.VK_RIGHT:
                if (dx != -1) {
                    dx = 1;
                    dy = 0;
                    d = 'd';
                }
                break;
        }
        snake.mover(d, comida.getPosicion());
        vista.mostrarTablero(filas, columnas, snake.getCabeza(), snake.getCuerpo(), snake.getCola(),
                comida.getPosicion(), d);
    }
}
