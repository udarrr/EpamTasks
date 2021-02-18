package com.epam.automation.JavaIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoriesReader {

    public List<Path> getPaths() throws IOException {
        Path path = Paths.get("C:\\energ2.0");
        List<Path> paths = getFiles(path);
        paths.forEach(System.out::println);

        return paths;
    }

    private List<Path> getFiles(Path path) throws IOException {
        List<Path> result;
        try (Stream<Path> walk = Files.walk(path)) {

            result = walk.collect(Collectors.toList());
        }

        return result;
    }

    public String getDirectoriesTree(File folder) throws IOException {
        int jumpRecursion = 0;

        StringBuilder stringBuilder = new StringBuilder();

        Stack<Integer> isLast = new Stack<>();

        getDirectoriesTree(folder, jumpRecursion, stringBuilder, isLast);
        return stringBuilder.toString();
    }

    private int isEndDirectory(Path path) throws IOException {
        Stack<Path> temporaryPath = new Stack<>();

        DirectoryStream<Path> directoryParent = Files.newDirectoryStream(path.getParent());

        for (Path p: directoryParent){
            temporaryPath.add(p);
        }

        if(!temporaryPath.isEmpty() && temporaryPath.peek().equals(path)){
            return 0;
        }
        else {
            return 1;
        }
    }

    private void getDirectoriesTree(File folder, int jumpRecursion, StringBuilder stringBuilder, Stack<Integer> isLast) throws IOException {
        stringBuilder.append(getStringAfterRecursion(isLast));
        stringBuilder.append("|--");
        stringBuilder.append(folder.getName());
        stringBuilder.append("\n");

        if(jumpRecursion >0){
            isLast.push(isEndDirectory(folder.toPath()));
        }

        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isDirectory()) {
                getDirectoriesTree(file, jumpRecursion + 1, stringBuilder, isLast);
            } else {
                getFile(file, stringBuilder, isLast);
            }
        }

        if(!isLast.isEmpty()) {
            isLast.pop();
        }
    }

    private void getFile(File file, StringBuilder stringBuilder, Stack<Integer> isLast) {
        stringBuilder.append(getStringAfterRecursion(isLast));
        stringBuilder.append("|--");
        stringBuilder.append(file.getName());
        stringBuilder.append("\n");
    }

    private String getStringAfterRecursion(Stack<Integer> isLast) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stackWithIsLastValue = (Stack<Integer>) isLast.clone();
        Stack<Integer> stack= reverseStack(stackWithIsLastValue);

        while (!stack.isEmpty()) {
            if (stack.peek() == 1) {
                stringBuilder.append("|\u0020\u0020\u0020");
            }
            if (stack.peek() == 0) {
                stringBuilder.append("\u0020\u0020\u0020");
            }
            stack.pop();
        }

        return stringBuilder.toString();
    }

    private Stack<Integer> reverseStack(Stack<Integer> stackWithIsLastValue){
        Stack<Integer> reverseStack = new Stack<>();

        while (!stackWithIsLastValue.isEmpty()){
            reverseStack.push(stackWithIsLastValue.pop());
        }
        return reverseStack;
    }
}
