/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


/**
 *
 * @author Alejandro Penagos
 */
public class Controles extends Thread
{
    private char direccionActual = 'd';
    
    @Override
    public void run(){
        try{
            while(true){
                char input = (char) System.in.read();
                System.out.print(input);
                cambiarDireccion(input);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // Método para cambiar la dirección de la serpiente
    private synchronized void cambiarDireccion(char input) {
        if (input == 'w' && direccionActual != 's') {
            direccionActual = 'w'; // Arriba
        } else if (input == 's' && direccionActual != 'w') {
            direccionActual = 's'; // Abajo
        } else if (input == 'a' && direccionActual != 'd') {
            direccionActual = 'a'; // Izquierda
        } else if (input == 'd' && direccionActual != 'a') {
            direccionActual = 'd'; // Derecha
        }
    }

    // Método para obtener la dirección actual
    public synchronized char obtenerDireccion() {
        return direccionActual;
    }
}
