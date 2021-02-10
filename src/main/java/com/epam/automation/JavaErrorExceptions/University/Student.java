package com.epam.automation.JavaErrorExceptions.University;

public class Student {

    String firstName;
    String lastName;
    Subject subject;

    public Student(String firstName, String lastName, Subject subject) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public Student(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public Subject getSubject() {

        return subject;
    }

    public void setSubject(Subject subject) {

        this.subject = subject;
    }
}
