package com.epam.automation.JavaErrorExceptions.University;

public class Subject {

    String typeSubject;
    Grade grade;

    public Subject(String typeSubject, Grade grade) {

        this.typeSubject = typeSubject;
        this.grade = grade;
    }

    public Subject(String typeSubject) {

        this.typeSubject = typeSubject;
    }

    public String getTypeSubject() {

        return typeSubject;
    }

    public void setTypeSubject(String typeSubject) {

        this.typeSubject = typeSubject;
    }

    public Grade getGrade() {

        return grade;
    }

    public void setGrade(Grade grade) {

        this.grade = grade;
    }
}
