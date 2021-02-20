package com.epam.automation.JavaIO.OptionalTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StartPoint3 {
    public static void main(String[] args) throws IOException {
        List<StringBuilder> linesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader
                (new FileReader("src\\main\\java\\com\\epam\\automation\\JavaIO\\OptionalTask\\File\\Point2JavaProgram.java"))) {

            String line;

            while ((line = br.readLine()) != null) {
                linesList.add(new StringBuilder(line));
            }

            List<StringBuilder> listAfterChanging = linesList.stream().
                    map(cg -> cg.reverse()).
                    collect(Collectors.toList());

            try (BufferedWriter bw = new BufferedWriter
                    (new FileWriter("src\\main\\java\\com\\epam\\automation\\JavaIO\\OptionalTask\\File\\Point3JavaProgram.java"))) {

                for (StringBuilder lines : listAfterChanging) {
                    bw.write(String.valueOf(lines));
                    bw.newLine();
                }
            }
        }
    }
}
