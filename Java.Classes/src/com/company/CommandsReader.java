package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandsReader
{
    public static void setCommandInLine() throws IOException
    {
        CarCreator creator = new CarCreator();
        Car[] carDataInit = creator.createMassive();
        Car[] carDataHandler;

        for (Car item:carDataInit)
        {
         System.out.println(item);
        }

        BufferedReader inputCommand = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while (!input.equalsIgnoreCase("exit"))
        {
            CommandsHandler commandsHandler = new CommandsHandler();
            carDataHandler = carDataInit;

            showCommand();

            String firstCondition = null;
            String command = null;
            String secondCondition = null;

            input = inputCommand.readLine();
            String[] params = input.split("[\\s(^'.$)]");

            if (params[0] != null)
            {
                firstCondition = params[0];
            }
            if (params[1] != null)
            {
                command = params[1];
            }
            if (params[2] != null)
            {
                secondCondition = params[2];
            }

            if (firstCondition != null || secondCondition != null)
            {
                for (int i = 0; i < params.length - 3; i += 4)
                {
                    String additionalOperation = params[i + 3];
                    boolean checkSecondOperation = additionalOperation.equalsIgnoreCase("AND");
                    if (checkSecondOperation)
                    {
                        carDataHandler = commandsHandler.processData(firstCondition, secondCondition, command, carDataHandler);
                        firstCondition = params[i + 4];
                        command = params[i + 5];
                        secondCondition = params[i + 6];
                    }
                }
                commandsHandler.printResult(firstCondition, secondCondition, command, carDataHandler);
            }
        }
    }
    private static void showCommand()
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
