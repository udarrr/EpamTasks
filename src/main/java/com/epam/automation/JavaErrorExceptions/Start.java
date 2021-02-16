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

        Menu menu = new Menu(management);
        menu.startMainConsoleMenu();
    }
}
