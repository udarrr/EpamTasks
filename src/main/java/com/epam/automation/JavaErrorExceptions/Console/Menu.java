package com.epam.automation.JavaErrorExceptions.Console;

import com.epam.automation.JavaErrorExceptions.Exception.NoFacultyInUniversityException;
import com.epam.automation.JavaErrorExceptions.Exception.NoGroupInFacultyException;
import com.epam.automation.JavaErrorExceptions.Exception.NoStudentInGroupException;
import com.epam.automation.JavaErrorExceptions.Exception.NoSubjectInStudentException;
import com.epam.automation.JavaErrorExceptions.Management.Management;

import java.util.Scanner;

public class Menu {

    private final Management management;

    public Menu(Management management) {

        this.management = management;
    }

    Printer printer = new Printer();

    Scanner sc = new Scanner(System.in);

    public void mainConsoleMenu() {

        while (true) {

            printer.printMainMenuDescription();

            Scanner sc = new Scanner(System.in);

            String inputConsoleLine = sc.nextLine();

            if (inputConsoleLine.equals("4")) {

                break;
            }

            switch (inputConsoleLine) {

                case "1" -> startHandlerMenuAddingFaculty();

                case "2" -> startHandlerMenuAddMarks();

                case "3" -> startHandlerMenuAverageMark();

                default -> System.out.println("Your choosing isn't recognized");
            }
        }
    }

    private void startHandlerMenuAddingFaculty() {

        System.out.println();
        System.out.println("Exist faculties:");
        printer.printUniversity(management.getFaculties());
        System.out.println();
        System.out.print("Enter new FACULTY name: ");
        String inputNameFaculty = sc.nextLine();
        management.addFaculty(inputNameFaculty);

        System.out.println();
        System.out.println("Exist groups");
        printer.printGroup(management.getGroup());
        System.out.println();
        System.out.print("Enter new GROUP name: ");
        String inputNameGroup = sc.nextLine();
        management.addGroup(inputNameFaculty, inputNameGroup);

        System.out.println();
        System.out.println("Exist student");
        printer.printStudent(management.getStudent());
        System.out.println();
        System.out.print("Enter new STUDENT name: ");

        String inputNameStudent = sc.nextLine();

        management.addStudent(inputNameGroup, inputNameStudent);

        addSubjectsConsoleLine();
    }

    private void startHandlerMenuAddMarks() {

        while (true) {

            printer.printAddMarksMenuDescription();

            String input = sc.nextLine();

            if (input.equals("2")) {

                break;
            }

            if (input.equals("1")) {

                addMarksConsoleLine();
            }
        }
    }

    private void addMarksConsoleLine() {

        printer.printUniversity(management.getFaculties());

        try {
            if (management.getFaculties().size() == 0) {
                throw new NoFacultyInUniversityException();
            }

        } catch (NoFacultyInUniversityException e) {
            System.out.println("In university no faculty, please add one");
            System.out.print("Enter name for new faculty:");

            management.addFaculty(sc.nextLine());
            printer.printUniversity(management.getFaculties());
        }

        System.out.println();
        System.out.print("Choose and enter value of ID FACULTY where you'd like to add subject: ");
        System.out.println();

        int inputIdFaculty;

        while (true) {
            try {
                inputIdFaculty = Integer.parseInt(sc.nextLine());

                if (inputIdFaculty <= management.getFaculties().size()) {
                    break;
                } else {
                    System.out.println("Id faculty isn't exist");
                }

            } catch (Exception e) {
                System.out.println("Id is integer please choose someone from list");
            }
        }

        printer.printGroup(management.getGroup(inputIdFaculty));

        try {
            if (management.getGroup(inputIdFaculty).size() == 0) {
                throw new NoGroupInFacultyException();
            }
        } catch (NoGroupInFacultyException e) {
            System.out.println("In faculty no group, please add one");
            System.out.print("Enter name for new group:");

            management.addGroup(inputIdFaculty, sc.nextLine());
            printer.printGroup(management.getGroup(inputIdFaculty));
        }

        System.out.println();
        System.out.print("Choose and enter value of ID GROUP where you'd like to add subject: ");
        System.out.println();


        int inputIdGroup;

        while (true) {
            try {
                inputIdGroup = Integer.parseInt(sc.nextLine());

                if (inputIdGroup <= management.getGroup().size()) {
                    break;
                } else {
                    System.out.println("Id group isn't exist");
                }

            } catch (Exception e) {
                System.out.println("Id is integer please choose someone from list");
            }
        }

        printer.printStudent(management.getStudent(inputIdGroup));

        try {
            if (management.getStudent(inputIdGroup).size() == 0) {
                throw new NoStudentInGroupException();
            }
        } catch (NoStudentInGroupException e) {
            System.out.println("In group no student, please add one");
            System.out.print("Enter name for new student:");

            management.addStudent(inputIdGroup, sc.nextLine());
            printer.printStudent(management.getStudent(inputIdGroup));
        }

        System.out.println();
        System.out.print("Choose and enter value of ID STUDENT where you'd like to add subject: ");
        System.out.println();

        int inputIdStudent;

        while (true) {
            try {
                inputIdStudent = Integer.parseInt(sc.nextLine());

                if (inputIdStudent <= management.getStudent().size()) {
                    break;
                } else {
                    System.out.println("Id student isn't exist");
                }

            } catch (Exception e) {
                System.out.println("Id is integer please choose someone from list");
            }
        }

        printer.printSubjectOfStudent(management.getSubject(inputIdStudent));

        try {
            if (management.getSubject(inputIdStudent).size() == 0) {
                throw new NoSubjectInStudentException();
            }
        } catch (NoSubjectInStudentException e) {
            System.out.println("In student no subject, please add one");
            System.out.print("Enter name for new subject:");

            management.addSubject(inputIdStudent, sc.nextLine());
            printer.printSubjectOfStudent(management.getSubject(inputIdStudent));
        }

        System.out.println();
        System.out.print("Choose and enter value of ID SUBJECT where you'd like to add marks: ");
        System.out.println();

        int inputIdSubject;

        while (true) {
            try {
                inputIdSubject = Integer.parseInt(sc.nextLine());

                if (inputIdSubject <= management.getSubject(inputIdStudent).size()) {
                    break;
                } else {
                    System.out.println("Id subject isn't exist");
                    System.out.println();
                }

            } catch (Exception e) {
                System.out.println("Id is integer please choose someone from list");
                System.out.println();
            }
        }

        int indexFaculty = management.getIndexFaculty(inputIdFaculty);
        int indexGroup = management.getIndexGroup(indexFaculty, inputIdGroup);
        int indexStudent = management.getIndexStudent(indexFaculty, indexGroup, inputIdStudent);
        int indexSubject = management.getIndexSubject(indexFaculty, indexGroup, indexStudent, inputIdSubject);

        while (true) {

            System.out.println("Writing mark or enter exit");
            String markOrExit = sc.nextLine();

            if (markOrExit.equals("exit")) {

                break;
            }

            management.addMarks(indexFaculty, indexGroup, indexStudent, indexSubject, Integer.parseInt(markOrExit));
            printer.printSubjectOfStudent(management.getSubject(inputIdStudent, inputIdSubject));
        }
    }

