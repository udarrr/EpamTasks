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
}
