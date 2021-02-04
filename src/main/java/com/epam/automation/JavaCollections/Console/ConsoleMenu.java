package com.epam.automation.JavaCollections.Console;

import com.epam.automation.JavaCollections.Appliances.ConsumerElectronic;
import com.epam.automation.JavaCollections.Appliances.HomeElectricAppliance;
import com.epam.automation.JavaCollections.Appliances.MajorAppliance;
import com.epam.automation.JavaCollections.CollectionAppliances;
import com.epam.automation.JavaCollections.Flat;
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
                    case "1" -> {
                        consolePrinter.printDescriptionPluggingMenu();
                        startHandlerPluggingAppliance();
                    }

                    case "2" -> {
                        consolePrinter.printDescriptionSearcherMenu();
                        startHandlerSearcherAppliance();
                    }

                    case "3" -> startHandlerSortingByPowerAppliance();
                    case "4" -> consoleLineMainMenu = EXIT;
                    default -> System.out.println("Your choosing isn't recognized");
                }
            }
            catch (IOException | CsvException e)
            {
                System.out.println(e.getMessage() +" Command isn't recognized");
            }
        }
    }

    private void startHandlerPluggingAppliance() throws IOException, CsvException
    {
        List<HomeElectricAppliance> connectedAppliance = new ArrayList<>();

        List<HomeElectricAppliance> homeElectricAppliances = collectionAppliances.getAllAppliances();

        String consoleLineFirstPositionMenu="";

        while (!consoleLineFirstPositionMenu.equals(EXIT))
        {
            consoleLineFirstPositionMenu = sc.nextLine();

            switch (consoleLineFirstPositionMenu)
            {
                case "1" -> {

                    if (connectedAppliance.size() != 0 && homeElectricAppliances.size() != 0)
                    {
                        connectedAppliance = flat.connectRandomAppliancesToElectricalNetwork(homeElectricAppliances, connectedAppliance);

                    } else if (connectedAppliance.size() == 0)
                    {
                        connectedAppliance = flat.getRandomAppliance(homeElectricAppliances);
                    }
                    consolePrinter.printConnectedApplianceToElectricNetwork(connectedAppliance);
                    consolePrinter.printPowerConnectedAppliancesInHome(flat.getWholePowerConnectedAppliancesInHome(connectedAppliance));
                    consolePrinter.printDescriptionPluggingMenu();

                    if (homeElectricAppliances.size() == 0)
                    {
                        System.out.println();
                        System.out.println("Nothing to connect");
                    }
                }

                case "2" -> consoleLineFirstPositionMenu = EXIT;
                default -> System.out.println("Your choosing isn't recognized");
            }
        }
    }

    private void startHandlerSearcherAppliance() throws IOException, CsvException
    {
        String consoleLineSecondPositionMenu="";
        String parameterTypeOfAppliance;

        int firstValueTheRange;
        int secondValueTheRange;

        while (!consoleLineSecondPositionMenu.equals(EXIT))
        {
            consoleLineSecondPositionMenu = sc.nextLine();

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
                            flat.getBatteryCapacityConsumerElectronicAppliancesBetweenTheRange(firstValueTheRange, secondValueTheRange,
                                    flat.getConsumerElectronicAppliance(homeElectricAppliances));

                    consolePrinter.printAppliances(filteredConsumerElectronicByBatteryCapacity);
                }

                if ((parameterTypeOfAppliance.equalsIgnoreCase("Size")))
                {
                    List<MajorAppliance> filteredMajorApplianceBySize =
                            flat.getSizeMajorApplianceBetweenTheRange(firstValueTheRange, secondValueTheRange, flat.getMajorAppliance(homeElectricAppliances));

                    consolePrinter.printAppliances(filteredMajorApplianceBySize);
                }

                if ((parameterTypeOfAppliance.equalsIgnoreCase("Power")))
                {
                    List<HomeElectricAppliance> filteredAppliancesByPower =
                            flat.getPowerHomeElectricAppliancesBetweenTheRange(firstValueTheRange, secondValueTheRange, homeElectricAppliances);

                    consolePrinter.printAppliances(filteredAppliancesByPower);
                }
            }

            if ("1".equals(consoleLineSecondPositionMenu))
            {
                consoleLineSecondPositionMenu = EXIT;
            }
            else if(splitConsoleLineWithParams.length !=3)
            {
                System.out.println("Command isn't recognized");
            }
        }
    }

    private void startHandlerSortingByPowerAppliance() throws IOException, CsvException
    {
        List<HomeElectricAppliance> homeElectricAppliances = collectionAppliances.getAllAppliances();

        consolePrinter.printSortedAppliancesByPower(flat.getSortedHomeElectricApplianceByPower(homeElectricAppliances));
        consolePrinter.printDescriptionSortedMenu();

        String consoleLineThirdPositionMenu="";

        while (!consoleLineThirdPositionMenu.equals(EXIT))
        {
            consoleLineThirdPositionMenu = sc.nextLine();

            if ("1".equals(consoleLineThirdPositionMenu))
            {
                System.out.println();
                consoleLineThirdPositionMenu = EXIT;
            }
        }
    }
}

