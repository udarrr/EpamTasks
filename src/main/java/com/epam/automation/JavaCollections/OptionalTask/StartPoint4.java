package com.epam.automation.JavaCollections.OptionalTask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StartPoint4
{
    public static void main(String[] args)
    {
        List<String> poem = Arrays.asList(
                new String("No one worth possessing,"),
                new String("Can be quite possessed,"),
                new String("Lay that on your heart,"),
                new String("My young angry dear;"),
                new String("This truth, this hard and precious stone,"),
                new String("Lay it on your hot cheek,"),
                new String("Let it hide your tear."),
                new String("Hold it like a crystal"),
                new String("When you are alone"),
                new String("And gaze in the depths of the icy stone."),
                new String("Long, look long and you will be blessed:"),
                new String("No one worth possessing"),
                new String("Can be quite possessed.")
        );

         poem.sort((Comparator<String>)(o1,o2) -> o1.length() - o2.length());

         for(String linesPoem : poem)
         {
             System.out.println(linesPoem);
         }
    }
}
