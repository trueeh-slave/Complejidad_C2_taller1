package co.edu.unbosque.model;

public class ModelManager {

    public void kmp(String text, String pattern){
        int patternLength = pattern.length();
        int textLength = text.length();

        int tabla[] = new int[patternLength];
        int j=0;
        tablaDePrefijos(pattern,patternLength,tabla);
        int i=0;

        while(i < textLength){
            if(pattern.charAt(j) == text.charAt(i)){
                j++;
                i++;
            }
            if( j == patternLength){
                System.out.println("patron encontrado en el index "+(i-j));
                j = tabla[j-1];
            }
            else if(i < textLength && pattern.charAt(j) != text.charAt(i)){
                if(j != 0){
                    j = tabla[j-1];
                } else {
                    i = i+1;
                }
            }
        }
    }

    public void tablaDePrefijos(String pattern, int m, int table[]){
        int i = 0,j = 0;
        table[0] = 0;

        while(i<m){
            if(pattern.charAt(i) == pattern.charAt(j)){
                j++;
                table[i] = j;
                i++;
            } else {
                if(j != 0){
                    j = table[j - 1];
                } else {
                    table[i] = j;
                    i++;
                }
            }
        }
    }
}
