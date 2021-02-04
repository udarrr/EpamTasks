package com.epam.automation.JavaFundamental.maintask.task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter your name");

        String hello = sc.nextLine();

        System.out.println("Hello " + hello);
    }
}
