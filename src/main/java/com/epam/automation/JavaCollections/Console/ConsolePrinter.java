package com.epam.automation.JavaCollections.Console;

import com.epam.automation.JavaCollections.Appliances.HomeElectricAppliance;

import java.util.List;

public class ConsolePrinter
{
    public void printAppliances(List<? extends HomeElectricAppliance> appliances)
    {
        for(HomeElectricAppliance appliance: appliances)
        {
            System.out.println(appliance);
        }
    }

    public void printConnectedApplianceToElectricNetwork(List<HomeElectricAppliance> connectedAppliance)
    {
        System.out.println("Connected: ");

        for(HomeElectricAppliance connectedHomeElectricAppliance:connectedAppliance)
        {
            System.out.println(connectedHomeElectricAppliance);
        }
    }

    public void printPowerConnectedAppliancesInHome(int connectedAppliance)
    {
        System.out.println();
        System.out.println("Entire Power connected appliances in electric network: " + connectedAppliance + "Watt");
    }

    public void printSortedAppliancesByPower(List<HomeElectricAppliance> sortedAppliances)
    {
        for(HomeElectricAppliance connectedHomeElectricAppliance:sortedAppliances)
        {
            System.out.println(connectedHomeElectricAppliance);
        }
    }

    public void printDescriptionMainMenu()
    {
        System.out.println();
        System.out.println("Please choose position of menu enter it in console and press button ENTER");
        System.out.println("Menu");
        System.out.println("1.Plugging into");
        System.out.println("2.Search by range");
        System.out.println("3.Sorting appliances by power");
        System.out.println("4.Exit");
    }

    public void printDescriptionPluggingMenu()
    {
        System.out.println();
        System.out.println("You can switch on some random electric appliances in outlet one by one");
        System.out.println("When you are going out from here all appliances to be unplugged");
        System.out.println();
        System.out.println("Menu");
        System.out.println("1.Switch on next one");
        System.out.println("2.Exit to previous menu");
    }

    public void printDescriptionSearcherMenu()
    {
        System.out.println();
        System.out.println("Examples for search");
        System.out.println(" 'size 1-100' or 'power 1-10000' or 'batterycapacity 1-10000' where word is parameter of appliance that have got it" );
        System.out.println("first number is first condition that mean size > 10 and second number is second condition that mean size < 100");
        System.out.println("We have 3 commands it's size,power,batterycapacity");
        System.out.println("Please enter your command in console line or enter exit");
        System.out.println();
        System.out.println("Menu");
        System.out.println("1.Exit to previous menu");
    }

    public void printDescriptionSortedMenu()
    {
        System.out.println();
        System.out.println("Sorted appliances by power");
        System.out.println();
        System.out.println("1.Exit to previous menu");
    }
}