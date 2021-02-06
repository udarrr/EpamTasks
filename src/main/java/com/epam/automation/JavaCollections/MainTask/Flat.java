package com.epam.automation.JavaCollections.MainTask;

import com.epam.automation.JavaCollections.MainTask.Appliances.ConsumerElectronic;
import com.epam.automation.JavaCollections.MainTask.Appliances.HomeElectricAppliance;
import com.epam.automation.JavaCollections.MainTask.Appliances.MajorAppliance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Flat
{
    public Flat()
    {
        super();
    }

    public List<? extends HomeElectricAppliance> allHomeElectricAppliances;

    public Flat(List<? extends HomeElectricAppliance> allHomeElectricAppliances)
    {
        this.allHomeElectricAppliances = allHomeElectricAppliances;
    }

    public List<ConsumerElectronic> getConsumerElectronicAppliance()
    {
        List<ConsumerElectronic> consumerElectronics = new ArrayList<>();

        for (HomeElectricAppliance homeElectricAppliance: allHomeElectricAppliances)
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

        for (HomeElectricAppliance homeElectricAppliance: allHomeElectricAppliances)
        {
            if(homeElectricAppliance instanceof MajorAppliance)
            {
                majorAppliances.add((MajorAppliance) homeElectricAppliance);
            }
        }

        return  majorAppliances;
    }

    public List<HomeElectricAppliance> getSortedHomeElectricApplianceByPower()
    {
        allHomeElectricAppliances.sort((Comparator<HomeElectricAppliance>) (o1, o2)-> (o1.getPower() - o2.getPower()));

        return new ArrayList<>(allHomeElectricAppliances);
    }

    public List<HomeElectricAppliance> filterByPower(int min, int max)
    {
        List<HomeElectricAppliance> filteredAppliancesByPowerBetweenRange = new ArrayList<>();

        for(HomeElectricAppliance homeElectricAppliance: allHomeElectricAppliances)
        {
            if(homeElectricAppliance.getPower() > min && homeElectricAppliance.getPower() < max)
            {
                filteredAppliancesByPowerBetweenRange.add(homeElectricAppliance);
            }
        }

        return filteredAppliancesByPowerBetweenRange;
    }

    public List<ConsumerElectronic> filterByBatteryCapacity(int min, int max, List<ConsumerElectronic> consumerElectronics)
    {
        List<ConsumerElectronic> filteredAppliancesByBatteryCapacityBetweenRange = new ArrayList<>();

        for(ConsumerElectronic consumerElectronic: consumerElectronics)
        {
            if(consumerElectronic.getBatteryCapacity() > min && consumerElectronic.getBatteryCapacity() < max)
            {
                filteredAppliancesByBatteryCapacityBetweenRange.add(consumerElectronic);
            }
        }

        return filteredAppliancesByBatteryCapacityBetweenRange;
    }

    public List<MajorAppliance> filterBySize(int min, int max, List<MajorAppliance> majorAppliances)
    {
        List<MajorAppliance> filteredAppliancesBySizeBetweenRange = new ArrayList<>();

        for(MajorAppliance majorAppliance: majorAppliances)
        {
            if(majorAppliance.getHeight() > min && majorAppliance.getHeight() < max)
            {
                filteredAppliancesBySizeBetweenRange.add(majorAppliance);
            }
        }

        return filteredAppliancesBySizeBetweenRange;
    }

    public List<HomeElectricAppliance> getRandomAppliance(List<HomeElectricAppliance> appliances)
    {
        List<HomeElectricAppliance> someoneRandomConnectedApplianceToElectricalNetwork = new ArrayList<>();

        int numberRandomAppliance = appliances.size();

        someoneRandomConnectedApplianceToElectricalNetwork.add(appliances.
                get(new Random().ints(0,numberRandomAppliance).findFirst().getAsInt()));

        return someoneRandomConnectedApplianceToElectricalNetwork;
    }


    public List<HomeElectricAppliance> connectRandomAppliancesToElectricalNetwork(List<HomeElectricAppliance> homeElectricAppliances,List<HomeElectricAppliance> connectedAppliances)
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

    public int getWholePowerConnectedAppliancesInHome(List<HomeElectricAppliance> connectedElectricAppliances)
    {
        int wholePowerAppliancesInHome = 0;

        for (HomeElectricAppliance homeElectricAppliance : connectedElectricAppliances)
        {
            wholePowerAppliancesInHome += homeElectricAppliance.getPower();
        }

        return wholePowerAppliancesInHome;
    }
}
