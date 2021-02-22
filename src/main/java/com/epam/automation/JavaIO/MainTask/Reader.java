package com.epam.automation.JavaIO.MainTask;

import com.epam.automation.JavaIO.MainTask.Exception.NoDirectoriesInPath;
import com.epam.automation.JavaIO.MainTask.Exception.NoFilesInDirectories;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Reader {
    public String fillDirectoriesTree(File path) throws IOException {
        int jumpRecursion = 0;

        StringBuilder stringBuilder = new StringBuilder();

        Stack<Boolean> positionDirectory = new Stack<>();

        fillDirectoriesTree(path, jumpRecursion, stringBuilder, positionDirectory);

        return stringBuilder.toString();
    }

    private Boolean checkEndDirectory(Path path) throws IOException {
        Stack<Path> pathsDirectoriesInParentDirectory = new Stack<>();

        DirectoryStream<Path> parentDirectory = Files.newDirectoryStream(path.getParent());

        for (Path p : parentDirectory) {
            pathsDirectoriesInParentDirectory.add(p);
        }

        if (!pathsDirectoriesInParentDirectory.isEmpty() && pathsDirectoriesInParentDirectory.peek().equals(path)) {
            return false;
        } else {
            return true;
        }
    }

    private void fillDirectoriesTree(File path, int jumpRecursion, StringBuilder stringBuilder, Stack<Boolean> positionDirectory) throws IOException {
        stringBuilder.append(getStringAfterRecursion(positionDirectory));
        stringBuilder.append("+--");
        stringBuilder.append(path.getName());
        stringBuilder.append("\r\n");

        if (jumpRecursion > 0) {
            positionDirectory.push(checkEndDirectory(path.toPath()));
        }

        for (File file : Objects.requireNonNull(path.listFiles())) {
            if (file.isDirectory()) {
                fillDirectoriesTree(file, jumpRecursion + 1, stringBuilder, positionDirectory);
            } else {
                buildLineWithFile(file, stringBuilder, positionDirectory);
            }
        }

        if (!positionDirectory.isEmpty()) {
            positionDirectory.pop();
        }
    }

    private void buildLineWithFile(File path, StringBuilder stringBuilder, Stack<Boolean> positionDirectory) {
        stringBuilder.append(getStringAfterRecursion(positionDirectory));
        stringBuilder.append("\\--");
        stringBuilder.append(path.getName());
        stringBuilder.append("\r\n");
    }

    private String getStringAfterRecursion(Stack<Boolean> positionDirectory) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Boolean> copiedStackPositionDirectory = (Stack<Boolean>) positionDirectory.clone();
        Stack<Boolean> reversedStack = reverseStack(copiedStackPositionDirectory);

        while (!reversedStack.isEmpty()) {
            if (reversedStack.peek()) {
                stringBuilder.append("|\u0020\u0020\u0020");
            }

            if (reversedStack.peek()) {
                stringBuilder.append("\u0020\u0020\u0020");
            }
            reversedStack.pop();
        }

        return stringBuilder.toString();
    }

    private Stack<Boolean> reverseStack(Stack<Boolean> stack) {
        Stack<Boolean> reversedStack = new Stack<>();

        while (!stack.isEmpty()) {
            reversedStack.push(stack.pop());
        }

        return reversedStack;
    }

    public double getDirectoriesNumber(List<String> strings) {
        return (double) strings.stream().filter(x -> x.contains("+--")).count();
    }

    public double getFilesNumber(List<String> strings) {
        return (double) strings.stream().filter(x -> x.contains("\\--")).count();
    }

    public double getAverageFilesQuantityInDirectories(List<String> strings) throws NoDirectoriesInPath {
        if (getDirectoriesNumber(strings) != 0) {
            return getFilesNumber(strings) / getDirectoriesNumber(strings);
        } else {
            throw new NoDirectoriesInPath("There are no directories in path");
        }
    }

    private double getFileLengthsValue(List<String> strings) {
        double averageLength = 0;

        for (String line : getFilesList(strings)) {
            String[] splittedLine = line.split("\\\\--");

            if (splittedLine.length == 2) {
                String[] splittedFileNameAndExtention = splittedLine[1].split("\\.");
                averageLength += splittedFileNameAndExtention[0].length();
            }
        }

        return averageLength;
    }

    private List<String> getFilesList(List<String> strings) {
        return strings.stream().filter(x -> x.contains("\\--")).collect(Collectors.toList());
    }

    public double getAverageLengthNameOfFiles(List<String> strings) throws NoFilesInDirectories {
        if (getFilesNumber(strings) != 0) {
            return getFileLengthsValue(strings) / getFilesNumber(strings);
        } else {
            throw new NoFilesInDirectories("There are no files in directories");
        }
    }

    public List<String> readFile(File path) throws IOException {
        List<String> directoriesAndFilesList = new LinkedList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                directoriesAndFilesList.add(line);
            }

            return directoriesAndFilesList;
        }
    }
}
