package com.company;

public class CommandsHandler
{
    public void printResult(String firstCondition, String secondCondition, String command, CarInfo[] car)
    {
        try {
            DataPrinter dataPrinter = new DataPrinter();

            switch (firstCondition) {

                case "vendor":
                    dataPrinter.printVendor(car, secondCondition, command);
                    break;
                case "model":
                    dataPrinter.printModel(car, secondCondition, command);
                    break;
                case "regId":
                    dataPrinter.printRegId(car, secondCondition, command);
                    break;
                case "color":
                    dataPrinter.printColor(car, secondCondition, command);
                    break;
                case "year":
                    dataPrinter.printYear(car, Integer.parseInt(secondCondition), command);
                    break;
                case "price":
                    dataPrinter.printPrice(car, Double.parseDouble(secondCondition), command);
                    break;
                default:
                    System.out.println("Wrong command");
            }
        } catch (NumberFormatException e) {System.out.println(e + " Try again");}
    }

    public CarInfo[] processingData(String firstCondition, String secondCondition, String command, CarInfo[] car)
    {
        CarInfo[] result = new CarInfo[0];
        DataHandler dataHandler = new DataHandler();

        switch (firstCondition)
        {
            case "vendor":
                result = dataHandler.getDataFromVendor(car, secondCondition, command);
                break;
            case "model":
                result = dataHandler.getDataFromModel(car, secondCondition, command);
                break;
            case "regId":
                result = dataHandler.getDataFromRegId(car, secondCondition, command);
                break;
            case "color":
                result = dataHandler.getDataFromColor(car, secondCondition, command);
                break;
            case "year":
                result = dataHandler.getDataFromYear(car, Integer.parseInt(secondCondition), command);
                break;
            case "price":
                result = dataHandler.getDataFromPrice(car, Double.parseDouble(secondCondition), command);
                break;
            default:
                System.out.println("Wrong command");
        }
        return result;
    }
}
