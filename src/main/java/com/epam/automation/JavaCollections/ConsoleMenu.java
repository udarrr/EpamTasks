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

    Scanner sc = new Scanner(System.in);

    String consoleLineMainMenu="";

    ConsolePrinter consolePrinter = new ConsolePrinter();

    CollectionAppliances collectionAppliances = new CollectionAppliances();

    Flat flat = new Flat();

    public void mainConsoleMenu() throws IOException, CsvException
    {
        while (!consoleLineMainMenu.equals(EXIT))
        {
            consolePrinter.printDescriptionMainMenu();

            consoleLineMainMenu = sc.nextLine();

            switch (consoleLineMainMenu)
            {
                case "1":
                    consolePrinter.printDescriptionFirstPositionMenu();
                    setHandlerFirstPositionMenu();
                    break;

                case "2":
                    consolePrinter.printDescriptionSecondPositionOfMenu();
                    setHandlerSecondPositionMenu();
                    break;

                case "3":
                    setHandlerThirdPositionMenu();
                    break;

                case "4":
                    consoleLineMainMenu = EXIT;
                    break;

                default:System.out.println("Your choosing isn't recognized");
            }
        }
    }

    private void setHandlerFirstPositionMenu() throws IOException, CsvException
    {
        List<HomeElectricAppliance> connectedAppliance = new ArrayList<>();

        List<HomeElectricAppliance> homeElectricAppliances = collectionAppliances.getAllAppliances();

        String consoleLineFirstPositionMenu="";

        while (!consoleLineFirstPositionMenu.equals(EXIT))
        {
            consoleLineFirstPositionMenu = sc.nextLine();

            switch (consoleLineFirstPositionMenu)
            {
                case "1":

                    if(connectedAppliance.size() != 0 && homeElectricAppliances.size() != 0)
                    {
                        connectedAppliance = flat.connectRandomApplianceToElectricalNetwork(homeElectricAppliances,connectedAppliance);

                    } else if (connectedAppliance.size() == 0)
                    {
                        connectedAppliance = flat.getRandomAppliance(homeElectricAppliances);
                    }

                    consolePrinter.printConnectedApplianceToElectricNetwork(connectedAppliance);
                    consolePrinter.printPowerConnectedAppliancesInHome(flat.getWholePowerConnectedApplianceInHome(connectedAppliance));

                    consolePrinter.printDescriptionFirstPositionMenu();

                    if(homeElectricAppliances.size() == 0)
                    {
                        System.out.println();
                        System.out.println("Nothing to connect");
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

    private void setHandlerSecondPositionMenu()
    {
        String consoleLineSecondPositionMenu="";

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

    private void setHandlerThirdPositionMenu() throws IOException, CsvException
    {
        List<HomeElectricAppliance> homeElectricAppliances = collectionAppliances.getAllAppliances();

        consolePrinter.printSortedAppliancesByPower(flat.getSortedHomeElectricApplianceByPower(homeElectricAppliances));
        consolePrinter.printDescriptionThirdPositionOfMenu();

        String consoleLineThirdPositionMenu="";

        while (!consoleLineThirdPositionMenu.equals(EXIT))
        {
            consoleLineThirdPositionMenu = sc.nextLine();

            switch (consoleLineThirdPositionMenu)
            {
                case "1":
                    System.out.println();
                    consoleLineThirdPositionMenu = EXIT;
                    break;

                default:
                    System.out.println("Your choosing isn't recognized");
            }
        }
    }
}

