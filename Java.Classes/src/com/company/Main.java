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
        CommandsForCmd.CommadLine();
    }


}

