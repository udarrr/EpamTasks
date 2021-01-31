package com.epam.automation.Java.Classes.src.com.company;

import com.epam.automation.Java.Classes.src.Enums.*;
import java.util.Random;

public class CarCreator
{
    private int getRandomYear(int min, int max)
    {
        return new Random().ints(min, (max + 1)).findFirst().getAsInt();
    }

    private double getRandomPrice(double min, double max)
    {
        return new Random().doubles(min, (max + 1)).findFirst().getAsDouble();
    }

    private String getRandomRegistrationNumber(int min, int max)
    {
        Random random = new Random();

        char[] str = "ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray();
        int randomNumber = random.ints(min, (max + 1)).findFirst().getAsInt();
        int charA = random.ints(0, (str.length)).findFirst().getAsInt();
        int charB = random.ints(0, (str.length)).findFirst().getAsInt();
        StringBuilder resultStr = new StringBuilder();

        return resultStr.append(randomNumber).append(str[charA]).append(str[charB]).toString();
    }

    public Car[] createCarData(int quantity)
    {
        Car[] data = new Car[quantity];

        for (int i = 0; i < data.length; i++)
        {
            switch (CarVendor.getRandomVendor())
            {
                case VW -> data[i] = new Car(i + 1, CarVendor.VW, VWModel.getRandomModels().toString(),
                        getRandomYear(1990, 2020), CarColor.getRandomColor(), (double) Math.round(getRandomPrice(5000.00, 25000.00)), getRandomRegistrationNumber(1000, 9999));
                case BMW -> data[i] = new Car(i + 1, CarVendor.BMW, BMWModel.getRandomModel().toString(),
                        getRandomYear(1990, 2020), CarColor.getRandomColor(), (double) Math.round(getRandomPrice(5000.00, 25000.00)), getRandomRegistrationNumber(1000, 9999));
                case MITSUBISHI -> data[i] = new Car(i + 1, CarVendor.MITSUBISHI, MitsubishiModel.getRandomModel().toString(),
                        getRandomYear(1990, 2020), CarColor.getRandomColor(), (double) Math.round(getRandomPrice(5000.00, 25000.00)), getRandomRegistrationNumber(1000, 9999));
                case VAZ -> data[i] = new Car(i + 1, CarVendor.VAZ, VAZModel.getRandomModel().toString(),
                        getRandomYear(1990, 2020), CarColor.getRandomColor(), (double) Math.round(getRandomPrice(5000.00, 25000.00)), getRandomRegistrationNumber(1000, 9999));
                default -> System.out.println("isn't possible add car");
            }
        }
        return data;
    }
}


