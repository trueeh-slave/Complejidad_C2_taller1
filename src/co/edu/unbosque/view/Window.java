package co.edu.unbosque.view;

import javax.swing.*;

public class Window {
    JFrame principal = new JFrame("test");

    public Window(){
        principal.setVisible(true);
        principal.setSize(500,500);
        principal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        principal.setLocationRelativeTo(null);

        JButton btnRead = new JButton("Clic para leer el archivo");
        int test;
    }

}
