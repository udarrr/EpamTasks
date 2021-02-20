package com.epam.automation.JavaIO.OptionalTask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class StartPoint4 {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();

        Path pathParentDirectory = Path.of("src\\main\\java\\com\\epam\\automation\\JavaIO\\OptionalTask\\File\\NewDirectoryPoint4");

        if (!Files.isDirectory(pathParentDirectory)) {
            try {
                Files.createDirectory(pathParentDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader br = new BufferedReader
                (new FileReader("src\\main\\java\\com\\epam\\automation\\JavaIO\\OptionalTask\\File\\NewDirectoryPoint2\\Point2JavaProgram.java"))) {

            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            char[] alphabet = new char[]{'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I',
                    'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R',
                    's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z'};
            boolean isWord = false;

            List<Character> wordsInChar = new ArrayList<>();

            for (int i = 0; i < lines.size(); i++) {
                char[] lineInChar = lines.get(i).toCharArray();
                for (int j = 0; j < lines.get(i).length(); j++) {
                    for (int k = 0; k < alphabet.length; k++) {
                        if (lineInChar[j] == alphabet[k]) {
                            wordsInChar.add(lineInChar[j]);
                            isWord = true;
                            break;
                        }
                    }
                    if (isWord) {
                        isWord = false;
                    } else {
                        wordsInChar.add(' ');
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            wordsInChar.forEach(sb::append);
            String[] wordsWithSpaces = sb.toString().split(" ");

            List<String> words =
                    Arrays.stream(wordsWithSpaces).
                            filter(x -> x.length() > 2).
                            collect(Collectors.toList());

            List<String> linesAfterChanging = lines.stream().map(originalLine ->
            {
                String res = originalLine;
                for (int i = 0; i < words.size(); i++) {
                    res = res.replace(words.get(i), words.get(i).toUpperCase(Locale.ROOT));
                }
                return res;

            }).collect(Collectors.toList());

            try (BufferedWriter bw = new BufferedWriter
                    (new FileWriter(pathParentDirectory + "\\Point4JavaProgram.java"))) {

                for (String changedLine : linesAfterChanging) {
                    bw.write(changedLine);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
