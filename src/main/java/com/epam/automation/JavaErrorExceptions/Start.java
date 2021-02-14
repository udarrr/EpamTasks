package com.epam.automation.JavaErrorExceptions;

import com.epam.automation.JavaErrorExceptions.Console.Menu;
import com.epam.automation.JavaErrorExceptions.Console.Printer;
import com.epam.automation.JavaErrorExceptions.University.Faculty;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {

        List<Faculty> universityData = new ArrayList<>();

        Management management = new Management(universityData);

        Menu menu = new Menu(management);

        Printer printer = new Printer();

        management.addFaculty("ELECTROTEH");
        management.addGroup("ELECTROTEH", "EP033");
        management.addStudent("EP033", "KLYSHNIKOV");
        management.addStudent("EP033", "MARFEL");
        management.addSubject(2, "HISTORY", new ArrayList<>(List.of(1, 1, 1, 1)));
        management.addSubject(1, "ELECTRONIKA", new ArrayList<>(List.of(5, 5, 5, 5)));
        management.addSubject(1, "MICROELECTRONIKA", new ArrayList<>(List.of(10, 10, 10, 10)));

        menu.mainConsoleMenu();
    }
}
