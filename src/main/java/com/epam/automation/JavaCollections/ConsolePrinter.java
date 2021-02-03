package com.epam.automation.JavaCollections;

import com.epam.automation.JavaCollections.Appliances.HomeElectricAppliance;

import java.util.List;

public class ConsolePrinter
{
    public void printConnectedApplianceToElectricNetwork(List<HomeElectricAppliance> connectedAppliance)
    {
        for(HomeElectricAppliance connectedHomeElectricAppliance:connectedAppliance)
        {
            System.out.println(connectedHomeElectricAppliance);
        }
    }

    public void printPowerConnectedAppliancesInHome(int connectedAppliance)
    {
        System.out.println();
        System.out.println("Entire Power connected appliances in electric network: " + connectedAppliance);
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
        System.out.println("Please chose position of menu enter it in console and press button ENTER");
        System.out.println("Menu");
        System.out.println("1.Switching");
        System.out.println("2.SearchByRange");
        System.out.println("3.Sorting appliances by power");
        System.out.println("4.Exit");
    }

    public void printDescriptionFirstPositionMenu()
    {
        System.out.println();
        System.out.println("Menu");
        System.out.println("1.Switch someone appliance");
        System.out.println("2.Exit to previous menu");
    }

    public void printDescriptionSecondPositionOfMenu()
    {
        System.out.println("");
        System.out.println("Examples for search");
        System.out.println("size(10,100) where size is parameter of appliance that have got it" );
        System.out.println("10 is first condition that mean size > 10 and 100 is second condition that mean size < 100");
        System.out.println("We have 3 commands it's size(*,*),power(*,*),batterysize(*,*)");
        System.out.println("Please enter your command in console line or enter exit");
        System.out.println("");
        System.out.println("Menu");
        System.out.println("1.Exit to previous menu");
    }

    public void printDescriptionThirdPositionOfMenu()
    {
        System.out.println();
        System.out.println("Sorted appliances by power");
        System.out.println("1.Exit to previous menu");
    }
}
