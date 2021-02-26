package com.epam.automation.JavaThreads.OptionalTask;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        int runaway = 5;
        Airport airport = new Airport(runaway);
        airport.start();
    }
}
