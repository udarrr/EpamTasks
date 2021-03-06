package com.epam.automation.javaerrorexceptions_stage2.university;

import java.util.Arrays;
import java.util.List;

public class Subject {
    int id;
    String name;
    List<Integer> marks;

    public Subject(int id, String name, List<Integer> marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMark(int mark) {
        this.marks.add(mark);
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + Arrays.toString(marks.toArray()) +
                '}';
    }
}
