package com.epam.automation.JavaErrorExceptions;

import com.epam.automation.JavaErrorExceptions.Console.Menu;
import com.epam.automation.JavaErrorExceptions.Management.Management;
import com.epam.automation.JavaErrorExceptions.University.Faculty;
import com.epam.automation.JavaErrorExceptions.University.University;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        List<University> university = new ArrayList<>();

        Management management = new Management(university);

        management.addUniversity("BRU");
//        management.addFaculty("TECHNICAL ");
//        management.addFaculty("ECONOMY");
//        management.addFaculty("LAW");
//        management.addGroup(1, "EP033");
//        management.addGroup(2, "EP033");
//        management.addStudent(1, "Sergey", "Klyshnikov");
//        management.addStudent(1, "Ivan", "Ivanov");
//        management.addStudent(1, "Petr", "Petrov");
//        management.addStudent(1, "Sidr","Sidorov");
//        management.addSubject(1,"Programming");
//        management.addSubject(1,"Microelectronic");
//        management.addSubject(1,"History");

        Menu menu = new Menu(management);
        menu.startMainConsoleMenu();
    }
}
