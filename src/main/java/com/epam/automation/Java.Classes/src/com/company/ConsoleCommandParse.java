package com.epam.automation.Java.Classes.src.com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ConsoleCommandParse
{
    public Car[] getCarsAfterConsoleCommands (Car[] cars, String[] consoleCommand) throws ArrayIndexOutOfBoundsException
    {
        final String AND = "and";
        ConsoleCommandReader consoleCommandReader = new ConsoleCommandReader();

            if (consoleCommand[0] != null && consoleCommand[1] != null && consoleCommand[2] != null)
            {
                String firstCondition = consoleCommand[0];
                String command = consoleCommand[1];
                String secondCondition = consoleCommand[2];

                for (int i = 0; i < consoleCommand.length - 3; i += 4)
                {
                    String additionalOperation = consoleCommand[i + 3];

                    if (additionalOperation.equalsIgnoreCase(AND))
                    {
                        cars = consoleCommandReader.getParametersCars(firstCondition, secondCondition, command, cars);
                        if (consoleCommand[i + 4] != null)
                        {
                            firstCondition = consoleCommand[i + 4];
                        }
                        if (consoleCommand[i + 5] != null)
                        {
                            command = consoleCommand[i + 5];
                        }
                        if (consoleCommand[i + 6] != null)
                        {
                            secondCondition = consoleCommand[i + 6];
                        }
                    }
                }
                if(consoleCommand.length == 3)
                {
                    cars = consoleCommandReader.getParametersCars(firstCondition, secondCondition, command, cars);
                }
            }

            return cars;
    }

    public Car[] getVendor(Car[] carData, String vendorRequest, String command)
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

    public Car[] getModel(Car[] carData, String modelRequest, String command)
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

    public Car[] getYear(Car[] carData, int yearRequest, String command)
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

    public Car[] getPrice(Car[] carData, double priceRequest, String command)
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

    public Car[] getColor(Car[] cars, String colorRequest, String command)
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

    public Car[] getRegistrationNumber(Car[] carData, String registrationNumber, String command)
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
}
