package com.epam.automation.javacollections_stage1.maintask;

import com.epam.automation.javacollections_stage1.maintask.appliances.ConsumerElectronic;
import com.epam.automation.javacollections_stage1.maintask.appliances.HomeElectricAppliance;
import com.epam.automation.javacollections_stage1.maintask.appliances.MajorAppliance;
import com.epam.automation.javacollections_stage1.maintask.appliances.SmallAppliance;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public List<HomeElectricAppliance> getAllAppliances() {
        List<HomeElectricAppliance> homeElectricAppliances = new ArrayList<>();

        homeElectricAppliances.addAll(getConsumerElectronicsFromCsvFile());
        homeElectricAppliances.addAll(getMajorApplianceFromCsvFile());
        homeElectricAppliances.addAll(getApplianceFromCsvFile());

        return homeElectricAppliances;
    }

    private List<ConsumerElectronic> getConsumerElectronicsFromCsvFile() {
        List<ConsumerElectronic> consumerElectronics = new ArrayList<>();

        try {
            consumerElectronics = new CsvToBeanBuilder
                    (new FileReader("src\\main\\java\\com\\epam\\automation\\JavaCollections\\MainTask\\CSV\\ConsumerElectronic.csv"))
                    .withSeparator(';').withType(ConsumerElectronic.class).build().parse();
        } catch (IOException exception) {
            System.out.println(exception.getMessage() + " " + "There is no csv file ConsumerElectronic in the directory");
        }

        return consumerElectronics;
    }

    private List<MajorAppliance> getMajorApplianceFromCsvFile() {
        List<MajorAppliance> majorAppliances = new ArrayList<>();

        try {
            majorAppliances = new CsvToBeanBuilder
                    (new FileReader("src\\main\\java\\com\\epam\\automation\\JavaCollections\\MainTask\\CSV\\MajorAppliance.csv"))
                    .withSeparator(';').withType(MajorAppliance.class).build().parse();

        } catch (IOException exception) {
            System.out.println(exception.getMessage() + " " + "There is no csv file MajorAppliance in the directory");
        }

        return majorAppliances;
    }


    private List<SmallAppliance> getApplianceFromCsvFile() {
        List<SmallAppliance> smallAppliances = new ArrayList<>();

        try {
            smallAppliances = new CsvToBeanBuilder
                    (new FileReader("src\\main\\java\\com\\epam\\automation\\JavaCollections\\MainTask\\CSV\\SmallAppliance.csv"))
                    .withSeparator(';').withType(SmallAppliance.class).build().parse();

        } catch (IOException exception) {
            System.out.println(exception.getMessage() + " " + "There is no csv file SmallAppliance in the directory");
        }

        return smallAppliances;
    }
}
