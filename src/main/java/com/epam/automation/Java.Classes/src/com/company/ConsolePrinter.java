package com.epam.automation.Java.Classes.src.com.company;

public class ConsolePrinter
{
    public void printCarData(Car[] carDataResult)
    {
        for (Car item : carDataResult)
        {
            System.out.println(item.toString());
        }
    }

    public void printDescriptionOfCommands()
    {
        System.out.println(" ");
        System.out.println("Commands '=' is equal '>' is more ,'<' is less, '%' is time exploitation, 'AND' is additional operation ");
        System.out.println("Use space between words: vendor,model,year,color,price,regId");
        System.out.println("****************Examples****************");
        System.out.println("vendor = MITSUBISHI");
        System.out.println("model = LADASedan and year % 10");
        System.out.println("year = 2004 and price > 5000");
        System.out.println("model = X7 and year % 10 and price > 10000");
        System.out.println("****************************************");
    }
}
