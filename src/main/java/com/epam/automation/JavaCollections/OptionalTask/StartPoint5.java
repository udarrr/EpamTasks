package com.epam.automation.JavaCollections.OptionalTask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StartPoint5
{
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(-1);
        list.add(-2);
        list.add(1);
        list.add(4);
        list.add(8);
        list.add(9);
        list.add(-5);
        list.add(-4);
        list.add(-3);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(-6);
        list.add(-8);
        list.add(-9);
        list.add(-7);
        list.add(6);
        list.add(0);

        list.sort((Comparator<Integer>) (o1,o2) -> -(o1-o2));

        System.out.println(list);
    }
}
