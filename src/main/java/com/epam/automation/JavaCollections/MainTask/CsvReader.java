package com.epam.automation.JavaCollections.MainTask;

import com.epam.automation.JavaCollections.MainTask.Appliances.ConsumerElectronic;
import com.epam.automation.JavaCollections.MainTask.Appliances.HomeElectricAppliance;
import com.epam.automation.JavaCollections.MainTask.Appliances.MajorAppliance;
import com.epam.automation.JavaCollections.MainTask.Appliances.SmallAppliance;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader
{
    public List<HomeElectricAppliance> getAllAppliances()
    {
        return getApplianceFromCsvFile();
    }

    private List<HomeElectricAppliance> getApplianceFromCsvFile()
    {
        List<ConsumerElectronic> consumerElectronics = new ArrayList<>();
        List<MajorAppliance> majorAppliances = new ArrayList<>();
        List<SmallAppliance> smallAppliances = new ArrayList<>();

        try
        {
            consumerElectronics = new CsvToBeanBuilder
                    (new FileReader("src\\main\\java\\com\\epam\\automation\\JavaCollections\\MainTask\\CSV\\ConsumerElectronic.csv"))
                    .withSeparator(';').withType(ConsumerElectronic.class).build().parse();
        }
        catch (IOException exception)
        {
            System.out.println(exception.getMessage() + " " + "There is no csv file ConsumerElectronic in the directory");
        }

        try
        {
            majorAppliances = new CsvToBeanBuilder
                    (new FileReader("src\\main\\java\\com\\epam\\automation\\JavaCollections\\MainTask\\CSV\\MajorAppliance.csv"))
                    .withSeparator(';').withType(MajorAppliance.class).build().parse();
        }
        catch (IOException exception)
        {
            System.out.println(exception.getMessage() + " " + "There is no csv file MajorAppliance in the directory");
        }

        try
        {
            smallAppliances = new CsvToBeanBuilder
                    (new FileReader("src\\main\\java\\com\\epam\\automation\\JavaCollections\\MainTask\\CSV\\SmallAppliance.csv"))
                    .withSeparator(';').withType(SmallAppliance.class).build().parse();
        }
        catch (IOException exception)
        {
            System.out.println(exception.getMessage() + " " + "There is no csv file SmallAppliance in the directory");
        }

        List<HomeElectricAppliance> homeElectricAppliances = new ArrayList<>();

        homeElectricAppliances.addAll(consumerElectronics);
        homeElectricAppliances.addAll(majorAppliances);
        homeElectricAppliances.addAll(smallAppliances);

        return homeElectricAppliances;
    }
}
