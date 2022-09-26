package co.edu.unbosque.model;

import java.util.ArrayList;

public class BoyerMoore {
    private final int R = 256;
    private int[] derecha;   
    private String pattern;
    
    public BoyerMoore(String pat) {
        pattern = pat;
        
        derecha = new int[R];
        for (int c = 0; c < R; c++) derecha[c] = -1;
        for (int j = 0; j < pat.length(); j++) derecha[pat.charAt(j)] = j;
    }
    
    public ArrayList<Integer> bm(String text) {
        int patternLength = pattern.length();
        int textLength = text.length();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int numerosDeSaltos;

        for (int i = 0; i <= textLength - patternLength; i += numerosDeSaltos) {
            numerosDeSaltos=0;
            for (int j = patternLength-1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i+j)) {
                    numerosDeSaltos = Math.max(1, j - derecha[text.charAt(i+j)]);
                    break;
                }
            }
            if (numerosDeSaltos == 0) {
                arrayList.add(i);
                numerosDeSaltos++;
            }
        }
        return arrayList;
    }

    public ArrayList<Integer> bmWithourMayus(String text) {
        int patternLength = pattern.length();
        int textLength = text.length();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int numerosDeSaltos;

        for (int i = 0; i <= textLength - patternLength; i += numerosDeSaltos) {
            numerosDeSaltos=0;
            for (int j = patternLength-1; j >= 0; j--) {
                if (pattern.toUpperCase().charAt(j) != text.toUpperCase().charAt(i+j)) {
                    numerosDeSaltos = Math.max(1, j - derecha[text.charAt(i+j)]);
                    break;
                }
            }
            if (numerosDeSaltos == 0) {
                arrayList.add(i);
                numerosDeSaltos++;
            }
        }
        return arrayList;
    }
}