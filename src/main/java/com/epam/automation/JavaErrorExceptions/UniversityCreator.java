package com.epam.automation.JavaErrorExceptions;

import com.epam.automation.JavaErrorExceptions.University.*;

import java.util.ArrayList;
import java.util.List;

public class UniversityCreator {

    public List<University> createUniversity() {

        List<University> university = new ArrayList<>();
        university.add(
                new University("BRU",
                     new Faculty("Electroteh",
                          new Group("EP033",
                                new Student("Sergey","Klyshnikov",
                                        new Subject("Microelectronic", new Grade(10)))))));

        university.add(
                new University("BRU",
                        new Faculty("Economy")));

        return university;
    }
}
