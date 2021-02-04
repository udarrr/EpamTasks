package com.epam.automation.JavaCollections;

import com.epam.automation.JavaCollections.Console.ConsoleMenu;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class Start
{
    public static void main(String[] args) throws IOException, CsvException
    {
        new ConsoleMenu().mainConsoleMenu();
    }
}
