package com.epam.automation.JavaErrorExceptions.Console;

import com.epam.automation.JavaErrorExceptions.Exception.NoFacultyInUniversityException;
import com.epam.automation.JavaErrorExceptions.Exception.NoGroupInFacultyException;
import com.epam.automation.JavaErrorExceptions.Exception.NoStudentInGroupException;
import com.epam.automation.JavaErrorExceptions.Exception.NoSubjectInStudentException;
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

            Scanner sc = new Scanner(System.in);

            String inputConsoleLine = sc.nextLine();

            if (inputConsoleLine.equals("3")) {
                break;
            }

            switch (inputConsoleLine) {
                case "1" -> startHandlerMenuUniversity();

                case "2" -> startHandlerMenuAverageMark();

                default -> System.out.println("Your a choice isn't recognized");
            }
        }
    }

    private void startHandlerMenuAddingFaculty() {
        while (true) {
            System.out.println();
            System.out.println("Existing faculties:");

            printer.printUniversity(management.getFaculties());

            System.out.println();

            printer.printMenuAddingFacultyDescription();

            String input = sc.nextLine();

            if (input.equals("2")) {
                break;
            }

            if (input.equals("1")) {
                System.out.println();
                System.out.print("Enter new FACULTY name: ");
                String inputFacultyName = sc.nextLine();
                management.setFaculty(inputFacultyName);
            }
        }
    }

    private void startHandlerMenuUniversity() {
        while (true) {
            printer.printUniversityMenuDescription();

            String input = sc.nextLine();

            if (input.equals("3")) {
                break;
            }

            if (input.equals("1")) {
                startHandlerMenuAddingFaculty();
            }

            if (input.equals("2")) {
                addMarksFromConsoleLine();
            }
        }
    }

    private void addMarksFromConsoleLine() {
        checkExistingFaculty();
        int inputFacultyId = takeIdFacultyFromConsole();

        checkExistingGroup(inputFacultyId);
        int inputGroupId = takeIdGroupFromConsole(inputFacultyId);

        checkExistingStudent(inputGroupId);
        int inputIdStudent = takeIdStudentFromConsole(inputGroupId);

        checkExistingSubject(inputIdStudent);
        int inputSubjectId = takeIdSubjectFromConsole(inputIdStudent);

        addMarksToParticularSubject(inputFacultyId, inputGroupId, inputIdStudent, inputSubjectId);
    }

    private void checkExistingFaculty() {
        printer.printUniversity(management.getFaculties());

        try {
            if (management.getFaculties().size() == 0) {
                throw new NoFacultyInUniversityException();
            }

        } catch (NoFacultyInUniversityException e) {
            System.out.println("In university no faculty, please add one");
            System.out.print("Enter name for new faculty:");

            management.setFaculty(sc.nextLine());
            printer.printUniversity(management.getFaculties());
        }
    }

    private void checkExistingGroup(int inputFacultyId) {
        printer.printGroup(management.filteredGroup(inputFacultyId));

        try {
            if (management.filteredGroup(inputFacultyId).size() == 0) {
                throw new NoGroupInFacultyException();
            }
        } catch (NoGroupInFacultyException e) {
            System.out.println("In faculty no group, please add one");
            System.out.print("Enter name for new group:");

            management.addGroup(inputFacultyId, sc.nextLine());
            printer.printGroup(management.filteredGroup(inputFacultyId));
        }
    }

    private void checkExistingStudent(int inputGroupId) {
        printer.printStudent(management.filteredStudents(inputGroupId));

        try {
            if (management.filteredStudents(inputGroupId).size() == 0) {
                throw new NoStudentInGroupException();
            }
        } catch (NoStudentInGroupException e) {
            System.out.println("In group no student, please add one");
            System.out.print("Enter firstname and lastname for new student:");

            management.addStudent(inputGroupId, sc.nextLine(), sc.nextLine());
            printer.printStudent(management.filteredStudents(inputGroupId));
        }
    }

    private void checkExistingSubject(int inputStudentId) {
        printer.printSubjectOfStudent(management.filteredSubject(inputStudentId));

        try {
            if (management.filteredSubject(inputStudentId).size() == 0) {

                throw new NoSubjectInStudentException();
            }
        } catch (NoSubjectInStudentException e) {
            System.out.println("In student no subject, please add one");
            System.out.print("Enter name for new subject:");

            management.addSubject(inputStudentId, sc.nextLine());
            printer.printSubjectOfStudent(management.filteredSubject(inputStudentId));
        }
    }

    private int takeIdFacultyFromConsole() {
        System.out.println();
        System.out.print("Choose and enter value of ID FACULTY where you'd like to add subject: ");
        System.out.println();

        int inputFacultyId;

        while (true) {
            try {
                inputFacultyId = Integer.parseInt(sc.nextLine());

                if (inputFacultyId <= management.getFaculties().size()) {
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
        System.out.print("Choose and enter value of ID GROUP where you'd like to add subject: ");
        System.out.println();

        int inputGroupId;

        while (true) {
            try {
                inputGroupId = Integer.parseInt(sc.nextLine());

                int finalInputGroupId = inputGroupId;
                if (management.filteredGroup(facultyId).stream().anyMatch(x->x.getId()== finalInputGroupId)) {
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
        System.out.print("Choose and enter value of ID STUDENT where you'd like to add subject: ");
        System.out.println();

        int inputStudentId;

        while (true) {
            try {
                inputStudentId = Integer.parseInt(sc.nextLine());

                int finalInputStudentId = inputStudentId;
                if (management.filteredStudents(groupId).stream().anyMatch(x->x.getId()== finalInputStudentId)) {
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
                if (management.filteredSubject(inputIdStudent).stream().anyMatch(x->x.getId() == finalInputSubjectId)) {
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
                management.setMarks(inputFacultyId, inputGroupId, inputStudentId, inputSubjectId, Integer.parseInt(markOrExit));
            } catch (NumberFormatException e) {
                System.out.println("Mark can be only integer please try again");
            }

            printer.printSubjectOfStudent(management.filteredSubject(inputStudentId, inputSubjectId));
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
                    double averageMark = management.getAvgMarkAllFacultiesBySubject(lineAfterSplit[1]);

                    if (averageMark == -1) {
                        System.out.println("There no marks in subject, please try again");
                    } else {
                        printer.printAvgMark(averageMark);
                    }
                }

                if (lineAfterSplit.length == 2 && lineAfterSplit[0].equalsIgnoreCase("STUDENT")) {
                    double averageMark = management.getAvgMarkAllSubjectsByStudent(lineAfterSplit[1]);

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
                    double averageMark = management.getAvgMarkStudentBySubject(lineAfterSplit[1], lineAfterSplit[3], lineAfterSplit[5]);

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
