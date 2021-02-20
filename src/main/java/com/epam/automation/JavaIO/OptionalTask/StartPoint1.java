package com.epam.automation.JavaIO.OptionalTask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;

public class StartPoint1 {
    public static void main(String[] args) {
        Random random = new Random();

        Path pathParentDirectory = Path.of("src\\main\\java\\com\\epam\\automation\\JavaIO\\OptionalTask\\File\\NewDirectoryPoint1");

        if (!Files.isDirectory(pathParentDirectory)) {
            try {
                Files.createDirectory(pathParentDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedWriter bw = new BufferedWriter
                (new FileWriter(pathParentDirectory + "\\Point1Unsorted.txt"))) {
            for (int i = 0; i < 100; i++) {
                bw.write(Integer.toString(random.nextInt(10)));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(pathParentDirectory + "\\Point1Unsorted.txt"))) {
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();
            sb.append(line);

            int[] lineInInteger = new int[line.length()];

            for (int i = 0; i < line.length() - 1; i++) {
                lineInInteger[i] = Integer.parseInt(sb.substring(i, i + 1));
            }

            Arrays.sort(lineInInteger);

            sb = new StringBuilder();

            for (int j : lineInInteger) {
                sb.append(j);
            }

            if (Files.isDirectory(pathParentDirectory)) {
                try (BufferedWriter bw = new BufferedWriter
                        (new FileWriter(pathParentDirectory + "\\Point1Sorted.txt"))) {
                    bw.write(sb.toString());
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

