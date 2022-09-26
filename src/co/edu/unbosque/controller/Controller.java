package co.edu.unbosque.controller;

import co.edu.unbosque.model.BoyerMoore;
import co.edu.unbosque.model.Kmp;
import co.edu.unbosque.view.Window;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class Controller implements ActionListener{
    co.edu.unbosque.view.Window window = new Window();
    Kmp md = new Kmp();

    String result = "";
    BoyerMoore boyerMoore;
    public Controller(){
        listeners();
    }

    public void listeners(){
        window.getLeer().addActionListener(this);
        window.getKmp().addActionListener(this);
        window.getBm().addActionListener(this);
        window.getPatron().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "LEERARCHIVO": {
                readFile();
            } break;

            case "KMP":{
                String getTextPattern = window.getPatron().getText();
                if(window.getCheckBox().isSelected()){
                    List<Integer> searchList = md.kmpWithoutMayus(result,getTextPattern);
                    SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
                    StyleConstants.setForeground(simpleAttributeSet,Color.black);
                    StyleConstants.setBackground(simpleAttributeSet,Color.yellow);

                    StyledDocument doc = window.getAreaTexto().getStyledDocument();

                    if(searchList == null) return;
                    for (var offset : searchList){
                        doc.setCharacterAttributes(offset,getTextPattern.length(),simpleAttributeSet,true);
                    }
                } else {
                    List<Integer> searchList = md.kmp(result,getTextPattern);
                    SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
                    StyleConstants.setForeground(simpleAttributeSet,Color.black);
                    StyleConstants.setBackground(simpleAttributeSet,Color.yellow);

                    StyledDocument doc = window.getAreaTexto().getStyledDocument();

                    if(searchList == null) return;
                    for (var offset : searchList){
                        doc.setCharacterAttributes(offset,getTextPattern.length(),simpleAttributeSet,true);
                    }
                }
            } break;

            case "BM":{
                String getTextPattern = window.getPatron().getText();
                boyerMoore = new BoyerMoore(getTextPattern);

                if(window.getCheckBox().isSelected()){
                    ArrayList<Integer> bm = boyerMoore.bmWithourMayus(result);
                    SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
                    StyleConstants.setForeground(simpleAttributeSet,Color.black);
                    StyleConstants.setBackground(simpleAttributeSet,Color.yellow);

                    StyledDocument doc = window.getAreaTexto().getStyledDocument();

                    if(bm == null) return;
                    for(var offset : bm){
                        doc.setCharacterAttributes(offset,getTextPattern.length(),simpleAttributeSet,true);
                    }
                } else {
                    ArrayList<Integer> search = boyerMoore.bm(result);
                    SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
                    StyleConstants.setForeground(simpleAttributeSet,Color.black);
                    StyleConstants.setBackground(simpleAttributeSet,Color.yellow);

                    StyledDocument doc = window.getAreaTexto().getStyledDocument();

                    if(search == null) return;
                    for(var offset : search){
                        doc.setCharacterAttributes(offset,getTextPattern.length(),simpleAttributeSet,true);
                    }
                }
            } break;
        }
    }

    public String readFile(){
        String fileName = "";
        String fileAddress = "";
        FileDialog fd = new FileDialog(new Frame(),"Seleccionar un archivo", FileDialog.LOAD);
        final FilenameFilter filter = (dir, name) -> name.endsWith(".txt");
        fd.setFilenameFilter(filter);
        fd.setVisible(true);

        if(fd.getFile() != null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
        }
        System.out.println("file: "+fileAddress+fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress+fileName));
            String line = null;

            while((line = br.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
            br.close();
            window.getAreaTexto().setText(stringBuilder.toString());

        } catch (Exception e){
            System.out.println("El archivo no se pudo abrir");
        }
        result = stringBuilder.toString(); //listo, ahora podes usar result en cualquier lado, y este metodo no se va a callear
        return stringBuilder.toString();
    }
}
