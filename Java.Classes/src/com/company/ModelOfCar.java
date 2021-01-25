package com.company;

public class ModelOfCar extends VendorOfCar
{
    private String model;

    public ModelOfCar(int id, String vendor, String model)
    {
        super(id, vendor);
        this.model = model;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public static void print(RegIdOfCar[] vendor, String request, String command)
    {
        for (RegIdOfCar item : vendor)
        {
            if(command.equals("=")) {
                if (item.getModel().equalsIgnoreCase(request))
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
                if (cars[i].getModel().equals(request))
                {
                    length++;
                }
            }
        }
        return length;
    }

    public static RegIdOfCar[] DataFromFirstCommand(RegIdOfCar[] cars, String request, String command)
    {
        int valueIndex  = ModelOfCar.ValueIndexForArrSecondCommand(cars,request,command);
        RegIdOfCar[] result = new RegIdOfCar[valueIndex];

        for (int i = 0,j=0; i < cars.length; i++)
        {
            if(command.equals("="))
            {
                if (cars[i].getModel().equalsIgnoreCase(request))
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
        return getId() + " " + getVendor() + " " + getModel();
    }
}
