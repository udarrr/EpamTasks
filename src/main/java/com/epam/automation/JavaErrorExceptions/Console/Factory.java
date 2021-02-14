package com.epam.automation.JavaErrorExceptions.Console;

import com.epam.automation.JavaErrorExceptions.University.Faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Factory {


    private List<Faculty> faculties;

    public Factory(List<Faculty> faculties) {

        this.faculties = faculties;
    }

    public List<Object> filterAfterCommands(String parameter, String condition) {

        List<Object> filterFaculty = new ArrayList<>();

        switch (parameter) {

            case "FACULTY":
                filterFaculty = faculties.stream().
                        filter(x -> x.getNameFaculty().equals(condition)).
                        collect(Collectors.toList());
                break;

            case "GROUP":
                filterFaculty = faculties.stream().
                        flatMap(x -> x.getGroup().stream()).
                        filter(z -> z.getNameGroup().equals(condition)).
                        collect(Collectors.toList());

            default:
                System.out.println("Parameter was wrong");
        }

        return filterFaculty;
    }
}
