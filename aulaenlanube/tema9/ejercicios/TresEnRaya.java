package aulaenlanube.tema9.ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TresEnRaya extends JFrame {

    private int ronda = 0;
    private boolean jugadorAzul = true;
    private JButton[][] tablero = new JButton[3][3];

    public TresEnRaya() {

        // título, tamaño y layout manager
        this.setTitle("Tres en raya");
        this.setSize(400, 400);
        this.setLayout(new GridLayout(3, 3));

        // creamos los 9 botones y los añadimos al tablero
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = new JButton();
                tablero[i][j].addActionListener(e -> jugar(e));
                this.add(tablero[i][j]);
            }
        }

        // cierre y visibilidad
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void jugar(ActionEvent e) {

        // obtenemos el botón que se ha pulsado
        JButton botonPulsado = (JButton) e.getSource();

        // si juega el AZUL
        if (jugadorAzul) {
            botonPulsado.setBackground(Color.BLUE);
            botonPulsado.setEnabled(false);
            jugadorAzul = false;
        }
        // si juega el ROJO
        else {
            botonPulsado.setBackground(Color.RED);
            botonPulsado.setEnabled(false);
            jugadorAzul = true;
        }
        ronda++;
        verificarFinDelJuego();
    }

    private boolean verificar3EnRaya(JButton p1, JButton p2, JButton p3) {
        return p1.getBackground() == p2.getBackground() && p2.getBackground() == p3.getBackground()
                && (p1.getBackground() == Color.RED || p1.getBackground() == Color.BLUE);
    }

    private void verificarFinDelJuego() {

        // victoria en filas o columnas
        for (int i = 0; i < 3; i++) {
            if (verificar3EnRaya(tablero[i][0], tablero[i][1], tablero[i][2])
                    || verificar3EnRaya(tablero[0][i], tablero[1][i], tablero[2][i])) {
                victoria();
                return;
            }
        }

        // victoria con diagonales
        if (verificar3EnRaya(tablero[0][0], tablero[1][1], tablero[2][2])
                || verificar3EnRaya(tablero[0][2], tablero[1][1], tablero[2][0])) {
            victoria();
            return;
        }

        // empate
        if (ronda == 9)
            empate();
    }

    private void victoria() {
        JOptionPane.showMessageDialog(this, "El jugador " + (jugadorAzul ? "ROJO" : "AZUL") + " gana");
        reiniciarJuego();
    }

    private void empate() {
        JOptionPane.showMessageDialog(this, "Empate");
        reiniciarJuego();
    }

    private void reiniciarJuego() {

        // reiniciamos botones
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j].setEnabled(true);
                tablero[i][j].setBackground(null);
            }
        }
        // reiniciamos juego
        jugadorAzul = true;
        ronda = 0;
    }

    public static void main(String[] args) {
        new TresEnRaya();
    }
}
