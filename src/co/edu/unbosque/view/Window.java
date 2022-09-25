package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    JPanel panel = new JPanel();
    static JTextPane areaTexto = new JTextPane();

    JCheckBox checkBox = new JCheckBox("Diferenciar Mayus/minus");
    JTextField patron = new JTextField();
    JLabel texto = new JLabel("Ingrese el patron:");

    static JScrollPane scrollPane = new JScrollPane(areaTexto);

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
        kmp.setActionCommand("KMP");

        bm = new JButton("BM");
        bm.setActionCommand("BM");



        leer.setBounds(150,50,100,50);
        kmp.setBounds(300,50,100,50);
        bm.setBounds(450,50,100,50);
        patron.setBounds(152,550,200,40);
        texto.setBounds(50,550,200,40);


        panel.add(leer);
        panel.add(kmp);
        panel.add(bm);
        panel.add(patron);
        panel.add(texto);
    }

    public void areaDeTexto(){
        areaTexto.setBounds(50,150,400,600);
        areaTexto.setEditable(false);
        scrollPane.setBounds(50,150,600,350);
        checkBox.setBounds(50,500, 200,50);
        panel.add(checkBox);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
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

    public JTextField getPatron() {
        return patron;
    }

    public void setPatron(JTextField patron) {
        this.patron = patron;
    }

    public JLabel getTexto() {
        return texto;
    }

    public void setTexto(JLabel texto) {
        this.texto = texto;
    }

    public static JScrollPane getScrollPane() {
        return scrollPane;
    }

    public static void setScrollPane(JScrollPane scrollPane) {
        Window.scrollPane = scrollPane;
    }
}
