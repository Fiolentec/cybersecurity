package com.company;

//import static com.company.AlphabetGetter.LocaleLanguage.*;
//import static com.company.AlphabetGetter.getAlphabet;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Main {
    final static int SHIFT_SIZE = 8;
    public static void main(String[] args) throws UnsupportedEncodingException {
//        for(int i = 0; i<args.length; i++) {
//            System.out.println("args[" + i + "]: " + args[i]);
//        }
        String s = "standard text for checking the encryption algorithm";
        System.out.println(s);
        String encryptString = SiftCipher.encryptOrDecryptString(s,"ENGLISH", SHIFT_SIZE, false);//language = ["RUSSIAN", "ENGLISH"]
        System.out.println(encryptString);
        String decryptString = SiftCipher.encryptOrDecryptString(encryptString,"ENGLISH", SHIFT_SIZE, true);//language = ["RUSSIAN", "ENGLISH"]
        System.out.println(decryptString);

        encryptString = TranspositionCipher.encryptOrDecryptString(s, "ENGLISH","[3,4,1,2]");
        System.out.println(encryptString);
        decryptString = TranspositionCipher.encryptOrDecryptString(encryptString, "ENGLISH","[3,4,1,2]");
        System.out.println(decryptString);

        encryptString = XORcipher.encryptOrDecrypt(s, "ENGLISH", "cat", false);
        System.out.println(encryptString);
        decryptString = XORcipher.encryptOrDecrypt(encryptString, "ENGLISH", "cat", true);
        System.out.println(decryptString);

    }


}
