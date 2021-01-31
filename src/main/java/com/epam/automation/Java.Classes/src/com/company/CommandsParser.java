package com.epam.automation.Java.Classes.src.com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CommandsParser
{
    public Car[] getDataFromVendor(Car[] carData, String vendorRequest, String command)
    {
        int length = 0;

        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getVendor().name().equalsIgnoreCase(vendorRequest))
            {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0,j=0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getVendor().name().equalsIgnoreCase(vendorRequest))
            {
                result[j++] = carData[i];
            }
        }

        return  result;
    }

    public Car[] getDataFromModel(Car[] carData, String modelRequest, String command)
    {
        int length = 0;

        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getModel().equalsIgnoreCase(modelRequest))
            {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0,j=0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getModel().equalsIgnoreCase(modelRequest))
            {
                result[j++] = carData[i];
            }
        }

        return  result;
    }

    public Car[] getDataFromYear(Car[] carData, int yearRequest, String command)
    {
        int length = 0;


        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getYear() == yearRequest)
            {
                length++;
            }
        }
        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals(">") && carData[i].getYear() > yearRequest)
            {
                length++;
            }
        }
        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("<") && carData[i].getYear() < yearRequest)
            {
                length++;
            }
        }

        Calendar calendar = new GregorianCalendar();
        int yearNow = calendar.get(Calendar.YEAR);

        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("%") &&  (yearNow - carData[i].getYear()) > yearRequest)
            {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0,j=0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getYear() == yearRequest)
            {
                result[j++] = carData[i];
            }

            if (command.equals(">") && carData[i].getYear() > yearRequest)
            {
                result[j++] = carData[i];
            }

            if (command.equals("<") && carData[i].getYear() < yearRequest)
            {
                result[j++] = carData[i];
            }

            if (command.equals("%") && (yearNow - carData[i].getYear()) > yearRequest)
            {
                result[j++] = carData[i];
            }

        }
        return  result;
    }

    public Car[] getDataFromPrice(Car[] carData, double priceRequest, String command)
    {
        int length = 0;

        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getPrice() == priceRequest)
            {
                length++;
            }
        }
        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals(">") && carData[i].getPrice() > priceRequest)
            {
                length++;
            }
        }
        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("<") && carData[i].getPrice() < priceRequest)
            {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0,j=0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getPrice() == priceRequest)
            {
                result[j++] = carData[i];
            }

            if (command.equals(">") && carData[i].getPrice() > priceRequest)
            {
                result[j++] = carData[i];
            }

            if (command.equals("<") && carData[i].getPrice() < priceRequest)
            {
                result[j++] = carData[i];
            }
        }
        return  result;
    }

    public Car[] getDataFromColor(Car[] cars, String colorRequest, String command)
    {
        int length = 0;

        for (int i = 0; i < cars.length; i++)
        {
            if (command.equals("=") && cars[i].getColor().name().equalsIgnoreCase(colorRequest))
            {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0,j=0; i < cars.length; i++)
        {
            if (command.equals("=") && cars[i].getColor().name().equalsIgnoreCase(colorRequest))
            {
                result[j++] = cars[i];
            }
        }

        return  result;
    }

    public Car[] getDataFromRegId(Car[] carData, String registrationNumber, String command)
    {
        int length = 0;

        for (int i = 0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getRegistrationNumber().equalsIgnoreCase(registrationNumber))
            {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0,j=0; i < carData.length; i++)
        {
            if (command.equals("=") && carData[i].getRegistrationNumber().equalsIgnoreCase(registrationNumber))
            {
                result[j++] = carData[i];
            }
        }
        return  result;
    }

    public Car[] getDataFromArrayOfCar(String firstCondition, String secondCondition, String command, Car[] carData)
    {
        Car[] dataFromArrayOfCar = new Car[0];
        CommandsParser dataHandler = new CommandsParser();

        switch (firstCondition)
        {
            case "vendor":
                dataFromArrayOfCar = dataHandler.getDataFromVendor(carData, secondCondition, command);
                break;
            case "model":
                dataFromArrayOfCar = dataHandler.getDataFromModel(carData, secondCondition, command);
                break;
            case "regId":
                dataFromArrayOfCar = dataHandler.getDataFromRegId(carData, secondCondition, command);
                break;
            case "color":
                dataFromArrayOfCar = dataHandler.getDataFromColor(carData, secondCondition, command);
                break;
            case "year":
                dataFromArrayOfCar = dataHandler.getDataFromYear(carData, Integer.parseInt(secondCondition), command);
                break;
            case "price":
                dataFromArrayOfCar = dataHandler.getDataFromPrice(carData, Double.parseDouble(secondCondition), command);
                break;
            default:
                System.out.println("Command isn't recognized");
        }
        return dataFromArrayOfCar;
    }
}
