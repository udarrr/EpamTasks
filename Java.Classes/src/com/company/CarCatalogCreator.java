package com.company;

import java.util.Random;
import java.util.Scanner;

public class CarCatalogCreator
{
    private int getRandomNumberInts(int min, int max)
    {
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }
    private double getRandomNumberDouble(double min, double max)
    {
        Random random = new Random();
        return random.doubles(min,(max+1)).findFirst().getAsDouble();
    }
    private String getRandomNumberRegId(int min, int max)
    {
        Random random = new Random();
        char[] str= "ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray();
        int randomNumber = random.ints(min,(max+1)).findFirst().getAsInt();
        int charA = random.ints(0,(str.length)).findFirst().getAsInt();
        int charB = random.ints(0,(str.length)).findFirst().getAsInt();
        StringBuilder resultStr = new StringBuilder();
        return  resultStr.append(randomNumber).append(str[charA]).append(str[charB]).toString();
    }
    public  CarInfo[] createMassive ()
    {
        Random rnd = new Random();
        int line = 0;
        boolean exit = true;

        System.out.println("Enter quantity cars from catalog: ");

        while (exit)
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                line = sc.nextInt();
                exit = false;
            }
            catch (Exception e)
            {
                System.out.println("Only int number, try again");
                exit = true;
            }
        }

        CarInfo[] data = new CarInfo[line];

        for (int i = 0; i < data.length; i++)
        {
            switch (CarCatalog.enumVendorCars.getRandomVendorsCars())
            {
                case VW ->  data[i] = new CarInfo(i+1,"VW", CarCatalog.enumModelVW.getRandomModelsVW().toString(),
                        getRandomNumberInts(1990,2020), CarCatalog.enumColorCars.getRandomColorOfCars().toString(), (double) Math.round(getRandomNumberDouble(5000.00,25000.00)),getRandomNumberRegId(1000,9999));
                case BMW -> data[i] = new CarInfo(i+1,"BMW", CarCatalog.enumModelBMW.getRandomModelBMW().toString(),
                        getRandomNumberInts(1990,2020), CarCatalog.enumColorCars.getRandomColorOfCars().toString(),(double) Math.round(getRandomNumberDouble(5000.00,25000.00)),getRandomNumberRegId(1000,9999));
                case MITSUBISHI -> data[i] = new CarInfo(i+1,"MITSUBISHI", CarCatalog.enumModelMitsubishi.getRandomModelMitsubishi().toString(),
                        getRandomNumberInts(1990,2020), CarCatalog.enumColorCars.getRandomColorOfCars().toString(),(double) Math.round(getRandomNumberDouble(5000.00,25000.00)),getRandomNumberRegId(1000,9999));
                case VAZ -> data[i] = new CarInfo(i+1,"VAZ", CarCatalog.enumModelVAZ.getRandomModelVAZ().toString(),
                        getRandomNumberInts(1990,2020), CarCatalog.enumColorCars.getRandomColorOfCars().toString(),(double) Math.round(getRandomNumberDouble(5000.00,25000.00)),getRandomNumberRegId(1000,9999));
                default -> System.out.println("isn't possible add car");
            }
        }
        return data;
    }
}
