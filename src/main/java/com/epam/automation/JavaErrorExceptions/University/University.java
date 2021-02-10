package com.epam.automation.JavaErrorExceptions.University;

public class University {

    String nameUniversity;
    Faculty faculty;

    public University() {

        super();
    }

    public University(String nameUniversity) {

        this.nameUniversity = nameUniversity;
    }

    public University(Faculty faculty) {

        this.faculty = faculty;
    }

    public University(String nameUniversity, Faculty faculty) {

        this.nameUniversity = nameUniversity;
        this.faculty = faculty;
    }

    public String getNameUniversity() {

        return nameUniversity;
    }

    public void setNameUniversity(String nameUniversity) {

        this.nameUniversity = nameUniversity;
    }

    public Faculty getFaculty() {

        return faculty;
    }

    public void setFaculty(Faculty faculty) {

        this.faculty = faculty;
    }
}
