package com.epam.automation.javaerrorexceptions_stage2.university;

import java.util.List;

public class Faculty {
    int id;
    String name;
    List<Group> groups;

    public Faculty(int id, String name, List<Group> groups) {
        this.id = id;
        this.name = name;
        this.groups = groups;
    }

    public int getId() {
        return id;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(Group groups) {
        this.groups.add(groups);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
