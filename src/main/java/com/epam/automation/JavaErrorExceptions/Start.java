package com.epam.automation.JavaErrorExceptions;

import com.epam.automation.JavaErrorExceptions.Console.Menu;
import com.epam.automation.JavaErrorExceptions.Management.Management;
import com.epam.automation.JavaErrorExceptions.University.Faculty;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {

        List<Faculty> universityData = new ArrayList<>();

        Management management = new Management(universityData);

//        management.addFaculty("ELECTROTEH");
//        management.addGroup("ELECTROTEH", "EP033");
//        management.addStudent("EP033", "KLYSHNIKOV");
//        management.addStudent("EP033", "MARFEL");
//        management.addSubject(2, "HISTORY");
//        management.addSubject(1, "ELECTRONICA");
//        management.addSubject(1, "MICROELECTRONICS");
//
//        management.addMarks(1,1,1,1,new ArrayList<>(List.of(1,2,3,4)));
//        management.addMarks(1,1,1,2,new ArrayList<>(List.of(1,2,3,4)));
//        management.addMarks(1,1,2,1,new ArrayList<>(List.of(5,5,4,5)));

        Menu menu = new Menu(management);
        menu.mainConsoleMenu();
    }
}
