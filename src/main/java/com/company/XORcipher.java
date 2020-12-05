package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class XORcipher {
    static String encryptOrDecrypt(String s, String language, String key, boolean decrypt) {
        char[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
        if (language.equals("ENGLISH"))
            alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        String str = String.valueOf(alphabet) + " ";
        char[] alph = str.toCharArray();
        int[] keyArr = new int[key.length()];
        int num = 0;
        for (Character c : key.toCharArray()) {
            for (int i = 0; i < alph.length; i++) {
                if (c.equals(alph[i])) {
                    if (decrypt)
                        keyArr[num] = alph.length-(i+1);
                    else
                        keyArr[num]=i+1;
                    break;
                }
            }
            num++;
        }
        ArrayList<Character> list = new ArrayList<>();
        num = 0;
        for (Character c : s.toCharArray()) {
            for (int i = 0; i < alph.length; i++) {
                if (c.equals(alph[i])) {
                    list.add(alph[(keyArr[num%key.length()]+i)%alph.length]);
                    break;
                }
            }
            num++;
        }
//        System.out.println(alph);
//        System.out.println(Arrays.toString(keyArr));
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }
}
