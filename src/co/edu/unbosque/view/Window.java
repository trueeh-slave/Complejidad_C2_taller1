package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    JPanel panel = new JPanel();


    public Window(){
        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Prueba");
        iniciarComponentes();

        JButton btnRead = new JButton("Clic para leer el archivo");
        int test;
    }

    private void iniciarComponentes(){

        panel.setLayout(null);
        this.getContentPane().add(panel);
        botones();
    }

    private void botones(){

        JButton leer = new JButton("Leer");
        JButton kmp = new JButton("KMP");
        JButton bp = new JButton("BP");
        JTextArea areaTexto = new JTextArea();

        leer.setBounds(50,50,100,50);
        kmp.setBounds(200,50,100,50);
        bp.setBounds(350,50,100,50);
        areaTexto.setBounds(500,50,100,100);
        areaTexto.setBackground(Color.BLACK);

        panel.add(leer);
        panel.add(kmp);
        panel.add(bp);
        panel.add(areaTexto);


    }

}
