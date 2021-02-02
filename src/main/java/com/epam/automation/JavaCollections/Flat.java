package com.epam.automation.JavaCollections;

import com.epam.automation.JavaCollections.Appliances.ConsumerElectronic;
import com.epam.automation.JavaCollections.Appliances.HomeElectricAppliance;

import java.util.ArrayList;
import java.util.List;

public class Flat
{
    private List<? extends HomeElectricAppliance> homeElectricAppliances;

    public Flat(List<? extends HomeElectricAppliance> homeElectricAppliances)
    {
        this.homeElectricAppliances = homeElectricAppliances;
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


}
