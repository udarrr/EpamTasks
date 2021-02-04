package com.epam.automation.JavaCollections;

import com.epam.automation.JavaCollections.Appliances.ConsumerElectronic;
import com.epam.automation.JavaCollections.Appliances.HomeElectricAppliance;
import com.epam.automation.JavaCollections.Appliances.MajorAppliance;

import java.util.*;

public class Flat
{
    public List<ConsumerElectronic> getConsumerElectronicAppliance(List<HomeElectricAppliance> homeElectricAppliances)
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

    public List<MajorAppliance> getMajorAppliance(List<HomeElectricAppliance> homeElectricAppliances)
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

    public List<HomeElectricAppliance> getSortedHomeElectricApplianceByPower(List<HomeElectricAppliance> homeElectricAppliances)
    {
        homeElectricAppliances.sort((Comparator<HomeElectricAppliance>) (o1, o2)-> (o1.getPower() - o2.getPower()));

        return new ArrayList<>(homeElectricAppliances);
    }

    public List<HomeElectricAppliance> getHomeElectricAppliancesWithParametersBetweenTheRange(List<HomeElectricAppliance> homeElectricAppliances,int firstConditionTheRange, int secondConditionTheRange)
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

    public List<ConsumerElectronic> getConsumerElectronicAppliancesWithParametersBetweenTheRange(int firstConditionTheRange, int secondConditionTheRange, List<ConsumerElectronic> consumerElectronics)
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

    public List<MajorAppliance> getMajorApplianceWithParametersBetweenTheRange(int firstConditionTheRange, int secondConditionTheRange, List<MajorAppliance> majorAppliances)
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

    public List<HomeElectricAppliance> getRandomAppliance(List<HomeElectricAppliance> homeElectricAppliances)
    {
        List<HomeElectricAppliance> someoneRandomConnectedApplianceToElectricalNetwork = new ArrayList<>();

        int numberRandomAppliance = homeElectricAppliances.size();

        someoneRandomConnectedApplianceToElectricalNetwork.add(homeElectricAppliances.
                get(new Random().ints(0,numberRandomAppliance).findFirst().getAsInt()));

        return someoneRandomConnectedApplianceToElectricalNetwork;

    }


    public List<HomeElectricAppliance> connectRandomApplianceToElectricalNetwork(List<HomeElectricAppliance> homeElectricAppliances,List<HomeElectricAppliance> connectedAppliances)
    {
        for (int i = 0; i < connectedAppliances.size(); i++)
        {
            int finalI = i;

            homeElectricAppliances.removeIf(x -> (x.equals(connectedAppliances.get(finalI))));
        }

        if(homeElectricAppliances.size() != 0)
        {
            connectedAppliances.add(getRandomAppliance(homeElectricAppliances).get(0));
        }

        return connectedAppliances;

    }

    public int getWholePowerConnectedApplianceInHome(List<HomeElectricAppliance> connectedElectricAppliances)
    {
        int allPowerApplianceInHome = 0;

        for (HomeElectricAppliance homeElectricAppliance : connectedElectricAppliances)
        {
            allPowerApplianceInHome += homeElectricAppliance.getPower();
        }

        return allPowerApplianceInHome;
    }

}
