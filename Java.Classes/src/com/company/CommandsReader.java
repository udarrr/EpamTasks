package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandsReader
{
    public static void start() throws IOException
    {
        CarCreator creator = new CarCreator();
        Car[] cars = creator.createCarData();

        for (Car item : cars)
        {
            System.out.println(item);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        Car[] carDataHandler;

        while (!input.equalsIgnoreCase("exit"))
        {
            CommandsHandler commandsHandler = new CommandsHandler();
            ConsolePrinter consolePrinter = new ConsolePrinter();
            carDataHandler = cars;

            printDescriptionCommands();

            String firstCondition;
            String command;
            String secondCondition;

            input = reader.readLine();
            String[] params = input.split("[\\s(^'.$)]");

            if (params[0] != null && params[2] != null && params[1] != null)
            {
                firstCondition = params[0];
                command = params[1];
                secondCondition = params[2];

                for (int i = 0; i < params.length - 3; i += 4)
                {
                    String additionalOperation = params[i + 3];
                    boolean checkSecondOperation = additionalOperation.equalsIgnoreCase("AND");
                    if (checkSecondOperation)
                    {
                        carDataHandler = commandsHandler.processData(firstCondition, secondCondition, command, carDataHandler);
                        if (params[i + 4] != null)
                        {
                            firstCondition = params[i + 4];
                        }
                        if (params[i + 5] != null)
                        {
                            command = params[i + 5];
                        }
                        if (params[i + 6] != null)
                        {
                            secondCondition = params[i + 6];
                        }
                    }
                }
            }
            consolePrinter.printCarDataResult(carDataHandler);
        }
    }

    private static void printDescriptionCommands()
    {
        System.out.println(" ");
        System.out.println("Commands '=' is equal '>' is more ,'<' is less, '%' is time exploitation, 'AND' is additional operation ");
        System.out.println("Use space between words: vendor,model,year,color,price,regId");
        System.out.println("****************Examples****************");
        System.out.println("vendor = MITSUBISHI");
        System.out.println("model = LADASedan and year % 10");
        System.out.println("year = 2004 and price > 5000");
        System.out.println("model = X7 and year % 10 and price > 10000");
        System.out.println("****************************************");
    }
}
