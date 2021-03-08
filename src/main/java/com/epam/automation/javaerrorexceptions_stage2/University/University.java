package com.epam.automation.javaerrorexceptions_stage2.University;

import java.util.List;

public class University {
    int id;
    String name;
    List<Faculty> faculties;

    public University(int id, String name, List<Faculty> faculties) {
        this.id = id;
        this.name = name;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Faculty faculties) {
        this.faculties.add(faculties);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityId=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
