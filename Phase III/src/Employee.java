package com.example.phaseiiicode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Employee {
    String id;
    String fileWord;
    File file = new File("C:\\Users\\Benit\\OneDrive\\Desktop\\Names.txt");
    Scanner sc = new Scanner(file);

    public Employee() throws FileNotFoundException {
        id = "";
    }

    public Employee(String s) throws FileNotFoundException {
        id = s;
    }

    String checkEmployee() {
        int i = 0;
        while (i < 77) {
            fileWord = sc.next();
            if (id.equals(fileWord)) {
                String employeeType = sc.next();
                if (employeeType.equals("C")) {
                    return "Cook";
                }
                else if (employeeType.equals("P")) {
                    return "Agent";
                }
            }
            i++;
        }
        return "";
    }
}
