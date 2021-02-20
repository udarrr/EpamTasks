package com.epam.automation.JavaIO.MainTask.Console;

import com.epam.automation.JavaIO.MainTask.Resources.PathPlaces;

public class Printer {
    public void printDescriptionMenu() {
        System.out.println();
        System.out.println("Enter path or path to file below:" + "Example C:\\Microsoft");
    }

    public void printPlaceWithResult() {
        System.out.println("File with result was written to:");
        System.out.println("\033[0;32m" + PathPlaces.getPlaceAfterReadingDirectories() + "\033[0;38m");
    }

    public void printAmountDirectories(double amount) {
        System.out.println("Quantity directories is: " + amount);
    }

    public void printAmountFiles(double amount) {
        System.out.println("Quantity files is: " + amount);
    }

    public void printAverageQuantityFilesInDirectories(double amount) {
        System.out.println("Average quantity files in directory is: " + amount);
    }

    public void printAverageLengthNameOfFiles(double value) {
        System.out.println("Average length name of files in directories is: " + value);
    }
}
