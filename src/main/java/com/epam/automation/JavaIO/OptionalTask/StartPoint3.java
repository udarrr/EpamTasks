package com.epam.automation.JavaIO.OptionalTask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StartPoint3 {
    public static void main(String[] args) {
        List<StringBuilder> linesList = new ArrayList<>();

        Path pathParentDirectory = Path.of("src\\main\\java\\com\\epam\\automation\\JavaIO\\OptionalTask\\File\\NewDirectoryPoint3");

        if (!Files.isDirectory(pathParentDirectory)) {
            try {
                Files.createDirectory(pathParentDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader br = new BufferedReader
                (new FileReader("src\\main\\java\\com\\epam\\automation\\JavaIO\\OptionalTask\\File\\NewDirectoryPoint2\\Point2JavaProgram.java"));
             BufferedWriter bw = new BufferedWriter
                     (new FileWriter(pathParentDirectory + "\\Point3JavaProgram.java"))) {

            String line;

            while ((line = br.readLine()) != null) {
                linesList.add(new StringBuilder(line));
            }

            List<StringBuilder> listAfterChanging = linesList.stream().
                    map(cg -> cg.reverse()).
                    collect(Collectors.toList());

            for (StringBuilder lines : listAfterChanging) {
                bw.write(String.valueOf(lines));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
