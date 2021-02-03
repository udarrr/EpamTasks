package com.epam.automation.JavaCollections;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class Start
{
    public static void main(String[] args) throws IOException, CsvException
    {
        ConsoleMenu consoleMenu = new ConsoleMenu();
        consoleMenu.mainConsoleMenu();
    }
}
