package com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.resources;

import com.epam.automation.webdriver_stage2.hardmeplenty_hardcore.enums.*;

public final class CommonDataHardMePlentyJSON {
    private final String quantityInstances = "4";
    private final String operationSystem = OperationSystem.FREE.getType();
    private final String machineClass = MachineClass.REGULAR.getType();
    private final String series = Series.N1.getType();
    private final String machineType = MachineType.N1_STANDART_8.getType();
    private final String gpuQuantity = GPUQuantity.ONE.getType();
    private final String gpuType = GPUType.NVIDIA_TESLA_V100.getType();
    private final String localSSD = LocalSSD.X2_375.getType();
    private final String dataCenterLocation = DatacenterLocation.FRANKFURT.getType();
    private final String committedUsage = CommittedUsage.YEAR_1.getType();
    private String resultPriceAfterManualTest = "1,082.77";
    private String resultPriceFromCalculator = "";

    private final String descriptionPriceField = "Estimated Component Cost";
    public static final String vmClassField = "VM class";
    public static final String instanceTypeField = "Instance type";
    public static final String regionField =  "Region";
    public static final String localSSDField =  "local SSD";
    public static final String commitmentTermField =  "Commitment term";

    public String getQuantityInstances() {
        return quantityInstances;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public String getSeries() {
        return series;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getGpuQuantity() {
        return gpuQuantity;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public String getDescriptionPriceField() {
        return descriptionPriceField;
    }

    public String getResultPriceAfterManualTest() {
        return resultPriceAfterManualTest;
    }

    public String getResultPriceFromCalculator() {
        return resultPriceFromCalculator;
    }

    public void setResultPriceFromCalculator(String resultPriceFromCalculator) {
        this.resultPriceFromCalculator = resultPriceFromCalculator;
    }
}
