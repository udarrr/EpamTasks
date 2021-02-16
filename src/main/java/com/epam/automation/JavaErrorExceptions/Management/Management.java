package com.epam.automation.JavaErrorExceptions.Management;

import com.epam.automation.JavaErrorExceptions.Exception.NumberIsNotInRangeException;
import com.epam.automation.JavaErrorExceptions.University.Faculty;
import com.epam.automation.JavaErrorExceptions.University.Group;
import com.epam.automation.JavaErrorExceptions.University.Student;
import com.epam.automation.JavaErrorExceptions.University.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Management {

    private final List<Faculty> faculties;

    public Management(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculty(String nameFaculty) {
        int nextIdFaculty = faculties.size() + 1;

        if (faculties.stream().noneMatch(x -> {

            return x.getName().equals(nameFaculty);
        })) {
            faculties.add(new Faculty(nextIdFaculty, nameFaculty, new ArrayList<>()));
        }
    }

    public int getIndexFaculty(String faculty) {
        int indexFaculty = 0;
        boolean isIndex = false;

        for (int i = 0; i < faculties.size(); i++) {
            if (faculties.get(i).getName().equals(faculty)) {
                indexFaculty = i;
                isIndex = true;

                break;
            }
        }

        return isIndex ? indexFaculty : -1;
    }

    public int getIndexFaculty(int idFaculty) {
        int indexFaculty = 0;
        boolean isIndex = false;

        for (int i = 0; i < faculties.size(); i++) {
            if (faculties.get(i).getId() == idFaculty) {
                indexFaculty = i;
                isIndex = true;

                break;
            }
        }

        return isIndex ? indexFaculty : -1;
    }

    public double getAvgMarkFromParticularStudentAllSubjects(String nameStudent) {
        double avgMark;
        try {
            avgMark = faculties.stream().
                    flatMap(x -> x.getGroups().stream()).
                    flatMap(z -> z.getStudents().stream()).
                    filter(v -> v.getFirstName().equals(nameStudent)).
                    flatMap(n -> n.getSubjects().stream()).
                    flatMap(m -> m.getMarks().stream()).mapToInt(s -> s).average().
                    orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            return -1;
        }

        return avgMark;
    }


    public double getAvgMarkFromParticularGroupStudentSubject(String nameFaculty, String nameGroup, String nameSubject) {
        double avgMark;
        int indexFaculty = getIndexFaculty(nameFaculty);
        int indexGroup = getIndexGroup(indexFaculty, nameGroup);

        if (indexFaculty > -1 && indexGroup > -1) {
            try {
                avgMark = faculties.get(indexFaculty).getGroups().get(indexGroup).getStudents().stream().
                        flatMap(x -> x.getSubjects().stream()).
                        filter(z -> z.getName().equals(nameSubject)).
                        flatMap(c -> c.getMarks().stream()).mapToInt(v -> v).average().
                        orElseThrow(NoSuchElementException::new);
            } catch (NoSuchElementException e) {
                return -1;
            }
        } else {
            return -1;
        }

        return avgMark;
    }

    public double getAvgMarkWholeUniversityFromParticularSubject(String nameSubject) {
        double avgMark;
        try {
            avgMark = faculties.stream().
                    flatMap(z -> z.getGroups().stream()).
                    flatMap(x -> x.getStudents().stream()).
                    flatMap(c -> c.getSubjects().stream()).filter(v -> v.getName().equals(nameSubject)).
                    flatMap(b -> b.getMarks().stream()).mapToInt(n -> n).average().
                    orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            return -1;
        }

        return avgMark;
    }

    public List<Group> getGroup() {
        return faculties.stream().flatMap(x -> x.getGroups().stream()).collect(Collectors.toList());
    }

    public List<Group> getGroup(int idFaculty) {

        return faculties.stream().
                filter(x -> x.getId() == idFaculty).
                flatMap(z -> z.getGroups().stream()).
                collect(Collectors.toList());
    }

    public void setGroup(int idFaculty, String nameGroup) {
        int nextIdGroup = getGroup().size() + 1;
        int indexFaculty = 0;
        boolean isFaculty = false;

        for (int i = 0; i < faculties.size(); i++) {
            if (faculties.get(i).getId() == idFaculty) {
                indexFaculty = i;
                isFaculty = true;

                break;
            }
        }

        if (isFaculty &&
                faculties.get(indexFaculty).getGroups().stream().noneMatch(z -> {

                    return z.getName().equals(nameGroup);
                })) {

            faculties.get(indexFaculty).getGroups().add(new Group(nextIdGroup, nameGroup, new ArrayList<>()));
        }
    }

    public int getIndexGroup(int indexFaculty, String group) {
        int indexGroup = 0;
        boolean isIndex = false;

        for (int i = 0; i < faculties.get(indexFaculty).getGroups().size(); i++) {
            if (faculties.get(indexFaculty).getGroups().get(i).getName().equals(group)) {
                indexGroup = i;
                isIndex = true;

                break;
            }
        }

        return isIndex ? indexGroup : -1;
    }

    public int getIndexGroup(int indexFaculty, int idGroup) {
        int indexGroup = 0;
        boolean isIndex = false;

        for (int i = 0; i < faculties.get(indexFaculty).getGroups().size(); i++) {
            if (faculties.get(indexFaculty).getGroups().get(i).getId() == idGroup) {
                indexGroup = i;
                isIndex = true;

                break;
            }
        }

        return isIndex ? indexGroup : -1;
    }

    public List<Student> getStudent() {
        return faculties.stream().
                flatMap(z -> z.getGroups().stream()).
                flatMap(x -> x.getStudents().stream()).
                collect(Collectors.toList());
    }


    public List<Student> getStudent(int idGroup) {
        return faculties.stream().
                flatMap(z -> z.getGroups().stream()).
                filter(m -> m.getId() == idGroup).
                flatMap(x -> x.getStudents().stream()).
                collect(Collectors.toList());
    }

    public void setStudent(int idGroup, String firstName, String lastName) {
        int nextIdStudent = getStudent().size() + 1;
        int indexGroup = 0;
        int indexFaculty = 0;
        boolean isGroup = false;

        for (int i = 0; i < faculties.size(); i++) {
            if (!isGroup) {
                for (int j = 0; j < faculties.get(i).getGroups().size(); j++) {
                    if (faculties.get(i).getGroups().get(j).getId() == idGroup) {
                        indexFaculty = i;
                        indexGroup = j;
                        isGroup = true;

                        break;
                    }
                }
            } else {

                break;
            }
        }

        if (isGroup &&
                faculties.
                        get(indexFaculty).getGroups().
                        get(indexGroup).getStudents().
                        stream().noneMatch(z -> {

                    return z.getFirstName().equals(firstName) && z.getLastName().equals(lastName);
                })) {

            faculties.get(indexFaculty).getGroups().get(indexGroup).getStudents().add(new Student(nextIdStudent, firstName, lastName, new ArrayList<>()));
        }
    }

    public int getIndexStudent(int indexFaculty, int indexGroup, int idStudent) {
        int indexStudent = 0;
        boolean isIndex = false;

        for (int i = 0; i < faculties.get(indexFaculty).getGroups().get(indexGroup).getStudents().size(); i++) {
            if (faculties.get(indexFaculty).getGroups().get(indexGroup).getStudents().get(i).getId() == idStudent) {
                indexStudent = i;
                isIndex = true;

                break;
            }
        }

        return isIndex ? indexStudent : -1;
    }

    public List<Subject> getSubject(int idStudent) {

        return faculties.stream().
                flatMap(z -> z.getGroups().stream()).
                flatMap(x -> x.getStudents().stream()).
                filter(v -> v.getId() == idStudent).
                flatMap(c -> c.getSubjects().stream()).
                collect(Collectors.toList());
    }

    public List<Subject> getSubject(int idStudent, int idSubject) {

        return faculties.stream().
                flatMap(z -> z.getGroups().stream()).
                flatMap(x -> x.getStudents().stream()).
                filter(v -> v.getId() == idStudent).
                flatMap(c -> c.getSubjects().stream()).
                filter(b -> b.getId() == idSubject).
                collect(Collectors.toList());
    }

    public void setSubject(int idStudent, String nameSubject) {
        int indexFaculty = 0;
        int indexGroup = 0;
        int indexStudent = 0;
        int nextIdSubject = getSubject(idStudent).size() + 1;

        boolean isStudent = false;

        for (int i = 0; i < faculties.size(); i++) {
            if (!isStudent) {
                for (int j = 0; j < faculties.get(i).getGroups().size(); j++) {
                    if (!isStudent) {
                        for (int k = 0; k < faculties.get(i).getGroups().get(j).getStudents().size(); k++) {
                            if (faculties.
                                    get(i).getGroups().
                                    get(j).getStudents().get(k).
                                    getId() == idStudent) {

                                indexFaculty = i;
                                indexGroup = j;
                                indexStudent = k;
                                isStudent = true;

                                break;
                            }
                        }
                    } else {

                        break;
                    }
                }

            } else {

                break;
            }
        }

        if (isStudent &&
                faculties.
                        get(indexFaculty).getGroups().
                        get(indexGroup).getStudents().
                        get(indexStudent).getSubjects().
                        stream().noneMatch(z -> {

                    return z.getName().equals(nameSubject);
                })) {

            faculties.
                    get(indexFaculty).getGroups().
                    get(indexGroup).getStudents().
                    get(indexStudent).getSubjects().
                    add(new Subject(nextIdSubject, nameSubject, new ArrayList<>()));
        }
    }

    public int getIndexSubject(int indexFaculty, int indexGroup, int indexStudent, int idSubject) {
        int indexSubject = 0;
        boolean isIndex = false;
        int amountSubjects = faculties.
                get(indexFaculty).getGroups().
                get(indexGroup).getStudents().
                get(indexStudent).getSubjects().size();

        for (int i = 0; i < amountSubjects; i++) {
            if (faculties.
                    get(indexFaculty).getGroups().
                    get(indexGroup).getStudents().
                    get(indexStudent).getSubjects().
                    get(i).getId() == idSubject) {

                indexSubject = i;
                isIndex = true;

                break;
            }
        }

        return isIndex ? indexSubject : -1;
    }

    public void setMarks(int indexFaculty, int indexGroup, int indexStudent, int indexSubject, int mark) {
        try {
            boolean nullChecker =
                            faculties.
                                    get(indexFaculty) != null &&
                            faculties.
                                    get(indexFaculty).
                                    getGroups().get(indexGroup) != null &&
                            faculties.
                                    get(indexFaculty).getGroups().
                                    get(indexGroup).getStudents().
                                    get(indexStudent) !=null &&
                            faculties.
                                    get(indexFaculty).getGroups().
                                    get(indexGroup).getStudents().
                                    get(indexStudent).getSubjects().
                                    get(indexSubject) != null;

            if ((mark >= 0) && (mark <= 10) && nullChecker) {
                faculties.
                        get(indexFaculty).getGroups().
                        get(indexGroup).getStudents().
                        get(indexStudent).getSubjects().
                        get(indexSubject).setMarks(mark);
            } else {
                throw new NumberIsNotInRangeException();
            }

        } catch (NumberIsNotInRangeException e) {
            System.out.println("You entered wrong number, mark can't be less 0 and more than 10");
        }
    }
}