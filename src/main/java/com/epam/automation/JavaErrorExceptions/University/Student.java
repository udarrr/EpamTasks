package com.epam.automation.JavaErrorExceptions.University;

import java.util.List;

public class Student {

    int idStudent;
    String name;
    List<Subject> subject;

    public Student(List<Subject> subject) {
        this.subject = subject;
    }

    public Student(int idStudent, String name, List<Subject> subject) {
        this.idStudent = idStudent;
        this.name = name;
        this.subject = subject;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }
}
