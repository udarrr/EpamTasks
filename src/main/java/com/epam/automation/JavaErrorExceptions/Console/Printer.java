package com.epam.automation.JavaErrorExceptions.Console;

import com.epam.automation.JavaErrorExceptions.University.Faculty;
import com.epam.automation.JavaErrorExceptions.University.Group;
import com.epam.automation.JavaErrorExceptions.University.Student;
import com.epam.automation.JavaErrorExceptions.University.Subject;

import java.util.Arrays;
import java.util.List;

public class Printer {

    public void printUniversity(List<Faculty> faculties) {
        faculties.forEach(x -> System.out.println("ID=" + x.getId() + " " + "NameFaculty=" + x.getName()));
    }

    public void printGroup(List<Group> groups) {
        groups.forEach((x) -> System.out.println("ID=" + x.getId() + " " + "NameGroup=" + x.getName()));
    }

    public void printStudent(List<Student> students) {
        students.forEach(x -> System.out.println("ID=" + x.getId() + " " + "NameStudent=" + x.getName()));
    }

    public void printSubjectOfStudent(List<Subject> subjects) {
        subjects.forEach(x -> System.out.println("ID=" + x.getId() + " " + "NameSubject=" + x.getName() + " " + "Marks=" + Arrays.toString(x.getMarks().toArray())));
    }


    public void printMainMenuDescription() {
        System.out.println();
        System.out.println("Please choose position of menu enter it in console and press button ENTER");
        System.out.println();
        System.out.println("Menu");
        System.out.println("1.Faculties");
        System.out.println("2.Get average mark");
        System.out.println("3.Exit");
        System.out.println();
    }

    public void printMenuAddingFacultyDescription() {
        System.out.println();
        System.out.println("Menu");
        System.out.println("1.Add new one");
        System.out.println("2.Exit to previous menu");
    }

    public void printUniversityMenuDescription() {
        System.out.println();
        System.out.println("Menu");
        System.out.println("1.Add faculty");
        System.out.println("2.Add marks");
        System.out.println("3.Exit to previous menu");
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
