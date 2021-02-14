package com.epam.automation.JavaErrorExceptions.University;

import java.util.List;

public class Group {

    int idGroup;
    String nameGroup;
    List<Student> student;

    public Group(List<Student> student) {
        this.student = student;
    }

    public Group(int idGroup, String nameGroup, List<Student> student) {
        this.idGroup = idGroup;
        this.nameGroup = nameGroup;
        this.student = student;
    }

    public Group(int idGroup, String nameGroup) {
        this.idGroup = idGroup;
        this.nameGroup = nameGroup;
    }

    public List<Student> getStudent() {
        return student;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
