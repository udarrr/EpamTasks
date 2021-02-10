package com.epam.automation.JavaErrorExceptions;

import com.epam.automation.JavaCollections.MainTask.Console.ConsoleMenu;

public class Start {

    public static void main(String[] args) {

        UniversityCreator universityCreator = new UniversityCreator();
        
        UniversityManagement universityManagement = new UniversityManagement(universityCreator.createUniversity());
        universityManagement.getGroup();
    }
}
