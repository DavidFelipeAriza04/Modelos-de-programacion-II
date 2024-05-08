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
public class Cuerpo {

    private ArrayList<int[]> posicionesCuerpo;

    public Cuerpo(ArrayList<int[]> posicionesCuerpo) {
        this.posicionesCuerpo = posicionesCuerpo;
    }

    public ArrayList<int[]> getPosicionCuerpo() {
        return posicionesCuerpo;
    }

    public void setPosicionCuerpo(ArrayList<int[]> posicionCuerpo) {
        this.posicionesCuerpo = posicionCuerpo;
    }

}
