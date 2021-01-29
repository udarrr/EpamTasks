package com.company;

public class ConsolePrinter
{
    public void printCarDataResult(Car[] carDataResult)
    {
        for (Car item : carDataResult)
        {
            System.out.println(item.toString());
        }
    }
}
