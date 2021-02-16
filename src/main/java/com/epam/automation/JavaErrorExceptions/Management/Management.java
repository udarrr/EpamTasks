package com.epam.automation.JavaErrorExceptions.Management;

import com.epam.automation.JavaErrorExceptions.Exception.NumberIsNotInRangeException;
import com.epam.automation.JavaErrorExceptions.University.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Management {
    private final List<University> university;

    public Management(List<University> university) {
        this.university = university;
    }

    public List<University> getUniversity() {
        return university;
    }

    public void addUniversity(String universityName) {

        if (university.stream().noneMatch(x -> x.getName().equals(universityName))) {
            university.add(new University(1, universityName, new ArrayList<>()));
        }
    }

    public void addFaculty(String facultyName) {
        int nextFacultyId = getAllFaculties().size() + 1;

        if (university.stream().
                flatMap(f -> f.getFaculties().stream()).noneMatch(x -> x.getName().equals(facultyName))) {

            university.stream().
                    findFirst().
                    ifPresent(x -> x.setFaculties(new Faculty(nextFacultyId, facultyName, new ArrayList<>())));
        }
    }

    public List<Faculty> getAllFaculties() {

        return university.stream().
                flatMap(f -> f.getFaculties().stream()).collect(Collectors.toList());
    }

    public List<Faculty> filteredFaculties(int facultyId) {

        return university.stream().
                flatMap(f -> f.getFaculties().stream()).
                filter(fac -> fac.getId() == facultyId).collect(Collectors.toList());
    }

    public double getAvgMarkAllSubjectsByStudent(String studentName) {
        double avgMark;

        try {
            avgMark = university.stream().
                    flatMap(f -> f.getFaculties().stream()).
                    flatMap(x -> x.getGroups().stream()).
                    flatMap(z -> z.getStudents().stream()).
                    filter(v -> v.getFirstName().equals(studentName)).
                    flatMap(n -> n.getSubjects().stream()).
                    flatMap(m -> m.getMarks().stream()).mapToInt(s -> s).average().
                    orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            return -1;
        }

        return avgMark;
    }

    public double getAvgMarkStudentBySubject(String facultyName, String groupName, String subjectName) {
        double avgMark;

        try {
            avgMark = university.stream().
                    flatMap(f -> f.getFaculties().stream()).
                    filter(f -> f.getName().equals(facultyName)).
                    flatMap(g -> g.getGroups().stream()).
                    filter(gr -> gr.getName().equals(groupName)).
                    flatMap(x -> x.getStudents().stream()).
                    flatMap(subj -> subj.getSubjects().stream()).
                    filter(z -> z.getName().equals(subjectName)).
                    flatMap(c -> c.getMarks().stream()).mapToInt(v -> v).average().
                    orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            return -1;
        }
        return avgMark;
    }

    public double getAvgMarkAllFacultiesBySubject(String subjectName) {
        double avgMark;

        try {
            avgMark = university.stream().
                    flatMap(f -> f.getFaculties().stream()).
                    flatMap(z -> z.getGroups().stream()).
                    flatMap(x -> x.getStudents().stream()).
                    flatMap(c -> c.getSubjects().stream()).filter(v -> v.getName().equals(subjectName)).
                    flatMap(b -> b.getMarks().stream()).mapToInt(n -> n).average().
                    orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            return -1;
        }

        return avgMark;
    }

    public List<Group> getAllGroups() {

        return university.stream().
                flatMap(f -> f.getFaculties().stream()).
                flatMap(x -> x.getGroups().stream()).collect(Collectors.toList());
    }

    public List<Group> filteredGroup(int facultyId) {
        return university.stream().
                flatMap(f -> f.getFaculties().stream()).
                filter(x -> x.getId() == facultyId).
                flatMap(z -> z.getGroups().stream()).
                collect(Collectors.toList());
    }

    public void addGroup(int facultyId, String groupName) {
        int nextIdGroup = getAllGroups().size() + 1;

        if (university.stream().
                flatMap(f -> f.getFaculties().stream()).
                flatMap(x -> x.getGroups().stream()).
                noneMatch(z -> z.getName().equals(groupName))) {

            university.stream().
                    flatMap(f -> f.getFaculties().stream()).filter(z -> z.getId() == facultyId).
                    findFirst().ifPresent(v -> v.setGroups
                    (new Group(nextIdGroup, groupName, new ArrayList<>())));
        }
    }

    public List<Student> getAllStudents() {

        return university.stream().
                flatMap(f -> f.getFaculties().stream()).
                flatMap(z -> z.getGroups().stream()).
                flatMap(x -> x.getStudents().stream()).
                collect(Collectors.toList());
    }

    public List<Student> filteredStudents(int groupId) {

        return university.stream().
                flatMap(f -> f.getFaculties().stream()).
                flatMap(z -> z.getGroups().stream()).
                filter(m -> m.getId() == groupId).
                flatMap(x -> x.getStudents().stream()).
                collect(Collectors.toList());
    }

    public void addStudent(int groupId, String firstName, String lastName) {
        int nextStudentId = getAllStudents().size() + 1;

        if (university.stream().
                flatMap(f -> f.getFaculties().stream()).
                flatMap(g -> g.getGroups().stream()).
                flatMap(s -> s.getStudents().stream()).
                noneMatch(z -> z.getFirstName().equals(firstName) && z.getLastName().equals(lastName))) {

            university.stream().
                    flatMap(f -> f.getFaculties().stream()).flatMap(g -> g.getGroups().stream()).
                    filter(z -> z.getId() == groupId).
                    findFirst().ifPresent(s -> s.setStudents
                    (new Student(nextStudentId, firstName, lastName, new ArrayList<>())));
        }
    }

    public List<Subject> filteredSubject(int studentId) {

        return university.stream().
                flatMap(f -> f.getFaculties().stream()).
                flatMap(z -> z.getGroups().stream()).
                flatMap(x -> x.getStudents().stream()).
                filter(v -> v.getId() == studentId).
                flatMap(c -> c.getSubjects().stream()).
                collect(Collectors.toList());
    }

    public List<Subject> filteredSubject(int studentId, int subjectId) {

        return university.stream().
                flatMap(f -> f.getFaculties().stream()).
                flatMap(z -> z.getGroups().stream()).
                flatMap(x -> x.getStudents().stream()).
                filter(v -> v.getId() == studentId).
                flatMap(c -> c.getSubjects().stream()).
                filter(b -> b.getId() == subjectId).
                collect(Collectors.toList());
    }

    public void addSubject(int studentId, String subjectName) {

        int nextSubjectId = filteredSubject(studentId).size() + 1;

        if (university.stream().
                flatMap(f -> f.getFaculties().stream()).
                flatMap(g -> g.getGroups().stream()).
                flatMap(st -> st.getStudents().stream()).
                filter(s -> s.getId() == studentId).
                flatMap(sub -> sub.getSubjects().stream()).
                noneMatch(n -> n.getName().equals(subjectName))) {

            university.stream().
                    flatMap(f -> f.getFaculties().stream()).
                    flatMap(g -> g.getGroups().stream()).
                    flatMap(s -> s.getStudents().stream()).
                    filter(z -> z.getId() == studentId).
                    findFirst().ifPresent(s -> s.setSubjects
                    (new Subject(nextSubjectId, subjectName, new ArrayList<>())));
        }
    }

    public void setMarks(int facultyId, int groupId, int studentId, int subjectId, int mark) {
        try {
            if ((mark >= 0) && (mark <= 10)) {
                university.stream().
                        flatMap(f -> f.getFaculties().stream()).filter(f -> f.getId() == facultyId).
                        flatMap(fuc -> fuc.getGroups().stream()).filter(g -> g.getId() == groupId).
                        flatMap(s -> s.getStudents().stream()).filter(st -> st.getId() == studentId).
                        flatMap(sub -> sub.getSubjects().stream()).filter(subject -> subject.getId() == subjectId).findFirst().
                        ifPresent(m -> m.addMark(mark));
            } else {
                throw new NumberIsNotInRangeException();
            }
        } catch (NumberIsNotInRangeException e) {
            System.out.println("You entered wrong number, mark can't be less 0 and more than 10");
        }
    }
}