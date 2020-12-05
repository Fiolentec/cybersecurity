package com.company;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class SiftCipher {
    public static String encryptOrDecryptString(String s, String language, int num, boolean decrypt) {
        char[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
        if (language.equals("ENGLISH"))
            alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        if (decrypt)
            num = alphabet.length-num;
        ArrayList<Character> list = new ArrayList<>();
        for (Character c: s.toCharArray()){
            if (c==' '){
                list.add(' ');
                continue;
            }
            for (int i = 0; i < alphabet.length; i++) {
                if (c.equals(alphabet[i])){
                    list.add(alphabet[(i+num)%alphabet.length]);
                    break;
                }
            }
        }
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }
}
