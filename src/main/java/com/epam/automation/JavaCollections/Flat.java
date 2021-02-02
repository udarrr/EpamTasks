package com.epam.automation.JavaCollections;

import com.epam.automation.JavaCollections.Appliances.ConsumerElectronic;
import com.epam.automation.JavaCollections.Appliances.HomeElectricAppliance;
import com.epam.automation.JavaCollections.Appliances.MajorAppliance;
import com.epam.automation.JavaCollections.Appliances.SmallAppliance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Flat
{
    private final List<HomeElectricAppliance> homeElectricAppliances;

    public Flat(List<HomeElectricAppliance> homeElectricAppliances)
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

    public  List<HomeElectricAppliance> getAppliancesWithPowerBetweenTheRange(int firstRange,int secondRange)
    {
        List<HomeElectricAppliance> filteredAppliancesByPowerBetweenRange = new ArrayList<>();

        for(HomeElectricAppliance homeElectricAppliance: homeElectricAppliances)
        {
            if(homeElectricAppliance.getPower() > firstRange && homeElectricAppliance.getPower() < secondRange)
            {
                filteredAppliancesByPowerBetweenRange.add(homeElectricAppliance);
            }
        }

        return filteredAppliancesByPowerBetweenRange;

    }
}
