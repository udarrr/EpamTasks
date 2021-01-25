package com.company;

public class RegIdOfCar extends PriceOfCar
{
    private String regId;


    public RegIdOfCar(int id, String vendor, String model, int year, String color, Double price, String regId)
    {
        super(id, vendor, model, year, color, price);
        this.regId = regId;
    }

    public RegIdOfCar(int id, String vendor, String model, int year, String color, Double price)
    {
        super(id, vendor, model, year, color, price);
    }

    public String getRegId()
    {
        return regId;
    }

    public void setRegId(String regId)
    {
        this.regId = regId;
    }

    public static void print(RegIdOfCar[] vendor, String request, String command)
    {
        for (RegIdOfCar item : vendor)
        {
            if(command.equals("=")) {
               if (item.getRegId().equalsIgnoreCase(request))
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
                if (cars[i].getRegId().equalsIgnoreCase(request))
                {
                    length++;
                }
            }
        }
        return length;
    }

    public static RegIdOfCar[] DataFromFirstCommand(RegIdOfCar[] cars, String request, String command)
    {
        int valueIndex  = RegIdOfCar.ValueIndexForArrSecondCommand(cars,request,command);
        RegIdOfCar[] result = new RegIdOfCar[valueIndex];

        for (int i = 0,j=0; i < cars.length; i++)
        {
            if(command.equals("="))
            {
                if (cars[i].getRegId().equalsIgnoreCase(request))
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
                    " model='" + getModel() + '\'' + " year='" + getYear() + '\'' + " color='" + getColor() + '\'' +
                    " price='" + getPrice() + '\'' + " regId='"+ getRegId();

    }
}
