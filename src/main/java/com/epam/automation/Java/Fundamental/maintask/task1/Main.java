package com.epam.automation.Java.Fundamental.maintask.task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner user = new Scanner(System.in);
        System.out.println("Please Enter your name");
        String hello = user.nextLine();
        System.out.println("Hello " + hello);
    }
}
