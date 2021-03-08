package com.epam.automation.javacollections_stage1.optionaltask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StartPoint6 {

    public static void main(String[] args) throws IOException {
        List<String> linesFromFile = new ArrayList<>();

        BufferedReader in = new BufferedReader(new FileReader("src\\main\\java\\com\\epam\\automation\\JavaCollections\\OptionalTask\\Files\\TaskPoint6.txt"));

        String line;

        while ((line = in.readLine()) != null) {
            linesFromFile.add(line);
        }

        Collections.sort(linesFromFile, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return o1.length() - o2.length();
            }
        });

        for (String sortingLines : linesFromFile) {
            System.out.println(sortingLines);
        }
    }
}
