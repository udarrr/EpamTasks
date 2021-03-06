package com.epam.automation.javaclasses_stage1.console;

import com.epam.automation.javaclasses_stage1.cars.Car;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CommandParser {
    public Car[] filter(Car[] cars, String[] parameters) throws ArrayIndexOutOfBoundsException {
        if (parameters[0] != null && parameters[1] != null && parameters[2] != null) {
            String firstCondition = parameters[0];
            String command = parameters[1];
            String secondCondition = parameters[2];

            for (int i = 0; i < parameters.length - 3; i += 4) {
                String additionalOperation = parameters[i + 3];

                if (additionalOperation.equalsIgnoreCase("and")) {
                    cars = filterCars(firstCondition, secondCondition, command, cars);

                    if (parameters[i + 4] != null) {
                        firstCondition = parameters[i + 4];
                    }

                    if (parameters[i + 5] != null) {
                        command = parameters[i + 5];
                    }

                    if (parameters[i + 6] != null) {
                        secondCondition = parameters[i + 6];
                    }
                }
            }

            if (parameters.length == 3) {
                cars = filterCars(firstCondition, secondCondition, command, cars);
            }
        }

        return cars;
    }

    private Car[] filterCars(String firstCondition, String secondCondition, String command, Car[] cars) {
        Car[] filteredCars = new Car[0];

        switch (firstCondition) {
            case "vendor":
                filteredCars = getVendor(cars, secondCondition, command);
                break;
            case "model":
                filteredCars = getModel(cars, secondCondition, command);
                break;
            case "regId":
                filteredCars = getRegistrationNumber(cars, secondCondition, command);
                break;
            case "color":
                filteredCars = getColor(cars, secondCondition, command);
                break;
            case "year":
                filteredCars = getYear(cars, Integer.parseInt(secondCondition), command);
                break;
            case "price":
                filteredCars = getPrice(cars, Double.parseDouble(secondCondition), command);
                break;
            default:
                System.out.println("Parameter isn't recognized");
        }

        return filteredCars;
    }

    private Car[] getVendor(Car[] carData, String vendorRequest, String command) {
        int length = 0;

        for (int i = 0; i < carData.length; i++) {
            if (command.equals("=") && carData[i].getVendor().name().equalsIgnoreCase(vendorRequest)) {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0, j = 0; i < carData.length; i++) {
            if (command.equals("=") && carData[i].getVendor().name().equalsIgnoreCase(vendorRequest)) {
                result[j++] = carData[i];
            }
        }

        return result;
    }

    private Car[] getModel(Car[] carData, String modelRequest, String command) {
        int length = 0;

        for (int i = 0; i < carData.length; i++) {
            if (command.equals("=") && carData[i].getModel().equalsIgnoreCase(modelRequest)) {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0, j = 0; i < carData.length; i++) {
            if (command.equals("=") && carData[i].getModel().equalsIgnoreCase(modelRequest)) {
                result[j++] = carData[i];
            }
        }

        return result;
    }

    private Car[] getYear(Car[] carData, int yearRequest, String command) {
        int length = 0;

        for (int i = 0; i < carData.length; i++) {
            if (command.equals("=") && carData[i].getYear() == yearRequest) {
                length++;
            }
        }

        for (int i = 0; i < carData.length; i++) {
            if (command.equals(">") && carData[i].getYear() > yearRequest) {
                length++;
            }
        }

        for (int i = 0; i < carData.length; i++) {
            if (command.equals("<") && carData[i].getYear() < yearRequest) {
                length++;
            }
        }

        Calendar calendar = new GregorianCalendar();

        int yearNow = calendar.get(Calendar.YEAR);

        for (int i = 0; i < carData.length; i++) {
            if (command.equals("%") && (yearNow - carData[i].getYear()) > yearRequest) {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0, j = 0; i < carData.length; i++) {
            if (command.equals("=") && carData[i].getYear() == yearRequest) {
                result[j++] = carData[i];
            }

            if (command.equals(">") && carData[i].getYear() > yearRequest) {
                result[j++] = carData[i];
            }

            if (command.equals("<") && carData[i].getYear() < yearRequest) {
                result[j++] = carData[i];
            }

            if (command.equals("%") && (yearNow - carData[i].getYear()) > yearRequest) {
                result[j++] = carData[i];
            }
        }

        return result;
    }

    private Car[] getPrice(Car[] carData, double priceRequest, String command) {
        int length = 0;

        for (int i = 0; i < carData.length; i++) {
            if (command.equals("=") && carData[i].getPrice() == priceRequest) {
                length++;
            }
        }

        for (int i = 0; i < carData.length; i++) {
            if (command.equals(">") && carData[i].getPrice() > priceRequest) {
                length++;
            }
        }

        for (int i = 0; i < carData.length; i++) {
            if (command.equals("<") && carData[i].getPrice() < priceRequest) {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0, j = 0; i < carData.length; i++) {
            if (command.equals("=") && carData[i].getPrice() == priceRequest) {
                result[j++] = carData[i];
            }

            if (command.equals(">") && carData[i].getPrice() > priceRequest) {
                result[j++] = carData[i];
            }

            if (command.equals("<") && carData[i].getPrice() < priceRequest) {
                result[j++] = carData[i];
            }
        }

        return result;
    }

    private Car[] getColor(Car[] cars, String colorRequest, String command) {
        int length = 0;

        for (int i = 0; i < cars.length; i++) {
            if (command.equals("=") && cars[i].getColor().name().equalsIgnoreCase(colorRequest)) {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0, j = 0; i < cars.length; i++) {
            if (command.equals("=") && cars[i].getColor().name().equalsIgnoreCase(colorRequest)) {
                result[j++] = cars[i];
            }
        }

        return result;
    }

    private Car[] getRegistrationNumber(Car[] carData, String registrationNumber, String command) {
        int length = 0;

        for (int i = 0; i < carData.length; i++) {
            if (command.equals("=") && carData[i].getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                length++;
            }
        }

        Car[] result = new Car[length];

        for (int i = 0, j = 0; i < carData.length; i++) {
            if (command.equals("=") && carData[i].getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                result[j++] = carData[i];
            }
        }

        return result;
    }
}
