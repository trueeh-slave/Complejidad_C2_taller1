package co.edu.unbosque.controller;

import co.edu.unbosque.model.FileManager;
import co.edu.unbosque.view.Window;

public class AplMain {
    public static void main(String[] args) {
        new Controller();
        new Window();
        new FileManager().readFile();
    }
}