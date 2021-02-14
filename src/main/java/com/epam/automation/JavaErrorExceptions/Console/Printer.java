package com.epam.automation.JavaErrorExceptions.Console;

import com.epam.automation.JavaErrorExceptions.University.Faculty;
import com.epam.automation.JavaErrorExceptions.University.Group;
import com.epam.automation.JavaErrorExceptions.University.Student;
import com.epam.automation.JavaErrorExceptions.University.Subject;

import java.util.Arrays;
import java.util.List;

public class Printer {

    public void printFaculty(List<Faculty> faculties) {

        faculties.forEach(x -> System.out.println("ID " + x.getIdFaculty() + " " + x.getNameFaculty()));
    }

    public void printGroup(List<Group> groups) {

        groups.forEach((x) -> System.out.println("ID" + x.getIdGroup() + " " + x.getNameGroup()));
    }

    public void printStudent(List<Student> students) {

        students.forEach(x -> System.out.println("ID" + x.getIdStudent() + " " + x.getName()));
    }

    public void printSubjectOfStudent(List<Subject> subjects) {

        subjects.forEach(x -> System.out.println(x.getTypeSubject() + " " + Arrays.toString(x.getMark().toArray())));
    }


    public void printMainMenuDescription() {

        System.out.println();
        System.out.println("Please choose position of menu enter it in console and press button ENTER");
        System.out.println();
        System.out.println("Menu");
        System.out.println("1.Add FACULTY");
        System.out.println("2.Add MARKS");
        System.out.println("3.Get average MARK");
        System.out.println("4.Exit");
        System.out.println();
    }

    public void printAddMarksMenuDescription() {

        System.out.println();
        System.out.println("Menu");
        System.out.println("1.Choose student");
        System.out.println("2.Exit to previous menu");
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
