package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kmp {

    public static int[] tablaDePrefijos(String pattern) {
        if(pattern.equalsIgnoreCase("")) return new int[0];
        int patternLen = pattern.length();
        int[] array = new int[patternLen + 1];
        array[0] = -1;
        array[1] = 0;

        int prefixLength = 0;
        int i = 1;

        while (i < patternLen) {
            if (pattern.charAt(prefixLength) == pattern.charAt(i)) {
                prefixLength++;
                i++;
                array[i] = prefixLength;

            } else if (prefixLength > 0) {
                prefixLength = array[prefixLength];

            } else {
                i++;
                array[i] = 0;
            }
        }

        return array;
    }

    public List<Integer> kmp(String text, String pattern) {
        int currentTextPos = 0;
        int currentCharPos = 0;
        if(pattern.length() == 0) return null;

        if(pattern == null) return Collections.emptyList();
        int textLength = text.length();
        int charLength = pattern.length();

        List<Integer> arrayList = new ArrayList<>();
        int[] prefixLen = tablaDePrefijos(pattern);

        while (currentTextPos < textLength) {
            if (pattern.charAt(currentCharPos) == text.charAt(currentTextPos)) {
                currentCharPos++;
                currentTextPos++;

                if (currentCharPos == charLength) {
                    arrayList.add(currentTextPos-currentCharPos);
                    currentCharPos = prefixLen[currentCharPos];
                }

            } else {
                currentCharPos = prefixLen[currentCharPos];

                if (currentCharPos < 0) {
                    currentTextPos++;
                    currentCharPos++;
                }
            }
        }
        return arrayList;
    }

    public List<Integer> kmpWithoutMayus(String text, String pattern){
        int currentTextPos = 0;
        int currentCharPos = 0;
        if(pattern.length() == 0) return null;

        if(pattern == null) return Collections.emptyList();
        int textLength = text.length();
        int charLength = pattern.length();

        List<Integer> arrayList = new ArrayList<>();
        int[] prefixLen = tablaDePrefijos(pattern);

        while (currentTextPos < textLength) {
            if (pattern.toUpperCase().charAt(currentCharPos) == text.toUpperCase().charAt(currentTextPos)) {
                currentCharPos++;
                currentTextPos++;

                if (currentCharPos == charLength) {
                    arrayList.add(currentTextPos-currentCharPos);
                    currentCharPos = prefixLen[currentCharPos];
                }

            } else {
                currentCharPos = prefixLen[currentCharPos];

                if (currentCharPos < 0) {
                    currentTextPos++;
                    currentCharPos++;
                }
            }
        }
        return arrayList;
    }
}
