package aulaenlanube.tema9.ejemplos;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ejemplo_JTextField {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Ejemplo de uso JTextField");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());  

        // Crea un JTextField
        JTextField textField = new JTextField(10); // 10 es el ancho

        // Crea un JButton
        JButton boton = new JButton("Pulsa");

        // Agrega un ActionListener al botón para manejar el clic
        boton.addActionListener(e -> {
            // Cuando el botón se presiona, imprime el texto actual del JTextField
            System.out.println("Texto introducido: " + textField.getText());
        });
        
        // Agrega el JTextField y JButton al frame
        ventana.add(textField);
        ventana.add(boton);
        ventana.setVisible(true);

    }

}