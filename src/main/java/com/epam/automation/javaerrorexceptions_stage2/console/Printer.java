package com.epam.automation.javaerrorexceptions_stage2.console;

import com.epam.automation.javaerrorexceptions_stage2.university.*;

import java.util.List;

public class Printer {
    public void printUniversity(List<University> university) {
        university.forEach(x -> System.out.println(x.toString()));
    }

    public void printFaculties(List<Faculty> faculties) {
        faculties.forEach(x -> System.out.println(x.toString()));
    }

    public void printGroup(List<Group> groups) {
        groups.forEach((x) -> System.out.println(x.toString()));
    }

    public void printStudent(List<Student> students) {
        students.forEach(x -> System.out.println(x.toString()));
    }

    public void printSubjectOfStudent(List<Subject> subjects) {
        subjects.forEach(x -> System.out.println(x.toString()));
    }

    public void printMainMenuDescription() {
        System.out.println();
        System.out.println("Please choose position of menu enter it in console and press button ENTER");
        System.out.println();
        System.out.println("Menu");
        System.out.println("1.University");
        System.out.println("2.Get average mark");
        System.out.println("3.Exit");
        System.out.println();
    }

    public void printAvgMarkMenuDescription() {
        System.out.println();
        System.out.println("Average mark with a particular condition");
        System.out.println();
        System.out.println("Menu");
        System.out.println("1.Conditions");
        System.out.println("2.Exit to previous menu");
    }

    public void printAvgMark(double avgMark) {
        System.out.println("Average mark: " + avgMark);
    }
}
