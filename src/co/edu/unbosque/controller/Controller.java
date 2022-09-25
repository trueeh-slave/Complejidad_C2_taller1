package co.edu.unbosque.controller;

import co.edu.unbosque.view.Window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Controller implements ActionListener{
//    FileManager fm = new FileManager();
    co.edu.unbosque.view.Window window = new Window();
    String entireFile;
    public Controller(){
        listeners();
    }

    public void listeners(){
        window.getLeer().addActionListener(this);
        window.getKmp().addActionListener(this);
        window.getBm().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);
        switch (command){
            case "LEERARCHIVO": {
                System.out.println(readFile());
            }

            case "KMP":{

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
        return stringBuilder.toString();
    }
}
