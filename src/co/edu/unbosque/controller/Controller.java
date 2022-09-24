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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command){
            case "LEERARCHIVO": {
                readFile();
            }
        }
    }

    public void readFile(){
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

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress+fileName));
            String line = null;

            StringBuilder stringBuilder = new StringBuilder();
            while((line = br.readLine()) != null){
                stringBuilder.append(line);
                window.getAreaTexto().read(br,new FileReader(fileAddress+fileName));
            }


            br.close();
        } catch (Exception e){
            System.out.println("El archivo no se pudo abrir");
        }
    }
}
