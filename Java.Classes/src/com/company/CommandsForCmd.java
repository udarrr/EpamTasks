package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandsForCmd
{
    public static void CommadLine() throws IOException,ArrayIndexOutOfBoundsException {

        RegIdOfCar[] car = CreateDataAboutCars.CreateMassive();
        RegIdOfCar[] initCar = car.clone();

        for (RegIdOfCar item:initCar)
        {
         System.out.println(item);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while (!input.equalsIgnoreCase("exit"))
        {
            try {
                car = initCar;
                showCommand();
                input = in.readLine();
                String[] params = input.split("[\\s(^'.'$)]");
                String firstCondition = params[0];
                String command = params[1];
                String secondCondition = params[2];

                try {
                    for (int i = 0; i < params.length-3; i += 4)
                    {
                        String AdditionalOperation = params[i + 3];
                        boolean checkSecondOperation = AdditionalOperation.equalsIgnoreCase("AND");
                        if (checkSecondOperation)
                        {
                            car = SecondOperationHandler(firstCondition, secondCondition, command, car);
                        }
                        firstCondition = params[i + 4];
                        command = params[i + 5];
                        secondCondition = params[i + 6];
                    }
                    FirstOperationPrint(firstCondition, secondCondition, command, car);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                }
            }catch (Exception e){System.out.println("Command is not recognized");}
        }
    }
    public static void showCommand()
    {
        System.out.println("");
        System.out.println("Commands '=' is equal '>' is more ,'<' is less, '%' is time exploitation, 'AND' is additional operation ");
        System.out.println("Use space between words: vendor,model,year,color,price,regid");
        System.out.println("****************Examples****************");
        System.out.println("vendor = BMW");
        System.out.println("model = LADASedan and year % 10");
        System.out.println("year = 2004 and price > 5000");
        System.out.println("model = X7 and year % 10 and price > 10000");
        System.out.println("****************************************");
    }

    public static void FirstOperationPrint(String firstCondition, String secondCondition, String command, RegIdOfCar[] car)
    {
        try {
            switch (firstCondition) {

                case "vendor":
                    VendorOfCar.print(car, secondCondition, command);
                    break;
                case "model":
                    ModelOfCar.print(car, secondCondition, command);
                    break;
                case "regid":
                    RegIdOfCar.print(car, secondCondition, command);
                    break;
                case "color":
                    ColorOfCar.print(car, secondCondition, command);
                    break;
                case "year":
                    YearOfCar.print(car, Integer.parseInt(secondCondition), command);
                    break;
                case "price":
                    PriceOfCar.print(car, Double.parseDouble(secondCondition), command);
                    break;
                default:
                    System.out.println("Wrong command");
            }
        } catch (NumberFormatException e) {System.out.println(e + " Try again");}
    }

    public static RegIdOfCar[] SecondOperationHandler(String firstCondition, String secondCondition, String command, RegIdOfCar[] car)
    {
        RegIdOfCar[] result = new RegIdOfCar[0];

        switch (firstCondition)
        {
            case "vendor":
                result = VendorOfCar.DataFromFirstCommand(car, secondCondition, command);
                break;
            case "model":
                result = ModelOfCar.DataFromFirstCommand(car, secondCondition, command);
                break;
            case "regid":
                result = RegIdOfCar.DataFromFirstCommand(car, secondCondition, command);
                break;
            case "color":
                result = ColorOfCar.DataFromFirstCommand(car, secondCondition, command);
                break;
            case "year":
                result = YearOfCar.DataFromFirstCommand(car, Integer.parseInt(secondCondition), command);
                break;
            case "price":
                result = PriceOfCar.DataFromFirstCommand(car, Double.parseDouble(secondCondition), command);
                break;
            default:
                System.out.println("Wrong command");
        }
        return result;
    }
}
