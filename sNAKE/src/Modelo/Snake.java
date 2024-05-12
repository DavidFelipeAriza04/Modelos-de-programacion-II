/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public class Snake implements Movible {

    private Cabeza cabeza;
    private Cuerpo cuerpo;
    private Cola cola;
    
    public Snake(int[] posicionCabeza, ArrayList<int[]> posicionCuerpo, int[] posicionCola) {
        this.cabeza = new Cabeza(posicionCabeza);
        this.cuerpo = new Cuerpo(posicionCuerpo);
        this.cola = new Cola(posicionCola);
    }

    public int[] getCabeza() {
        return cabeza.getPosicionCabeza();
    }

    public void setCabeza(int[] posCabeza) {
        this.cabeza.setPosicionCabeza(posCabeza);
    }

    public ArrayList<int[]> getCuerpo() {
        return cuerpo.getPosicionCuerpo();
    }

    public void setCuerpo(ArrayList<int[]> posCuerpo) {
        this.cuerpo.setPosicionCuerpo(posCuerpo);
    }

    public int[] getCola() {
        return cola.getPosicionCola();
    }

    public void setCola(int[] posCola) {
        this.cola.setPosicionCola(posCola);
    }

    public void comer(Comida comida) {
        cuerpo.getPosicionCuerpo().add(comida.getPosicion());
    }

    @Override
    public void mover(char mov, int[] posicionComida) {
        if (this.getCabeza() == posicionComida) {
            System.out.println("Comiendo");
        }
        int[] cabezaAnterior = this.getCabeza().clone();
        ArrayList<int[]> posicionCuerpoAnterior = (ArrayList<int[]>) this.getCuerpo().clone();

        // Mueve la cabeza según la dirección de movimiento
        switch (mov) {
            case 'd': // Derecha
                this.setCabeza(new int[] { cabezaAnterior[0], cabezaAnterior[1] + 1 });
                break;
            case 'w': // Arriba
                this.setCabeza(new int[] { cabezaAnterior[0] - 1, cabezaAnterior[1] });
                break;
            case 'a': // Izquierda
                this.setCabeza(new int[] { cabezaAnterior[0], cabezaAnterior[1] - 1 });
                break;
            case 's': // Abajo
                this.setCabeza(new int[] { cabezaAnterior[0] + 1, cabezaAnterior[1] });
                break;
            default:
                break;
        }

        ArrayList<int[]> posicionCuerpo = this.getCuerpo();

        for (int i = 0; i < posicionCuerpo.size(); i++) {
            int[] posAnterior = i == 0 ? cabezaAnterior : posicionCuerpoAnterior.get(i - 1);
            posicionCuerpo.set(i, posAnterior);
        }

        this.setCola(posicionCuerpoAnterior.get(posicionCuerpo.size() - 1));

    }
}
