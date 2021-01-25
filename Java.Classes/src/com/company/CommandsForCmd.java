package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandsForCmd
{
    public static void CommadLine() throws IOException {
        RegIdOfCar[] car = CreateDataAboutCars.CreateMassive();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while (!input.equalsIgnoreCase("exit")) {
            showCommand();
            input = in.readLine();
            String[] params = input.split("[\\s(^'.'$)]");
            String firstConditional = params[0];
            String command = params[1];
            String secondConditional = params[2];

            try {

                for (int i = 0; i < params.length-4; i+=4)
                {
                    String AdditionalOperation = params[i+3];
                    boolean checkSecondOperation = AdditionalOperation.equalsIgnoreCase("AND");

                    if (checkSecondOperation)
                    {
                        car = SecondOperationHandler(firstConditional, secondConditional, command, car);
                        firstConditional = params[i+4];
                        command = params[i+5];
                        secondConditional = params[i+6];
                    }
                }
                FirstOperationPrint(firstConditional,secondConditional,command,car);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
            }
        }
    }
    public static void showCommand()
    {
        System.out.println("Enter vendor or model or year or color or price or regid or \"exit\" to exit");
    }

    public static void FirstOperationPrint(String firstConditional, String secondConditional, String command, RegIdOfCar[] car)
    {
        try {
            switch (firstConditional) {

                case "vendor":
                    VendorOfCar.print(car, secondConditional, command);
                    break;
                case "model":
                    ModelOfCar.print(car, secondConditional, command);
                    break;
                case "regid":
                    RegIdOfCar.print(car, secondConditional, command);
                    break;
                case "color":
                    ColorOfCar.print(car, secondConditional, command);
                    break;
                case "year":
                    YearOfCar.print(car, Integer.parseInt(secondConditional), command);
                    break;
                case "price":
                    PriceOfCar.print(car, Double.parseDouble(secondConditional), command);
                    break;
                default:
                    System.out.println("Wrong command");
            }
        } catch (NumberFormatException e) {System.out.println(e + " Try again");}
    }

    public static RegIdOfCar[] SecondOperationHandler(String firstConditional, String secondConditional, String command, RegIdOfCar[] car)
    {
        RegIdOfCar[] result = new RegIdOfCar[0];

        switch (firstConditional)
        {
            case "vendor":
                result = VendorOfCar.DataFromFirstCommand(car, secondConditional, command);
                break;
            case "model":
                result = ModelOfCar.DataFromFirstCommand(car, secondConditional, command);
                break;
            case "regid":
                result = RegIdOfCar.DataFromFirstCommand(car, secondConditional, command);
                break;
            case "color":
                result = ColorOfCar.DataFromFirstCommand(car, secondConditional, command);
                break;
            case "year":
                result = YearOfCar.DataFromFirstCommand(car, Integer.parseInt(secondConditional), command);
                break;
            case "price":
                result = PriceOfCar.DataFromFirstCommand(car, Double.parseDouble(secondConditional), command);
                break;
            default:
                System.out.println("Wrong command");
        }
        return result;
    }
}
