package co.edu.unbosque.model;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileManager {
    String fileName;
    String fileAddress;
    public void readFile(){
        FileDialog fd = new FileDialog(new Frame(),"Seleccionar un archivo", FileDialog.LOAD);
        final FilenameFilter filter = (dir,name) -> name.endsWith(".txt");
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
                //ponerla sen el jpane
                stringBuilder.append(line);
            }
            br.close();
            String[] fileSeparatedBySpace = stringBuilder.toString().split(" ");
            System.out.println("Array"+ Arrays.toString(fileSeparatedBySpace)+"\n");
//            System.out.println(stringBuilder.append(line));
        } catch (Exception e){
            System.out.println("El archivo no se pudo abrir");
        }
    }

}
