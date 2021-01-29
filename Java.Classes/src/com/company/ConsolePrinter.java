package com.company;

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
