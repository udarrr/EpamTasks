package com.company;

import java.util.Random;
import java.util.Scanner;

public class CreateDataAboutCars
{

    enum enumVendorCars
    {
        VW,BMW,MITSUBISHI,VAZ;

        public static enumVendorCars getRandomVendorsCars() {
            return values()[(int) (Math.random() * values().length)];
        }
    }

    enum enumModelVW
    {
        POLO,TOURAN,GOLF,PASSAT,SHARAN;

        public static enumModelVW getRandomModelsVW() {
            return values()[(int) (Math.random() * values().length)];
        }
    }

    enum enumModelBMW
    {
        X1,X2,X3,X4,X5,X6,X7;

        public static enumModelBMW getRandomModelBMW() {
            return values()[(int) (Math.random() * values().length)];
        }
    }

    enum enumModelMitsubishi
    {
        SPACESTAR,VAGON,PADJERO,OUTLANDER,ASX,ECLIPSE;

        public static enumModelMitsubishi getRandomModelMitsubishi() {return values()[(int) (Math.random() * values().length)];
        }
    }

    enum enumModelVAZ
    {
        VESTA,GRANTA,LADA2101,LADA2106,LADASedan,CROSS;

        public static enumModelVAZ getRandomModelVAZ() {return values()[(int) (Math.random() * values().length)];
        }
    }

    enum enumColorCars
    {
        BLACK,WHITE,RED,GREEN,ORANGE,BLUE,BACLAGAN;

        public static enumColorCars getRandomColorOfCars() {return values()[(int) (Math.random() * values().length)];
        }
    }

    static int getRandomNumberInts(int min, int max){
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }
    static double getRandomNumberDouble(double min, double max){
        Random random = new Random();
        return random.doubles(min,(max+1)).findFirst().getAsDouble();
    }
    static String getRandomNumberRegId(int min, int max){
    Random random = new Random();
    char[] str= "ABCDEFGHIJKLMNOPQRSTUVWZYZ".toCharArray();
    int randomNumber = random.ints(min,(max+1)).findFirst().getAsInt();
    int charA = random.ints(0,(str.length)).findFirst().getAsInt();
    int charB = random.ints(0,(str.length)).findFirst().getAsInt();
    StringBuilder resultStr = new StringBuilder();
    return  resultStr.append(randomNumber).append(str[charA]).append(str[charB]).toString();
    }


public  static RegIdOfCar[] CreateMassive ()
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

    RegIdOfCar[] data = new RegIdOfCar[line];

    for (int i = 0; i < data.length; i++)
    {
        switch (enumVendorCars.getRandomVendorsCars())
        {
            case VW ->  data[i] = new RegIdOfCar(i+1,"VW", enumModelVW.getRandomModelsVW().toString(),
                    getRandomNumberInts(1990,2020), enumColorCars.getRandomColorOfCars().toString(), (double) Math.round(getRandomNumberDouble(5000.00,25000.00)),getRandomNumberRegId(1000,9999));
            case BMW -> data[i] = new RegIdOfCar(i+1,"BMW", enumModelBMW.getRandomModelBMW().toString(),
                    getRandomNumberInts(1990,2020), enumColorCars.getRandomColorOfCars().toString(),(double) Math.round(getRandomNumberDouble(5000.00,25000.00)),getRandomNumberRegId(1000,9999));
            case MITSUBISHI -> data[i] = new RegIdOfCar(i+1,"MITSUBISHI", enumModelMitsubishi.getRandomModelMitsubishi().toString(),
                    getRandomNumberInts(1990,2020), enumColorCars.getRandomColorOfCars().toString(),(double) Math.round(getRandomNumberDouble(5000.00,25000.00)),getRandomNumberRegId(1000,9999));
            case VAZ -> data[i] = new RegIdOfCar(i+1,"VAZ", enumModelVAZ.getRandomModelVAZ().toString(),
                    getRandomNumberInts(1990,2020), enumColorCars.getRandomColorOfCars().toString(),(double) Math.round(getRandomNumberDouble(5000.00,25000.00)),getRandomNumberRegId(1000,9999));
            default -> System.out.println("Wrong action");
        }
    }
    return data;
  }
}
