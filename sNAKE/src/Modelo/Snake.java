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
public class Snake {

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
}
