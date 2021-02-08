package com.epam.automation.JavaCollections.MainTask.Appliances;

import com.opencsv.bean.CsvBindByName;

public class SmallAppliance extends HomeElectricAppliance {

    @CsvBindByName
    private String smallApplianceType;

    public SmallAppliance() {

        super();
    }

    public SmallAppliance(String model, String color, String function, int power, String networkConnection, String smallApplianceType) {

        super(model, color, function, power, networkConnection);
        this.smallApplianceType = smallApplianceType;
    }

    public String getSmallApplianceType() {

        return smallApplianceType;
    }

    public void setSmallApplianceType(String smallApplianceType) {

        this.smallApplianceType = smallApplianceType;
    }

    @Override
    public String toString() {

        return "Model='" + super.getModel() +
                ", Power='" + super.getPower() + "Watt" + " " +
                "SmallApplianceType='" + smallApplianceType + '\'';
    }
}
