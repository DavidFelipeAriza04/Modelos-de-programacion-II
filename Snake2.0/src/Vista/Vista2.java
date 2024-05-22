/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Estudiantes
 */
public class Vista2 extends Vista {

    static GraphicsConfiguration gc;
    public JFrame frame;
    public JPanel panel;
    private static final int TILE_SIZE = 20;
    private int[] posCabeza;
    private ArrayList<int[]> posCuerpo;
    private int[] posCola;
    private int[] posComida;

    public Vista2(int[] posCabeza, ArrayList<int[]> posCuerpo, int[] posCola,
            int[] posComida) {
        this.posCabeza = posCabeza;
        this.posCuerpo = posCuerpo;
        this.posCola = posCola;
        this.posComida = posComida;
        initComponents();
    }

    public void initComponents() {

        this.frame = new JFrame(gc);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }
        };
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void mostrarTablero(int filas, int columnas, int[] posCabeza, ArrayList<int[]> posCuerpo, int[] posCola,
            int[] posComida, char direccion) {
        int width = (columnas * TILE_SIZE);
        int height = (filas * TILE_SIZE);

        this.posCabeza = posCabeza;
        this.posCuerpo = posCuerpo;
        this.posCola = posCola;
        this.posComida = posComida;

        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        panel.setPreferredSize(new Dimension(width, height));
        panel.setFocusable(true);
        panel.repaint();
    }

    private void draw(Graphics g) {
        // Dibujar el fondo
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, panel.getWidth(), panel.getHeight());

        // Dibujar la comida
        g.setColor(Color.RED);
        g.fillRect(posComida[1] * TILE_SIZE, posComida[0] * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        // Dibujar la serpiente
        g.setColor(Color.BLUE);
        g.fillRect(posCabeza[1] * TILE_SIZE, posCabeza[0] * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        g.setColor(Color.GREEN);
        for (int[] pos : posCuerpo) {
            g.fillRect(pos[1] * TILE_SIZE, pos[0] * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
        g.fillRect(posCola[1] * TILE_SIZE, posCola[0] * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

}
