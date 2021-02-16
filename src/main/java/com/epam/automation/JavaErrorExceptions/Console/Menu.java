package com.epam.automation.JavaErrorExceptions.Console;

import com.epam.automation.JavaErrorExceptions.Exception.*;
import com.epam.automation.JavaErrorExceptions.Management.Management;

import java.util.Scanner;

public class Menu {
    Printer printer = new Printer();

    Scanner sc = new Scanner(System.in);

    private final Management management;

    public Menu(Management management) {
        this.management = management;
    }

    public void startMainConsoleMenu() {
        while (true) {
            printer.printMainMenuDescription();

            String inputConsoleLine = sc.nextLine();

            if (inputConsoleLine.equals("3")) {
                break;
            }

            switch (inputConsoleLine) {
                case "1" -> addMarksFromConsoleLine();

                case "2" -> startHandlerMenuAverageMark();

                default -> System.out.println("Your choice isn't recognized");
            }
        }
    }

    private void addMarksFromConsoleLine() {
        printer.printUniversity(management.getUniversity());

        int inputUniversityId = takeIdUniversityFromConsole();

        try {
            management.checkExistingFaculty(inputUniversityId);
        } catch (NoFacultyInUniversityException e) {
            System.err.println(e.getMessage());
            System.out.println();
            System.out.print("Enter name for new faculty:");

            management.addFaculty(sc.nextLine());

            printer.printFaculties(management.getFaculties());
        }


        int inputFacultyId = takeIdFacultyFromConsole(inputUniversityId);

        try {
            management.checkExistingGroup(inputFacultyId);
        } catch (NoGroupInFacultyException e) {
            System.err.println(e.getMessage());
            System.out.print("Enter name for new group:");

            management.addGroup(inputFacultyId, sc.nextLine());

            printer.printGroup(management.getGroups(inputFacultyId));
        }


        int inputGroupId = takeIdGroupFromConsole(inputFacultyId);

        try {
            management.checkExistingStudent(inputGroupId);
        } catch (NoStudentInGroupException e) {
            System.err.println(e.getMessage());
            System.out.println();
            System.out.println("Enter firstname and lastname for new student:");
            System.out.print("First name:");
            String firstName = sc.nextLine();
            System.out.print("Last name:");
            String lastName = sc.nextLine();
            management.addStudent(inputGroupId, firstName, lastName);

            printer.printStudent(management.getStudents(inputGroupId));
        }
        int inputStudentId = takeIdStudentFromConsole(inputGroupId);

        try {
            management.checkExistingSubject(inputStudentId);
        } catch (NoSubjectInStudentException e) {
            System.err.println(e.getMessage());
            System.out.print("Enter name for new subject:");
            management.addSubject(inputStudentId, sc.nextLine());

            printer.printSubjectOfStudent(management.getSubject(inputStudentId));
        }

        int inputSubjectId = takeIdSubjectFromConsole(inputStudentId);

        addMarksToParticularSubject(inputFacultyId, inputGroupId, inputStudentId, inputSubjectId);
    }

    private int takeIdUniversityFromConsole() {
        System.out.println();
        System.out.print("Choose and enter value of ID UNIVERSITY: ");
        System.out.println();

        int inputUniversityId;

        while (true) {
            try {
                inputUniversityId = Integer.parseInt(sc.nextLine());

                int finalInputUniversityId = inputUniversityId;
                if (management.getUniversity().stream().anyMatch(u -> u.getId() == finalInputUniversityId)) {
                    break;
                } else {
                    System.out.println("Id university isn't exist");
                }
            } catch (Exception e) {
                System.out.println("Id is integer please choose someone from list");
            }
        }

        return inputUniversityId;
    }

    private int takeIdFacultyFromConsole(int universityId) {
        System.out.println();
        System.out.print("Choose and enter value of ID FACULTY: ");
        System.out.println();

        int inputFacultyId;

        while (true) {
            try {
                inputFacultyId = Integer.parseInt(sc.nextLine());

                int finalInputFacultyId = inputFacultyId;
                if (management.getFaculties(universityId).stream().anyMatch(x -> x.getId() == finalInputFacultyId)) {
                    break;
                } else {
                    System.out.println("Id faculty isn't exist");
                }
            } catch (Exception e) {
                System.out.println("Id is integer please choose someone from list");
            }
        }

        return inputFacultyId;
    }

