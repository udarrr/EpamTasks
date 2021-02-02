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
        CsvReaderToCollection csvReaderToCollectionAppliance = new CsvReaderToCollection();
        List<HomeElectricAppliance> temp = csvReaderToCollectionAppliance.getApplianceFromCsvFile();

        Flat flat = new Flat(temp);

        new ConsumerElectronic();


for(HomeElectricAppliance flat1: flat.getSortedHomeElectricApplianceByPower().getAllAppliance())
{
    System.out.println(flat1);
}


    }

}
