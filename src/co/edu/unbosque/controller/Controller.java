package co.edu.unbosque.controller;

import co.edu.unbosque.model.ModelManager;
import co.edu.unbosque.view.Window;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Controller implements ActionListener{
//    FileManager fm = new FileManager();
    co.edu.unbosque.view.Window window = new Window();
    ModelManager md = new ModelManager();

    String result = "";
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
        System.out.println(command);
        switch (command){
            case "LEERARCHIVO": {
                readFile();
            }

            case "KMP":{
                String getTextPatern = window.getPatron().getText();

                List<Integer> searchList = md.search(result,getTextPatern);
                SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
                StyleConstants.setForeground(simpleAttributeSet,Color.black);
                StyleConstants.setBackground(simpleAttributeSet,Color.yellow);

                StyledDocument doc = window.getAreaTexto().getStyledDocument();

                for (var offset : searchList){
                    doc.setCharacterAttributes(offset,getTextPatern.length(),simpleAttributeSet,true);
                }
            }

            case "BM":{

            }
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
