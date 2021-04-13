package com.Chenjiajie.notes.util工具类;

import java.util.Scanner;

public class input {
    public void input(String[] args) {
        for (int i=0;i<5;i++){
            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(scanner.nextLine());
            while (scanner1.hasNext()){
                String str1 = scanner1.nextLine();
                System.out.println(str1);

            }
        }
    }
}
