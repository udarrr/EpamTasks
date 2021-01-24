package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException
    {
        RegIdOfCar[] car = CreateDataAboutCars.CreateMassive();
        for (int i = 0; i <car.length ; i++)
        {
            System.out.println(car[i].toString());
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while (!input.equalsIgnoreCase("exit"))
        {
            showCommand();
            input = in.readLine();
            String[] params = input.split("[\\s(^'.'$)]");
            switch (params[0])
            {
                case "vendor":
                case "model":
                case "regid":
                case "color":
                    PrinterData.print(car, params[2]);
                    break;
                case "year":
                case "price":
                    if(params[2].equals("="))
                    {
                        PrinterData.print(car, params[2]);
                    }
                    else if(params[2].equals(">"))
                    {

                    }
                    else if(params[2].equals("<"))
                    {

                    }
                    break;
                default: System.out.println("Wrong command");
            }
        }


    }
    public static void showCommand() {
        System.out.println("Enter vendor or model or year or color or price or regid or \"exit\" to exit");
        System.out.println("For example *vendor = VW* pls use space beatwen words");
    }

}

