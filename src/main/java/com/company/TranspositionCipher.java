package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class TranspositionCipher {
    public static String encryptOrDecryptString(String s, String language, String stringKey) {
        System.out.println(s);
        String[] items = stringKey.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        int [] key = new int [items.length];
        for(int i=0; i<items.length; i++) {
            key[i] = Integer.parseInt(items[i]);
        }
        ArrayList<Character> list = new ArrayList<>();

        char [] array = new char[(s.length()/ key.length + 1) * key.length];
        Arrays.fill(array,' ');
        int i = 0;
        for (Character c: s.toCharArray()){
            array[(i / key.length) * key.length + key[i % key.length] - 1] = c;
            i++;
        }
        return String.valueOf(array);
    }
}
