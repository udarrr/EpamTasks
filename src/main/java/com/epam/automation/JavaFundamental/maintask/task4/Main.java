package com.epam.automation.JavaFundamental.maintask.task4;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your number1: ");
        String line1 =scan.nextLine();

        boolean operation = true;
        double number1 = 0;
        double number2 = 0;

        try
        {
            number1 = Double.parseDouble(line1);
        }
        catch (Exception e)
        {
            System.out.println("Wrong number1");
            operation = false;

        }
        System.out.println("Enter your number2: ");
        String line2 =scan.nextLine();

        try
        {
            number2 = Double.parseDouble(line2);
        }
        catch (Exception e)
        {
            System.out.println("Wrong number2");
            operation = false;
        }
              if(operation)
              {
                  double summ = number1+number2;
                  System.out.println("Summ is:" +summ);

                  double multiplication = number1*number2;
                  System.out.println("Multiplication is:"+multiplication);
              }
              else {System.out.println("No result due to you enter wrong number");}
    }
}
