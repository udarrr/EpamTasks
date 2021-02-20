package com.epam.automation.JavaIO.OptionalTask;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class StartPoint1 {
    public static void main(String[] args) throws IOException {
        Random random = new Random();

        try (BufferedWriter out = new BufferedWriter
                (new FileWriter("src\\main\\java\\com\\epam\\automation\\JavaIO\\OptionalTask\\File\\Point1Unsorted.txt"))) {
            for (int i = 0; i < 100; i++) {
                out.write(Integer.toString(random.nextInt(10)));
            }
        }

        try (BufferedReader in = new BufferedReader(new FileReader("src\\main\\java\\com\\epam\\automation\\JavaIO\\OptionalTask\\File\\Point1Unsorted.txt"))) {
            String line = in.readLine();
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

            try (BufferedWriter out = new BufferedWriter
                    (new FileWriter("src\\main\\java\\com\\epam\\automation\\JavaIO\\OptionalTask\\File\\Point1Sorted.txt"))) {
                out.write(sb.toString());
            }
        }
    }
}

