package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandsForCmd
{
    public static void setCommandInLine()
    {
        CarCreator creator = new CarCreator();
        Car[] car = creator.createMassive();
        Car[] initCar = car.clone();

        for (Car item:initCar)
        {
         System.out.println(item);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while (!input.equalsIgnoreCase("exit"))
        {
            try {
                CommandsHandler commandsHandler = new CommandsHandler();

                car = initCar;
                showCommand();

                input = in.readLine();
                String[] params = input.split("[\\s(^'.$)]");
                String firstCondition = params[0];
                String command = params[1];
                String secondCondition = params[2];

                try {
                    for (int i = 0; i < params.length-3; i += 4)
                    {
                        String additionalOperation = params[i + 3];
                        boolean checkSecondOperation = additionalOperation.equalsIgnoreCase("AND");
                        if (checkSecondOperation)
                        {
                            car = commandsHandler.processingData(firstCondition, secondCondition, command, car);
                        }
                        firstCondition = params[i + 4];
                        command = params[i + 5];
                        secondCondition = params[i + 6];
                    }
                    commandsHandler.printResult(firstCondition, secondCondition, command, car);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("Error pls try again");
                }
            }
            catch (Exception e)
            {
                System.out.println("Command is not recognized");
            }
        }
    }
    private static void showCommand()
    {
        System.out.println(" ");
        System.out.println("Commands '=' is equal '>' is more ,'<' is less, '%' is time exploitation, 'AND' is additional operation ");
        System.out.println("Use space between words: vendor,model,year,color,price,regid");
        System.out.println("****************Examples****************");
        System.out.println("vendor = MITSUBISHI");
        System.out.println("model = LADASedan and year % 10");
        System.out.println("year = 2004 and price > 5000");
        System.out.println("model = X7 and year % 10 and price > 10000");
        System.out.println("****************************************");
    }
}
