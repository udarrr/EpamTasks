package com.company;

public class CommandsHandler
{
    public void printResult(String firstCondition, String secondCondition, String command, Car[] carData)
    {
        ConsolePrinter consolePrinter = new ConsolePrinter();

        switch (firstCondition)
        {
            case "vendor":
                consolePrinter.printVendor(carData, secondCondition, command);
                break;
            case "model":
                consolePrinter.printModel(carData, secondCondition, command);
                break;
            case "regId":
                consolePrinter.printRegId(carData, secondCondition, command);
                break;
            case "color":
                consolePrinter.printColor(carData, secondCondition, command);
                break;
            case "year":
                consolePrinter.printYear(carData, Integer.parseInt(secondCondition), command);
                break;
            case "price":
                consolePrinter.printPrice(carData, Double.parseDouble(secondCondition), command);
                break;
            default:
                System.out.println("Command isn't recognized");
        }
    }
    public Car[] processData(String firstCondition, String secondCondition, String command, Car[] carData)
    {
        Car[] result = new Car[0];
        CarDataHandler dataHandler = new CarDataHandler();

        switch (firstCondition)
        {
            case "vendor":
                result = dataHandler.getDataFromVendor(carData, secondCondition, command);
                break;
            case "model":
                result = dataHandler.getDataFromModel(carData, secondCondition, command);
                break;
            case "regId":
                result = dataHandler.getDataFromRegId(carData, secondCondition, command);
                break;
            case "color":
                result = dataHandler.getDataFromColor(carData, secondCondition, command);
                break;
            case "year":
                result = dataHandler.getDataFromYear(carData, Integer.parseInt(secondCondition), command);
                break;
            case "price":
                result = dataHandler.getDataFromPrice(carData, Double.parseDouble(secondCondition), command);
                break;
            default:
                System.out.println("Command isn't recognized");
        }
        return result;
    }
}
