package com.epam.automation.JavaErrorExceptions.University;

public class Faculty {

    String nameFaculty;
    Group group;

    public Faculty(String nameFaculty) {

        this.nameFaculty = nameFaculty;
    }

    public Faculty(String nameFaculty, Group group) {

        this.nameFaculty = nameFaculty;
        this.group = group;
    }

    public String getNameFaculty() {

        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {

        this.nameFaculty = nameFaculty;
    }

    public Group getGroup() {

        return group;
    }

    public void setGroup(Group group) {

        this.group = group;
    }

    @Override

    public String toString() {

        return "Faculty{" + "nameFaculty='" + nameFaculty + '\'' + ", group=" + group.getNameGroup() + '}';
    }
}
