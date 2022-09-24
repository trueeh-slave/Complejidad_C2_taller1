package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    JPanel panel = new JPanel();
    JTextPane areaTexto = new JTextPane();
    JCheckBox checkBox = new JCheckBox("Diferenciar Mayus/minus");
    JScrollPane scrollPane = new JScrollPane(areaTexto);
    JButton leer;
    JButton kmp;
    JButton bm;

    public Window(){
        setVisible(true);
        setSize(700,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Prueba");
        iniciarComponentes();
    }

    private void iniciarComponentes(){

        panel.setLayout(null);
        this.getContentPane().add(panel);
        areaDeTexto();
        botones();
    }

    private void botones(){

        leer = new JButton("Leer");
        leer.setActionCommand("LEERARCHIVO");
        kmp = new JButton("KMP");
        bm = new JButton("BM");


        leer.setBounds(50,50,100,50);
        kmp.setBounds(200,50,100,50);
        bm.setBounds(350,50,100,50);


        panel.add(leer);
        panel.add(kmp);
        panel.add(bm);
    }

    public void areaDeTexto(){
        areaTexto.setBounds(50,150,400,250);
        areaTexto.setEditable(false);
        scrollPane.setBounds(50,150,400,250);
        checkBox.setBounds(50,400, 200,50);
        panel.add(checkBox);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane);

    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JTextPane getAreaTexto() {
        return areaTexto;
    }

    public void setAreaTexto(JTextPane areaTexto) {
        this.areaTexto = areaTexto;
    }

    public JCheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(JCheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public JButton getLeer() {
        return leer;
    }

    public void setLeer(JButton leer) {
        this.leer = leer;
    }

    public JButton getKmp() {
        return kmp;
    }

    public void setKmp(JButton kmp) {
        this.kmp = kmp;
    }

    public JButton getBm() {
        return bm;
    }

    public void setBm(JButton bm) {
        this.bm = bm;
    }
}
