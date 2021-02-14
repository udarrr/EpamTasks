package com.epam.automation.JavaErrorExceptions.Console;

import com.epam.automation.JavaErrorExceptions.Management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        printer.printFaculty(management.getFaculty());
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

        addSubjectsAndMarksWithParseConsoleLine();
    }

    private void startHandlerMenuAddMarks() {


        while (true) {

            printer.printAddMarksMenuDescription();

            String input = sc.nextLine();

            if (input.equals("2")) {

                break;
            }

            if (input.equals("1")) {

                addSubjectsAndMarksWithParseConsoleLine();
            }
        }
    }

    private void addSubjectsAndMarksWithParseConsoleLine() {

        System.out.println();
        printer.printStudent(management.getStudent());
        System.out.println();
        System.out.print("Choose and enter ID STUDENT where you'd like to add subject: ");
        System.out.println();

        int inputIdStudent = Integer.parseInt(sc.nextLine());

        printer.printSubjectOfStudent(management.getSubject(inputIdStudent));

        System.out.println();
        System.out.println("Enter SUBJECT and MARKS, EXAMPLE ECONOMY=1,2,3,4,5,6,7,8,9,10");
        System.out.println();
        System.out.print("SUBJECTS AMD MARKS: ");

        String inputNameSubjectAndMarks = sc.nextLine();
        String[] line = inputNameSubjectAndMarks.split("=");

        if (line.length == 2) {

            String inputNameSubject = line[0];

            List<Integer> inputMarks = Arrays.stream(line[1].split(",")).
                    mapToInt(Integer::parseInt).collect(ArrayList::new, List::add, List::addAll);

            management.addSubject(inputIdStudent, inputNameSubject, inputMarks);
        }
    }

    public void startHandlerMenuAverageMark() {

        while (true) {

            printer.printAvgMarkMenuDescription();

            String input = sc.nextLine();

            if (input.equals("2")) {

                break;
            }

            if (input.equals("1")) {

                System.out.println("Enter condition. Example SUBJECT=MICROELECTRONIKA or STUDENT=KLYSHNIKOV or FACULTY=ELECTROTEH GROUP=EP033 SUBJECT=MICROELECTRONIKA");
                String inputCondition = sc.nextLine();
                String[] lineAfterSplit = inputCondition.trim().split("\\s*(\\s|=|\\.)\\s*");

                if (lineAfterSplit.length == 2 && lineAfterSplit[0].equalsIgnoreCase("SUBJECT")) {

                    printer.printAvgMark(management.getAvgMarkWholeUniversityFromParticularSubject(lineAfterSplit[1]));
                }

                if (lineAfterSplit.length == 2 && lineAfterSplit[0].equalsIgnoreCase("STUDENT")) {

                    printer.printAvgMark(management.getAvgMarkFromParticularStudentAllSubjects(lineAfterSplit[1]));
                }

                if (lineAfterSplit.length == 6 &&
                        lineAfterSplit[0].equalsIgnoreCase("FACULTY") &&
                        lineAfterSplit[2].equalsIgnoreCase("GROUP") &&
                        lineAfterSplit[4].equalsIgnoreCase("SUBJECT")) {

                    printer.printAvgMark(management.getAvgMarkFromParticularGroupStudentSubject(lineAfterSplit[1], lineAfterSplit[3], lineAfterSplit[5]));
                }
            }
        }
    }
}
