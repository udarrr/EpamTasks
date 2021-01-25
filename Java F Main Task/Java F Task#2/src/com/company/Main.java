package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner user = new Scanner(System.in);
        System.out.println("Please Enter your name");
        String hello = user.nextLine();
        char[] array = hello.toCharArray();
        char[] arraytemp = new char[array.length];
        for(int i = 0; i< array.length; i ++)
        {
            arraytemp [(array.length-1)-i]= array[i];
        }
        String result = new String(arraytemp);
        System.out.println(result);
    }
}
