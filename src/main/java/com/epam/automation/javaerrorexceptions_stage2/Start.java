package com.epam.automation.javaerrorexceptions_stage2;

import com.epam.automation.javaerrorexceptions_stage2.console.Menu;
import com.epam.automation.javaerrorexceptions_stage2.management.Management;
import com.epam.automation.javaerrorexceptions_stage2.university.University;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        List<University> university = new ArrayList<>();

        Management management = new Management(university);

        Menu menu = new Menu(management);

        menu.startMainConsoleMenu();
    }
}