    private void addSubjectsConsoleLine() {

        System.out.println();
        printer.printStudent(management.getStudent());
        System.out.println();
        System.out.print("Choose and enter ID STUDENT where you'd like to add subject: ");
        System.out.println();

        int inputIdStudent = Integer.parseInt(sc.nextLine());

        printer.printSubjectOfStudent(management.getSubject(inputIdStudent));

        System.out.println();
        System.out.println("Enter name of SUBJECT");
        System.out.println();

        String inputNameSubject = sc.nextLine();
        management.addSubject(inputIdStudent, inputNameSubject);
    }

    public void startHandlerMenuAverageMark() {

        while (true) {

            printer.printAvgMarkMenuDescription();

            String input = sc.nextLine();

            if (input.equals("2")) {

                break;
            }

            if (input.equals("1")) {

                System.out.println("Enter condition. Example SUBJECT=MICROELECTRONICS or STUDENT=KLYSHNIKOV or FACULTY=ELECTROTEH GROUP=EP033 SUBJECT=MICROELECTRONICS");
                String inputCondition = sc.nextLine();
                String[] lineAfterSplit = inputCondition.trim().split("\\s*(\\s|=|\\.)\\s*");

                if (lineAfterSplit.length == 2 && lineAfterSplit[0].equalsIgnoreCase("SUBJECT")) {
                    double averageMark = management.getAvgMarkWholeUniversityFromParticularSubject(lineAfterSplit[1]);

                    if (averageMark == -1) {
                        System.out.println("Not all subjects have marks");
                    } else {
                        printer.printAvgMark(averageMark);
                    }
                }

                if (lineAfterSplit.length == 2 && lineAfterSplit[0].equalsIgnoreCase("STUDENT")) {
                    double averageMark = management.getAvgMarkFromParticularStudentAllSubjects(lineAfterSplit[1]);

                    if (averageMark == -1) {
                        System.out.println("Not all subjects have marks");
                    } else {
                        printer.printAvgMark(averageMark);
                    }
                }

                if (lineAfterSplit.length == 6 &&
                        lineAfterSplit[0].equalsIgnoreCase("FACULTY") &&
                        lineAfterSplit[2].equalsIgnoreCase("GROUP") &&
                        lineAfterSplit[4].equalsIgnoreCase("SUBJECT")) {
                    double averageMark = management.getAvgMarkFromParticularGroupStudentSubject(lineAfterSplit[1], lineAfterSplit[3], lineAfterSplit[5]);

                    if (averageMark == -1) {
                        System.out.println("Not all subjects have marks");
                    } else {
                        printer.printAvgMark(averageMark);

                    }
                }
            }
        }
    }
}
