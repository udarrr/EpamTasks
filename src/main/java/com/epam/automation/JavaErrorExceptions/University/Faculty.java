package com.epam.automation.JavaErrorExceptions.University;

import java.util.List;

public class Faculty {

    int idFaculty;
    String nameFaculty;
    List<Group> group;

    public Faculty(List<Group> group) {
        this.group = group;
    }

    public Faculty(int idFaculty, String nameFaculty, List<Group> group) {
        this.idFaculty = idFaculty;
        this.nameFaculty = nameFaculty;
        this.group = group;
    }

    public Faculty(int idFaculty, String nameFaculty) {
        this.idFaculty = idFaculty;
        this.nameFaculty = nameFaculty;
    }

    public List<Group> getGroup() {
        return group;
    }

    public int getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(int idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }
}
