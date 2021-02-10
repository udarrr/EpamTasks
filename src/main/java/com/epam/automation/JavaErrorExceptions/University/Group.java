package com.epam.automation.JavaErrorExceptions.University;

public class Group {

    String nameGroup;
    Student student;

    public Group(String nameGroup, Student student) {

        this.nameGroup = nameGroup;
        this.student = student;
    }

    public Group(String nameGroup) {

        this.nameGroup = nameGroup;
    }

    public String getNameGroup() {

        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {

        this.nameGroup = nameGroup;
    }

    public Student getStudent() {

        return student;
    }

    public void setStudent(Student student) {

        this.student = student;
    }
}
