package com.epam.automation.JavaCollections.MainTask.Console;

import com.epam.automation.JavaCollections.MainTask.Appliances.ConsumerElectronic;
import com.epam.automation.JavaCollections.MainTask.Appliances.HomeElectricAppliance;
import com.epam.automation.JavaCollections.MainTask.Appliances.MajorAppliance;
import com.epam.automation.JavaCollections.MainTask.CsvReader;
import com.epam.automation.JavaCollections.MainTask.Flat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleMenu
{
    final private String EXIT = "exit";

    Scanner sc = new Scanner(System.in);

    String inputConsoleLine="";

    ConsolePrinter consolePrinter = new ConsolePrinter();

    CsvReader collectionAppliances = new CsvReader();

    List<HomeElectricAppliance> homeElectricAppliances = collectionAppliances.getAllAppliances();

    Flat flatWithAllAppliances = new Flat(homeElectricAppliances);

    public void mainConsoleMenu()
    {
        while (!inputConsoleLine.equals(EXIT))
        {
            consolePrinter.printMainMenuDescription();

            inputConsoleLine = sc.nextLine();

            switch (inputConsoleLine)
            {
                case "1" -> {
                    consolePrinter.printPluggingMenuDescription();
                    startHandlerPluggingAppliance();
                }

                case "2" -> {
                    consolePrinter.printSearcherMenuDescription();
                    startHandlerSearcherAppliance();
                }

                case "3" -> startHandlerSortingByPowerAppliance();
                case "4" -> inputConsoleLine = EXIT;
                default -> System.out.println("Your choosing isn't recognized");
            }
        }
    }

    private void startHandlerPluggingAppliance()
    {
        Flat flatWithConnectedAppliances = new Flat();

        List<HomeElectricAppliance> connectedAppliance = new ArrayList<>();

        List<HomeElectricAppliance> homeElectricAppliances = collectionAppliances.getAllAppliances();

        String inputConsoleLine="";

        while (!inputConsoleLine.equals(EXIT))
        {
            inputConsoleLine = sc.nextLine();

            switch (inputConsoleLine)
            {
                case "1" -> {

                    if (connectedAppliance.size() != 0 && homeElectricAppliances.size() != 0)
                    {
                        connectedAppliance = flatWithConnectedAppliances.connectRandomAppliancesToElectricalNetwork(homeElectricAppliances, connectedAppliance);

                    }

                    if (homeElectricAppliances.size() == 0)
                    {
                        System.out.println();
                        System.out.println("Nothing to connect");
                    }

                    else if (connectedAppliance.size() == 0)
                    {
                        connectedAppliance = flatWithConnectedAppliances.getRandomAppliance(homeElectricAppliances);
                    }
                    consolePrinter.printConnectedApplianceToElectricNetwork(connectedAppliance);
                    consolePrinter.printPowerConnectedAppliancesInHome(flatWithConnectedAppliances.getWholePowerConnectedAppliancesInHome(connectedAppliance));
                    consolePrinter.printPluggingMenuDescription();
                }

                case "2" -> inputConsoleLine = EXIT;
                default -> System.out.println("Your a choice isn't recognized");
            }
        }
    }

    private void startHandlerSearcherAppliance()
    {
        String inputConsoleLine="";
        String parameterTypeOfAppliance;

        int min;
        int max;

        while (!inputConsoleLine.equals(EXIT))
        {
            inputConsoleLine = sc.nextLine();

            Pattern pattern = Pattern.compile("\\s*(\\s|,|\\)|-|\\(|!|\\.)\\s*");

            String[] splitConsoleLineWithParams = pattern.split(inputConsoleLine);

            if(splitConsoleLineWithParams.length == 3)
            {
                parameterTypeOfAppliance = splitConsoleLineWithParams[0];
                min = Integer.parseInt(splitConsoleLineWithParams[1]);
                max = Integer.parseInt(splitConsoleLineWithParams[2]);

                if (parameterTypeOfAppliance.equalsIgnoreCase("BatteryCapacity"))
                {
                    List<ConsumerElectronic> consumerElectronics = flatWithAllAppliances.getConsumerElectronicAppliance();

                    List<ConsumerElectronic> filteredConsumerElectronicByBatteryCapacity =
                            flatWithAllAppliances.filterByBatteryCapacity(min, max, consumerElectronics);

                    consolePrinter.printAppliances(filteredConsumerElectronicByBatteryCapacity);
                }

                if (parameterTypeOfAppliance.equalsIgnoreCase("Size"))
                {
                    List<MajorAppliance> majorAppliances = flatWithAllAppliances.getMajorAppliance();

                    List<MajorAppliance> filteredMajorApplianceBySize =
                            flatWithAllAppliances.filterBySize(min, max, majorAppliances);

                    consolePrinter.printAppliances(filteredMajorApplianceBySize);
                }

                if ((parameterTypeOfAppliance.equalsIgnoreCase("Power")))
                {
                    List<HomeElectricAppliance> filteredAppliancesByPower =
                            flatWithAllAppliances.filterByPower(min, max);

                    consolePrinter.printAppliances(filteredAppliancesByPower);
                }
            }

            if (inputConsoleLine.equals("1"))
            {
                inputConsoleLine = EXIT;
            }
            else if(splitConsoleLineWithParams.length !=3)
            {
                System.out.println("Command isn't recognized");
            }
        }
    }

    private void startHandlerSortingByPowerAppliance()
    {
        consolePrinter.printSortedAppliancesByPower(flatWithAllAppliances.getSortedHomeElectricApplianceByPower());
        consolePrinter.printSortedMenuDescription();

        String inputConsoleLine="";

        while (!inputConsoleLine.equals(EXIT))
        {
            inputConsoleLine = sc.nextLine();

            if (inputConsoleLine.equals("1"))
            {
                System.out.println();
                inputConsoleLine = EXIT;
            }
        }
    }
}

