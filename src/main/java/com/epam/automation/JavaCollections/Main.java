package com.epam.automation.JavaCollections;

import com.epam.automation.JavaCollections.Appliances.ConsumerElectronic;
import com.epam.automation.JavaCollections.Appliances.HomeElectricAppliance;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException, CsvException
    {
        CsvReader csvReaderAppliance = new CsvReader();
        List<HomeElectricAppliance> temp = csvReaderAppliance.getApplianceFromCsvFile();
        Flat flat = new Flat(temp);
        flat.getConsumerElectronicAppliance();

        new ConsumerElectronic();

        for (ConsumerElectronic print:flat.getConsumerElectronicAppliance() )
        {
            System.out.println(print);
        }
    }

}
