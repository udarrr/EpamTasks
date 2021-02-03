package com.epam.automation.JavaCollections;

import com.epam.automation.JavaCollections.Appliances.ConsumerElectronic;
import com.epam.automation.JavaCollections.Appliances.HomeElectricAppliance;
import com.epam.automation.JavaCollections.Appliances.MajorAppliance;
import com.epam.automation.JavaCollections.Appliances.SmallAppliance;

import java.util.*;

public class Flat
{
    private List<? extends HomeElectricAppliance> homeElectricAppliances;

    public Flat(List<? extends HomeElectricAppliance> homeElectricAppliances)
    {
        this.homeElectricAppliances = homeElectricAppliances;
    }

    public List<HomeElectricAppliance> getAllAppliance()
    {
        return new ArrayList<>(homeElectricAppliances);
    }

    public List<ConsumerElectronic> getConsumerElectronicAppliance()
    {
        List<ConsumerElectronic> consumerElectronics = new ArrayList<>();

        for (HomeElectricAppliance homeElectricAppliance: homeElectricAppliances)
        {
            if(homeElectricAppliance instanceof ConsumerElectronic)
            {
                consumerElectronics.add((ConsumerElectronic) homeElectricAppliance);
            }
        }

        return  consumerElectronics;

    }

    public List<MajorAppliance> getMajorAppliance()
    {
        List<MajorAppliance> majorAppliances = new ArrayList<>();

        for (HomeElectricAppliance homeElectricAppliance: homeElectricAppliances)
        {
            if(homeElectricAppliance instanceof MajorAppliance)
            {
                majorAppliances.add((MajorAppliance) homeElectricAppliance);
            }
        }

        return  majorAppliances;

    }

    public List<SmallAppliance> getSmallAppliance()
    {
        List<SmallAppliance> smallAppliances = new ArrayList<>();

        for (HomeElectricAppliance homeElectricAppliance: homeElectricAppliances)
        {
            if(homeElectricAppliance instanceof SmallAppliance)
            {
                smallAppliances.add((SmallAppliance) homeElectricAppliance);
            }
        }

        return  smallAppliances;

    }

    public  Flat getSortedHomeElectricApplianceByPower()
    {
        homeElectricAppliances.sort((Comparator<HomeElectricAppliance>) (o1,o2)-> (int) (o1.getPower() - o2.getPower()));

        return this;
    }

    public List<HomeElectricAppliance> getAppliancesWithParametersBetweenTheRange(int firstConditionTheRange, int secondConditionTheRange)
    {
        List<HomeElectricAppliance> filteredAppliancesByPowerBetweenRange = new ArrayList<>();

        for(HomeElectricAppliance homeElectricAppliance: homeElectricAppliances)
        {
            if(homeElectricAppliance.getPower() > firstConditionTheRange && homeElectricAppliance.getPower() < secondConditionTheRange)
            {
                filteredAppliancesByPowerBetweenRange.add(homeElectricAppliance);
            }
        }

        return filteredAppliancesByPowerBetweenRange;

    }


    public List<ConsumerElectronic> getAppliancesWithParametersBetweenTheRange(int firstConditionTheRange, int secondConditionTheRange, List<ConsumerElectronic> consumerElectronics)
    {
        List<ConsumerElectronic> filteredAppliancesByBatteryCapacityBetweenRange = new ArrayList<>();

        for(ConsumerElectronic consumerElectronic: consumerElectronics)
        {
            if(consumerElectronic.getBatteryCapacity() > firstConditionTheRange && consumerElectronic.getBatteryCapacity() < secondConditionTheRange)
            {
                filteredAppliancesByBatteryCapacityBetweenRange.add(consumerElectronic);
            }
        }

        return filteredAppliancesByBatteryCapacityBetweenRange;

    }

    public List<MajorAppliance> getAppliancesWithParametersBetweenTheRange(double firstConditionTheRange, double secondConditionTheRange, List<MajorAppliance> majorAppliances)
    {
        List<MajorAppliance> filteredAppliancesBySizeBetweenRange = new ArrayList<>();

        for(MajorAppliance majorAppliance: majorAppliances)
        {
            if(majorAppliance.getSize() > firstConditionTheRange && majorAppliance.getSize() < secondConditionTheRange)
            {
                filteredAppliancesBySizeBetweenRange.add(majorAppliance);
            }
        }

        return filteredAppliancesBySizeBetweenRange;

    }

    public List<HomeElectricAppliance> connectRandomApplianceToElectricalNetwork()
    {
        List<HomeElectricAppliance> someoneRandomConnectedApplianceToElectricalNetwork = new ArrayList<>();
        int numberRandomAppliance = homeElectricAppliances.size();
        someoneRandomConnectedApplianceToElectricalNetwork.add(homeElectricAppliances.get(0));

        return someoneRandomConnectedApplianceToElectricalNetwork;
    }

    public List<HomeElectricAppliance> connectRandomApplianceToElectricalNetwork(List<HomeElectricAppliance> connectedAppliances)
    {
        List<HomeElectricAppliance> appliancesConnectedToElectricalNetwork;
        for(HomeElectricAppliance exceptConnectedAppliance : homeElectricAppliances)
        {
            if (exceptConnectedAppliance.equals(connectedAppliances.get(0)))
            {
                homeElectricAppliances.remove(exceptConnectedAppliance);
            }
        }

        appliancesConnectedToElectricalNetwork =  connectRandomApplianceToElectricalNetwork();

        return appliancesConnectedToElectricalNetwork;
    }
}
