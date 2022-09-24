package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    JPanel panel = new JPanel();
    JTextPane areaTexto = new JTextPane();
    JCheckBox checkBox = new JCheckBox("Diferenciar Mayus/minus");


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
        areaDeTexto();
        botones();
    }

    private void botones(){

        JButton leer = new JButton("Leer");
        JButton kmp = new JButton("KMP");
        JButton bp = new JButton("BP");


        leer.setBounds(50,50,100,50);
        kmp.setBounds(200,50,100,50);
        bp.setBounds(350,50,100,50);


        panel.add(leer);
        panel.add(kmp);
        panel.add(bp);
    }

    public void areaDeTexto(){
        areaTexto.setBounds(50,150,400,250);
        panel.add(areaTexto);
        checkBox.setBounds(50,400, 200,50);
        panel.add(checkBox);

    }
}
