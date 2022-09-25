package co.edu.unbosque.controller;

import co.edu.unbosque.model.ModelManager;
import co.edu.unbosque.view.Window;

public class AplMain {
    static ModelManager md = new ModelManager();
    public static void main(String[] args) {
        new Controller();
        md.booyermoore("this is a text", "text");
    }
}