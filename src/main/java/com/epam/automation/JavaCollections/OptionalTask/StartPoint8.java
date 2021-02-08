package com.epam.automation.JavaCollections.OptionalTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StartPoint8
{
    public static void main(String[] args) throws IOException
    {
        HashSet<String> text = new HashSet<>();

        List<String[]> separatedTextInLine = new ArrayList<>();

        HashSet<String> uniqueWords = new HashSet<>();
        HashSet<String> repeatWords = new HashSet<>();


        BufferedReader in = new BufferedReader(
                new FileReader("src\\main\\java\\com\\epam\\automation\\JavaCollections\\OptionalTask\\Files\\TaskPoint8.txt"));

        String line;

        while ((line = in.readLine()) != null)
        {
            separatedTextInLine.add(line.split("\\s*(\\s|,|\\)|-|\\(|!|\\.)\\s*"));
        }

        for (String[] strings : separatedTextInLine)
        {
            for (String string : strings)
            {
                if(text.addAll(Collections.singleton(string)))
                {
                    uniqueWords.add(string.toLowerCase(Locale.ROOT));
                }
                else
                {
                    repeatWords.add(string.toLowerCase(Locale.ROOT));
                }
            }
        }

        for(String removeStrings : repeatWords)
        {
            uniqueWords.remove(removeStrings);
        }

        System.out.println(uniqueWords);
    }
}
