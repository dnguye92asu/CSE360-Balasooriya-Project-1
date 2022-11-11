package com.example.phaseiiicode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Customer {
    String id;
    String fileWord;
    File file = new File("C:\\Users\\Benit\\OneDrive\\Desktop\\Names.txt");
    Scanner sc = new Scanner(file);

    public Customer() throws FileNotFoundException {
        id = "";
    }

    public Customer(String s) throws FileNotFoundException {
        id = s;
    }

    boolean checkStudent() {
        int i = 0;
        while (i < 77) {
            fileWord = sc.next();
            if (id.equals(fileWord)) {
                if (sc.next().equals("S")) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }
}








