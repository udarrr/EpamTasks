package com.epam.automation.JavaIO.OptionalTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StartPoint2 {

    public static void main(String[] args) throws IOException {
        List<String> linesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader
                (new FileReader("src\\main\\java\\com\\epam\\automation\\JavaIO\\OptionalTask\\File\\Point2JavaProgramUnchanged.java"))) {

            String line;

            while ((line = br.readLine()) != null) {
                linesList.add(line);
            }

            List<String> listAfterChanging = linesList.stream().
                    map(ch -> ch.replace("Point2JavaProgramUnchanged", "Point2JavaProgramChanged")).
                    map(cg -> {
                        if (!(cg.contains("public") && cg.contains("class"))) {
                            return cg.replace("public", "private");
                        } else {
                            return cg;
                        }
                    }).
                    collect(Collectors.toList());

            try (BufferedWriter bw = new BufferedWriter
                    (new FileWriter("src\\main\\java\\com\\epam\\automation\\JavaIO\\OptionalTask\\File\\Point2JavaProgramChanged.java"))) {

                for (String lines : listAfterChanging) {
                    bw.write(lines);
                    bw.newLine();
                }
            }
        }
    }
}
