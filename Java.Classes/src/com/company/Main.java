package com.company;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int quantity;
        boolean exit = true;
        System.out.println("Enter quantity cars from catalog: ");

        while (exit)
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                quantity = sc.nextInt();
                Car[] cars = new CarCreator().createCarData(quantity);;
                CommandsReader.start(cars);
                exit = false;
            } catch (Exception e)
            {
                System.out.println("Quantity is a integer number");
                exit = true;
            }
        }
    }
}