    private int takeIdGroupFromConsole(int facultyId) {
        System.out.println();
        System.out.print("Choose and enter value of ID GROUP: ");
        System.out.println();

        int inputGroupId;

        while (true) {
            try {
                inputGroupId = Integer.parseInt(sc.nextLine());

                int finalInputGroupId = inputGroupId;
                if (management.getGroups(facultyId).stream().anyMatch(x -> x.getId() == finalInputGroupId)) {
                    break;
                } else {
                    System.out.println("Id group isn't exist");
                }

            } catch (Exception e) {
                System.out.println("Id is integer please choose someone from list");
            }
        }
        return inputGroupId;
    }

    private int takeIdStudentFromConsole(int groupId) {
        System.out.println();
        System.out.print("Choose and enter value of ID STUDENT: ");
        System.out.println();

        int inputStudentId;

        while (true) {
            try {
                inputStudentId = Integer.parseInt(sc.nextLine());

                int finalInputStudentId = inputStudentId;
                if (management.getStudents(groupId).stream().anyMatch(x -> x.getId() == finalInputStudentId)) {
                    break;
                } else {
                    System.out.println("Id student isn't exist");
                }

            } catch (Exception e) {
                System.out.println("Id is integer please choose someone from list");
            }
        }

        return inputStudentId;
    }

    private int takeIdSubjectFromConsole(int inputIdStudent) {
        System.out.println();
        System.out.print("Choose and enter value of ID SUBJECT where you'd like to add marks: ");
        System.out.println();

        int inputSubjectId;

        while (true) {
            try {
                inputSubjectId = Integer.parseInt(sc.nextLine());

                int finalInputSubjectId = inputSubjectId;
                if (management.getSubject(inputIdStudent).stream().anyMatch(x -> x.getId() == finalInputSubjectId)) {
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

        return inputSubjectId;
    }

    private void addMarksToParticularSubject(int inputFacultyId, int inputGroupId, int inputStudentId, int inputSubjectId) {
        while (true) {
            System.out.println("Enter new mark or type exit in console");

            String markOrExit = sc.nextLine();

            if (markOrExit.equals("exit")) {
                break;
            }

            try {
                management.addMark(inputFacultyId, inputGroupId, inputStudentId, inputSubjectId, Integer.parseInt(markOrExit));
            } catch (NumberFormatException e) {
                System.out.println("Mark can be only integer please try again");
            } catch (NumberIsNotInRangeException e) {
                System.err.println(e.getMessage());
            }

            printer.printSubjectOfStudent(management.getSubject(inputStudentId, inputSubjectId));
        }
    }

    private void startHandlerMenuAverageMark() {
        while (true) {
            printer.printAvgMarkMenuDescription();

            String input = sc.nextLine();

            if (input.equals("2")) {
                break;
            }

            if (input.equals("1")) {
                System.out.println("Enter condition. Example SUBJECT=MICROELECTRONICS or STUDENT=KLYSHNIKOV or FACULTY=ELECTROTEH/GROUP=EP033/SUBJECT=MICROELECTRONICS");
                String inputCondition = sc.nextLine();
                String[] lineAfterSplit = inputCondition.trim().split("\\s*(\\s|=|/|\\.)\\s*");

                if (lineAfterSplit.length == 2 && lineAfterSplit[0].equalsIgnoreCase("SUBJECT")) {
                    double averageMark = management.getSubjectAverageMark(lineAfterSplit[1]);

                    if (averageMark == -1) {
                        System.out.println("There no marks in subject, please try again");
                    } else {
                        printer.printAvgMark(averageMark);
                    }
                }

                if (lineAfterSplit.length == 2 && lineAfterSplit[0].equalsIgnoreCase("STUDENT")) {
                    double averageMark = management.getStudentAverageMark(lineAfterSplit[1]);

                    if (averageMark == -1) {
                        System.out.println("There no marks in subject, please try again");
                    } else {
                        printer.printAvgMark(averageMark);
                    }
                }

                if (lineAfterSplit.length == 6 &&
                        lineAfterSplit[0].equalsIgnoreCase("FACULTY") &&
                        lineAfterSplit[2].equalsIgnoreCase("GROUP") &&
                        lineAfterSplit[4].equalsIgnoreCase("SUBJECT")) {
                    double averageMark = management.getFacultyGroupSubjectAverageMark(lineAfterSplit[1], lineAfterSplit[3], lineAfterSplit[5]);

                    if (averageMark == -1) {
                        System.out.println("There no marks in subject, please try again");
                    } else {
                        printer.printAvgMark(averageMark);
                    }
                }
            }
        }
    }
}
