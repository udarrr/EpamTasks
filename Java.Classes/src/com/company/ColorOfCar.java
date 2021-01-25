package com.company;

public class ColorOfCar extends YearOfCar
{
    private String color;

    public ColorOfCar(int id, String vendor, String model,int year, String color)
    {
        super(id, vendor, model, year);
        this.color = color;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public static void print(RegIdOfCar[] vendor, String request, String command)
    {
        for (RegIdOfCar item : vendor)
        {
            if(command.equals("=")) {
                if (item.getColor().equalsIgnoreCase(request))
                {
                    System.out.println(item.toString());
                }
            }
        }
    }

    public static int ValueIndexForArrSecondCommand(RegIdOfCar[] cars, String request, String command)
    {
        int length = 0;
        for (int i = 0; i < cars.length; i++)
        {
            if(command.equals("="))
            {
               if (cars[i].getColor().equalsIgnoreCase(request))
                {
                    length++;
                }
            }
        }
        return length;
    }

    public static RegIdOfCar[] DataFromFirstCommand(RegIdOfCar[] cars, String request, String command)
    {
        int valueIndex  = ColorOfCar.ValueIndexForArrSecondCommand(cars,request,command);
        RegIdOfCar[] result = new RegIdOfCar[valueIndex];

        for (int i = 0,j=0; i < cars.length; i++)
        {
            if(command.equals("="))
            {
                if (cars[i].getColor().equalsIgnoreCase(request))
                {
                    result[j] = cars[i];
                    j++;
                }
            }
        }
        return  result;
    }

    @Override
    public String toString()
    {
        return " ID='"  + getId() + '\''  + " vendor='" + getVendor() + '\'' +
                " model='" + getModel() + '\'' + " year='" + getYear() + '\'' + " color='" + getColor() + '\'';
    }
}
