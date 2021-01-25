package com.company;

public class VendorOfCar
{
    private int id;
    private String vendor;

    public VendorOfCar(int id, String vendor)
    {
        this.id = id;
        this.vendor = vendor;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getVendor()
    {
        return vendor;
    }

    public void setVendor(String vendor)
    {
        this.vendor = vendor;
    }

    public static void print(RegIdOfCar[] vendor, String request, String command)
    {
        for (RegIdOfCar item : vendor)
        {
            if(command.equals("=")) {
                if (item.getVendor().equalsIgnoreCase(request))
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
                if (cars[i].getVendor().equalsIgnoreCase(request))
                {
                    length++;
                }
            }
        }
        return length;
    }

    public static RegIdOfCar[] DataFromFirstCommand(RegIdOfCar[] cars, String request, String command)
    {
        int valueIndex  = VendorOfCar.ValueIndexForArrSecondCommand(cars,request,command);
        RegIdOfCar[] result = new RegIdOfCar[valueIndex];

        for (int i = 0,j=0; i < cars.length; i++)
        {
            if(command.equals("="))
            {
                if (cars[i].getVendor().equalsIgnoreCase(request))
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
        return " ID='"  + getId() + '\''  + " vendor='" + getVendor() + '\'';
    }
}
