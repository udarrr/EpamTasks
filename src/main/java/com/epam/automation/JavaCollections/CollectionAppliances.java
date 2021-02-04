package com.epam.automation.JavaCollections;

import com.epam.automation.JavaCollections.Appliances.ConsumerElectronic;
import com.epam.automation.JavaCollections.Appliances.HomeElectricAppliance;
import com.epam.automation.JavaCollections.Appliances.MajorAppliance;
import com.epam.automation.JavaCollections.Appliances.SmallAppliance;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectionAppliances
{

    public List<HomeElectricAppliance> getAllAppliances() throws IOException
    {
        return getApplianceFromCsvFile();
    }

    private List<HomeElectricAppliance> getApplianceFromCsvFile() throws IOException
    {
        List<ConsumerElectronic> consumerElectronics = new CsvToBeanBuilder
                (new FileReader("src\\main\\java\\com\\epam\\automation\\JavaCollections\\CSV\\ConsumerElectronic.csv"))
                .withSeparator(';').withType(ConsumerElectronic.class).build().parse();

        List<MajorAppliance> majorAppliances = new CsvToBeanBuilder
                (new FileReader("src\\main\\java\\com\\epam\\automation\\JavaCollections\\CSV\\MajorAppliance.csv"))
                .withSeparator(';').withType(MajorAppliance.class).build().parse();

        List<SmallAppliance> smallAppliances = new CsvToBeanBuilder
                (new FileReader("src\\main\\java\\com\\epam\\automation\\JavaCollections\\CSV\\SmallAppliance.csv"))
                .withSeparator(';').withType(SmallAppliance.class).build().parse();

        List<HomeElectricAppliance> homeElectricAppliances = new ArrayList<>();

        homeElectricAppliances.addAll(consumerElectronics);
        homeElectricAppliances.addAll(majorAppliances);
        homeElectricAppliances.addAll(smallAppliances);

        return homeElectricAppliances;
    }
}
