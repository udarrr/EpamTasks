package com.epam.automation.JavaErrorExceptions;

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

    public void addFaculty(String nameFaculty) {

        int nextIdFaculty = getFaculty().size() + 1;


        if (faculties.stream().noneMatch(x -> {
            return x.getNameFaculty().equals(nameFaculty);
        })) {

            faculties.add(new Faculty(nextIdFaculty, nameFaculty, new ArrayList<>()));
        }
    }

    public List<Faculty> getFaculty(String nameFaculty) {

        return faculties.stream().filter(x -> x.getNameFaculty().equals(nameFaculty)).collect(Collectors.toList());
    }

    public List<Faculty> getFaculty() {

        return new ArrayList<>(faculties);
    }

    public void addGroup(String nameFaculty, String nameGroup) {

        int nextIdGroup = getGroup().size() + 1;

        int indexFaculty = 0;
        boolean isFaculty = false;

        for (int i = 0; i < faculties.size(); i++) {

            if (faculties.get(i).getNameFaculty().equals(nameFaculty)) {

                indexFaculty = i;
                isFaculty = true;

                break;
            }
        }

        if (isFaculty &&
                faculties.get(indexFaculty).getGroup().stream().noneMatch(z -> {

                    return z.getNameGroup().equals(nameGroup);
                })) {

            faculties.get(indexFaculty).getGroup().add(new Group(nextIdGroup, nameGroup, new ArrayList<>()));
        }
    }

    public List<Faculty> getGroup(String nameGroup) {

        return faculties.stream().filter(x -> x.getNameFaculty().equals(nameGroup)).collect(Collectors.toList());
    }

    public List<Group> getGroup() {

        return faculties.stream().flatMap(x -> x.getGroup().stream()).collect(Collectors.toList());
    }

    public void addStudent(String nameGroup, String nameStudent) {

        int indexGroup = 0;
        int indexFaculty = 0;
        boolean isGroup = false;

        int nextIdStudent = getStudent().size() + 1;


        for (int i = 0; i < faculties.size(); i++) {

            if (!isGroup) {

                for (int j = 0; j < faculties.get(i).getGroup().size(); j++) {

                    if (faculties.get(i).getGroup().get(j).getNameGroup().equals(nameGroup)) {

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
                        get(indexFaculty).getGroup().
                        get(indexGroup).getStudent().
                        stream().noneMatch(z -> {

                    return z.getName().equals(nameStudent);
                })) {

            faculties.get(indexFaculty).getGroup().get(indexGroup).getStudent().add(new Student(nextIdStudent, nameStudent, new ArrayList<>()));
        }
    }

    public List<Faculty> getStudent(String nameStudent) {

        return faculties.stream().filter(x -> x.getNameFaculty().equals(nameStudent)).collect(Collectors.toList());
    }

    public List<Student> getStudent() {

        return faculties.stream().flatMap(z -> z.getGroup().stream()).flatMap(x -> x.getStudent().stream()).collect(Collectors.toList());
    }

    public void addSubject(int idStudent, String nameSubject, List<Integer> marks) {

        int indexFaculty = 0;
        int indexGroup = 0;
        int indexStudent = 0;

        boolean isStudent = false;


        for (int i = 0; i < faculties.size(); i++) {

            if (!isStudent) {

                for (int j = 0; j < faculties.get(i).getGroup().size(); j++) {

                    if (!isStudent) {

                        for (int k = 0; k < faculties.get(i).getGroup().get(j).getStudent().size(); k++) {

                            if (faculties.get(i).getGroup().get(j).getStudent().get(k).getIdStudent() == idStudent) {

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
                        get(indexFaculty).getGroup().
                        get(indexGroup).getStudent().
                        get(indexStudent).getSubject().
                        stream().noneMatch(z -> {

                    return z.getTypeSubject().equals(nameSubject);
                })) {

            faculties.get(indexFaculty).getGroup().get(indexGroup).getStudent().get(indexStudent).getSubject().add(new Subject(nameSubject, marks));
        }
    }

    public List<Subject> getSubject(int idStudent) {

        return faculties.stream().
                flatMap(z -> z.getGroup().stream()).
                flatMap(x -> x.getStudent().stream()).filter(v -> {
            return v.getIdStudent() == idStudent;
        }).
                flatMap(c -> c.getSubject().stream()).collect(Collectors.toList());
    }


    public double getAvgMarkFromParticularStudentAllSubjects(String nameStudent) {

        double avgMark;

        avgMark = faculties.stream().
                flatMap(x -> x.getGroup().stream()).
                flatMap(z -> z.getStudent().stream()).
                filter(v -> v.getName().equals(nameStudent)).
                flatMap(n -> n.getSubject().stream()).
                flatMap(m -> m.getMark().stream()).mapToInt(s -> s).average().orElseThrow(NoSuchElementException::new);

        return avgMark;
    }


    public double getAvgMarkFromParticularGroupStudentSubject(String nameFaculty, String nameGroup, String nameSubject) {


        double avgMark;

        int indexFaculty = getIndexFaculty(nameFaculty);
        int indexGroup = getIndexGroup(indexFaculty, nameGroup);

        if (indexFaculty == -1 || indexGroup == -1) {

            // THROW EXCEPTION
        }

        avgMark = faculties.get(indexFaculty).getGroup().get(indexGroup).getStudent().stream().
                flatMap(x -> x.getSubject().stream()).
                filter(z -> z.getTypeSubject().equals(nameSubject)).
                flatMap(c -> c.getMark().stream()).mapToInt(v -> v).average().orElseThrow(NoSuchElementException::new);

        return avgMark;
    }

    private int getIndexFaculty(String faculty) {

        int indexFaculty = 0;
        boolean isIndex = false;

        for (int i = 0; i < faculties.size(); i++) {

            if (faculties.get(i).getNameFaculty().equals(faculty)) {

                indexFaculty = i;
                isIndex = true;

                break;
            }
        }

        return isIndex ? indexFaculty : -1;
    }

    private int getIndexGroup(int indexFaculty, String group) {

        int indexGroup = 0;
        boolean isIndex = false;

        for (int i = 0; i < faculties.get(indexFaculty).getGroup().size(); i++) {

            if (faculties.get(indexFaculty).getGroup().get(i).getNameGroup().equals(group)) {

                indexGroup = i;
                isIndex = true;

                break;
            }
        }

        return isIndex ? indexGroup : -1;
    }

    public double getAvgMarkWholeUniversityFromParticularSubject(String nameSubject) {

        double avgMark;

        avgMark = faculties.stream().
                flatMap(z -> z.getGroup().stream()).
                flatMap(x -> x.getStudent().stream()).
                flatMap(c -> c.getSubject().stream()).filter(v -> v.getTypeSubject().equals(nameSubject)).
                flatMap(b -> b.getMark().stream()).mapToInt(n -> n).average().orElseThrow(NoSuchElementException::new);

        return avgMark;
    }
}