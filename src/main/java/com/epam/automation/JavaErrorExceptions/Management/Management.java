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

    public void setFaculty(String facultyName) {
        int nextFacultyId = faculties.size() + 1;

        if (faculties.stream().noneMatch(x -> {

            return x.getName().equals(facultyName);
        })) {
            faculties.add(new Faculty(nextFacultyId, facultyName, new ArrayList<>()));
        }
    }

    public double getAvgMarkAllSubjectsByStudent(String studentName) {
        double avgMark;

        try {
            avgMark = faculties.stream().
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
                avgMark = faculties.stream().
                        filter(f->f.getName().equals(facultyName)).
                        flatMap(g->g.getGroups().stream()).
                        filter(gr->gr.getName().equals(groupName)).
                        flatMap(x -> x.getStudents().stream()).
                        flatMap(subj->subj.getSubjects().stream()).
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
            avgMark = faculties.stream().
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

        return faculties.stream().flatMap(x -> x.getGroups().stream()).collect(Collectors.toList());
    }

    public List<Group> filteredGroup(int facultyId) {

        return faculties.stream().
                filter(x -> x.getId() == facultyId).
                flatMap(z -> z.getGroups().stream()).
                collect(Collectors.toList());
    }

        public void addGroup(int facultyID, String groupName) {
        int nextIdGroup = getAllGroups().size() + 1;

            if (faculties.stream().
                    flatMap(x->x.getGroups().stream()).
                    noneMatch(z -> z.getName().equals(groupName))) {

                faculties.stream().filter(z -> z.getId() == facultyID).
                        findFirst().ifPresent(v -> v.setGroups
                        (new Group(nextIdGroup, groupName, new ArrayList<>())));
            }
    }

    public List<Student> getAllStudents() {

        return faculties.stream().
                flatMap(z -> z.getGroups().stream()).
                flatMap(x -> x.getStudents().stream()).
                collect(Collectors.toList());
    }

    public List<Student> filteredStudents(int groupId) {

        return faculties.stream().
                flatMap(z -> z.getGroups().stream()).
                filter(m -> m.getId() == groupId).
                flatMap(x -> x.getStudents().stream()).
                collect(Collectors.toList());
    }

    public void addStudent(int groupId, String firstName, String lastName){
    int nextStudentId = getAllStudents().size() + 1;

        if (faculties.stream().
                flatMap(g->g.getGroups().stream()).
                flatMap(s->s.getStudents().stream()).
                noneMatch(z -> z.getFirstName().equals(firstName) && z.getLastName().equals(lastName))) {

            faculties.stream().flatMap(g->g.getGroups().stream()).
                    filter(z -> z.getId() == groupId).
                    findFirst().ifPresent(s -> s.setStudents
                    (new Student(nextStudentId,firstName,lastName,new ArrayList<>())));
        }
    }

    public List<Subject> filteredSubject(int studentId) {

        return faculties.stream().
                flatMap(z -> z.getGroups().stream()).
                flatMap(x -> x.getStudents().stream()).
                filter(v -> v.getId() == studentId).
                flatMap(c -> c.getSubjects().stream()).
                collect(Collectors.toList());
    }

    public List<Subject> filteredSubject(int studentId, int subjectId) {

        return faculties.stream().
                flatMap(z -> z.getGroups().stream()).
                flatMap(x -> x.getStudents().stream()).
                filter(v -> v.getId() == studentId).
                flatMap(c -> c.getSubjects().stream()).
                filter(b -> b.getId() == subjectId).
                collect(Collectors.toList());
    }

        public void addSubject(int studentId, String subjectName) {

        int nextSubjectId = filteredSubject(studentId).size() + 1;

        if (faculties.stream().
                flatMap(g->g.getGroups().stream()).
                flatMap(st->st.getStudents().stream()).
                filter(s->s.getId() == studentId).
                flatMap(sub->sub.getSubjects().stream()).
                noneMatch(n -> n.getName().equals(subjectName))) {

            faculties.stream().
                    flatMap(g->g.getGroups().stream()).
                    flatMap(s->s.getStudents().stream()).
                    filter(z -> z.getId() == studentId).
                    findFirst().ifPresent(s -> s.setSubjects
                    (new Subject(nextSubjectId,subjectName,new ArrayList<>())));
        }
    }

    public void setMarks(int facultyId, int groupId, int studentId, int subjectId, int mark) {
        try {
            if ((mark >= 0) && (mark <= 10)) {
                faculties.stream().filter(f->f.getId() == facultyId).
                        flatMap(fuc->fuc.getGroups().stream()).filter(g->g.getId() == groupId).
                        flatMap(s->s.getStudents().stream()).filter(st->st.getId()==studentId).
                        flatMap(sub->sub.getSubjects().stream()).filter(subject->subject.getId() == subjectId).findFirst().
                        ifPresent(m->m.setMarks(mark));
            } else {
                throw new NumberIsNotInRangeException();
            }
        } catch (NumberIsNotInRangeException e) {
            System.out.println("You entered wrong number, mark can't be less 0 and more than 10");
        }
    }
}