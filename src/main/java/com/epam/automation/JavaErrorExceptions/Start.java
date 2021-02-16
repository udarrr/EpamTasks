package com.epam.automation.JavaErrorExceptions;

import com.epam.automation.JavaErrorExceptions.Console.Menu;
import com.epam.automation.JavaErrorExceptions.Management.Management;
import com.epam.automation.JavaErrorExceptions.University.Faculty;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {

        List<Faculty> faculties = new ArrayList<>();

        Management management = new Management(faculties);

        management.setFaculty("TECHNICAL ");
        management.setFaculty("ECONOMY");
        management.setFaculty("LAW");
        management.setGroup(1, "EP033");
        management.setGroup(2, "EP033");
        management.setStudent(1, "Sergey", "Klyshnikov");
        management.setStudent(1, "Ivan", "Ivanov");
        management.setStudent(1, "Petr", "Petrov");
        management.setStudent(1, "Sidr","Sidorov");
        management.setSubject(1,"Programming");
        management.setSubject(1,"Microelectronic");
        management.setSubject(1,"History");

        Menu menu = new Menu(management);
        menu.startMainConsoleMenu();
    }
}
