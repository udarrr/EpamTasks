package com.company;

import Enums.*;
import java.util.Random;
import java.util.Scanner;

public class CarCreator
{
    private int getRandomNumberInts(int min, int max)
    {
        Random random = new Random();
        return random.ints(min, (max + 1)).findFirst().getAsInt();
    }

    private double getRandomNumberDouble(double min, double max)
    {
        Random random = new Random();
        return random.doubles(min, (max + 1)).findFirst().getAsDouble();
    }

    private String getRandomNumberRegId(int min, int max)
    {
        Random random = new Random();
        char[] str = "ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray();
        int randomNumber = random.ints(min, (max + 1)).findFirst().getAsInt();
        int charA = random.ints(0, (str.length)).findFirst().getAsInt();
        int charB = random.ints(0, (str.length)).findFirst().getAsInt();
        StringBuilder resultStr = new StringBuilder();
        return resultStr.append(randomNumber).append(str[charA]).append(str[charB]).toString();
    }

    public Car[] createMassive()
    {
        int quantity = 0;
        boolean exit = true;
        System.out.println("Enter quantity cars from catalog: ");

        while (exit)
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                quantity = sc.nextInt();
                exit = false;
            } catch (Exception e)
            {
                System.out.println("Only int number, try again");
                exit = true;
            }
        }

        Car[] data = new Car[quantity];

        for (int i = 0; i < data.length; i++)
        {
            switch (CarVendor.getRandomVendor())
            {
                case VW -> data[i] = new Car(i + 1, CarVendor.VW, VWModel.getRandomModels().toString(),
                        getRandomNumberInts(1990, 2020), CarColor.getRandomColor(), (double) Math.round(getRandomNumberDouble(5000.00, 25000.00)), getRandomNumberRegId(1000, 9999));
                case BMW -> data[i] = new Car(i + 1, CarVendor.BMW, BMWModel.getRandomModel().toString(),
                        getRandomNumberInts(1990, 2020), CarColor.getRandomColor(), (double) Math.round(getRandomNumberDouble(5000.00, 25000.00)), getRandomNumberRegId(1000, 9999));
                case MITSUBISHI -> data[i] = new Car(i + 1, CarVendor.MITSUBISHI, MitsubishiModel.getRandomModel().toString(),
                        getRandomNumberInts(1990, 2020), CarColor.getRandomColor(), (double) Math.round(getRandomNumberDouble(5000.00, 25000.00)), getRandomNumberRegId(1000, 9999));
                case VAZ -> data[i] = new Car(i + 1, CarVendor.VAZ, VAZModel.getRandomModel().toString(),
                        getRandomNumberInts(1990, 2020), CarColor.getRandomColor(), (double) Math.round(getRandomNumberDouble(5000.00, 25000.00)), getRandomNumberRegId(1000, 9999));
                default -> System.out.println("isn't possible add car");
            }
        }
        return data;
    }
}


