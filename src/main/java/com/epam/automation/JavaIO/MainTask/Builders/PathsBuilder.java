package com.epam.automation.JavaIO.MainTask.Builders;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class PathsBuilder {
    public String fillDirectoriesTree(File path) throws IOException {
        int jumpRecursion = 0;

        StringBuilder stringBuilder = new StringBuilder();

        Stack<Boolean> directoryPosition = new Stack<>();

        fillDirectoriesTree(path, jumpRecursion, stringBuilder, directoryPosition);

        return stringBuilder.toString();
    }

    private Boolean checkEndDirectory(Path path) throws IOException {
        Stack<Path> pathsDirectoriesInParentDirectory = new Stack<>();

        DirectoryStream<Path> parentDirectory = Files.newDirectoryStream(path.getParent());

        for (Path p : parentDirectory) {
            pathsDirectoriesInParentDirectory.add(p);
        }

        return pathsDirectoriesInParentDirectory.isEmpty() || !pathsDirectoriesInParentDirectory.peek().equals(path);
    }

    private void fillDirectoriesTree(File path, int jumpRecursion, StringBuilder stringBuilder, Stack<Boolean> directoryPosition) throws IOException {
        stringBuilder.append(getStringAfterRecursion(directoryPosition));
        stringBuilder.append("+--");
        stringBuilder.append(path.getName());
        stringBuilder.append("\r\n");

        if (jumpRecursion > 0) {
            directoryPosition.push(checkEndDirectory(path.toPath()));
        }

        for (File file : Objects.requireNonNull(path.listFiles())) {
            if (file.isDirectory()) {
                fillDirectoriesTree(file, jumpRecursion + 1, stringBuilder, directoryPosition);
            } else {
                buildLineWithFile(file, stringBuilder, directoryPosition);
            }
        }

        if (!directoryPosition.isEmpty()) {
            directoryPosition.pop();
        }
    }

    private void buildLineWithFile(File path, StringBuilder stringBuilder, Stack<Boolean> directoryPosition) {
        stringBuilder.append(getStringAfterRecursion(directoryPosition));
        stringBuilder.append("\\--");
        stringBuilder.append(path.getName());
        stringBuilder.append("\r\n");
    }

    private String getStringAfterRecursion(Stack<Boolean> directoryPosition) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Boolean> copiedStackDirectoryPosition = (Stack<Boolean>) directoryPosition.clone();
        Stack<Boolean> reversedStack = reverseStack(copiedStackDirectoryPosition);

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
}
