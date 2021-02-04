package com.epam.automation.JavaCollections;

import com.epam.automation.JavaCollections.Appliances.ConsumerElectronic;
import com.epam.automation.JavaCollections.Appliances.HomeElectricAppliance;
import com.epam.automation.JavaCollections.Appliances.MajorAppliance;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleMenu
{
    final private String EXIT = "exit";

    Scanner sc = new Scanner(System.in);

    String consoleLineMainMenu="";

    ConsolePrinter consolePrinter = new ConsolePrinter();

    CollectionAppliances collectionAppliances = new CollectionAppliances();

    Flat flat = new Flat();

    public void mainConsoleMenu()
    {
        while (!consoleLineMainMenu.equals(EXIT))
        {
            consolePrinter.printDescriptionMainMenu();

            consoleLineMainMenu = sc.nextLine();

            try
            {
                switch (consoleLineMainMenu)
                {
                    case "1":
                        consolePrinter.printDescriptionFirstPositionMenu();
                        startHandlerFirstPositionMenu();
                        break;

                    case "2":
                        consolePrinter.printDescriptionSecondPositionOfMenu();
                        startHandlerSecondPositionMenu();
                        break;

                    case "3":
                        startHandlerThirdPositionMenu();
                        break;

                    case "4":
                        consoleLineMainMenu = EXIT;
                        break;

                    default:
                        System.out.println("Your choosing isn't recognized");
                }
            }catch (IOException | CsvException e)
            {
                System.out.println(e.getMessage() +" Command isn't recognized");
            }
        }
    }

    private void startHandlerFirstPositionMenu() throws IOException, CsvException
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

    private void startHandlerSecondPositionMenu() throws IOException, CsvException
    {
        String consoleLineSecondPositionMenu="";
        String parameterTypeOfAppliance = "";

        int firstValueTheRange = 0;
        int secondValueTheRange = 0;

        List<HomeElectricAppliance> homeElectricAppliances = collectionAppliances.getAllAppliances();
        Pattern pattern = Pattern.compile("\\s*(\\s|,|\\)|-|\\(|!|\\.)\\s*");
        String[] splitConsoleLineWithParams = pattern.split(consoleLineSecondPositionMenu);

        if(splitConsoleLineWithParams.length == 3)
        {
            parameterTypeOfAppliance = splitConsoleLineWithParams[0];
            firstValueTheRange = Integer.parseInt(splitConsoleLineWithParams[1]);
            secondValueTheRange = Integer.parseInt(splitConsoleLineWithParams[2]);


            if (parameterTypeOfAppliance.equalsIgnoreCase("BatteryCapacity"))
            {
                List<ConsumerElectronic> filteredConsumerElectronicByBatteryCapacity =
                        flat.getAppliancesWithParametersBetweenTheRange(firstValueTheRange, secondValueTheRange,
                                flat.getConsumerElectronicAppliance(homeElectricAppliances));

                consolePrinter.printConsumerElectronicAppliances(filteredConsumerElectronicByBatteryCapacity);
            }

            if ((parameterTypeOfAppliance.equalsIgnoreCase("Size")))
            {
                List<MajorAppliance> filteredMajorApplianceBySize =
                        flat.getAppliancesWithParametersBetweenTheRange(firstValueTheRange,
                                flat.getMajorAppliance(homeElectricAppliances), secondValueTheRange);

                consolePrinter.printMajorAppliances(filteredMajorApplianceBySize);
            }

            if ((parameterTypeOfAppliance.equalsIgnoreCase("Power")))
            {
                List<HomeElectricAppliance> filteredAppliancesByPower =
                        flat.getAppliancesWithParametersBetweenTheRange(homeElectricAppliances, firstValueTheRange, secondValueTheRange);

                consolePrinter.printHomeElectricAppliance(filteredAppliancesByPower);
            }
        }

        while (!consoleLineSecondPositionMenu.equals(EXIT))
        {
            consoleLineSecondPositionMenu = sc.nextLine();

            switch (consoleLineSecondPositionMenu)
            {
                case "1":
                    consoleLineSecondPositionMenu = EXIT;
                    break;

                default:
                    consolePrinter.printDescriptionSecondPositionOfMenu();
                    System.out.println();
                    System.out.println("Wrong command please try again");
            }
        }
    }

    private void startHandlerThirdPositionMenu() throws IOException, CsvException
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

