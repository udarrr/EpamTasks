package com.epam.automation.javaio_stage2.optionaltask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StartPoint2 {

    public static void main(String[] args) {
        List<String> linesList = new ArrayList<>();

        Path pathParentDirectory = Path.of("src\\main\\java\\com\\epam\\automation\\JavaIO\\OptionalTask\\File\\NewDirectoryPoint2");

        if (!Files.isDirectory(pathParentDirectory)) {
            try {
                Files.createDirectory(pathParentDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader br = new BufferedReader
                (new FileReader(pathParentDirectory + "\\Point2JavaProgram.java"))) {

            String line;

            while ((line = br.readLine()) != null) {
                linesList.add(line);
            }

            List<String> listAfterChanging = linesList.stream().
                    map(cg -> {
                        if (!(cg.contains("public") && cg.contains("class"))) {
                            return cg.replace("public", "private");
                        } else {
                            return cg;
                        }
                    }).
                    collect(Collectors.toList());

            try (BufferedWriter bw = new BufferedWriter
                    (new FileWriter(pathParentDirectory + "\\Point2JavaProgram.java"))) {

                for (String lines : listAfterChanging) {
                    bw.write(lines);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
