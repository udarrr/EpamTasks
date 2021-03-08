package com.epam.automation.javacleancode_stage1.Planes;

import com.epam.automation.javacleancode_stage1.Enum.ClassificationSecurityLevel;
import com.epam.automation.javacleancode_stage1.Enum.ExperimentalType;

public class ExperimentalPlane extends Plane {
    private ExperimentalType experimentalType;
    private ClassificationSecurityLevel securityLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalType experimentalType, ClassificationSecurityLevel securityLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = experimentalType;
        this.securityLevel = securityLevel;
    }

    public ClassificationSecurityLevel getClassificationLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(ClassificationSecurityLevel securityLevel) {
        this.securityLevel = securityLevel;
    }

    public ExperimentalType getExperimentalType() {
        return experimentalType;
    }

    public void setExperimentalType(ExperimentalType experimentalType) {
        this.experimentalType = experimentalType;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + ',' + "experimentalType=" + experimentalType + '}';
    }
}
