package com.company;

import LsysRecursive.Grammatik;
import LsysRecursive.txt;

public class Main {

    public static void main(String[] args) {
        System.out.println("Test 2");
        txt test = new txt();
        String txtFile = test.getTxtFile();
        Grammatik grammatik = new Grammatik(txtFile);


    }
}
