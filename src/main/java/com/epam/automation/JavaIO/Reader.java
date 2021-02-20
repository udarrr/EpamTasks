package com.epam.automation.JavaIO;

import com.epam.automation.JavaIO.Exception.NoDirectoriesInPath;
import com.epam.automation.JavaIO.Exception.NoFilesInDirectories;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Reader {
    public String getDirectoriesTree(File path) throws IOException {
        int jumpRecursion = 0;

        StringBuilder stringBuilder = new StringBuilder();

        Stack<Integer> isLast = new Stack<>();

        getDirectoriesTree(path, jumpRecursion, stringBuilder, isLast);

        return stringBuilder.toString();
    }

    private int isEndDirectory(Path path) throws IOException {
        Stack<Path> temporaryPath = new Stack<>();

        DirectoryStream<Path> directoryParent = Files.newDirectoryStream(path.getParent());

        for (Path p : directoryParent) {
            temporaryPath.add(p);
        }

        if (!temporaryPath.isEmpty() && temporaryPath.peek().equals(path)) {

            return 0;
        } else {

            return 1;
        }
    }

    private void getDirectoriesTree(File path, int jumpRecursion, StringBuilder stringBuilder, Stack<Integer> positionDirectory) throws IOException {
        stringBuilder.append(getStringAfterRecursion(positionDirectory));
        stringBuilder.append("+--");
        stringBuilder.append(path.getName());
        stringBuilder.append("\r\n");

        if (jumpRecursion > 0) {
            positionDirectory.push(isEndDirectory(path.toPath()));
        }

        for (File file : Objects.requireNonNull(path.listFiles())) {
            if (file.isDirectory()) {
                getDirectoriesTree(file, jumpRecursion + 1, stringBuilder, positionDirectory);
            } else {
                getFile(file, stringBuilder, positionDirectory);
            }
        }

        if (!positionDirectory.isEmpty()) {
            positionDirectory.pop();
        }
    }

    private void getFile(File path, StringBuilder stringBuilder, Stack<Integer> isLast) {
        stringBuilder.append(getStringAfterRecursion(isLast));
        stringBuilder.append("\\--");
        stringBuilder.append(path.getName());
        stringBuilder.append("\r\n");
    }

    private String getStringAfterRecursion(Stack<Integer> positionDirectory) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> copyStackPositionDirectory = (Stack<Integer>) positionDirectory.clone();
        Stack<Integer> reversedStack = reverseStack(copyStackPositionDirectory);

        while (!reversedStack.isEmpty()) {
            if (reversedStack.peek() == 1) {
                stringBuilder.append("|\u0020\u0020\u0020");
            }
            if (reversedStack.peek() == 0) {
                stringBuilder.append("\u0020\u0020\u0020");
            }
            reversedStack.pop();
        }

        return stringBuilder.toString();
    }

    private Stack<Integer> reverseStack(Stack<Integer> copyStackPositionDirectory) {
        Stack<Integer> reversedStack = new Stack<>();

        while (!copyStackPositionDirectory.isEmpty()) {
            reversedStack.push(copyStackPositionDirectory.pop());
        }

        return reversedStack;
    }

    public double getDirectoriesNumber(List<String> text) {

        return (double) text.stream().filter(x->x.contains("+--")).count();
    }

    public double getFilesNumber(List<String> text) {

        return (double) text.stream().filter(x->x.contains("\\--")).count();
    }

    public double getAverageAmountFiles(List<String> text) throws NoDirectoriesInPath {
        if (getDirectoriesNumber(text) != 0) {
            return getFilesNumber(text) / getDirectoriesNumber(text);
        } else {
            throw new NoDirectoriesInPath("There are no directories in path");
        }
    }

    private double getFileLengthsNumber(List<String> text) {
        double averageLength = 0;

        for (String str : getListFiles(text)) {
            String[] splitedStr = str.split("\\\\--");
            if (splitedStr.length == 2) {
                String[] splittedFileNameAndExtention = splitedStr[1].split("\\.");
                averageLength += splittedFileNameAndExtention[0].length();
            }
        }

        return averageLength;
    }

    private List<String> getListFiles(List<String> text) {
        return text.stream().filter(x->x.contains("\\--")).collect(Collectors.toList());
    }

    public double getAverageLengthNameOfFiles(List<String> strings) throws NoFilesInDirectories {
        if (getFilesNumber(strings) != 0) {
            return getFileLengthsNumber(strings) / getFilesNumber(strings);
        } else {
            throw new NoFilesInDirectories("There are no files in directories");
        }
    }

    public List<String> readFile(File path) throws IOException {
        List<String> listDirectoriesAndFiles = new LinkedList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String readiedLine;

            while ((readiedLine = bufferedReader.readLine()) != null) {
                listDirectoriesAndFiles.add(readiedLine);
            }

            return listDirectoriesAndFiles;
        }
    }
}
