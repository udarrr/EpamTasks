package com.company;

import java.util.Scanner;

public class CreateArrayN {

    String[] createAndFillArr() {

        int n = 0;
        int i = 0;
        String[] num = new String[0];
        boolean exit = true;

        Scanner sc = new Scanner(System.in);
        System.out.println("Set n numbers, only int ");
        while (exit)
            try
            {
                String setLine = sc.nextLine();
                n = Integer.parseInt(setLine);
                num = new String[n];
                exit = false;
                System.out.println("Enter " + n + " numbers");
            } catch (Exception e) {
                System.out.println("Only int number");
            }

        while (i < n) {
            try {
                String line = sc.nextLine();
                Long.parseLong(line);
                num[i] = line;
                i++;
            } catch (Exception e) {
                System.out.println("Only numbers,please try again");
            }
        }
        return  num;
    }
}
