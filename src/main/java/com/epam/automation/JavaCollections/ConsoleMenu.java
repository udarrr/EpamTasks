package com.epam.automation.JavaCollections;

import com.epam.automation.JavaCollections.Appliances.HomeElectricAppliance;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu
{
    final private String EXIT = "exit";
    final private String firstPositionMenu = "1";
    final private String secondPositionMenu = "2";
    Scanner sc = new Scanner(System.in);
    String consoleLineMainMenu ="";
    String consoleLineFirstPositionMenu ="";
    String consoleLineSecondPositionMenu ="";

    public void Start() throws IOException, CsvException
    {
        while (!consoleLineMainMenu.equals(EXIT))
        {
            printDescriptionOfMenu();

            consoleLineMainMenu = sc.nextLine();
            switch (consoleLineMainMenu)
            {
                case "1":
                    printDescriptionEntireFirstPositionOfMenu();
                    break;
                case "2":
                    printDescriptionEntireSecondPositionOfMenu();
                    break;
                case "3":
                    consoleLineMainMenu = EXIT;
                    break;
                default:System.out.println("Your choosing isn't recognized");
            }
        }
    }

    public void printDescriptionOfMenu()
    {
        System.out.println("Menu");
        System.out.println("Please chose position of menu enter it in console and press button ENTER");
        System.out.println("1.Switching");
        System.out.println("2.SearchByRange");
        System.out.println("3.Exit");
    }

    public void printDescriptionEntireFirstPositionOfMenu() throws IOException, CsvException
    {
        System.out.println("Menu");
        System.out.println("1.Switch someone appliance");
        System.out.println("2.Exit to previous menu");

        List<HomeElectricAppliance> homeElectricAppliances = new CsvReaderToCollection().getApplianceFromCsvFile();
        Flat flat = new Flat(homeElectricAppliances);
        List<HomeElectricAppliance> switchedAppliance = new ArrayList<>();

        while (!consoleLineFirstPositionMenu.equals(EXIT))
        {
            consoleLineFirstPositionMenu = sc.nextLine();

            switch (consoleLineFirstPositionMenu)
            {
                case "1":
                    if(switchedAppliance.size() == 0)
                    {
                        switchedAppliance = flat.connectRandomApplianceToElectricalNetwork();
                    }
                    else
                    {
                        switchedAppliance = flat.connectRandomApplianceToElectricalNetwork(switchedAppliance);
                    }
                    break;
                case "2":
                    consoleLineFirstPositionMenu = EXIT;
                    break;
                default:
                    System.out.println("Your choosing isn't recognized");
            }
        }
    }

    public void printDescriptionEntireSecondPositionOfMenu()
    {
        System.out.println("Examples for search");
        System.out.println("size(10,100) where size is parameter of appliance that have got it" );
        System.out.println("10 is first condition that mean size > 10 and 100 is second condition that mean size < 100");
        System.out.println("We have 3 commands it's size(*,*),power(*,*),batterysize(*,*)");
        System.out.println("Please enter your command in console line or enter exit");
        System.out.println("");
        System.out.println("Menu");
        System.out.println("1.Exit to previous menu");

        while (!consoleLineSecondPositionMenu.equals(EXIT))
        {
            consoleLineSecondPositionMenu = sc.nextLine();

            switch (consoleLineSecondPositionMenu)
            {
                case "1":
                    consoleLineSecondPositionMenu = EXIT;
                    break;
                default:
                    System.out.println("Your choosing isn't recognized");
            }
        }
    }

}

